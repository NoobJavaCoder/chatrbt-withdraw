package net.monkeystudio.chatrbtw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * Created by bint on 2018/6/1.
 */
@Service
public class MQListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ChatPetRewardService chatPetRewardService;


    @Autowired
    private ChatPetMissionPoolService chatPetMissionPoolService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //if(event.getApplicationContext().getParent() == null){
        chatPetRewardService.comsumeLevelReward();
        chatPetMissionPoolService.initSubscribe();
        //}
    }
}
