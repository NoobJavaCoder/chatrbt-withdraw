package net.monkeystudio.admin.controller;

import net.monkeystudio.admin.controller.req.minigame.AddMiniGameReq;
import net.monkeystudio.admin.controller.req.minigame.UpdateMiniGameReq;
import net.monkeystudio.base.controller.BaseController;
import net.monkeystudio.base.controller.bean.RespBase;
import net.monkeystudio.base.utils.CommonUtils;
import net.monkeystudio.base.utils.DateUtils;
import net.monkeystudio.base.utils.RespHelper;
import net.monkeystudio.chatrbtw.entity.WxMiniGame;
import net.monkeystudio.chatrbtw.service.ChatPetGameCenterService;
import net.monkeystudio.chatrbtw.service.WxMiniGameService;
import net.monkeystudio.chatrbtw.service.bean.gamecenter.AdminMiniGameAdd;
import net.monkeystudio.chatrbtw.service.bean.gamecenter.AdminMiniGameResp;
import net.monkeystudio.chatrbtw.service.bean.gamecenter.AdminMiniGameUpdate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author xiaxin
 */
@RequestMapping(value = "/admin/chat-pet/game-center")
@Controller
public class ChatPetGameCenterMgrController extends BaseController{
    @Autowired
    private RespHelper respHelper;
    @Autowired
    private ChatPetGameCenterService chatPetGameCenterService;
    @Autowired
    private WxMiniGameService wxMiniGameService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public RespBase add(AddMiniGameReq req){
        Integer userId = getUserId();
        if ( userId == null ){
            return respHelper.nologin();
        }

        if(req.getHeadImg() == null){
            respHelper.failed("小游戏头像不能为空");
        }
        if(req.getQrCodeImg() == null){
            respHelper.failed("小游戏二维码不能为空");
        }
        if(req.getNickname() == null){
            respHelper.failed("小游戏名称不能为空");
        }
        if(req.getOnlineTime() == null){
            respHelper.failed("需要填写小游戏上线时间");
        }
        if(!wxMiniGameService.isOnlineTimeValid(req.getOnlineTime())){
            respHelper.failed("上线时间不可为设置当天,至少明天");
        }

        AdminMiniGameAdd adminMiniGameAdd = new AdminMiniGameAdd();
        BeanUtils.copyProperties(req,adminMiniGameAdd);

        wxMiniGameService.save(adminMiniGameAdd);

        return respHelper.ok();
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    @ResponseBody
    public RespBase delete(HttpServletRequest request, @PathVariable("id")Integer id){

        Integer userId = getUserId();
        if ( userId == null ){
            return respHelper.nologin();
        }

        wxMiniGameService.delete(id);

        return respHelper.ok();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public RespBase update(UpdateMiniGameReq updateMiniGameReq){

        Integer userId = getUserId();
        if ( userId == null ){
            return respHelper.nologin();
        }

        if(updateMiniGameReq.getNickname() == null){
            respHelper.failed("小游戏名称不能为空");
        }
        if(updateMiniGameReq.getOnlineTime() == null){
            respHelper.failed("需要填写小游戏上线时间");
        }

        AdminMiniGameUpdate adminMiniGameUpdate = new AdminMiniGameUpdate();
        BeanUtils.copyProperties(updateMiniGameReq,adminMiniGameUpdate);

        wxMiniGameService.update(adminMiniGameUpdate);

        return respHelper.ok();
    }

    @RequestMapping(value = "/{id}/get", method = RequestMethod.POST)
    @ResponseBody
    public RespBase getById(HttpServletRequest request, @PathVariable("id")Integer id){

        Integer userId = getUserId();
        if ( userId == null ){
            return respHelper.nologin();
        }

        WxMiniGame wxMiniGame = wxMiniGameService.getById(id);

        return respHelper.ok(wxMiniGame);
    }

    /**
     * 下架
     * @param request
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}/unshelve", method = RequestMethod.POST)
    @ResponseBody
    public RespBase unshelve(HttpServletRequest request, @PathVariable("id")Integer id){

        Integer userId = getUserId();
        if ( userId == null ){
            return respHelper.nologin();
        }

        wxMiniGameService.unshelve(id);

        return respHelper.ok();
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public RespBase list(HttpServletRequest request){

        Integer userId = getUserId();
        if ( userId == null ){
            return respHelper.nologin();
        }


        List<AdminMiniGameResp> resps = wxMiniGameService.getAdminMiniGameRespList();

        return respHelper.ok(resps);
    }

}
