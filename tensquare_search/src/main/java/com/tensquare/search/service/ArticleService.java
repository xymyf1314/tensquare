package com.tensquare.search.service;

import com.tensquare.search.dao.ArticleDao;
import com.tensquare.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import util.IdWorker;

/**
 * <p>
 * <p>Compiler: miyf
 * <p>版本:xxxxxxxxxx
 * <p>文件名：com.tensquare.search.service.ArticleService.java
 * <p>作者: miyf
 * <p>创建时间: 2020年12月14日 15:10
 * <p>负责人: miyf
 * <p>修改者： miyf
 * <p>修改时间：
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 添加文章索引
     * 日期: 15:21 2020/12/14
     * 作者: miyf
     *
     * @param article 文章索引
     **/
    public void save(Article article) {
        article.setId(idWorker.nextId() + "");
        articleDao.save(article);
    }

    /**
     * 查询方法，通过分词器查询
     * 日期: 15:26 2020/12/14
     * 作者: miyf
     *
     * @param key  关键词
     * @param page 页数
     * @param size 页大小
     * @return Result 结果集
     **/
    public Page<Article> findByKey(String key, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return articleDao.findByTitleOrContent(key, key, pageable);
    }
}
