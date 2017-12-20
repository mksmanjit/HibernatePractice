package foo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.HibernateUtil;

public class CategoryItemMain {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Category category = new Category();
		category.setName("Fruits");
		Item apple = new Item();
		apple.setName("APPLE");
		apple.setDescription("FRUITS");
		apple.getCategories().add(category);
		category.addItem(apple);
		Item mango = new Item();
		mango.setName("MANGO");
		mango.setDescription("MANGO FRUITS");
		category.addItem(mango);
		Item pineapple= new Item();
		pineapple.setName("PINEAPPLE");
		pineapple.setDescription("PINEAPPLE FRUIT");
		Category category1 = new Category();
		category1.setName("ANIMALS");
		pineapple.getCategories().add(category1);
		//category1.getItems().add(pineapple);
		//Category category = (Category) session.get(Category.class, new Long(1));
		//List<Category> categoryList = session.createQuery("from Category").list();
		//List<Category> categoryList = session.createCriteria(Category.class).setFetchSize(1).setFetchMode("items", FetchMode.EAGER).list();
		/*List<Category> categoryList = session.createCriteria(Category.class).list();
		for (Category category : categoryList) {
			Iterator<Item> itr = category.getItems().iterator();
			while (itr.hasNext()) {
				Item item = itr.next();
				System.out.println(item.getName());
			}
		}*/
		Transaction tx = session.beginTransaction();
		session.save(category);
		//session.save(apple);
		tx.commit();
		HibernateUtil.shutdown();
	}

}
