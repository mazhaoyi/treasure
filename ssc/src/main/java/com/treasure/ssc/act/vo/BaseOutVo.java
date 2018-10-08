package com.treasure.ssc.act.vo;

import java.io.Serializable;

/**
 * @author: mazy
 * @date: 2018/9/25 17:54
 */
public class BaseOutVo<T> implements Serializable {
    private static final long serialVersionUID = -1819605996229242894L;
    private Integer code;
    private String message;
    private String description;
    private T data;

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
