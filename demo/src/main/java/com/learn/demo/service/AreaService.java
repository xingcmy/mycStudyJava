package com.learn.demo.service;

import com.learn.demo.entity.Area;
import com.learn.demo.exception.AreaException;
import org.springframework.stereotype.Component;

import java.util.List;

public interface AreaService {
    List<Area> getAreaList();
    Area getAreaById(int areaId);
    boolean addArea(Area area);
    boolean modifyArea(Area area);
    boolean deleteArea(int areaId);
}
