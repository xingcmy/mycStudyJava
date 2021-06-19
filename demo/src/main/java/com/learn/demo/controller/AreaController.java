package com.learn.demo.controller;

import com.learn.demo.entity.Area;
import com.learn.demo.exception.AreaException;
import com.learn.demo.service.AreaService;
import com.learn.demo.service.impl.AreaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superAdmin")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listArea",method = RequestMethod.GET)
    public Map<String,Object> listArea(){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<Area> areaList=areaService.getAreaList();
        modelMap.put("areaList",areaList);
        return modelMap;
    }

    @RequestMapping(value = "/areaId",method = RequestMethod.GET)
    public Map<String,Object> areaById(Integer areaId){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        Area area=areaService.getAreaById(areaId);
        modelMap.put("area",area);
        return modelMap;
    }

    @RequestMapping(value = "/addArea",method = RequestMethod.POST)
    public Map<String,Object> addArea(@RequestBody Area area) {
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("addArea",areaService.addArea(area));
        return modelMap;
    }

    @RequestMapping(value = "/modifyArea",method = RequestMethod.POST)
    public Map<String,Object> modifyArea(@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("modifyArea",areaService.modifyArea(area));
        return modelMap;
    }

    @RequestMapping(value = "/removeArea",method = RequestMethod.GET)
    public Map<String,Object> removeArea(Integer areaId){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("removeArea",areaService.deleteArea(areaId));
        return modelMap;
    }
}
