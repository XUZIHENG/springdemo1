package com.example.demo1.repository;/**
 * Created by Administrator on 2018/12/11.
 */

import com.example.demo1.pojo.User;

import java.util.List;

/**
 *@author xuziheng
 *@date 2018/12/11
 *@since 1.0
 */
public interface UserRepository {
	/**
	 * 创建或修改用户
	 * @param user
	 * @return
	 */
	User saveOrUpdateUser(User user);

	/**
	 * 删除用户
	 * @param id
	 */
	void deleteUser(Long id);

	/**
	 * 根据ID查询用户
	 * @param id
	 * @return
	 */
	User getUserById(Long id);

	List<User> listUsers();
}
