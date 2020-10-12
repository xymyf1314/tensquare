package com.tensquare.qa.dao;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface ProblemDao extends JpaRepository<Problem, String>, JpaSpecificationExecutor<Problem> {
    /**
     * 最新回答
     * 日期: 17:25 2020/10/10
     * 作者: miyf
     *
     * @param labelid  标签
     * @param pageable 分页对象
     * @return List<Problem>
     **/
    @Query(value = "SELECT * FROM  tb_problem tp,tb_pl tpl WHERE tp.id = tpl.problemid AND labelid = ?  ORDER BY tp.replytime DESC", nativeQuery = true)
    public Page<Problem> newList(String labelid, Pageable pageable);

    /**
     * 最热回答
     * 日期: 17:25 2020/10/10
     * 作者: miyf
     *
     * @param labelid  标签
     * @param pageable 分页对象
     * @return List<Problem>
     **/
    @Query(value = "SELECT * FROM  tb_problem tp,tb_pl tpl WHERE tp.id = tpl.problemid AND labelid = ?  ORDER BY tp.reply DESC", nativeQuery = true)
    public Page<Problem> hotList(String labelid, Pageable pageable);

    /*
     * 等待回答
     * 日期: 17:26 2020/10/10
     * 作者: miyf
     * @param labelid 标签
     * @param pageable 分页对象
     * @return List<Problem>
     **/
    @Query(value = "SELECT * FROM  tb_problem tp,tb_pl tpl WHERE tp.id = tpl.problemid AND labelid = ? AND reply=0 ORDER BY tp.createtime DESC", nativeQuery = true)
    public Page<Problem> waitList(String labelid, Pageable pageable);

}
