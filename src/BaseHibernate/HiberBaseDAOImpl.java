package BaseHibernate;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;

import BaseHibernate.HibernateSessionFactory;
import util.PageData;

public class HiberBaseDAOImpl implements HibernateBaseDAO {
	@Override
	public Object insert(Object obj) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		try {
			Serializable key = session.save(obj);
			tx.commit();
			session.close();
			return key;
		} catch (HibernateException e) {
			if(tx != null)tx.rollback();
			if(session != null)session.close();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean delete(Object obj) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(obj);
			tx.commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			if(tx != null)tx.rollback();
			if(session != null)session.close();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Class cla, Serializable id) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(session.get(cla, id));
			tx.commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			if(tx != null)tx.rollback();
			if(session != null)session.close();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Object> select(String hql) {
		Session session = HibernateSessionFactory.getSession();
		try {
			Query query = session.createQuery(hql);
			List<Object> list = query.list();
			session.close();
			return list;
		} catch (HibernateException e) {
			if(session != null)session.close();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List select1(String hql) {
		Session session = HibernateSessionFactory.getSession();
		try {
			Query query = session.createQuery(hql);
			List list = query.list();
			session.close();
			return list;
		} catch (HibernateException e) {
			if(session != null)session.close();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Object> select(String hql, Object[] param) {
		Session session = HibernateSessionFactory.getSession();
		try {
			Query query = session.createQuery(hql);
			for(int i =0;i<param.length;i++){
				query.setParameter(i, param[i]);
			}
			List<Object> list = query.list();
			session.close();
			return list;
		} catch (HibernateException e) {
			if(session != null)session.close();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List select2(String hql, Object[] param) {
		Session session = HibernateSessionFactory.getSession();
		try {
			Query query = session.createQuery(hql);
			for(int i =0;i<param.length;i++){
				query.setParameter(i, param[i]);
			}
			List list = query.list();
			session.close();
			return list;
		} catch (HibernateException e) {
			if(session != null)session.close();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public PageData select(String hql, int pageindex, int pagecount) {
		Session session = HibernateSessionFactory.getSession();
		try {
			Query query = session.createQuery(hql);
			List<Object> list = query.list();
			PageData pagedata = new PageData();
			pagedata.setTotalnum(list.size());
			pagedata.setPagecount(list.size()%pagecount==0?list.size()/pagecount:list.size()/pagecount+1) ;
			Query query2 = session.createQuery(hql);  
			if(pageindex<1){
				pageindex = 1;
			}
			if(pageindex <= pagedata.getPagecount()){
				query2.setFirstResult((pageindex-1)*pagecount);
				query2.setMaxResults(pagecount);
			} else {
				pagedata.setListData(null);  
			}
			List<Object> list2 = query2.list();
			pagedata.setListData(list2);
			session.close();
			return pagedata;
		} catch (HibernateException e) {
			if(session != null)session.close();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object findByid(Class cla, Serializable id) {
		Session session = HibernateSessionFactory.getSession();
		try {
			Object obj = session.get(cla,id);
			session.close();
			return obj;
		} catch (HibernateException e) {
			if(session != null)session.close();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean edit(Object obj) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		try {
			
			session.update(obj);
			tx.commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			if(tx != null)tx.rollback();
			if(session != null)session.close();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(final String sql) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		try {

			Work work = new Work(){
				@Override
				public void execute(Connection connection) throws SQLException {
					PreparedStatement ptmt = connection.prepareStatement(sql);
					int row = ptmt.executeUpdate();
				}
			};
			session.doWork(work);
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			if(tx != null) tx.rollback();
			if(session != null) session.close();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(final String sql, final Object[] param) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		try {
			Work work = new Work(){
				@Override
				public void execute(Connection connection) throws SQLException {
					PreparedStatement ptmt = connection.prepareStatement(sql);
					for(int i=0;i<param.length;i++){
						ptmt.setObject(i+1, param[i]);
					}
					int row = ptmt.executeUpdate();
				}
			};
			session.doWork(work);
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			if(tx != null) tx.rollback();
			if(session != null) session.close();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean edit(final String sql, final Object[] param) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		try {
			Work work = new Work(){
				@Override
				public void execute(Connection connection) throws SQLException {
					PreparedStatement ptmt = connection.prepareStatement(sql);
					for(int i=0;i<param.length;i++){
						ptmt.setObject(i+1, param[i]);
					}
					int row = ptmt.executeUpdate();
				}
			};
			session.doWork(work);
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			if(tx != null) tx.rollback();
			if(session != null) session.close();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public PageData select(String hql, Object[] param, int pageindex,
			int pagecount) {
		Session session = HibernateSessionFactory.getSession();
		try {
			Query query = session.createQuery(hql);
			for(int i=0;i<param.length;i++){
				query.setParameter(i, param[i]);
			}
			List<Object> list = query.list();
			PageData pagedata = new PageData();
			pagedata.setTotalnum(list.size());
			pagedata.setPagecount(list.size()%pagecount==0?list.size()/pagecount:list.size()/pagecount+1) ;
			Query query2 = session.createQuery(hql);  
			for(int i=0;i<param.length;i++){
				query2.setParameter(i, param[i]);
			}
			if(pageindex<1){
				pageindex = 1;
			}
			if(pageindex < pagecount){
				query2.setFirstResult((pageindex-1)*pagecount);
				query2.setMaxResults(pagecount);
			} else {
				pagedata.setListData(null);
			}
			List<Object> list2 = query2.list();
			pagedata.setListData(list2);
			session.close();
			return pagedata;
		} catch (HibernateException e) {
			if(session != null)session.close();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List selectByPage(String hql, int startPage, int pageSize) {
		//从指定页数开始分页
				Session session = HibernateSessionFactory.getSession();
				List pList = null;
				int currentPage;
				try{
					Query query = session.createQuery(hql);
					//先求出pageSize得到的分页页数
					List list = query.list();
					//获取查询记录总数
					long records = list.size();
					//获取总页数
					int pages_all =(int)(records%pageSize==0?records/pageSize:records/pageSize+1);//获得总页数
					//设置类成员当前页面的操作页码
					if(startPage<=1){
						currentPage = 1;
					}else if(startPage>=pages_all){
						currentPage = pages_all;
					}else{
						currentPage = startPage;
					}
					
					Query query2 = session.createQuery(hql);
					//从第几条记录开始查询
					query2.setFirstResult((currentPage-1)*pageSize);
					query2.setMaxResults(pageSize);//每页显示多少条
					pList = query2.list();
					session.close();
				}catch (Exception e) {
					e.printStackTrace();
					
					if(session!=null) session.close();
				}
				return pList;
	}
//	public static void main(String args[]){
//		HiberBaseDAOImpl impl = new HiberBaseDAOImpl();
//		String hql ="from TRole where rolename like '%'||?||'%' order by id desc";
//		Object[] obj1 = {"管理员"};
//		PageData obj = impl.select(hql,obj1,1,10);
//		System.out.print(obj.getListData().size());
//	}

}
