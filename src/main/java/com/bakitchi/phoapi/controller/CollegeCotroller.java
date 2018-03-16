package com.bakitchi.phoapi.controller;

import com.bakitchi.phoapi.dao.BaseDAO;
import com.bakitchi.phoapi.dto.CollegeDTO;
import com.bakitchi.phoapi.entity.CollegeNodesEntity;
import com.bakitchi.phoapi.entity.TechAllEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value="/college")
public class CollegeCotroller {

    @Autowired
    BaseDAO baseDAO;

    //获得所有学院
    @RequestMapping(method = RequestMethod.GET)
    public List<CollegeDTO> getCollege(){
        return baseDAO.daoGetAllCollege();

    }

    //学院下所有老师
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public List<TechAllEntity> getTeacherInfoByCollegeId(@PathVariable(value = "id") Integer id) throws Exception {
        return baseDAO.daoGetTeacherInfoByCollegeId(id);
    }
}
