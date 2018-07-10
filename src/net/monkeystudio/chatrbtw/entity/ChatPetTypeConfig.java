package net.monkeystudio.chatrbtw.entity;

//表名e_chat_pet_type_config
public class ChatPetTypeConfig {
    private Integer id;
    private Integer chatPetType;
    private String newsCoverUrl;
    private String newsTitle;
    private String newsDescription;
    private String founderName;
    private String coinName;
    private Float coin;
    private Integer rewardType;

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChatPetType() {
        return chatPetType;
    }

    public void setChatPetType(Integer chatPetType) {
        this.chatPetType = chatPetType;
    }

    public String getNewsCoverUrl() {
        return newsCoverUrl;
    }

    public void setNewsCoverUrl(String newsCoverUrl) {
        this.newsCoverUrl = newsCoverUrl;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription;
    }

    public String getFounderName() {
        return founderName;
    }

    public void setFounderName(String founderName) {
        this.founderName = founderName;
    }

    public Float getCoin() {
        return coin;
    }

    public void setCoin(Float coin) {
        this.coin = coin;
    }

    public Integer getRewardType() {
        return rewardType;
    }

    public void setRewardType(Integer rewardType) {
        this.rewardType = rewardType;
    }
}