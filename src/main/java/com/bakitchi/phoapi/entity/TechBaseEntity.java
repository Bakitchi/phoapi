package com.bakitchi.phoapi.entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/14 下午7:20
 * @Description:
 */

@Entity(value = "TECH_BASE")
public class TechBaseEntity {
    @Property(value = "id")
    private Integer id;

    @Property(value = "name")
    private  String name;

    @Property(value = "img")
    private String img;

    @Property(value = "college")
    private  String college;

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
}
