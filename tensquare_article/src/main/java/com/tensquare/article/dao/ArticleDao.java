package com.tensquare.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.article.pojo.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface ArticleDao extends JpaRepository<Article, String>, JpaSpecificationExecutor<Article> {
    /**
     * 文章审核
     * 日期: 10:13 2020/10/13
     * 作者: miyf
     *
     * @param id 文章id
     * @return void
     **/
    @Modifying
    @Query(value = "UPDATE tb_article SET state = 1 where id = ?", nativeQuery = true)
    public void updateState(String id);

    /**
     * 点赞数增加
     * 日期: 10:19 2020/10/13
     * 作者: miyf
     *
     * @param id 文章id
     * @return void
     **/
    @Modifying
    @Query(value = "UPDATE tb_article SET thumbup = thumbup + 1 where id = ?", nativeQuery = true)
    public void addThumbup(String id);
}
