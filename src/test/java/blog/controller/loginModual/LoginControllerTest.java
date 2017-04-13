package blog.controller.loginModual;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.alibaba.fastjson.JSON;
import com.blog.model.User;
import com.blog.service.UserService;

import blog.controller.BaseControllerTest;

public class LoginControllerTest extends BaseControllerTest{
	@Autowired
	private UserService userService = null;
	/**
	 * perform：执行一个RequestBuilder请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理；
	 *get:声明发送一个get请求的方法。MockHttpServletRequestBuilder get(String urlTemplate, Object... urlVariables)：根据uri模板和uri变量值得到一个GET请求方式的。另外提供了其他的请求的方法，如：post、put、delete等。
	 *param：添加request的参数，如上面发送请求的时候带上了了pcode = root的参数。假如使用需要发送json数据格式的时将不能使用这种方式，可见后面被@ResponseBody注解参数的解决方法
	 *andExpect：添加ResultMatcher验证规则，验证控制器执行完成后结果是否正确（对返回的数据进行的判断）；
	 *andDo：添加ResultHandler结果处理器，比如调试时打印结果到控制台（对返回的数据进行的判断）；
	 *andReturn：最后返回相应的MvcResult；然后进行自定义验证/进行下一步的异步处理（对返回的数据进行的判断）；
	 */
	@Test
	public void loginTest(){
		User user = new User("sla");
		user.setUsername("qqq");
		String objString = JSON.toJSONString(user);
		try {
			String responseString = mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
					.contentType(MediaType.APPLICATION_JSON)
					.content(objString)
					.characterEncoding("UTF-8")
					.accept(MediaType.APPLICATION_JSON))
					.andDo(MockMvcResultHandlers.print())
					.andExpect(status().isOk())
					.andReturn().getResponse().getContentAsString();
	
			System.out.println("string = "+responseString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 注册
	 */
	@Test
	public void registerTest(){
		String userName = "ppwpww";
		String password = "wsa";
		String nickName = "";
		
		try {
			mockMvc.perform(MockMvcRequestBuilders.post("/user/register")
					.param("userName", userName)
					.param("password", password)
					.param("nickName", nickName)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
					.characterEncoding("UTF-8"))
					.andDo(MockMvcResultHandlers.print())
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andReturn().getResponse().getContentAsString();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改密码
	 */
	@Test
	public void changePasswordTest(){
		String userName = "ppp";
		String userId = "";
		String oldPassword = "wsa";
		String newPassword = "";
		
		try {
			mockMvc.perform(MockMvcRequestBuilders.post("/user/changePassword")
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
					.characterEncoding("UTF-8")
					.param("userName", userName)
					.param("userId", userId)
					.param("oldPassword", oldPassword)
					.param("newPassword", newPassword))
					.andExpect(status().isOk())
					.andDo(MockMvcResultHandlers.print())
					.andReturn();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * 找回密码
	 */
	
	@Test
	public void forgotPasswordTest(){
		String userName = "";
		String userId = "";
		String verification = "";
		String newPassword = "";
		try {
			mockMvc.perform(MockMvcRequestBuilders.post("/user/forgotPassword")
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
					.characterEncoding("UTF-8")
					.param("userName", userName)
					.param("userId", userId)
					.param("verification", verification)
					.param("newPassword", newPassword))
					.andExpect(status().isOk())
					.andDo(MockMvcResultHandlers.print())
					.andReturn();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
