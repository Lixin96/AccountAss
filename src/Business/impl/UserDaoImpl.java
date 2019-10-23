package Business.impl;

import java.util.List;

import util.PageData;
import BaseHibernate.HiberBaseDAOImpl;
import Business.dao.UserDAO;
import Model.TUser;

public class UserDaoImpl implements UserDAO {
	private HiberBaseDAOImpl impl;
	

	public void setImpl(HiberBaseDAOImpl impl) {
		this.impl = impl;
	}

    //用户登录
	@Override
	public 	List<TUser> userLogin(String username, String password) {//用户登录验证实现类
		String hql = "from TUser where username = ? and password = ?";
		Object[] para = {username,password};
		
		List<TUser> user =  impl.select2(hql, para);
		System.out.print(impl.select2(hql, para).size());
		if(user.size()>0){
			return user;
		}else {
			return null;
		}
	}

	//添加用户实现类
	@Override
	public boolean addUser(TUser user) {
		Object obj = impl.insert(user);
		if(obj!=null){
			return true;
		}else {
			return false;
		}	
	}

     //获取用户账务信息
	@Override
	public PageData getUserAccount(int userid,int accounttype,int pageindex,int pagesize) {
		String hql = "from TAccount where userid = ? and accounttype = ?";
		Object[] para = {userid,accounttype};
		PageData data = impl.select(hql, para, pageindex, pagesize);
		return data;
	}

	//注册的用户名是否可用
	@Override
	public List<TUser> Isuser(String username) {
		String hql ="from TUser where username= ? ";
		Object param[] = {username};
		List<TUser> user1 = impl.select2(hql, param);
		
		if (user1.size() > 0) {
			
			return user1;
		}
		else {
			return null;
		}
	}
}
