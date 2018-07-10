package net.monkeystudio.chatrbtw.service;

import net.monkeystudio.chatrbtw.entity.ChatPetTypeConfig;
import net.monkeystudio.chatrbtw.mapper.ChatPetTypeConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bint on 2018/5/17.
 */
@Service
public class ChatPetTypeConfigService {



    @Autowired
    private ChatPetTypeConfigMapper chatPetTypeConfigMapper;


    /**
     * 获取宠物种类的配置
     * @param chatPetType
     * @return
     */
    public ChatPetTypeConfig getChatPetTypeConfig(Integer chatPetType){
        return chatPetTypeConfigMapper.selectByChatPetTypeId(chatPetType);
    }


    /**
     * 增加金币
     * @param chaPetTypeId
     * @return
     */
    public Integer increaseCoin(Integer chaPetTypeId ,Float coin){
        return chatPetTypeConfigMapper.increaseCoin(chaPetTypeId,coin);
    }



    static class Constants{
        //手动领取经验和金币
        public final static Integer Manually_experience_coin = 1;

        //近需要领取金币
        public final static Integer Manually_only_experience = 2;
    }
}
