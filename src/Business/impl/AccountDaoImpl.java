package Business.impl;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import util.PageData;
import BaseHibernate.HiberBaseDAOImpl;
import Business.dao.AccountDAO;
import Model.TAccount;


public class AccountDaoImpl implements AccountDAO {
	private HiberBaseDAOImpl impl;
	

	public void setImpl(HiberBaseDAOImpl impl) {
		this.impl = impl;
	}

     //����˵�2019-9-5
	@Override
	public boolean addAccount(TAccount account) {
		if (impl.insert(account) != null) {
			return true;
		}
		return false;
	}

    /**
     * zhaohu2019-9-4
     * �˵��ı༭
     */
	@Override
	public boolean editAccout(TAccount account) {
		
		return impl.edit(account);
	}

    //ɾ���˵�
	@Override
	public boolean deleAccount(int id) {
		
		 boolean result =impl.delete(TAccount.class, id);
			if(result){
				return true;
			}
			else{
				return false;
			}
	}

    //ͨ��ʱ��β�ѯ�˵�
	@Override
	public PageData selectAccount(int userid, String starttime, String endtime,
			int pageindex, int pagesize) {		
		String hql = "from VAccount where userid = ? and time between ? and ? order by time desc";
		Object[] param = {userid,starttime,endtime};
		PageData data = impl.select(hql, param, pageindex, pagesize);		
		return data;
	}
	/*
	 * ���Է���
	 * public static void main(String args[]){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		 AccountDaoImpl acc = ctx.getBean("accountdaoimpl", AccountDaoImpl.class);
		 TAccount tac = new TAccount();
		 tac.setId(1);
		 tac.setUserid(1);
		 tac.setAccounttype(2);
		 tac.setMoney(999.0);
		 tac.setCreatetime("2019-9-4");
		 tac.setTime("2019-9-4");
		 tac.setPay(1);
		 tac.setRemark("СС��˧��ѽ");
		System.out.println(tac.getUserid());
		 boolean result =acc.editAccout(tac);
		 if(result){
			 System.out.println("�޸�OK���ֵ�");
		 }
		
	}*/

}
