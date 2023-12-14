package com.jdl.wps.controller;

import com.jdl.wps.domain.dto.ResultDto;
import com.jdl.wps.domain.dto.WpsDto;
import com.jdl.wps.domain.dto.WpsPageDto;
import com.jdl.wps.domain.dto.WpsQueryDto;
import com.jdl.wps.domain.entity.WpsMain;
import com.jdl.wps.domain.mapper.WpsMapper;
import com.jdl.wps.domain.vo.WpsVo;
import com.jdl.wps.service.HolidayService;
import com.jdl.wps.service.WpsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/wps")
public class WpsServerController {
    @Resource
    private WpsService wpsService;
    @Resource
    private HolidayService holidayService;

    /**
     * 根据年份和月份获取节假日列表
     * @param yearAndMonth 年份和月份，格式为yyyyMM
     * @return 响应的节假日列表
     */
    @RequestMapping(value = "/holiday/{yearAndMonth}", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<List<Integer>> holidayList(@PathVariable String yearAndMonth) {
        return ResultDto.success(holidayService.getHolidayListByMonth(yearAndMonth));
    }

    @RequestMapping(value = "/info/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<WpsDto> info(@PathVariable Long id) {
        WpsMain wpsMain = wpsService.byId(id);
        return ResultDto.success(WpsMapper.INSTANE.toDto(wpsMain));
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<WpsPageDto<List<WpsMain>>> list(@RequestBody WpsQueryDto queryDto) {
        log.info("查询列表:{}", queryDto.getUserCode());
        WpsVo query = WpsMapper.INSTANE.toVo(queryDto);
        query.convertPage(queryDto);
        return ResultDto.success(wpsService.queryAll(query));
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<String> insert(@RequestBody WpsDto wpsDto) {
        wpsService.insert(wpsDto);
        return ResultDto.success();
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<String> update(@RequestBody WpsDto wpsDto) {
        wpsService.update(wpsDto);
        return ResultDto.success();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<String> delete(@PathVariable Long id) {
        wpsService.delete(id);
        return ResultDto.success();
    }


}
