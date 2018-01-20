package com.hr.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GirlController {
    /**
     * 查找所有的girl
     */
    @Autowired
    private GirlDao girlDao;

    @GetMapping(value = "/girls")
    public List<Girl> girls(){
        return girlDao.findAll();
    }

    /**
     * 添加一个女生
     * @param cupSize
     * @param age   年龄
     * @return
     */
    @PostMapping("/girl")


    public Girl insert(@RequestParam("cup") String cupSize,
                       @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlDao.save(girl);
    }

}

