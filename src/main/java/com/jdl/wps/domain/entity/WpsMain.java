package com.jdl.wps.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class WpsMain {
    private Long id;
    private String userCode;
    private Integer progressStatus;
    private Date planStartTime;
    private Date planEndTime;
    private String projectName;
    private String prd;
    private String productManager;
    private String devBranchName;
    private String appVersion;
    private String card;
    private String devInfo;
    private int forcedDependency;
    private Integer deleted;
    private Date createTime;
    private Date updateTime;
}
