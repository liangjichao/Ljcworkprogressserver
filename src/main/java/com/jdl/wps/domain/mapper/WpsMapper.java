package com.jdl.wps.domain.mapper;

import com.jdl.wps.domain.dto.WpsDto;
import com.jdl.wps.domain.dto.WpsQueryDto;
import com.jdl.wps.domain.entity.WpsMain;
import com.jdl.wps.domain.vo.WpsVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author liangjichao
 * @date 2023/10/12 3:10 PM
 */
@Mapper
public interface WpsMapper {
    WpsMapper INSTANE = Mappers.getMapper(WpsMapper.class);
    @Mapping(target="card",source = "cardUrl")
    @Mapping(target="planStartTime",source="startTime",dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target="planEndTime",source="endTime",dateFormat = "yyyy-MM-dd HH:mm:ss")
    WpsMain toEntity(WpsDto wpsDto);

    WpsVo toVo(WpsQueryDto queryDto);

    WpsDto toDto(WpsMain wpsMain);
}
