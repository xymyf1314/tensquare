package com.tensquare.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.recruit.pojo.Recruit;

import java.util.List;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface RecruitDao extends JpaRepository<Recruit, String>, JpaSpecificationExecutor<Recruit> {
    /**
     * 推荐职位
     * 日期: 16:13 2020/10/10
     * 作者: miyf
     *
     * @param state 职位状态 0 关闭 1开启 2推荐
     * @return List<Recruit>
     **/
    public List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String state); // where state = ? order by createtime

    /**
     * 最新职位
     * 日期: 16:13 2020/10/10
     * 作者: miyf
     *
     * @param state 职位状态 0 关闭 1开启 2推荐
     * @return List<Recruit>
     **/
    public List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String state); // where state != ? order by createtime

}
