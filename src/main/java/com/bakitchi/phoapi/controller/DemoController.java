package com.bakitchi.phoapi.controller;

import com.bakitchi.phoapi.dao.BaseDAO;
import com.bakitchi.phoapi.entity.TechBaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

  @RequestMapping(value = "/test",method = RequestMethod.GET)
  public  String demo() throws Exception {
    baseDAO.findOneUser("100");
    return "";
  }

  @RequestMapping(value = "/teacher/{id}",method = RequestMethod.GET)
  public TechBaseEntity demo(@PathVariable(value = "id") Integer id) throws Exception {
    return baseDAO.daoGetTeacherInfo(id);
  }
}
