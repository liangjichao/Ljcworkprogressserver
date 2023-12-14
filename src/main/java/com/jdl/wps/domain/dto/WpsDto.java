package com.jdl.wps.domain.dto;

import lombok.Data;

@Data
public class WpsDto {
    private Long id;
    private String userCode;
    private String cardUrl;
    private Integer progressStatus;
    private String startTime;
    private String endTime;
    private String projectName;
    private String prd;
    private String productManager;
    private String devBranchName;
    private String appVersion;
    private String devInfo;
    private int forcedDependency;
}
