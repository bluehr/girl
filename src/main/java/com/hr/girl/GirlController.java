package com.hr.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Girl insert(@RequestParam("cupSize") String cupSize,
                       @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlDao.save(girl);
    }
    //删除一个女生
    @DeleteMapping("/girl/{id}")
    public void delete(@PathVariable("id")Integer id){
        girlDao.delete(id);
    }
    //查询一个女生
    @GetMapping("/girl/{id}")
    public Girl findGirl(@PathVariable("id")Integer id){
        return girlDao.findOne(id);
    }
    //更新
    @PutMapping("/girl/{id}")
    public Girl girlUpdate(@PathVariable("id")Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl g = new Girl(id,cupSize,age);
        return girlDao.save(g);
    }

}


