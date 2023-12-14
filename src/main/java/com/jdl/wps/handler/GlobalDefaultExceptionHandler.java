package com.jdl.wps.handler;

import com.jdl.wps.domain.dto.ResultDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liangjichao
 * @date 2023/10/13 2:36 PM
 */
@Slf4j
@ControllerAdvice
class GlobalDefaultExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultDto<String> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        log.error("请求处理失败:{}", e);
        return ResultDto.fail(e.getMessage());
    }
}