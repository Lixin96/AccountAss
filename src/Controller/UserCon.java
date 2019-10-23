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
 * �û�������
 *˵����UserDaoImpl ��Ӧ ����udao
 *     AccountDaoImpl ��Ӧ����accdao
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
	 * �û���¼��֤
	 * ǰ�˷��ʽӿڣ�userLogin
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/userLogin")
	public ResponseData getAuthList(@RequestBody Map<String,String> map){
		List<TUser> userlogin  = udao.userLogin(map.get("username").replace(" ",""), map.get("pwd")) ;
		if (userlogin != null ) {
			System.out.print(userlogin);
			ResponseData loginData = new ResponseData(200, "�û���½�ɹ���", userlogin);
			return loginData;
		}
		return null;
	}
	/**
	 * �û�ע�ᣨ�û���������ע�ᣬ������������
	 * ǰ�˷��ʽӿ�:Isuser
	 * @param map
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/Isuser")
	public ResponseData getUserList(@RequestBody TUser user){
		List<TUser> isuser = udao.Isuser(user.getUsername().replace(" ",""));
		if (isuser!=null) {
			ResponseData data = new ResponseData(100,"�û��Ѵ��ڣ�", isuser);
			return data;
		}
		else {
			user.setUsername(user.getUsername().replace(" ",""));
			boolean result = udao.addUser(user);
			if (result) {
				ResponseData adddata = new ResponseData(200, "ע��ɹ���", result);
				return adddata;
			}
			
		}
		return null;
	}
	//2019-9-5
	/**
	 * ǰ�˷��ʽӿ�:getuseraccount
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getuseraccount")
	public  ResponseData  getUserAccount(@RequestBody Map<String, String> map){
		PageData result = udao.getUserAccount(Integer.parseInt(map.get("userid")), Integer.parseInt(map.get("accounttype")),
				Integer.parseInt(map.get("pageindex")), Integer.parseInt(map.get("pagesize")));
		ResponseData data = new ResponseData(200, "����ɹ�", result);
		return data;
	}
	
	
}
