package com.bakitchi.phoapi.controller;

import com.bakitchi.phoapi.dao.BaseDAO;
import com.bakitchi.phoapi.dto.TeacherBasicInfoDTO;
import com.bakitchi.phoapi.entity.TechBaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/14 下午3:49
 * @Description:
 */
@RestController
public class DemoController {
  @Autowired
  BaseDAO baseDAO;


  @RequestMapping(value = "/teacher/{id}",method = RequestMethod.GET)
  public TeacherBasicInfoDTO demo(@PathVariable(value = "id") Integer id) throws Exception {
    return baseDAO.daoGetTeacherInfoById(id);
  }

  @RequestMapping(value = "/teacher/byname/",method = RequestMethod.GET)
  public TechBaseEntity demo(@RequestParam(value = "name") String name) throws Exception {
    return baseDAO.daoGetTeacherInfoByName(name);
  }
}
