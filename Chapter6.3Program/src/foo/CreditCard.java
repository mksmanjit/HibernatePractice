package foo;

public class CreditCard extends BillingDetails {

	private int type;
	private String expMonth;
	private String expYear;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getExpMonth() {
		return expMonth;
	}
	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}
	public String getExpYear() {
		return expYear;
	}
	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}
}
