package net.monkeystudio.chatpet.controller;

import net.monkeystudio.base.controller.bean.RespBase;
import net.monkeystudio.base.utils.RespHelper;
import net.monkeystudio.chatrbtw.service.ChatPetService;
import net.monkeystudio.chatrbtw.service.bean.chatpet.MyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bint on 2018/7/11.
 */
@Controller
@RequestMapping(value = "/chat-pet/my-info")
public class ChatPetMyInfoController extends ChatPetBaseController{


    @Autowired
    private ChatPetService chatPetService;

    @Autowired
    private RespHelper respHelper;


    /**
     * 获取"我的"信息
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public RespBase getMyInfo(){

        Integer wxFanId = this.getUserId();

        if(wxFanId == null){
            return respHelper.nologin();
        }

        MyInfo myInfo = chatPetService.getMyInfo(wxFanId);

        return respHelper.ok(myInfo);
    }
}
