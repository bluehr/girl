package com.hr.girl.service;

import com.hr.girl.dao.GirlDao;
import com.hr.girl.domain.Girl;
import com.hr.girl.enums.ResultEnums;
import com.hr.girl.exception.GirlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GirlService {
    @Autowired
    private GirlDao girlDao;


    public Girl getAge(Integer id) throws Exception {
        Girl girl = girlDao.findOne(id);
        if (girl.getAge()<10){
            throw new GirlException(ResultEnums.PRIMARY_SCHOOL);
        }
        if (girl.getAge()>10 && girl.getAge()<16){
            throw new GirlException(ResultEnums.MIDDLE_SCHOOL);
        }
        return girl;
    }

    /**
     * 通过id查询一个女生
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
       return girlDao.findOne(id);
    }
}
