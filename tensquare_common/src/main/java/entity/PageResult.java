package entity;


import java.util.List;

/**
 * <p> 分页类
 * <p>Compiler:fan
 * <p>版本:xxxxxxxxxx
 * <p>文件名：entity.PageResult.java
 * <p>作者: miyf1
 * <p>创建时间: 2020年09月17日 10:51
 * <p>负责人:fan
 * <p>修改者： fan
 * <p>修改时间：
 */
public class PageResult<T> {
    private long total;
    private List<T> rows;

    public PageResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
