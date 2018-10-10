package com.treasure.ssc.util;

import com.treasure.ssc.act.vo.BaseOutVo;

/**
 * 响应结果格式化
 * @author: mazy
 * @date: 2018/9/25 17:58
 */
public class ResultUtils {
    /**
     * 组装正确结果
     * @param data
     * @param <T>
     * @return
     */
    public static final <T> BaseOutVo success(T data) {
        return success(data, null);
    }

    /**
     * 组装正确结果
     * @param data
     * @param message
     * @param <T>
     * @return
     */
    public static final <T> BaseOutVo success(T data, String message) {
        return success(data, message, null);
    }

    /**
     * 组装正确结果
     * @param data
     * @param message
     * @param description
     * @param <T>
     * @return
     */
    public static final <T> BaseOutVo success(T data, String message, String description) {
        BaseOutVo outVo = new BaseOutVo();
        outVo.setCode(200);
        outVo.setMessage(message);
        outVo.setDescription(description);
        outVo.setData(data);
        return outVo;
    }

    /**
     * 组装错误结果
     * @param message
     * @return
     */
    public static final BaseOutVo error(String message) {
        return error(message, null);
    }

    /**
     * 组装错误结果
     * @param message
     * @param description
     * @return
     */
    public static final BaseOutVo error(String message, String description) {
        return error(500, message, description);
    }

    /**
     * 组装错误结果
     * @param code
     * @param message
     * @param description
     * @return
     */
    public static final BaseOutVo error(Integer code, String message, String description) {
        BaseOutVo outVo = new BaseOutVo();
        outVo.setCode(code);
        outVo.setMessage(message);
        outVo.setDescription(description);
        outVo.setData(null);
        return outVo;
    }
}
