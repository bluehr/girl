package com.hr.girl.controller;

import com.hr.girl.dao.GirlDao;
import com.hr.girl.domain.Girl;
import com.hr.girl.domain.Result;
import com.hr.girl.service.GirlService;
import com.hr.girl.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {
    /**
     * 查找所有的girl
     */
    @Autowired
    private GirlDao girlDao;

    @Autowired
    private GirlService girlService;

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
    public Result<Girl> insert(@Valid Girl girl,
                         BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultUtil.Error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlDao.save(girl));
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

    //查询一个女生
    @GetMapping("/girl/getAge/{id}")
    public Girl findGirlAge(@PathVariable("id")Integer id) throws Exception {
        return girlService.getAge(id);
    }

}


