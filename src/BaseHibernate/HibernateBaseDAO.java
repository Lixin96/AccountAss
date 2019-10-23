package BaseHibernate;

import java.util.List;

import util.PageData;

public interface HibernateBaseDAO {
	
	//���ݿ��������ӿ�
	
	/**
	 * ���һ������
	 * @param obj
	 * @return �������ݵ�id
	 */
	public Object insert(Object obj);
	
	/**
	 * ���һ������
	 * @param obj
	 * @return �������ݵ�id
	 */
	public boolean delete(Object obj);
	
	/**
	 * ɾ������
	 * @param cla
	 * @param id
	 * @return ɾ���ɹ�����trueʧ�ܷ���false
	 */
	public boolean delete(Class cla, java.io.Serializable id);
	/**
	 * �޲β�ѯ
	 * @param hql
	 * @return ���ز�ѯlist
	 */
	public List<Object> select(String hql);
	/**
	 * ��������ѯ
	 * @param hql
	 * @param param
	 * @return ����list
	 */	
	public List<Object> select(String hql,Object[] param);
	/**
	 * �޲β�ѯһ��������¼
	 * @param hql
	 * @param pageindex
	 * @param pagecount
	 * @return ��ѯ���List
	 */
	public PageData select(String hql, int pageindex, int pagecount);
	/**
	 * ���β�ѯһ�� �����ļ�¼
	 * @param hql
	 * @param param
	 * @param pageindex
	 * @param pagecount
	 * @return ��ѯ���List
	 */
	public PageData select(String hql,Object[] param,int pageindex, int pagecount);
	/**
	 * ͨ��id��ʵ�����ѯ����
	 * @param cla
	 * @param id
	 * @return ���ز�ѯ����Object
	 */
	public Object findByid(Class cla,java.io.Serializable id);
	
	/**
	 * �༭����
	 * @param obj
	 * @return �༭�ɹ�����true���򷵻�false
	 */
	public boolean edit(Object obj);
	/**
	 * ɾ������
	 * @param sql
	 * @return ɾ���ɹ�����true����ɾ��ʧ�ܷ���false
	 */
	public boolean delete(String sql);
	/**
	 * ���ε�ɾ��
	 * @param sql
	 * @param param
	 * @return ɾ���ɹ�����true����ɾ��ʧ�ܷ���false
	 */
	public boolean delete(String sql, Object[] param);
	/**
	 * ���α༭����
	 * @param sql
	 * @param param
	 * @return �༭�ɹ�����true,���򷵻�param
	 */
	public boolean edit(String sql, Object[] param);
	
/**
 * 
 * @param hql
 * @return ���ز�ѯ����
 */
	public List select1(String hql);
/**
 * 
 * @param hql
 * @param param
 * @return ���ش������Ĳ�ѯ����
 */
	List select2(String hql, Object[] param);

List selectByPage(String hql, int startPage, int pageSize);

	

}
