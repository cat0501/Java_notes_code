package com.itheima.shiro.client;

import com.itheima.shiro.tools.DigestsUtil;
import com.itheima.shiro.tools.EncodesUtil;
import org.junit.Test;

import java.util.Map;

/**
 * @Description：测试
 */
public class ClientTest {

//    /**
//     * @Description 测试16进制编码
//     */
//    @Test
//    public void testHex(){
//        String val = "holle";
//        String flag = EncodesUtil.encodeHex(val.getBytes());
//        String valHandler = new String(EncodesUtil.decodeHex(flag));
//        System.out.println("比较结果："+val.equals(valHandler));
//    }
//
//    /**
//     * @Description 测试base64编码
//     */
//    @Test
//    public void testBase64(){
//        String val = "holle";
//        String flag = EncodesUtil.encodeBase64(val.getBytes());
//        String valHandler = new String(EncodesUtil.decodeBase64(flag));
//        System.out.println("比较结果："+val.equals(valHandler));
//    }

    //获得结果：{password=8d693f6a6b3e7f0fa7accff1b95070d97b2d4072,
    // salt=239e1f9400d3accf865735d3448a5ac2}
    @Test
    public void testDigestsUtil(){
       Map<String,String> map =  DigestsUtil.entryptPassword("123");
        System.out.println("获得结果："+map.toString());
    }

}
