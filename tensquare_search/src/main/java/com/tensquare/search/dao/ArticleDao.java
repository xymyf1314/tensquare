package com.tensquare.search.dao;

import com.tensquare.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * <p>
 * <p>Compiler: miyf
 * <p>版本:xxxxxxxxxx
 * <p>文件名：com.tensquare.search.dao.ArticleDao.java
 * <p>作者: miyf
 * <p>创建时间: 2020年12月14日 15:09
 * <p>负责人: miyf
 * <p>修改者： miyf
 * <p>修改时间：
 */
public interface ArticleDao extends ElasticsearchCrudRepository<Article, String> {

    public Page<Article> findByTitleOrContent(String title, String content, Pageable pageable);
}
