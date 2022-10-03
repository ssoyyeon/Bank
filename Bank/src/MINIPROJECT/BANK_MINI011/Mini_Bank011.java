package MINIPROJECT.BANK_MINI011;

public class Mini_Bank011 {

	public static void main(String[] args) {

		Bank_v4[]  users = new Bank_v4[] {  new Bank_v4() , new Bank_v4() ,new Bank_v4()  };
		Process_v4_forEach process = new Process_v4_forEach();
		process.menu(users);	
	} // end main

} // end class
