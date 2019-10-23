package Business.dao;
import Model.TAccount;
import util.PageData;


public interface AccountDAO {
	/**
	 * 添加账单记录
	 * @param account
	 * @return
	 */
	public boolean addAccount(TAccount account);
	
	/**
	 * 编辑账单记录
	 * @param account
	 * @return
	 */
	public boolean editAccout(TAccount account);
	
	/**
	 * 删除记录
	 * @param account
	 * @return
	 */
	public boolean deleAccount(int id);
	/**
	 * 查询一段时间内的记录
	 * @param userid
	 * @param time
	 * @param pageindex
	 * @param pagesize
	 * @return
	 */
	public PageData selectAccount(int userid,String starttime,String endtime,int pageindex,int pagesize);
	
	
	
}
