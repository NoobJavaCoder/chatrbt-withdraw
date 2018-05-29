package net.monkeystudio.chatrbtw.mapper;

import net.monkeystudio.chatrbtw.entity.RWxPubProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by bint on 27/03/2018.
 */
public interface RWxPubProductMapper {

    int insert(RWxPubProduct rWxPubProduct);

    RWxPubProduct selectByWxPubAndProduct(@Param("wxPubOriginId") String wxPubOriginId , @Param("productId") Integer productId);

    List<RWxPubProduct> selectListByWxPubOriginId(@Param("wxPubOriginId") String wxPubOriginId);
}
