package com.shadow.mapper;

import com.shadow.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author WCZ
 * @date 2020-05-18
 * @Description:
 **/
@Repository
public interface UserMapper {

    List<User> selectByDormId(String dormId);
}
