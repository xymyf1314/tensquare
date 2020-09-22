package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

/**
 * <p>Label的service层
 * <p>Compiler:fan
 * <p>版本:xxxxxxxxxx
 * <p>文件名：com.tensquare.base.service.LabelService.java
 * <p>作者: miyf1
 * <p>创建时间: 2020年09月17日 18:26
 * <p>负责人:fan
 * <p>修改者： fan
 * <p>修改时间：
 */
@Service
@Transactional
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部label
     * 日期: 18:33 2020/9/17
     * 作者: miyf1
     *
     * @return List<Label>
     **/
    public List<Label> findAll() {
        return labelDao.findAll();
    }

    /**
     * 通过id查询
     * 日期: 18:34 2020/9/17
     * 作者: miyf1
     *
     * @param id id
     * @return Label
     **/
    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    /**
     * 新增的方法
     * 日期: 18:34 2020/9/17
     * 作者: miyf1
     *
     * @param label 待保存的label
     **/
    public void save(Label label) {
        label.setId(String.valueOf(idWorker.nextId()));
        labelDao.save(label);
    }

    /**
     * 修改的方法
     * 日期: 18:35 2020/9/17
     * 作者: miyf1
     *
     * @param label 待修改的label
     **/
    public void update(Label label) {
        labelDao.save(label);
    }

    /**
     * 删除的方法
     * 日期: 18:36 2020/9/17
     * 作者: miyf1
     *
     * @param id 待删除label的id
     **/
    public void delete(String id) {
        labelDao.deleteById(id);
    }
}
