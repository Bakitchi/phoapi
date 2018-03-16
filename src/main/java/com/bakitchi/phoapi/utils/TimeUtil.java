package com.bakitchi.phoapi.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/16 下午3:24
 * @Description:
 */
public class TimeUtil {
    public static String getCreateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-mm-ss");
        return df.format(new Date());
    }

}
