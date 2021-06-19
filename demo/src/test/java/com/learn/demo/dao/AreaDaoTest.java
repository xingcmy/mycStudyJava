package com.learn.demo.dao;

import com.learn.demo.entity.Area;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    void queryArea() {
        List<Area> areaList=areaDao.queryArea();
        System.out.println(areaList.toString());
    }

    @Test
    void queryAreaId() {
        Area area=areaDao.queryAreaId(1);
        System.out.println(area.toString());
    }

    @Test
    void insertArea() {
        Area area=new Area();
        area.setAreaName("上海");
        area.setPriority(2);
        int effect=areaDao.insertArea(area);
        assertEquals(1,effect);
    }

    @Test
    void updateArea() {
        Area area=new Area();
        area.setAreaName("四川");
        area.setAreaId(1);
        area.setLastEditTime(new Date());
        int effect=areaDao.updateArea(area);
        assertEquals(1,effect);
    }

    @Test
    void deleteArea() {
        int effect=areaDao.deleteArea(1);
        assertEquals(1,effect);
    }
}