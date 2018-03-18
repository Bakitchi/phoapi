package com.bakitchi.phoapi.entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value = "TEACHER_NODES")
public class TeacherNodesEntity
{
    @Property(value = "NAME")
    String NAME;
    @Property(value = "DEGREE")
    String DEGREE;

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDEGREE() {
        return DEGREE;
    }

    public void setDEGREE(String DEGREE) {
        this.DEGREE = DEGREE;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + NAME + '\'' +
                ", degree='" + DEGREE + '\'' +
                '}';
    }
}
