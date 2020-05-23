package com.shadow.mapper;

import com.shadow.entity.DormInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author WCZ
 * @date 2020-05-18
 * @Description:
 **/
@Repository
public interface DormMapper {
    List<DormInfo> selectDorm(@Param("dormitoryId")String dormitoryInfo,@Param("name")String name);

    DormInfo selectById(String id);
}
