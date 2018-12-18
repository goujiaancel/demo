package com.goujia.demo.controller;

import com.goujia.demo.PO.InfoPO;
import com.goujia.demo.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    private InfoService infoService;


    @RequestMapping("index")
    public String index(){
        InfoPO infoPO = new InfoPO();
        infoPO.setId(null);
        infoPO.setName("goujiaancel");
        infoPO.setAge(55);
        return String.valueOf(this.infoService.insertInfo(infoPO));
    }

}
