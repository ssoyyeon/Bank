package MINIPROJECT.BANK_MINI011;

public class Bank_v4 {
	// 멤버변수
	private String id;
	private String pass;
	private double balance;
	static String Company = "(주) 박소연 은행";

	// 생성자
	public Bank_v4() {
		super();
	}

	public Bank_v4(String id, String pass, int balance) {
		super();
		this.id = id;
		this.pass = pass;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Bank_v4 [id=" + id + ", pass=" + pass + ", balance=" + balance + "]";
	}

	// 멤버메서드 getter, setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public static String getCompany() {
		return Company;
	}

	public static void setCompany(String company) {
		Company = company;
	}

} // end Bank_v4 class
