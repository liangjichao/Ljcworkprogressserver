package com.jdl.wps.dao;

import com.jdl.wps.domain.entity.WpsMain;
import com.jdl.wps.domain.vo.WpsVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WpsMainDao {
    List<WpsMain> queryAll(WpsVo query);

    Long queryRows(WpsVo query);

    boolean insert(WpsMain wpsMain);
    boolean update(WpsMain wpsMain);
    boolean deleteByPk(Long id);

    WpsMain byId(Long id);
}
