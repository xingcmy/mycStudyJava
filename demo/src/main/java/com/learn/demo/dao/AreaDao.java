package com.learn.demo.dao;

import com.learn.demo.entity.Area;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AreaDao {
    List<Area> queryArea();
    Area queryAreaId(int areaId);
    int insertArea(Area area);
    int updateArea(Area area);
    int deleteArea(int areaId);
}
