package com.bakitchi.phoapi.controller;

import com.bakitchi.phoapi.dao.BaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/16 下午2:00
 * @Description:
 */
@RestController
@RequestMapping(value = "/subject")
public class SubjectController {
    @Autowired
    BaseDAO baseDAO;

    @RequestMapping(method = RequestMethod.GET)
    public List<String> getAllSubjects(){
        return baseDAO.daoGetAllSubjects();
    }
}
