package com.bakitchi.phoapi.dto;


import com.bakitchi.phoapi.entity.TechSubjectEntity;

import java.util.List;

public class SubjectDTO
{

    private String subject;

    private List<TechSubjectEntity> subjectEntity;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<TechSubjectEntity> getSubjectEntity() {
        return subjectEntity;
    }

    public void setSubjectEntity(List<TechSubjectEntity> subjectEntity) {
        this.subjectEntity = subjectEntity;
    }

    @Override
    public String toString() {
        return "[{" +
                "subject='" + subject + '\'' +
                ", theme=" + subjectEntity +
                "}]";
    }
}
