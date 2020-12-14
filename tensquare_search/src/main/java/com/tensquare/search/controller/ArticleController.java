package com.tensquare.search.controller;

import com.tensquare.search.pojo.Article;
import com.tensquare.search.service.ArticleService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * <p>文章的控制层
 * <p>Compiler: miyf
 * <p>版本:xxxxxxxxxx
 * <p>文件名：com.tensquare.search.controller.ArticleController.java
 * <p>作者: miyf
 * <p>创建时间: 2020年12月14日 15:13
 * <p>负责人: miyf
 * <p>修改者： miyf
 * <p>修改时间：
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 添加文章索引
     * 日期: 15:21 2020/12/14
     * 作者: miyf
     *
     * @param article 文章索引
     * @return Result 结果集
     **/
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Article article) {
        articleService.save(article);
        return new Result(true, StatusCode.OK, "添加成功");
    }
    /**
     * 查询方法，通过分词器查询
     * 日期: 15:26 2020/12/14
     * 作者: miyf
     * @param key 关键词
     * @param page 页数
     * @param size 页大小
     * @return Result 结果集
    **/
    @RequestMapping(value = "/{key}/{page}/{size}", method = RequestMethod.GET)
    public Result findByKey(@PathVariable String key, @PathVariable int page, @PathVariable int size) {
        Page<Article> pageData = articleService.findByKey(key, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Article>(pageData.getTotalElements(), pageData.getContent()));
    }
}
