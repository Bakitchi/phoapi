package com.bakitchi.phoapi.entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/15 下午2:07
 * @Description:
 */
@Entity(value = "PAPERS_INFO")
public class PapersInfoEntity {
    @Property(value = "index")
    private Integer index;

    @Property(value = "title")
    private String title;

    @Property(value = "link")
    private String link;

    @Property(value = "resource")
    private String resource;

    @Property(value = "date")
    private String date;

    @Property(value = "catagory")
    private String catagory;

    @Property(value = "authors")
    private String authors;

    @Property(value = "colleges")
    private String colleges;

    @Property(value = "kws")
    private String kws;

    @Property(value = "citation")
    private Integer citation;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getColleges() {
        return colleges;
    }

    public void setColleges(String colleges) {
        this.colleges = colleges;
    }

    public String getKws() {
        return kws;
    }

    public void setKws(String kws) {
        this.kws = kws;
    }

    public Integer getCitation() {
        return citation;
    }

    public void setCitation(Integer citation) {
        this.citation = citation;
    }
}
