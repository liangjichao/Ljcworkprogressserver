package com.jdl.wps.domain.mapper;

import com.alibaba.fastjson.JSON;
import com.jdl.wps.domain.dto.WpsDto;
import com.jdl.wps.domain.entity.WpsMain;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


/**
 * @author liangjichao
 * @date 2023/10/12 4:35 PM
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class WpsMapperTest {

    @Test
    public void toEntity() {
        WpsDto wpsDto = new WpsDto();
        wpsDto.setUserCode("ljc");
        wpsDto.setCardUrl("http://");
        wpsDto.setStartTime("2023-10-12 00:00:00");
        WpsMain wpsMain = WpsMapper.INSTANE.toEntity(wpsDto);
        Assertions.assertEquals(wpsMain.getUserCode(),"ljc");
        Assertions.assertEquals(wpsMain.getCard(),"http://");
        Assertions.assertEquals(DateFormatUtils.format(wpsMain.getPlanStartTime(), "yyyy-MM-dd HH:mm:ss"), "2023-10-12 00:00:00");
    }
}