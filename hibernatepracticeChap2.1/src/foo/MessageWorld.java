package foo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.transaction.JDBCTransaction;

import com.HibernateUtil;


public class MessageWorld {

	/**
	 * @param args
	 * @throws SystemException 
	 * @throws HeuristicRollbackException 
	 * @throws HeuristicMixedException 
	 * @throws RollbackException 
	 * @throws IllegalStateException 
	 * @throws SecurityException 
	 */
	public static void main(String[] args) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		JDBCTransaction tx = (JDBCTransaction) session.beginTransaction();
		Message message1 = new Message("Hello World3");
		Long msgId = (Long)session.save(message1);
		Message message2 = (Message) session.get(Message.class, 1l);
		//String sql = "Update Messages set Message_Text='Manjit3',version = version + '1' where Message_id='1'";
		//String sql = "Update Messages set Message_Text='Manjit3',version = version + '1' where message_text='Magic'";
		String hql = "Update versioned Message set text='Jack671' where id='1'";
		//session.flush();
		//session.createSQLQuery(hql).executeUpdate();
		session.createQuery(hql).executeUpdate();
		//session.flush();
		//session.clear();
		//session.evict(message2);
		//JDBCTransaction newTransaction = (JDBCTransaction) session.beginTransaction();
		//Message message3 = (Message) session.load(Message.class, new Long(1));
		String hql1 = "from Message where id='1'";
		/*String sql1 = "select * from Messages where message_id='1'";
		Object[] obj = (Object[]) (session.createSQLQuery(sql1).list()).get(0);
		Message message3 = new Message();
		message3.setText((String)obj[2]);
		message3.setId(((BigInteger)obj[0]).longValue());
		message3.setVersion(((BigInteger)obj[1]).longValue());*/
		Message message3 = (Message) session.createQuery(hql1).list().get(0);
		//message3.setVersion(message3.getVersion() + 1);
		message3.setText("Magic1234590114325");
		msgId = (Long) session.save(message3);
		//newTransaction.commit();
		//session.flush();
		//session.createQuery(hql).executeUpdate();
		tx.commit();
		message3.getNextMessage();
		/*String hql1 = "from Message where id='1'";
		//Message message3 = (Message) session.createQuery(hql1).list().get(0);
		Message message2 = (Message) session.get(Message.class, 1l);
		Message message4 = (Message) session.createQuery(hql1).list().get(0);
		//Message message4 = (Message) session.get(Message.class, 1l);
		tx.commit();*/
		session.close();
		
		/*Session newSession = HibernateUtil.getSessionFactory().openSession();
		JDBCTransaction newTransaction = (JDBCTransaction) newSession.beginTransaction();
		List messageList = newSession.createQuery("from Message m order by m.text asc").list();
		
		System.out.println(messageList.size() + " message (s) found:");
		for(Iterator itr = messageList.iterator();itr.hasNext();itr.next()){
			Message loadedMsg = (Message) itr.next();
			System.out.println(loadedMsg.getText());
		}
		newTransaction.commit();
		newSession.close();
		
		HibernateUtil.shutdown();*/
		/*String s="67z65z74z69z74z2Ez61z73z70z78z3Fz79z6Fz75z5Fz61z72z65z5Fz70z72z6Fz3Dz66z61z6Cz73z65";
		String[] str=s.split("z");
		 StringBuilder output = new StringBuilder();
		for(int i=0;i<str.length;i++){
			 output.append((char)Integer.parseInt(str[i], 16));
		}
		System.out.println(output);*/
		
		
	}

}
