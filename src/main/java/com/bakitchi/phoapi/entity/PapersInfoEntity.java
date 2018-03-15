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
    @Property(value = "INDEX")
    private Integer index;

    @Property(value = "TITLE")
    private String title;

    @Property(value = "LINK")
    private String link;

    @Property(value = "RESOURCE")
    private String resource;

    @Property(value = "DATA")
    private String date;

    @Property(value = "CATAGORY")
    private String catagory;

    @Property(value = "AUTHORS")
    private String authors;

    @Property(value = "COLLEGES")
    private String colleges;

    @Property(value = "KWS")
    private String kws;

    @Property(value = "CITATION")
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
