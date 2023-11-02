package com.hspedu.furns.entity;

import java.util.List;

/**
 * 为分页数据创建数据模式，这种编程思想要掌握！
 * @author ZhengLiHua
 * @date 2023-10-31
 */

//考虑到将来分页模型对应的数据类型可能是不确定的，因此使用泛型
public class Page<T> {
    //因为每行显示的记录数在别处也可能用的到，所有设为public的常量
    public static final Integer PAGE_SIZE = 3;
    //每页显示的记录数，数据由前端传来，并给个默认值
    private Integer pageSize = PAGE_SIZE;
    //显示当前是第几页，数据由前端传来
    private Integer pageNo;
    //总共有多少行，数据由Dao层获取
    private Integer totalRow;
    //总共有多少页，这个数据通过totalRow和pageSize计算得来
    private Integer pageTotalCount;
    //当前页要显示数据的集合，数据由Dao层获取
    private List<T> items;
    //分页导航
    private String url;

    public Page() {
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageSize=" + pageSize +
                ", pageNo=" + pageNo +
                ", totalRow=" + totalRow +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Page(Integer pageSize, Integer pageNo, Integer totalRow, Integer pageTotalCount, List<T> items, String url) {
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.totalRow = totalRow;
        this.pageTotalCount = pageTotalCount;
        this.items = items;
        this.url = url;
    }
}
