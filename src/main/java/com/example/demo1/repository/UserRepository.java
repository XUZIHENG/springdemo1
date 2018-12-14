package com.example.demo1.repository;/**
 * Created by Administrator on 2018/12/11.
 */

import com.example.demo1.pojo.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *@author xuziheng
 *@date 2018/12/11
 *@since 1.0
 */
public interface UserRepository extends CrudRepository<User,Long>{

}
