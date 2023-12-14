package com.jdl.wps.domain.dto;

import com.jdl.wps.domain.vo.WpsVo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liangjichao
 * @date 2023/10/17 8:26 PM
 */
@Data
@NoArgsConstructor
public class WpsPageDto<T> {
    /**
     * 当前页
     */
    private Long cpage;
    /**
     * 每页记录个数
     */
    private Integer pageSize;
    /**
     * 总记录
     */
    private Long rows;

    private T pageData;

    public WpsPageDto(WpsVo vo) {
        this.cpage = vo.getCpage();
        this.pageSize = vo.getPageSize();
    }
}
