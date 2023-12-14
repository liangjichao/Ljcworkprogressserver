package com.jdl.wps.domain.vo;

import com.jdl.wps.domain.dto.WpsQueryDto;
import lombok.Data;

/**
 * @author liangjichao
 * @date 2023/10/12 2:38 PM
 */
@Data
public class WpsVo {
    private String userCode;
    private String projectName;
    private String devBranchName;
    private String appVersion;
    private Integer progressStatus;

    private Long offset;
    private Integer limit;

    private Long cpage;
    private Integer pageSize;

    public void convertPage(WpsQueryDto queryDto) {
        cpage=queryDto.getCpage();
        pageSize=queryDto.getPageSize();
        offset = (cpage - 1) * pageSize;
        limit = pageSize;
    }
}
