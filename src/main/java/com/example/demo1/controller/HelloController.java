package com.example.demo1.controller;/**
 * Created by Administrator on 2018/12/10.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@author xuziheng
 *@date 2018/12/10
 *@since 1.0
 */
@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String hello(){
		return "Hello";
	}

}
