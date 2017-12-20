package foo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.HibernateUtil;

public class AppHelloWorld {
	
	public static void main(String args[]){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setHelloWorld("\"or '1'='1';--");
		session.save(helloWorld);
		String query="select h.id from HelloWorld h where h.helloWorld=:hell";
		Query hql=session.createQuery(query);
		hql.setString("hell","\"or '1'='1';--");
		List list=hql.list();
		System.out.println(list.size());
		transaction.commit();
		session.close();
	}

}
