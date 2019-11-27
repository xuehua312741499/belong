package com.belong.common.exception.handler;

import com.belong.common.core.base.ResponseVo;
import com.belong.common.exception.base.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import java.rmi.ServerException;

/**
 * @Description: 异常处理器
 * @Author: fengyu
 * @CreateDate: 2019/11/26 18:01
 * @UpdateUser: fengyu
 * @UpdateDate: 2019/11/26 18:01
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 方法实现说明:请求方式不支持
     *
     * @param e
     * @return com.belong.common.core.base.ResponseVo
     * @throws
     * @author fengyu
     * @date 2019/11/26 18:12
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseVo handleException(HttpRequestMethodNotSupportedException e) {
        log.warn(e.getMessage(), e);
        return ResponseVo.failed(500, "不支持' " + e.getMethod() + "'请求");
    }

    /**
     * 方法实现说明:拦截未知的运行时异常
     *
     * @param e
     * @return com.belong.common.core.base.ResponseVo
     * @throws
     * @author fengyu
     * @date 2019/11/27 9:50
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseVo notFount(RuntimeException e) {
        log.warn("运行时异常:", e);
        return ResponseVo.failed("运行时异常:" + e.getMessage());
    }

    /**
     * 方法实现说明:重复插入异常
     *
     * @param e
     * @return com.belong.common.core.base.ResponseVo
     * @throws
     * @author fengyu
     * @date 2019/11/27 9:51
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseVo handleDuplicateKeyException(DuplicateKeyException e) {
        log.warn(e.getMessage(), e);
        return ResponseVo.failed("数据库中已存在该记录！");
    }

    /**
     * 方法实现说明:未拦截异常
     *
     * @param e
     * @return com.belong.common.core.base.ResponseVo
     * @throws
     * @author fengyu
     * @date 2019/11/27 9:51
     */
    @ExceptionHandler(Exception.class)
    public ResponseVo handleException(Exception e) {
        log.warn(e.getMessage(), e);
        return ResponseVo.failed("服务器错误，请联系管理员!");
    }

    /**
     * 方法实现说明:无权限异常
     *
     * @param e
     * @return com.belong.common.core.base.ResponseVo
     * @throws
     * @author fengyu
     * @date 2019/11/27 9:52
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseVo handle401(UnauthorizedException e) {
        return ResponseVo.failed(401, e.getMessage());
    }
}