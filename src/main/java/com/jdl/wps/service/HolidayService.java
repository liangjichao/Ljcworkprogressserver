package com.jdl.wps.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.jdl.wps.component.CacheHelper;
import com.jdl.wps.domain.vo.HolidayResultVo;
import com.jdl.wps.domain.vo.HolidayVo;
import com.jdl.wps.enums.HolidayTypeEnum;
import com.jdl.wps.util.RestUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
public class HolidayService {


    /**
     * 根据年月获取假期列表
     *
     * @param yearAndMonth 年月字符串，格式为"yyyyMM"
     * @return 假期列表，包含该年月的所有假期日期
     */

    public List<Integer> getHolidayListByMonth(String yearAndMonth) {
        try {
            return CacheHelper.YearMonthHolidayCache.get(yearAndMonth, new Callable<List<Integer>>() {
                @Override
                public List<Integer> call() throws Exception {
                    List<Integer> holidayList = Lists.newArrayList();
                    String holidayDataByMonth = getHolidayDataByMonth(yearAndMonth);
                    HolidayResultVo resultVo = JSON.parseObject(holidayDataByMonth, HolidayResultVo.class);
                    if (resultVo.getCode().equals(1) && resultVo.getData() != null) {
                        for (HolidayVo datum : resultVo.getData()) {
                            if (HolidayTypeEnum.REST_DAY.getCode() == datum.getType() || HolidayTypeEnum.HOLIDAY.getCode() == datum.getType()) {
                                holidayList.add(datum.getDayOfYear());
                            }
                        }
                    }
                    return holidayList;
                }
            });
        } catch (ExecutionException e) {
            log.error("根据年月获取假期列表失败", e);
        }
        return Lists.newArrayList();
    }


    /**
     * 根据年份和月份获取假期数据
     *
     * @param yearAndMoth 年份和月份，格式为yyyyMM，例如202112
     * @return String 返回假期数据的字符串
     */
    public String getHolidayDataByMonth(String yearAndMoth) {
        String appid = "rdljlmkrknuisw8m";
        String appSecret = "y0XdiM1E6G4fLDxD8ErcW0X1sgH70sBP";
        String url = String.format("https://www.mxnzp.com/api/holiday/list/month/%s?ignoreHoliday=false&app_id=%s&app_secret=%s", yearAndMoth, appid, appSecret);
        return RestUtils.get(url);
    }
}
