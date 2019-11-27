package com.belong.common.core.base;

import com.belong.common.core.constant.ResponseCodeConstans;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Description: 响应信息主体
 * @Author: fengyu
 * @CreateDate: 2019/11/20 15:25
 * @UpdateUser: fengyu
 * @UpdateDate: 2019/11/20 15:25
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(description = "全局响应信息主体")
public class ResponseVo<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @ApiModelProperty(value = "返回标记：成功标记=200，失败标记=-1")
    private Integer code;

    @Getter
    @Setter
    @ApiModelProperty(value = "返回信息")
    private String msg;


    @Getter
    @Setter
    @ApiModelProperty(value = "数据")
    private T data;

    public static <T> ResponseVo<T> ok() {
        return restResult(null, ResponseCodeConstans.REQUEST_SUCCESS, null);
    }

    public static <T> ResponseVo<T> ok(T data) {
        return restResult(data, ResponseCodeConstans.REQUEST_SUCCESS, null);
    }

    public static <T> ResponseVo<T> ok(Integer code, String msg) {
        return restResult(code, msg);
    }

    public static <T> ResponseVo<T> failed() {
        return restResult(null, ResponseCodeConstans.REQUEST_FAIL, null);
    }

    public static <T> ResponseVo<T> failed(String msg) {
        return restResult(null, ResponseCodeConstans.REQUEST_FAIL, msg);
    }

    public static <T> ResponseVo<T> failed(T data) {
        return restResult(data, ResponseCodeConstans.REQUEST_FAIL, null);
    }

    public static <T> ResponseVo<T> failed(T data, String msg) {
        return restResult(data, ResponseCodeConstans.REQUEST_FAIL, msg);
    }

    public static <T> ResponseVo<T> failed(Integer code, String msg) {
        return restResult(code, msg);
    }

    private static <T> ResponseVo<T> restResult(T data, int code, String msg) {
        ResponseVo<T> apiResult = new ResponseVo<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    private static <T> ResponseVo<T> restResult(int code, String msg) {
        ResponseVo<T> apiResult = new ResponseVo<>();
        apiResult.setCode(code);
        apiResult.setData(null);
        apiResult.setMsg(msg);
        return apiResult;
    }
}
