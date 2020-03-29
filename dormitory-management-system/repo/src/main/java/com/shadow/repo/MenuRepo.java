package com.shadow.repo;

import com.shadow.entity.Menu;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author WCZ
 * @date 2020-03-29
 * @Description:
 **/
public interface MenuRepo extends JpaRepository<Menu,Integer> {

}
