package com.bakitchi.phoapi.entity;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;

/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/14 下午7:10
 * @Description:
 */

@Entity(value = "TEST2")
public class Test2Entity {
    @Property(value = "id")
    private Integer id;
}
