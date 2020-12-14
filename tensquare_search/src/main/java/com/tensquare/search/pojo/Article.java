package com.tensquare.search.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * <p>文章师徒类
 * <p>Compiler: miyf
 * <p>版本:xxxxxxxxxx
 * <p>文件名：com.tensquare.search.pojo.Article.java
 * <p>作者: miyf
 * <p>创建时间: 2020年12月14日 14:57
 * <p>负责人: miyf
 * <p>修改者： miyf
 * <p>修改时间：
 */
@Document(indexName = "tensquare_article",type = "article")
public class Article implements Serializable {

    @Id
    private String id;

    // 是否索引，就是看该域是否能被搜索 index = true
    // 是否分词，代表搜索时候是整体匹配还是单词匹配
    // 是否存储，就是是否在页面上显示
    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String title;

    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String content;

    private String state;//审核状态
}
