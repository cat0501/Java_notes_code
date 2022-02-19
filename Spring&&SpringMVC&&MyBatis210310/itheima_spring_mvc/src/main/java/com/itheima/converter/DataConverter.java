package com.itheima.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cat
 * @date 2022/2/13 下午6:29
 */
public class DataConverter implements Converter<String, Date> {

    @Override
    public Date convert(String dataStr) {
        // 将日期字符串转换成日期对象 返回
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date data = null;
        try {
            data = format.parse(dataStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return data;
    }

}
