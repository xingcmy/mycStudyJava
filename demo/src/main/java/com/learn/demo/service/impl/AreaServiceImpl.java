package com.learn.demo.service.impl;

import com.learn.demo.dao.AreaDao;
import com.learn.demo.entity.Area;
import com.learn.demo.exception.AreaException;
import com.learn.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.queryAreaId(areaId);
    }

    @Transactional  //默认回滚RuntimeException 运行时异常
    @Override
    public boolean addArea(Area area) {
        if (area.getAreaName()!=null && "".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effect=areaDao.insertArea(area);
                if (effect > 0){
                    return true;
                }else {
                    throw new RuntimeException("Inserting message error");
                }
            }catch (Exception e){
                throw new RuntimeException("Failed to insert message:"+e.getMessage());
            }
        }else {
            throw new RuntimeException("The insert information is empty");
        }
    }

    @Transactional
    @Override
    public boolean modifyArea(Area area) {
        if (area.getAreaId()!=null && area.getAreaId() > 0){
            area.setLastEditTime(new Date());
            try {
                int effect=areaDao.updateArea(area);
                if (effect > 0){
                    return true;
                }else {
                    throw new RuntimeException("Updating message error");
                }
            }catch (Exception e){
                throw new RuntimeException("Failed to update message:"+e.getMessage());
            }
        }else {
            throw new RuntimeException("The update information is empty");
        }
    }

    @Transactional
    @Override
    public boolean deleteArea(int areaId) {
        if (areaId > 0){
            try {
                int effect=areaDao.deleteArea(areaId);
                if (effect > 0){
                    return true;
                }else {
                    throw new RuntimeException("Delete message error");
                }
            }catch (Exception e){
                throw new RuntimeException("Failed to delete message:"+e.getMessage());
            }
        }else {
            throw new RuntimeException("ID deletion error");
        }
    }
}
