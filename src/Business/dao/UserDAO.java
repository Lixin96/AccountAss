package Business.dao;

import java.util.List;

import util.PageData;
import Model.TUser;

public interface UserDAO {
	/**
	 * �û����Ƿ����
	 * @param username
	 * 
	 * @return
	 */
	public List<TUser> Isuser(String username);
	/**
	 * �û���¼
	 * @param username
	 * @param password
	 * @return
	 */
	public List<TUser> userLogin(String username,String password);
	/**
	 * �û�ע��
	 * @param user
	 * @return
	 */
	public boolean addUser(TUser user);
	
	/**
	 * �����û�id�����Ͳ��˻���¼
	 * @param id
	 * @return
	 */
	/**
	 * �����û�id�����Ͳ��˻���¼
	 * @param id
	 * @return
	 */
	public PageData getUserAccount(int userid,int accounttype,int pageindex,int pagesize);
	
}
