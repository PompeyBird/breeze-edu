package org.bird.breeze.edu.bean.common;

import java.util.List;

/**
 * @author pompey
 */
public class PageBean<T> {
    private Integer pageIndex;
    private Long total;
    private List<T> data;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
