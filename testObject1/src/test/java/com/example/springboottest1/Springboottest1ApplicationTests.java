package com.example.springboottest1;

import com.example.springboottest1.entity.User;
import com.example.springboottest1.service.UserLoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboottest1ApplicationTests {

	@Resource
	private UserLoginService userLoginService;
	@Test
	public void contextLoads() {
		List<Map<String,Object>> result = userLoginService.queryAllUser();
		System.out.println(result);
	}

}
