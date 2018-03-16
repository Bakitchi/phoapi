package com.bakitchi.phoapi.dto;

/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/16 上午10:25
 * @Description:
 */
public class CollegeDTO {
    private Integer institutionID;
    private String  name;

    public Integer getInstitutionID() {
        return institutionID;
    }

    public void setInstitutionID(Integer institutionID) {
        this.institutionID = institutionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
