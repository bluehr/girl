package com.hr.girl;


import com.hr.girl.domain.Girl;
import com.hr.girl.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)  //底层使用的是junit
@SpringBootTest     //代表启动项目
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;
    @Test
    public void findOneTest(){
        Girl girl = girlService.findOne(3);
        Assert.assertEquals("B",girl.getCupSize());
    }

}
