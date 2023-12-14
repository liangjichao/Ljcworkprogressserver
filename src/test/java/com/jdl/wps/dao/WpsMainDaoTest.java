package com.jdl.wps.dao;

import com.jdl.wps.domain.entity.WpsMain;
import com.jdl.wps.domain.vo.WpsVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;


/**
 * @author liangjichao
 * @date 2023/10/13 10:24 AM
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class WpsMainDaoTest {
    @Resource
    private WpsMainDao wpsMainDao;
    @Test
    public void update() {
        WpsMain wpsMain = wpsMainDao.queryAll(new WpsVo()).get(0);
        wpsMain.setProjectName("update project");
        Assertions.assertTrue(wpsMainDao.update(wpsMain));
    }

    @Test
    public void deleteByPk() {
        Assertions.assertTrue(wpsMainDao.deleteByPk(1L));
    }
}