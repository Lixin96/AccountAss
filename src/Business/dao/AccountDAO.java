package Business.dao;
import Model.TAccount;
import util.PageData;


public interface AccountDAO {
	/**
	 * ����˵���¼
	 * @param account
	 * @return
	 */
	public boolean addAccount(TAccount account);
	
	/**
	 * �༭�˵���¼
	 * @param account
	 * @return
	 */
	public boolean editAccout(TAccount account);
	
	/**
	 * ɾ����¼
	 * @param account
	 * @return
	 */
	public boolean deleAccount(int id);
	/**
	 * ��ѯһ��ʱ���ڵļ�¼
	 * @param userid
	 * @param time
	 * @param pageindex
	 * @param pagesize
	 * @return
	 */
	public PageData selectAccount(int userid,String starttime,String endtime,int pageindex,int pagesize);
	
	
	
}
