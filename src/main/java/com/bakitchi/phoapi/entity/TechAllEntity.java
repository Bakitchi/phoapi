package com.bakitchi.phoapi.entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/15 下午1:53
 * @Description:
 */

@Entity(value = "TECH_ALL")
public class TechAllEntity {
    @Property(value = "id")
    private Integer id;

    @Property(value = "name")
    private  String name;

    @Property(value = "img")
    private String img;

    @Property(value = "college")
    private  String college;

    @Property(value = "abstract")
    private  String abstractinfo;

    @Property(value = "project")
    private  String project;

    @Property(value = "wanted")
    private  String wanted;

    @Property(value = "direction")
    private  String direction;

    @Property(value = "contact")
    private  String contact;

    @Property(value = "visit")
    private  Integer visit;

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
}
