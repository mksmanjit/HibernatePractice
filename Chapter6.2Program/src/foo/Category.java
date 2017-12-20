package foo;

import java.util.HashSet;
import java.util.Set;

public class Category {
	private long id;
	private long version;
	private String name;
	private Set<Item> items = new HashSet<Item>();;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	public void addItem(Item item){
		items.add(item);
	}

}
