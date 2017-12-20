package foo;

import java.util.HashSet;
import java.util.Set;

public class Item {
 private long id;
 private String name;
 private String description;
 private long version;
 private Set<Bid> bids = new HashSet<Bid>();
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public long getVersion() {
	return version;
}
public void setVersion(long version) {
	this.version = version;
}
public Set<Bid> getBids() {
	return bids;
}
public void setBids(Set<Bid> bids) {
	this.bids = bids;
}
 
 
}
