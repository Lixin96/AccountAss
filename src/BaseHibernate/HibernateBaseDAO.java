package BaseHibernate;

import java.util.List;

import util.PageData;

public interface HibernateBaseDAO {
	
	//数据库操作基类接口
	
	/**
	 * 添加一条数据
	 * @param obj
	 * @return 返回数据的id
	 */
	public Object insert(Object obj);
	
	/**
	 * 添加一条数据
	 * @param obj
	 * @return 返回数据的id
	 */
	public boolean delete(Object obj);
	
	/**
	 * 删除数据
	 * @param cla
	 * @param id
	 * @return 删除成功返回true失败返回false
	 */
	public boolean delete(Class cla, java.io.Serializable id);
	/**
	 * 无参查询
	 * @param hql
	 * @return 返回查询list
	 */
	public List<Object> select(String hql);
	/**
	 * 含参数查询
	 * @param hql
	 * @param param
	 * @return 返回list
	 */	
	public List<Object> select(String hql,Object[] param);
	/**
	 * 无参查询一定数量记录
	 * @param hql
	 * @param pageindex
	 * @param pagecount
	 * @return 查询结果List
	 */
	public PageData select(String hql, int pageindex, int pagecount);
	/**
	 * 含参查询一定 数量的记录
	 * @param hql
	 * @param param
	 * @param pageindex
	 * @param pagecount
	 * @return 查询结果List
	 */
	public PageData select(String hql,Object[] param,int pageindex, int pagecount);
	/**
	 * 通过id和实体类查询数据
	 * @param cla
	 * @param id
	 * @return 返回查询对象Object
	 */
	public Object findByid(Class cla,java.io.Serializable id);
	
	/**
	 * 编辑数据
	 * @param obj
	 * @return 编辑成功返回true否则返回false
	 */
	public boolean edit(Object obj);
	/**
	 * 删除数据
	 * @param sql
	 * @return 删除成功返回true负责删除失败返回false
	 */
	public boolean delete(String sql);
	/**
	 * 含参的删除
	 * @param sql
	 * @param param
	 * @return 删除成功返回true负责删除失败返回false
	 */
	public boolean delete(String sql, Object[] param);
	/**
	 * 含参编辑数据
	 * @param sql
	 * @param param
	 * @return 编辑成功返回true,否则返回param
	 */
	public boolean edit(String sql, Object[] param);
	
/**
 * 
 * @param hql
 * @return 返回查询对象
 */
	public List select1(String hql);
/**
 * 
 * @param hql
 * @param param
 * @return 返回带参数的查询对象
 */
	List select2(String hql, Object[] param);

List selectByPage(String hql, int startPage, int pageSize);

	

}
