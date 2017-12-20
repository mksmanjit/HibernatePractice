package foo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.HibernateUtil;

public class CategoryItemMain {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		/*Bid bid = new Bid();
		bid.setAmount(100);
		Item apple = new Item();
		apple.setName("APPLE");
		apple.setDescription("FRUITS");
		bid.setItem(apple);
		apple.getBids().add(bid);
		Transaction tx = session.beginTransaction();
		session.save(apple);
		tx.commit();*/
		Item itemDB = (Item) session.get(Item.class, 1l);
		itemDB.getBids();
		
		HibernateUtil.shutdown();
	}

}
