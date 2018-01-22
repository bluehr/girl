package com.hr.girl.dao;

import com.hr.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GirlDao extends JpaRepository<Girl,Integer> {

}
