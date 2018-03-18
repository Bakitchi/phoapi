package com.bakitchi.phoapi.controller;

import com.bakitchi.phoapi.dao.BaseDAO;
import com.bakitchi.phoapi.dto.CollegeNetDTO;
import com.bakitchi.phoapi.dto.PercentDTOS;
import com.bakitchi.phoapi.dto.SubjectDTO;
import com.bakitchi.phoapi.dto.TeacherNetDTO;
import com.sun.org.apache.bcel.internal.generic.LSTORE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/18 下午1:22
 * @Description:
 */

@RestController
@RequestMapping(value="/analysis")
public class AnalysisController {
    @Autowired
    BaseDAO baseDAO;

    @RequestMapping(value = "/percent",method = RequestMethod.GET)
    public List<PercentDTOS> getPercent(@RequestParam("colleges") String[] colleges){
        List<PercentDTOS> percentDTOSList = new ArrayList<>();

        for (int i = 0; i < colleges.length; i++) {
            PercentDTOS percentDTOS = new PercentDTOS();
            percentDTOS.setCollege(colleges[i]);
            percentDTOS.setList(baseDAO.daoGetYearPercentByCollege(colleges[i]));
            percentDTOSList.add(percentDTOS);
        }
        return percentDTOSList;
    }

    @RequestMapping(value = "/teacherNet",method = RequestMethod.GET)
    public String getTeacherNet(@RequestParam("nameList") List<String> nameList){
        TeacherNetDTO teacherNetDTO = new TeacherNetDTO();
        teacherNetDTO.setEdges(baseDAO.daoGetTeacherEdgesByTeacherName(nameList));
        teacherNetDTO.setNodes(baseDAO.daoGetTeacherNodesByTeacherName(nameList));
        return teacherNetDTO.toString();
    }

    @RequestMapping(value = "/collegeNet",method = RequestMethod.GET)
    public String getCollegeNet(@RequestParam("nameList") List<String> nameList){
        CollegeNetDTO collegeNetDTO = new CollegeNetDTO();
        collegeNetDTO.setEdges(baseDAO.daoGetCollegeEdgesByCollegeName(nameList));
        collegeNetDTO.setNodes(baseDAO.daoGetCollegeNodesByCollegeName(nameList));
        return collegeNetDTO.toString();
    }

    @RequestMapping(value = "/subject",method = RequestMethod.GET)
    public List<SubjectDTO> getSubjectBySubjectName(@RequestParam(value = "belongList") List<String> belongList) throws Exception
    {
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        for (String belongItem : belongList){
            SubjectDTO subjectDTO = new SubjectDTO();
            subjectDTO.setSubject(belongItem);
            subjectDTO.setSubjectEntity(baseDAO.daoGetSubjectBySubjectName(belongItem));
            subjectDTOS.add(subjectDTO);
        }
        return subjectDTOS;
    }

    @RequestMapping(value = "/subjectAll",method = RequestMethod.GET)
    public List<SubjectDTO> getSubjectBySubjectName() throws Exception
    {

        List<String> belongList = baseDAO.daoGetAllSubjects();


        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        for (String belongItem : belongList){
            SubjectDTO subjectDTO = new SubjectDTO();
            subjectDTO.setSubject(belongItem);
            subjectDTO.setSubjectEntity(baseDAO.daoGetSubjectBySubjectName(belongItem));
            subjectDTOS.add(subjectDTO);
        }
        return subjectDTOS;
    }

}
