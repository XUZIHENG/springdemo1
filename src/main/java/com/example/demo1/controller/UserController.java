package com.example.demo1.controller;/**
 * Created by Administrator on 2018/12/10.
 */

import com.example.demo1.pojo.User;
import com.example.demo1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *@author xuziheng
 *@date 2018/12/10
 *@since 1.0
 */
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;


	/**
	 * 查询所有用户
	 * @param model
	 * @return
	 */
	@GetMapping
	public ModelAndView list(Model model){

		model.addAttribute("userList",userRepository.findAll());
		model.addAttribute("title","用户管理");
		return new ModelAndView("users/list","userModel",model);

	}

	/**
	 * 查询所有用户
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Long id,Model model){
		User user = userRepository.findOne(id);
		model.addAttribute("user",user);
		model.addAttribute("title","查看所有用户");
		return new ModelAndView("users/view","userModel",model);
	}
	/**
	 * 获取创建表单页面
	 * @param model
	 * @return
	 */
	@GetMapping("/form")
	public ModelAndView createForm(Model model){
		model.addAttribute("user",new User(null,null,null));
		model.addAttribute("title","创建用户");
		return new ModelAndView("users/form","userModel",model);
	}
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id){
		userRepository.delete(id);
		return new ModelAndView("redirect:/users");
	}

	@PostMapping
	public ModelAndView saveOrUpdateUser(User user,Model model){
		user = userRepository.save(user);
//		model.addAttribute("user",new User());
//		model.addAttribute("title","创建用户");
		return new ModelAndView("redirect:/users");
	}
	@GetMapping("/modify/{id}")
	public ModelAndView modify(@PathVariable("id")Long id,Model model){
		User user = userRepository.findOne(id);
		model.addAttribute("user",user);
		model.addAttribute("title","修改用户");
		return new ModelAndView("users/form","userModel",model);
	}

}
