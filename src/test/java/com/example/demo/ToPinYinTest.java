package com.example.demo;

import com.example.demo.utils.ChangeToPinYin;
import com.example.demo.utils.ChangeToPinYinJP;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToPinYinTest {

    @Resource
    private ChangeToPinYin changeToPinYin;
    @Resource
    private ChangeToPinYinJP changeToPinYinJP;

    @Test
    public void changePinYinTest(){
        String str = "你在做什么？what are you nong sa lie?";

        System.out.println(changeToPinYin.getStringPinYin(str));
    }

    @Test
    public void changePinYinJPTest(){
        String str = "你在做什么？what are you nong sa lie?";

        System.out.println(changeToPinYinJP.changeToTonePinYin(str));
    }

    @Ignore
    public void changechar(){
        char c = '你';
        System.out.println(changeToPinYin.getCharPinYin(c));
    }


}