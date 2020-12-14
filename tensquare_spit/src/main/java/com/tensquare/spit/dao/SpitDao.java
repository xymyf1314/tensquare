package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * <p>
 * <p>Compiler:fan
 * <p>版本:xxxxxxxxxx
 * <p>文件名：com.tensquare.spit.dao.SpitDao.java
 * <p>作者: miyf1
 * <p>创建时间: 2020年10月28日 10:19
 * <p>负责人:fan
 * <p>修改者： fan
 * <p>修改时间：
 */
public interface SpitDao extends MongoRepository<Spit, String> {
    /**
     * 根据父级id分页查询
     * 日期: 11:29 2020/10/28
     * 作者: miyf
     *
     * @param parentid 父级id
     * @param pageable 分页对象
     * @return Page<Spit>
     **/
    public Page<Spit> findByParentid(String parentid, Pageable pageable);
}
