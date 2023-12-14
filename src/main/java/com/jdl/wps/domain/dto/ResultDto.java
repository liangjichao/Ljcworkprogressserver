package com.jdl.wps.domain.dto;

import lombok.Data;

/**
 * @author liangjichao
 * @date 2023/10/13 10:33 AM
 */
@Data
public class ResultDto<T> {
    public static final int DEFAULT_RESULT_CODE = 1;
    public static final int DEFAULT_RESULT_CODE_FAILD = -1;

    private boolean success;
    private Integer resultCode;
    private T resultValue;
    private String resultMessage;

    public ResultDto() {
        this.resultCode = DEFAULT_RESULT_CODE;
    }

    public static <E> ResultDto<E> success(E resultValue) {
        ResultDto<E> resultDto = new ResultDto<>();
        resultDto.setSuccess(true);
        resultDto.setResultValue(resultValue);
        return resultDto;
    }
    public static ResultDto<String> success() {
        return ResultDto.success(null);
    }
    public static <T> ResultDto<T> fail(String resultMessage) {
        ResultDto<T> resultDto = new ResultDto<>();
        resultDto.setSuccess(false);
        resultDto.setResultCode(DEFAULT_RESULT_CODE_FAILD);
        resultDto.setResultMessage(resultMessage);
        return resultDto;
    }
}

