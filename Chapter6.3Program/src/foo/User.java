package foo;

public class User {
private String firstName;
private String lastName;
private String userName;
private String password;
private String email;
private long id;
private long version;
private BillingDetails billingDetails;
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
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
public BillingDetails getBillingDetails() {
	return billingDetails;
}
public void setBillingDetails(BillingDetails billingDetails) {
	this.billingDetails = billingDetails;
}


}
