package com.bakitchi.phoapi.entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;
import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;

/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/16 下午1:30
 * @Description:
 */
@Entity(value = "TECH_SUBJECT")
public class TechSubjectEntity {
    @Property(value = "ID")
    private Integer id;

    @Property(value = "THEME")
    private String theme;

    @Property(value = "KNOWLEDGE")
    private String knowledge;

    @Property(value = "BELONG")
    private String belong;

    @Property(value = "CNTS")
    private Integer cnts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public Integer getCnts() {
        return cnts;
    }

    public void setCnts(Integer cnts) {
        this.cnts = cnts;
    }
}
