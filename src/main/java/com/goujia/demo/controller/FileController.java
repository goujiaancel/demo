package com.goujia.demo.controller;

import com.goujia.demo.PO.InfoPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {
    private static final Logger logger = LoggerFactory.getLogger("normal");

    @RequestMapping(value = "/upload" ,
            method = RequestMethod.POST
             )
    public InfoPO uploadFile(MultipartHttpServletRequest request) {
        logger.info("uploadFile params : {}",request);
        request.getFile("name");
        request.getFile("type");
        request.getFile("channel");
        request.getFile("source");
        MultipartFile multipartFile = request.getFile("fileContent");
        byte[] fileByte = null;
        try {
            fileByte = multipartFile.getBytes();
        } catch (IOException e) {
            logger.error("get fileBytes exception :{}", e);
        }
        if (null == fileByte) {
            logger.error("fileBytes is null");
            return new InfoPO("fileBytes is null");
        }
        File file = new File("D:/fdf.jpg");
        //文件字节流不为空
        try{
            multipartFile.transferTo(file);
        }catch (IOException e){
            logger.error("save file error :{}",e);
            return new InfoPO("save file error");
        }
        return new InfoPO("save file successfully");
    }




}
