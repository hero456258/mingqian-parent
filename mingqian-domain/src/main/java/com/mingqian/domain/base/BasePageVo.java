package com.mingqian.domain.base;

import java.io.Serializable;

public class BasePageVo implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Long DEFAULT_START = 0L;

    public static final Long DEFAULT_ROWS = 10L;

    /**
     * 第几页
     */
    private Long start = DEFAULT_START;

    /**
     * 每页记录数
     */
    private Long rows = DEFAULT_ROWS;

    /**
     * 查询开始位置
     */
    private Long rowStart;

    /**
     * 查询结束位置
     */
    private Long rowEnd;

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        if(start == null || start <= 0){
            this.start = DEFAULT_START;
        }else{
            this.start = start;
        }
    }

    public Long getRows() {
        return rows;
    }

    public void setRows(Long rows) {
        this.rows = rows;
    }

    public Long getRowStart() {
        if(start != null && start > 0){
            //oracle从第一条记录开始  加一操作
            this.rowStart = (start -1) * rows ;
        }
        return rowStart;
    }


    public Long getRowEnd() {
        if(rows != null && rows > 0){
            this.rowEnd = rows;
        }
            return rowEnd;
    }

    public void setRowEnd(Long rowEnd) {
        if(rows != null && rows > 0){
            this.rowEnd = rows;
        }
        this.rowEnd = this.rows;
    }
}
