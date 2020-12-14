package com.tensquare.spit.service;

import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.Date;
import java.util.List;

/**
 * <p>吐槽的服务层
 * <p>Compiler:fan
 * <p>版本:xxxxxxxxxx
 * <p>文件名：com.tensquare.spit.service.SpitService.java
 * <p>作者: miyf1
 * <p>创建时间: 2020年10月28日 10:20
 * <p>负责人:fan
 * <p>修改者： fan
 * <p>修改时间：
 */
@Service
@Transactional
public class SpitService {

    @Autowired
    private SpitDao spitDao;

    /**
     * 生成id
     **/
    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 吐槽查询所有的方法
     * 日期: 10:49 2020/10/28
     * 作者: miyf
     *
     * @return List<Spit> 结果集
     **/
    public List<Spit> findAll() {
        return spitDao.findAll();
    }

    /**
     * 吐槽根据id查询方法
     * 日期: 10:32 2020/10/28
     * 作者: miyf
     *
     * @param id id
     * @return Spit
     **/
    public Spit findById(String id) {
        return spitDao.findById(id).get();
    }

    /**
     * 吐槽的新增方法
     * 日期: 10:32 2020/10/28
     * 作者: miyf
     *
     * @param spit 需要保存的实体
     **/
    public void save(Spit spit) {
        spit.set_id(idWorker.nextId() + "");
        spit.setPublishtime(new Date());
        spit.setVisits(0); //浏览量
        spit.setShare(0); // 分享数
        spit.setThumbup(0);// 点赞数
        spit.setComment(0); //回复数
        spit.setState("1"); //状态
        spitDao.save(spit);
        // 如果当前添加的吐槽有父节点，那么父节点的吐槽回复数要加一
        if (spit.getParentid() != null && !"".equals(spit.getParentid())) {
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(spit.getParentid()));
            Update update = new Update();
            update.inc("comment", 1);
            mongoTemplate.updateFirst(query, update, "spit");
        }
    }

    /**
     * 吐槽的更新方法
     * 日期: 10:33 2020/10/28
     * 作者: miyf
     *
     * @param spit 需要更新的实体
     **/
    public void update(Spit spit) {
        spitDao.save(spit);
    }

    /**
     * 吐槽的删除方法
     * 日期: 10:34 2020/10/28
     * 作者: miyf
     *
     * @param id id
     **/
    public void deleteById(String id) {
        spitDao.deleteById(id);
    }

    /**
     * 根据父级id分页查询
     * 日期: 11:32 2020/10/28
     * 作者: miyf
     *
     * @param parentid 父级id
     * @param page     页码
     * @param size     页大小
     * @return Page<Spit> 结果集
     **/
    public Page<Spit> findByParentid(String parentid, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return spitDao.findByParentid(parentid, pageable);
    }

    /**
     * 点赞功能
     * 日期: 11:31 2020/10/29
     * 作者: miyf
     *
     * @param spitId id
     **/
    public void thumbup(String spitId) {
        // 使用原生monggo命令来实现自增 db.spit.update({"_id":"1"},{$inc:{thumbup:NumberInt(1)}})
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is("1"));
        Update update = new Update();
        update.inc("thumbup", 1);
        mongoTemplate.updateFirst(query, update, "spit");
    }
}
