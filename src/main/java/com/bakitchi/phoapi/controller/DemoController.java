package com.bakitchi.phoapi.controller;

import com.bakitchi.phoapi.dao.BaseDAO;
import com.bakitchi.phoapi.dto.TeacherBasicInfoDTO;
import com.bakitchi.phoapi.entity.CollegeNodesEntity;
import com.bakitchi.phoapi.entity.TechAllEntity;
import com.bakitchi.phoapi.entity.TechBaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/14 下午3:49
 * @Description:
 */
@RestController
public class DemoController {
  @Autowired
  BaseDAO baseDAO;

//
//  @RequestMapping(value = "/teacher/{id}",method = RequestMethod.GET)
//  public TeacherBasicInfoDTO demo(@PathVariable(value = "id") Integer id) throws Exception {
//    return baseDAO.daoGetTeacherInfoById(id);
//  }
//
//
//
//    @RequestMapping(value = "/college/{id}",method = RequestMethod.GET)
//    public List<TechAllEntity> getTeacherInfoByCollegeId(@PathVariable(value = "id") Integer id) throws Exception {
//        return baseDAO.daoGetTeacherInfoByCollegeId(id);
//    }
//
//  @RequestMapping(value = "/teacherVisit/{id}",method = RequestMethod.GET)
//  public Integer getTeacherVisitByTeacherId(@PathVariable(value = "id") Integer id) throws Exception {
//    return baseDAO.daoGetVisitByTeacherId(id);
//  }
//
//  @RequestMapping(value = "/updateVisit/{id}",method = RequestMethod.GET)
//  public void updateVisitByTeacherId(@PathVariable(value = "id") Integer id) throws Exception {
//    baseDAO.daoUpdateVisitByTeacherId(id);
//  }

}
