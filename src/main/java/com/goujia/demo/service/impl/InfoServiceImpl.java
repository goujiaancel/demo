package com.goujia.demo.service.impl;

import com.goujia.demo.PO.InfoPO;
import com.goujia.demo.dao.InfoDAO;
import com.goujia.demo.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    InfoDAO infoDAO;


    @Override
    public int insertInfo(InfoPO infoPO) {
        return infoDAO.insertInfo(infoPO);
    }
}
