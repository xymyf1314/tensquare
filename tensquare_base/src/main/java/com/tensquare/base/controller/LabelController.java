package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * <p>Compiler:fan
 * <p>版本:xxxxxxxxxx
 * <p>文件名：com.tensquare.base.controller.BaseController.java
 * <p>作者: miyf1
 * <p>创建时间: 2020年09月17日 11:52
 * <p>负责人:fan
 * <p>修改者： fan
 * <p>修改时间：
 */
@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private LabelService labelService;

    /**
     * 查询全部
     * 日期: 14:33 2020/9/17
     * 作者: miyf1
     *
     * @return Result
     **/
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", labelService.findAll());
    }

    /**
     * 根据id查询
     * 日期: 14:34 2020/9/17
     * 作者: miyf1
     *
     * @param labelId labelId
     * @return Result
     **/
    @RequestMapping(value = "/{labelId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId) {
        return new Result(true, StatusCode.OK, "查询成功", labelService.findById(labelId));
    }

    /**
     * 添加方法
     * 日期: 14:49 2020/9/17
     * 作者: miyf1
     *
     * @param label 要添加label
     * @return Result
     **/
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label) {
        labelService.save(label);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 修改方法
     * 日期: 14:50 2020/9/17
     * 作者: miyf1
     *
     * @param labelId 要修改的id
     * @param label   修改后的值
     * @return Result
     **/
    @RequestMapping(value = "/{labelId}", method = RequestMethod.PUT)
    public Result update(@PathVariable("labelId") String labelId, @RequestBody Label label) {
        label.setId(labelId);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 日期: 14:50 2020/9/17
     * 作者: miyf1
     *
     * @param labelId 要删除的id
     * @return Result
     **/
    @RequestMapping(value = "/{labelId}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable("labelId") String labelId) {
        labelService.delete(labelId);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
