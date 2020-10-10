package com.tensquare.base.dao;

import com.tensquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <p> Label 的DAO层
 * <p>Compiler:fan
 * <p>版本:xxxxxxxxxx
 * <p>文件名：com.tensquare.base.dao.LabelDao.java
 * <p>作者: miyf
 * <p>创建时间: 2020年09月17日 15:05
 * <p>负责人:fan
 * <p>修改者： fan
 * <p>修改时间：
 */
public interface LabelDao extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {
}
