package com.example.demo1.repository;/**
 * Created by Administrator on 2018/12/11.
 */

import com.example.demo1.pojo.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 *@author xuziheng
 *@date 2018/12/11
 *@since 1.0
 */
@Repository
public class UserRepositoryImpl implements UserRepository{
	private  AtomicLong counter = new AtomicLong();
	private final ConcurrentHashMap<Long,User> userMap =  new ConcurrentHashMap<>();
	@PostConstruct
	public void init(){
		User user = new User(counter.incrementAndGet(),"1","qq");
		userMap.put(1L,user);
	}
	@Override
	public User saveOrUpdateUser(User user) {
		Long id = user.getId();
		if(id==null){
			id = counter.incrementAndGet();
			user.setId(id);
		}
		this.userMap.put(id,user);
		return user;
	}

	@Override
	public void deleteUser(Long id) {
		this.userMap.remove(id);
	}

	@Override
	public User getUserById(Long id) {
		return this.userMap.get(id);
	}

	@Override
	public List<User> listUsers() {
		return new ArrayList<User>(this.userMap.values());
	}
}
