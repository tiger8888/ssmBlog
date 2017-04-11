package blog.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.blog.model.User;
import com.blog.model.UserKey;
import com.blog.service.UserService;

import global.BaseTest;

/**
 * 此处拿userbase 做测试
 * @author Administrator
 *
 */
public class BaseServiceTest extends BaseTest{
	@Autowired
	private UserService userService = null;

	@Test
	public void selectByPrimaryKey(){
		UserKey userKey = new UserKey(100000,"wqq");
		User user = this.userService.selectByPrimaryKey(userKey);
		if (user != null) {
			System.out.println(user);
		}else{
			System.out.println("查询内容不存在");
		}
	}
	
	@Test
	public void insertUser(){
		User user = new User("sla","wqoq");
		user.setUsername("qqqw");
		int result = this.userService.insert(user);
		if (result > 0) {
			System.out.println("添加数据成功");
		}else {
			System.out.println("添加数据失败");
		}
	}
	
	/**
	 * 这个插入最好不要用于注册
	 */
	@Test
	public void insertSelective(){
		User user = new User();
		user.setUsername("qqqqqq");
		int result = this.userService.insertSelective(user);
		if (result > 0) {
			System.out.println("添加数据成功");
		}else {
			System.out.println("添加数据失败");
		}
	}
	
	@Test
	public void updateByPrimaryKey(){
		User user = new User("qalqqq");
		user.setUsername("wwwqw");
		user.setUserid(100002);
		int result = this.userService.updateByPrimaryKeySelective(user);
		
		System.out.println(user);
		if (result > 0) {
			System.out.println("更新数据成功");
		}else {
			System.out.println("更新数据失败");
		}
	}

	@Test
	public void deleteByPrimaryKey(){
		User user = new User();
		user.setUsername("www");
		user.setUserid(100001);
		int result = this.userService.deleteByPrimaryKey(user);
		
		System.out.println(user);
		if (result > 0) {
			System.out.println("删除数据成功");
		}else {
			System.out.println("删除数据失败");
		}
	}
}
