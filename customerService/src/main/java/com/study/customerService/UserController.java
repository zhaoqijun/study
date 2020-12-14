package com.study.customerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.customerService.bean.User;
import com.study.customerService.dao.UserDao;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserDao userDao;

	/**
	 * 获取示例数据库 t_user 的全部信息
	 * 
	 * @return 返回 json 数据
	 */
	@GetMapping("/users")
	public Object getUsers() {
		System.out.println("==============");

		List<User> list = userDao.findByName("");
		return list;
	}
	
	
    @PostMapping("/hmm")
    public String hmmDemo(@RequestParam(value = "str", required = false, defaultValue = "0") String testStr) {
    	if(testStr.equals("0")) {
            return "are you kidding me?";
        }else {
        	return "To Be continue";
        }
        
    }
}