package com.shahenpc.common.utils.age;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AgeUtils {
    //根据身份证号输出年龄
    public static int IdNOToAge(String IdNO){
        int leh = IdNO.length();
        IdNO=IdNO.replace("x","0");
        IdNO=IdNO.replace("X","0");
        String dates="";
        if (leh == 18) {
            int se = Integer.valueOf(IdNO.substring(leh - 1)) % 2;
            dates = IdNO.substring(6, 10);
            SimpleDateFormat df = new SimpleDateFormat("yyyy");
            String year=df.format(new Date());
            int u=Integer.parseInt(year)-Integer.parseInt(dates);
            return u;
        }else{
            dates = IdNO.substring(6, 8);
            return Integer.parseInt(dates);
        }
    }

    //根据出生年月日
    public static int bornDate(String date){
            SimpleDateFormat df = new SimpleDateFormat("yyyy");
            String year=df.format(new Date());
            int u=Integer.parseInt(year)-Integer.parseInt(date);
            return u;
    }
}
