package Business.dao;

import java.util.List;

import util.PageData;
import Model.TUser;

public interface UserDAO {
	/**
	 * 用户名是否可用
	 * @param username
	 * 
	 * @return
	 */
	public List<TUser> Isuser(String username);
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	public List<TUser> userLogin(String username,String password);
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public boolean addUser(TUser user);
	
	/**
	 * 根据用户id和类型查账户记录
	 * @param id
	 * @return
	 */
	/**
	 * 根据用户id和类型查账户记录
	 * @param id
	 * @return
	 */
	public PageData getUserAccount(int userid,int accounttype,int pageindex,int pagesize);
	
}
