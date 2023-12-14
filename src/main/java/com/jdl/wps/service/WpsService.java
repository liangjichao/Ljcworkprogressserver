package com.jdl.wps.service;

import com.jdl.wps.dao.WpsMainDao;
import com.jdl.wps.domain.dto.WpsDto;
import com.jdl.wps.domain.dto.WpsPageDto;
import com.jdl.wps.domain.entity.WpsMain;
import com.jdl.wps.domain.mapper.WpsMapper;
import com.jdl.wps.domain.vo.WpsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class WpsService {
    @Resource
    private WpsMainDao wpsMainDao;

    public WpsPageDto<List<WpsMain>> queryAll(WpsVo query) {
        WpsPageDto pageDto = new WpsPageDto(query);
        List<WpsMain> pageData = wpsMainDao.queryAll(query);
        Long rows = wpsMainDao.queryRows(query);
        pageDto.setPageData(pageData);
        pageDto.setRows(rows);
        return pageDto;
    }

    @Transactional
    public void insert(WpsDto wpsDto) {
        WpsMain wpsMain = WpsMapper.INSTANE.toEntity(wpsDto);
        wpsMainDao.insert(wpsMain);
    }

    @Transactional
    public void update(WpsDto wpsDto) {
        WpsMain wpsMain = WpsMapper.INSTANE.toEntity(wpsDto);
        wpsMainDao.update(wpsMain);
    }
    @Transactional
    public void delete(Long id) {
        wpsMainDao.deleteByPk(id);
    }

    public WpsMain byId(Long id) {
        return wpsMainDao.byId(id);
    }
}
