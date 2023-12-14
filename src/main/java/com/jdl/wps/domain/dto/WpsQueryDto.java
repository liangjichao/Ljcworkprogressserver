package com.jdl.wps.domain.dto;

import lombok.Data;

/**
 * @author liangjichao
 * @date 2023/10/13 2:00 PM
 */
@Data
public class WpsQueryDto {
    private String userCode;
    private String projectName;
    private String devBranchName;
    private String appVersion;
    private Integer progressStatus;

    private Long cpage;
    private Integer pageSize;
}
