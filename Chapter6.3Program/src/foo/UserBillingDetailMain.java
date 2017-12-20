package foo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.HibernateUtil;

public class UserBillingDetailMain {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		User user = new User();
		user.setFirstName("Manjit");
		user.setLastName("Kumar");

		CreditCard creditCard = new CreditCard();
		creditCard.setType(1);
		creditCard.setExpMonth("12");
		creditCard.setExpYear("2016");
		creditCard.setOwner("Jacky");
		
		user.setBillingDetails(creditCard);
		creditCard.setUser(user);
		/*BankAccount bankAccount = new BankAccount();
		bankAccount.setBankName("SBI");
		bankAccount.setOwner("Sanju");*/
		
		Transaction tx = session.beginTransaction();
			session.save(user);
			//session.save(creditCard);
			//session.save(bankAccount);
		tx.commit();
		/*Transaction tx = session.beginTransaction();
		CreditCard card = (CreditCard) session.load(CreditCard.class, new Long(1));
		System.out.println(card.getOwner());
		tx.commit();*/
		
		
		
	}

}
