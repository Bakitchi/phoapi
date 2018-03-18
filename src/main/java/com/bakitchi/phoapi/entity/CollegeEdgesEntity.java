package com.bakitchi.phoapi.entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

@Entity(value = "COLLEGE_EDGES")
public class CollegeEdgesEntity
{
    @Property(value = "ID")
    Integer ID;

    @Property(value = "SOURCE")
    String SOURCE;

    @Property(value = "TARGET")
    String TARGET;

    @Property(value = "COUNT")
    Integer COUNT;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getSOURCE() {
        return SOURCE;
    }

    public void setSOURCE(String SOURCE) {
        this.SOURCE = SOURCE;
    }

    public String getTARGET() {
        return TARGET;
    }

    public void setTARGET(String TARGET) {
        this.TARGET = TARGET;
    }

    public Integer getCOUNT() {
        return COUNT;
    }

    public void setCOUNT(Integer COUNT) {
        this.COUNT = COUNT;
    }

    @Override
    public String toString() {
        return "{" +
                "source='" + SOURCE + '\'' +
                ", target='" + TARGET + '\'' +
                ", count=" + COUNT +
                '}';
    }
}
