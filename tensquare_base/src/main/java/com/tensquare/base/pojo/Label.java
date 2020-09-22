package com.tensquare.base.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>标签Label实体类
 * <p>Compiler:fan
 * <p>版本:xxxxxxxxxx
 * <p>文件名：com.tensquare.base.pojo.Label.java
 * <p>作者: miyf1
 * <p>创建时间: 2020年09月17日 14:46
 * <p>负责人:fan
 * <p>修改者： fan
 * <p>修改时间：
 */

@Entity
@Table(name = "tb_label")
public class Label implements Serializable {
    @Id
    private String id;
    private String labelname;   //标签名称
    private String state;       //状态
    private Long count;         //使用数量
    private Long fans;          //关注数
    private String recommend;   //是否推荐

    public Label(String id, String labelname, String state, Long count, Long fans, String recommend) {
        this.id = id;
        this.labelname = labelname;
        this.state = state;
        this.count = count;
        this.fans = fans;
        this.recommend = recommend;
    }

    public Label() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabelname() {
        return labelname;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getFans() {
        return fans;
    }

    public void setFans(Long fans) {
        this.fans = fans;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }
}
