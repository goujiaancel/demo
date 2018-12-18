package com.goujia.demo.dao;

import com.goujia.demo.PO.InfoPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoDAO {
    int insertInfo(InfoPO infoPO);
}
