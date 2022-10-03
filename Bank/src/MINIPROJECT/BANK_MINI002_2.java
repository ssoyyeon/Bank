package MINIPROJECT;

import java.util.Scanner;

public class BANK_MINI002_2 {

	public static void main(String[] args) {
		int num = 0, id=1 , pass=1, deposit= 0, withdraw= 0; 
		double balance = 10000;
		String result= "", delete= "";
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("==========BANK==========\n"
						+ "1.추가\n" + "2.조회\n" + "3.입금\n" + "4.출금\n" + "5.삭제\n" + "9.종료\n" + "입력 >>>"); 
		num= scanner.nextInt();
		
		switch(num) {
			case 1:
				System.out.print("□ 아이디 : "); id= scanner.nextInt();
				System.out.print("□ 비밀번호 : "); pass= scanner.nextInt();
				System.out.print("□ 잔	액 : "); balance= scanner.nextDouble();
				System.out.println("설정되어 있습니다." );
				 break;
			case 2:
				System.out.println("□ 조회기능입니다.");
				System.out.print("본인확인ID : "); id= scanner.nextInt();
				System.out.print("본인확인pass : "); pass= scanner.nextInt();
				if(!(id==1 && pass==1)) {
					System.out.println("다시 확인해 주세요.");
					System.out.print("==========BANK==========\n"
							+ "1.추가\n" + "2.조회\n" + "3.입금\n" + "4.출금\n" + "5.삭제\n" + "9.종료\n" + "입력 >>>");
					num= scanner.nextInt();
					System.out.println("□ 조회기능입니다.");
					System.out.print("본인확인ID : "); id= scanner.nextInt();
					System.out.print("본인확인pass : "); pass= scanner.nextInt();
					System.out.println("==반갑습니다 고객님");
					System.out.println("ID : " + id);
					System.out.println("pass : "+ pass);
					System.out.println("balance : " + balance);
				}
				else if (id==1 && pass==1){
					System.out.println("==반갑습니다 고객님");
					System.out.println("ID : " + id);
					System.out.println("pass : "+ pass);
					System.out.println("balance : " + balance);
				}  break;
				
			case 3:
				System.out.println("□ 입금기능 입니다." );
				System.out.print("본인확인ID : "); id= scanner.nextInt();
				System.out.print("본인확인pass : "); pass= scanner.nextInt();
				if(!(id==1 && pass==1)) {
					System.out.println("다시 확인해 주세요.");
					System.out.print("==========BANK==========\n"
						+ "1.추가\n" + "2.조회\n" + "3.입금\n" + "4.출금\n" + "5.삭제\n" + "9.종료\n" + "입력 >>>");
					num= scanner.nextInt();
					System.out.println("□ 입금기능 입니다." );
					System.out.print("본인확인ID : "); id= scanner.nextInt();
					System.out.print("본인확인pass : "); pass= scanner.nextInt();
					System.out.print("입금할 금액을 입금해주세요> "); deposit= scanner.nextInt();
					balance += deposit;
					System.out.println("==잔액확인");
					System.out.println("ID : " + id);
					System.out.println("pass : "+ pass);
					System.out.println("balance : " + balance);
				} else if(id==1 && pass==1) {
					System.out.print("입금할 금액을 입금해주세요> "); deposit= scanner.nextInt();
					balance += deposit;
					System.out.println("==잔액확인");
					System.out.println("ID : " + id);
					System.out.println("pass : "+ pass);
					System.out.println("balance : " + balance);
				}  break;
			case 4 :
				System.out.println("□ 출금기능 입니다");
				System.out.print("본인확인ID : "); id= scanner.nextInt();
				System.out.print("본인확인pass : "); pass= scanner.nextInt();
				if(!(id==1 && pass==1)) {
					System.out.println("다시 확인해 주세요.");
					System.out.print("==========BANK==========\n"
					+ "1.추가\n" + "2.조회\n" + "3.입금\n" + "4.출금\n" + "5.삭제\n" + "9.종료\n" + "입력 >>>");
					num= scanner.nextInt();
					System.out.println("□ 출금기능 입니다");
					System.out.print("본인확인ID : "); id= scanner.nextInt();
					System.out.print("본인확인pass : "); pass= scanner.nextInt();
					System.out.print("출금할 금액을 출금해주세요> "); withdraw= scanner.nextInt();
					balance -= withdraw;
					System.out.println("==잔액확인");
					System.out.println("ID : " + id);
					System.out.println("pass : "+ pass);
					System.out.println("balance : " + balance);
				} else if (id==1 && pass==1) {
					System.out.print("출금할 금액을 출금해주세요> "); withdraw= scanner.nextInt();
					balance -= withdraw;
					System.out.println("==잔액확인");
					System.out.println("ID : " + id);
					System.out.println("pass : "+ pass);
					System.out.println("balance : " + balance);
				}
				break;
			case 5 :
				System.out.println("□ 삭제기능 입니다.");
				System.out.println("==잔액확인");
				id= 0; pass= 0; balance= 0.0f;
				System.out.println("ID : " + id);
				System.out.println("pass : "+ pass);
				System.out.println("balance : " + balance);
				break;
			default :
				 System.out.println("□ 종료기능입니다"); break;
		} 
	}
}
