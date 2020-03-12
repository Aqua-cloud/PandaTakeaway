package com.yjc.www.util;

import com.yjc.www.po.Order;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DaoUtil{

         private DaoUtil(){
        }

        public static String timeToString(Date date){
        //Date指定格式：yyyy-MM-dd HH:mm:ss:SSS
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(date);//format()方法将Date转换成指定格式的String
        return dateStr;
        }

}
