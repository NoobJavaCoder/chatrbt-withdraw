package net.monkeystudio.chatrbtw.mapper;

import net.monkeystudio.chatrbtw.entity.ChatPet;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by bint on 2018/4/16.
 */
public interface ChatPetMapper {

    Integer insert(ChatPet chatPet);

    ChatPet selectById(Integer id);

    ChatPet selectByParam(ChatPet chatPet);

    Integer increaseExperience(@Param("id") Integer chatPetId ,@Param("augend") Float augend);

    Integer increaseCoin(@Param("id") Integer chatPetId ,@Param("rewardCoin") Float rewardCoin);

    List<ChatPet> selectListByExperience(@Param("secondEthnicGroupsId") Integer secondEthnicGroupsId, @Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize);

    Integer countSecondEthnicGroupsById(@Param("secondEthnicGroupsId") Integer secondEthnicGroupsId);

    Integer countByAppearceCode(@Param("chatPetType") Integer chatPetType ,@Param("appearenceCode") String appearenceCode);

    List<ChatPet> selectExperienceRankList(@Param("parentId") Integer parentId ,@Param("chatPetId") Integer chatPetId,@Param("startIndex")Integer startIndex,@Param("pageSize")Integer pageSize);

    Integer countExperienceRankList(Integer chatPetId);

    Integer decreaseCoin(@Param("chatPetId") Integer chatPetId,@Param("coin") Float coin);

    Integer countByParentId(Integer parentId);

    List<ChatPet> selectByChatPetType(Integer chatPetType);

    Double countTotalCoin(Integer chatPetType);

    Double countTotalExperience(Integer chatPetType);

    Integer increaseMoney(@Param("id") Integer chatPetId,@Param("additionMoney") Float additionMoney);

    ChatPet selectByWxFanId(Integer wxFanId);

    List<ChatPet> selectAll();

    Integer updateWxFanId(@Param("chatPetId") Integer chatPetId,@Param("wxFanId") Integer wxFanId);

    Integer update(ChatPet record);

    Integer countByDate(@Param("startTime")Date startTime,@Param("endTime")Date endTime);

    Integer countByDateAndCoin(@Param("startTime")Date startTime,@Param("endTime")Date endTime);
}
