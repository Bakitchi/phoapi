package com.bakitchi.phoapi.dto;

import java.util.List;

/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/18 下午1:23
 * @Description:
 */
public class PercentDTOS {
    private List<PercentDTO> list;
    private String college;

    public List<PercentDTO> getList() {
        return list;
    }

    public void setList(List<PercentDTO> list) {
        this.list = list;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}
