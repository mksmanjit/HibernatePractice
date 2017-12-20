package foo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.HibernateUtil;

public class UserAddressMain {
	public static void main(String args[]){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Address address = new Address();
		address.setStreet("646 Toorak Rd");
		address.setCity("Toorak");
		address.setZipcode("3000");
		/*Transaction tx=session.beginTransaction();
		session.save(address);
		tx.commit();*/
		User user = new User();
		address.setUser(user);
		user.setFirstName("manjit123");
		user.setAddress(address);
		//user.setBillingAddress(address);
		Transaction tx=session.beginTransaction();
		session.save(user);
		tx.commit();
		/*Transaction tx=session.beginTransaction();
		Address address = (Address) session.get(Address.class, new Long(4));
		User user = (User) session.get(User.class, new Long(3));
		address.setUser(user);
		tx.commit();*/
		
		HibernateUtil.shutdown();
	}
}
