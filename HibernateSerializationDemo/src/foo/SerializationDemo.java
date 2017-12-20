package foo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.HibernateUtil;

public class SerializationDemo {

	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Collar c = new Collar(12);
		Dog d= new Dog();
		d.setDogSize(5);
		//System.out.println("befor: collar size is "+ d.getCollar().getCollarSize());
		try{
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(bos);
			os.writeObject(c);
			os.flush();
			os.close();
			byte[] data = bos.toByteArray();
			Blob b = (Blob) Hibernate.createBlob(data, session);
			d.setTheCollar(b);
			session.save(d);
		}catch(Exception e){
			e.printStackTrace();
		}
		tx.commit();
		
		Dog db = (Dog) session.get(Dog.class, new Integer(1));
		ObjectInputStream obj = new ObjectInputStream(db.getTheCollar().getBinaryStream());
		Collar theCollar = (Collar) obj.readObject();
		System.out.println(db.getDogSize()+">>"+theCollar.getCollarSize());
		session.close();
		/*try{
			FileInputStream fis = new FileInputStream("testSer.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			d = (Dog) ois.readObject();
			ois.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("after: collar size is " + d.getCollar().getCollarSize());*/
	}

}

class Dog implements Serializable{
	private Integer id;
	private  Blob theCollar;
	private int dogSize;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public int getDogSize() {
		return dogSize;
	}

	public void setDogSize(int dogSize) {
		this.dogSize = dogSize;
	}

	public Blob getTheCollar() {
		return theCollar;
	}

	public void setTheCollar(Blob theCollar) {
		this.theCollar = theCollar;
	}

}

class Collar implements Serializable{
	private Integer collarSize;

	public Collar(int size) {
		setCollarSize(size);
	}

	public Integer getCollarSize() {
		return collarSize;
	}

	public void setCollarSize(Integer collarSize) {
		this.collarSize = collarSize;
	}

}
