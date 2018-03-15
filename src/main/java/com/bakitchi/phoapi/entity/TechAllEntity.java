package com.bakitchi.phoapi.entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;
import com.oracle.webservices.internal.api.message.PropertySet;

/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/15 下午1:53
 * @Description:
 */

@Entity(value = "TECH_ALL")
public class TechAllEntity {
    @Property(value = "ID")
    private Integer id;

    @Property(value = "NAME")
    private  String name;

    @Property(value = "IMG")
    private String img;

    @Property(value = "COLLEGE")
    private  String college;

    @Property(value = "ABSTRACT")
    private  String abstractinfo;

    @Property(value = "PROJECT")
    private  String project;

    @Property(value = "WANTED")
    private  String wanted;

    @Property(value = "DIRECTION")
    private  String direction;

    @Property(value = "CONTACT")
    private  String contact;

    @Property(value = "VISIT")
    private  Integer visit;

    @Property(value = "TIME")
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getAbstractinfo() {
        return abstractinfo;
    }

    public void setAbstractinfo(String abstractinfo) {
        this.abstractinfo = abstractinfo;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getWanted() {
        return wanted;
    }

    public void setWanted(String wanted) {
        this.wanted = wanted;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getVisit() {
        return visit;
    }

    public void setVisit(Integer visit) {
        this.visit = visit;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
