package com.goujia.demo.service.impl;

import com.goujia.demo.service.ScheduleService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    //计数器1
    int count1 = 1;
    //计数器2
    int count2 = 2;


    @Scheduled(fixedRateString = "1")
    @Async
    public void job1(){
        System.out.println("job1每秒钟执行一次正在执行第"+count1+"次");
        count1++;
    }
    @Scheduled(fixedRateString = "1")
    @Async
    public void job2(){
        System.out.println("job2每秒钟执行一次正在执行第"+count2+"次");
        count2++;
    }


}
