package Controller;
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
import Model.TAccount;
/**
 * 
 * 
 * ���������
 * ˵����UserDaoImpl ��Ӧ ����udao
 *     AccountDaoImpl ��Ӧ����accdao
 * 
 *
 */
@Controller
public class AccountCon {
	private UserDaoImpl udao;
	private AccountDaoImpl accdao;
	
	@PostConstruct
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		accdao = ctx.getBean("accountdaoimpl",AccountDaoImpl.class);
		udao = ctx.getBean("userdaoimpl",UserDaoImpl.class);
	}
	/**
	 * 2019-9-5
	 * ǰ�˷��ʽӿڣ�addaccount
	 * @param account 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/addAccount")
	public ResponseData addAccount(@RequestBody TAccount account){
		boolean result = accdao.addAccount(account);
		if (result){
			ResponseData data = new ResponseData(200, "����˵���¼�ɹ�", result);
			return data;
		}
		return null;
	}
	
	/***
	 * 2019-9-4
	 * zhaohu
	 * �˵��༭ �ɹ�
	 * ǰ�˷��ʽӿڣ�editAccount
	 * @param account
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/editAccount")
	public ResponseData editAccount(@RequestBody TAccount account){
	 boolean result = accdao.editAccout(account);
	  if(result){
		  ResponseData rd = new ResponseData(200,"�˵��༭�ɹ�",result);
		  return rd;
	  }
		return null;
	}
	/**
	 *ǰ�˷��ʽӿڣ�getAccountByTime
	 */
	@ResponseBody
	@RequestMapping(value="/getAccountByTime")
	public ResponseData getAccountByTime(@RequestBody Map<String,String> map){
		PageData data = accdao.selectAccount(Integer.parseInt(map.get("userid")),map.get("starttime"),map.get("endtime"),Integer.parseInt(map.get("pageindex")), Integer.parseInt(map.get("pagesize")));
		ResponseData data1 = new ResponseData(200,"��������ɹ���",data);
		return data1;
	}
	/**
	 *ǰ�˷��ʽӿڣ�deleteaccount
	 */
	@ResponseBody
	@RequestMapping(value="/deleteaccount")
	public ResponseData deleteAccount(@RequestBody  Map<String,Integer> map ){
		
		boolean result = accdao.deleAccount(map.get("id"));
		if (result) {
			ResponseData res = new ResponseData(200, "ɾ���ɹ�", result);
			return res;
		}
		return null;
	}
}
