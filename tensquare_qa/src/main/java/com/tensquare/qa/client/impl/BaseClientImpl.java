package com.tensquare.qa.client.impl;

import com.tensquare.qa.client.BaseClient;
import entity.Result;
import entity.StatusCode;
import org.springframework.stereotype.Component;

/**
 * <p>
 * <p>Compiler: miyf
 * <p>版本:xxxxxxxxxx
 * <p>文件名：com.tensquare.qa.client.impl.BaseClientImpl.java
 * <p>作者: miyf
 * <p>创建时间: 2020年12月24日 11:50
 * <p>负责人: miyf
 * <p>修改者： miyf
 * <p>修改时间：
 */
@Component
public class BaseClientImpl implements BaseClient {
    @Override
    public Result findById(String labelId) {
        return new Result(false, StatusCode.ERROR, "熔断器触发了");
    }
}
