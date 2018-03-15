package com.bakitchi.phoapi.dto;

import com.bakitchi.phoapi.entity.PapersInfoEntity;
import com.bakitchi.phoapi.entity.TechAllEntity;

import java.util.List;

/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/15 下午2:06
 * @Description:教师基本信息数据传输对象
 *                  包括教师基本信息对象和所发论文的List对象
 */
public class TeacherBasicInfoDTO {
    private TechAllEntity techAllEntity;
    private List<PapersInfoEntity> papersList;

    public TechAllEntity getTechAllEntity() {
        return techAllEntity;
    }

    public void setTechAllEntity(TechAllEntity techAllEntity) {
        this.techAllEntity = techAllEntity;
    }

    public List<PapersInfoEntity> getPapersList() {
        return papersList;
    }

    public void setPapersList(List<PapersInfoEntity> papersList) {
        this.papersList = papersList;
    }
}
