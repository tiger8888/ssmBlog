package blog.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.blog.model.User;
import com.blog.model.UserKey;
import com.blog.service.UserService;

import global.BaseTest;

public class UserServiceTest extends BaseTest{
	
	@Autowired
	private UserService userService = null;
	@Test
	public void selectedByName(){
		UserKey userKey = new UserKey("wqq");
		User user = this.userService.selectByUserName(userKey);
		if (user != null) {
			System.out.println(user);
		}else{
			System.out.println("查询内容不存在");
		}
	}
	@Test
	public void selectedByUserId(){
		UserKey userKey = new UserKey(100000);
		User user = this.userService.selectByUserId(userKey);
		if (user != null) {
			System.out.println(user);
		}else{
			System.out.println("查询内容不存在");
		}
	}
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
		int result = this.userService.insert(user);
		if (result > 0) {
			System.out.println("添加数据成功");
		}else {
			System.out.println("添加数据失败");
		}
	}
	@Test
	public void insertSelective(){
		User user = new User("sla","wqoq");
		int result = this.userService.insertSelective(user);
		if (result > 0) {
			System.out.println("添加数据成功");
		}else {
			System.out.println("添加数据失败");
		}
	}
	
	@Test
	public void deleteByUserId(){
		UserKey userKey = new UserKey(100004);
		int result = this.userService.deleteByUserId(userKey);
		if (result > 0) {
			System.out.println("删除数据成功");
		}else {
			System.out.println("删除数据失败");
		}
	}
	@Test
	public void deleteByUserName(){
		UserKey userKey = new UserKey("wqq");
		int result = this.userService.deleteByUserName(userKey);
		if (result > 0) {
			System.out.println("删除数据成功");
		}else {
			System.out.println("删除数据失败");
		}
	}
	@Test
	public void deleteByPrimaryKey(){
		UserKey userKey = new UserKey(100004,"wqq");
		int result = this.userService.deleteByPrimaryKey(userKey);
		if (result > 0) {
			System.out.println("删除数据成功");
		}else {
			System.out.println("删除数据失败");
		}
	}
	
	@Test
	public void updateByPrimaryKey(){
		User user = new User("wqq","qqq","wq21");
		int result = this.userService.updateByPrimaryKey(user);
		if (result > 0) {
			System.out.println("更新数据成功");
		}else {
			System.out.println("更新数据失败");
		}
	}
	@Test
	public void updateByPrimaryKeySelective(){
		User user = new User("www","qqq","wq21");
		int result = this.userService.updateByPrimaryKeySelective(user);
		if (result > 0) {
			System.out.println("更新数据成功");
		}else {
			System.out.println("更新数据失败");
		}
	}

}
