package net.monkeystudio.admin.controller.req.minigame;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xiaxin
 */
public class UpdateMiniGameReq {
    private Integer id;
    private MultipartFile headImg;
    private MultipartFile qrCodeImg;
    private String nickname;
    private Integer needSign;
    private Integer openType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date onlineTime;
    private MultipartFile coverImg;
    private Float starNum = 2F;
    private List<Integer> tagIdList = new ArrayList<>();
    private Boolean isHandpicked;
    private String appId;

    public MultipartFile getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(MultipartFile coverImg) {
        this.coverImg = coverImg;
    }

    public Float getStarNum() {
        return starNum;
    }

    public void setStarNum(Float starNum) {
        this.starNum = starNum;
    }

    public List<Integer> getTagIdList() {
        return tagIdList;
    }

    public void setTagIdList(List<Integer> tagIdList) {
        this.tagIdList = tagIdList;
    }

    public Boolean getHandpicked() {
        return isHandpicked;
    }

    public void setHandpicked(Boolean handpicked) {
        isHandpicked = handpicked;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MultipartFile getHeadImg() {
        return headImg;
    }

    public void setHeadImg(MultipartFile headImg) {
        this.headImg = headImg;
    }

    public MultipartFile getQrCodeImg() {
        return qrCodeImg;
    }

    public void setQrCodeImg(MultipartFile qrCodeImg) {
        this.qrCodeImg = qrCodeImg;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getNeedSign() {
        return needSign;
    }

    public void setNeedSign(Integer needSign) {
        this.needSign = needSign;
    }

    public Integer getOpenType() {
        return openType;
    }

    public void setOpenType(Integer openType) {
        this.openType = openType;
    }

    public Date getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
    }
}
