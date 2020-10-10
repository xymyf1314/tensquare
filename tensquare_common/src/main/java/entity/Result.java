package entity;

/**
 * 返回结果类
 * <p>Compiler:fan
 * <p>版本:xxxxxxxxxx
 * <p>文件名：entity.Result.java
 * <p>作者: miyf
 * <p>创建时间: 2020年09月17日 10:34
 * <p>负责人:fan
 * <p>修改者： fan
 * <p>修改时间：
 */
public class Result {
    /**
     * 是否成功
     **/
    private Boolean flag;
    /**
     * 状态码
     **/
    private Integer code;
    /**
     * 返回信息
     **/
    private String message;
    /**
     * 返回数据
     **/
    private Object data;

    public Result(Boolean flag, Integer code, String message) {
        this.code = code;
        this.flag = flag;
        this.message = message;
    }

    public Result(Boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result() {
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
