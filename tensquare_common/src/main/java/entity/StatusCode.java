package entity;

/**
 * <p> 状态码
 * <p>Compiler:fan
 * <p>版本:xxxxxxxxxx
 * <p>文件名：entity.StatusCode.java
 * <p>作者: miyf
 * <p>创建时间: 2020年09月17日 10:54
 * <p>负责人:fan
 * <p>修改者： fan
 * <p>修改时间：
 */
public class StatusCode {
    public static final int OK = 20000;             //成功
    public static final int ERROR = 20001;          //失败
    public static final int LOGINERROR = 20002;     //用户名或密码错误
    public static final int ACCESSERROR = 20003;    //权限不足
    public static final int REMOTEERROR = 20004;    //远程调用失败
    public static final int REPERROR = 20005;       //重复操作
}
