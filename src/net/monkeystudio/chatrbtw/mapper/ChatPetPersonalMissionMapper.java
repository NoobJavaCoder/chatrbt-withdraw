package net.monkeystudio.chatrbtw.mapper;

import net.monkeystudio.chatrbtw.entity.ChatPetPersonalMission;

import java.util.List;

public interface ChatPetPersonalMissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChatPetPersonalMission record);

    int insertSelective(ChatPetPersonalMission record);

    ChatPetPersonalMission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChatPetPersonalMission record);

    int updateByPrimaryKey(ChatPetPersonalMission record);

    Float sumTotalCoinByParam(ChatPetPersonalMission param);

    List<ChatPetPersonalMission> selectListByParam(ChatPetPersonalMission param);

    ChatPetPersonalMission selectByParam(ChatPetPersonalMission param);


}