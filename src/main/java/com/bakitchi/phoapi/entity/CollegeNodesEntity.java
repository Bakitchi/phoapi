package com.bakitchi.phoapi.entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/15 下午3:09
 * @Description:
 */

@Entity(value = "COLLEGE_NODES")
public class CollegeNodesEntity {
    @Property(value = "ID")
    private Integer id;

    @Property(value = "COLLEGE")
    private String college;

    @Property(value = "COUNT")
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + college + '\'' +
                ", degree=" + count +
                '}';
    }
}
