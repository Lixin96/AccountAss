package Controller;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import util.PageData;
import util.ResponseData;
import Business.impl.AccountDaoImpl;
import Business.impl.UserDaoImpl;
import Model.TUser;

/**
 * 
 * 用户控制器
 *说明：UserDaoImpl 对应 变量udao
 *     AccountDaoImpl 对应变量accdao
 */
@Controller
public class UserCon {
	
	private UserDaoImpl udao;
	private AccountDaoImpl accdao;
	@PostConstruct
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		accdao = ctx.getBean("accountdaoimpl",AccountDaoImpl.class);
		udao = ctx.getBean("userdaoimpl",UserDaoImpl.class);
	}
	/**
	 * 用户登录验证
	 * 前端访问接口：userLogin
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/userLogin")
	public ResponseData getAuthList(@RequestBody Map<String,String> map){
		List<TUser> userlogin  = udao.userLogin(map.get("username").replace(" ",""), map.get("pwd")) ;
		if (userlogin != null ) {
			System.out.print(userlogin);
			ResponseData loginData = new ResponseData(200, "用户登陆成功！", userlogin);
			return loginData;
		}
		return null;
	}
	/**
	 * 用户注册（用户名可用则注册，不可用跳出）
	 * 前端访问接口:Isuser
	 * @param map
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/Isuser")
	public ResponseData getUserList(@RequestBody TUser user){
		List<TUser> isuser = udao.Isuser(user.getUsername().replace(" ",""));
		if (isuser!=null) {
			ResponseData data = new ResponseData(100,"用户已存在！", isuser);
			return data;
		}
		else {
			user.setUsername(user.getUsername().replace(" ",""));
			boolean result = udao.addUser(user);
			if (result) {
				ResponseData adddata = new ResponseData(200, "注册成功！", result);
				return adddata;
			}
			
		}
		return null;
	}
	//2019-9-5
	/**
	 * 前端访问接口:getuseraccount
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getuseraccount")
	public  ResponseData  getUserAccount(@RequestBody Map<String, String> map){
		PageData result = udao.getUserAccount(Integer.parseInt(map.get("userid")), Integer.parseInt(map.get("accounttype")),
				Integer.parseInt(map.get("pageindex")), Integer.parseInt(map.get("pagesize")));
		ResponseData data = new ResponseData(200, "请求成功", result);
		return data;
	}
	
	
}
