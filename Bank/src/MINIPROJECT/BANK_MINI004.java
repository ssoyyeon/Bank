/* 클래스 이름: BANK_MINI004

   작성자: 박소연

   작성일: 2022년 5월 4일
   
   for 이용한 출력

*/
package MINIPROJECT;
import java.util.Scanner;
public class BANK_MINI004 {
	public static void main(String[] args) {
				String id = "", pass = "", userId = "", userPass = "";
				int num = 0, deposit = 0, withdraw = 0;
				double balance = 10000;
				Scanner scanner = new Scanner(System.in);

				for (num = 1; num <= 9;) {
					System.out.print("==========BANK==========\n" + 
							"1.추가\n" + "2.조회\n" + "3.입금\n" + "4.출금\n" + "5.삭제\n"
							+ "9.종료\n" + "입력 >>>");
					num = scanner.nextInt();
					if (num == 1) {
						System.out.print("□ 아이디 : ");
						id = scanner.next();
						userId = id;
						System.out.print("□ 비밀번호 : ");
						pass = scanner.next();
						userPass = pass;
						System.out.print("□ 잔	액 : ");
						balance = scanner.nextDouble();
						System.out.println("설정되어 있습니다.");
					} else if (num == 2) {
						System.out.println("□ 조회기능입니다.");
						System.out.print("본인확인ID : ");
						userId = scanner.next();
						System.out.print("본인확인pass : ");
						userPass = scanner.next();
						if (id.equals(userId) && pass.equals(userPass)) {
							System.out.println("==반갑습니다 고객님");
							System.out.println("ID : " + userId);
							System.out.println("pass : " + userPass);
							System.out.println("balance : " + (int)balance);
						} else
							System.out.println("다시 확인해 주세요.");
					} else if (num == 3) {
						System.out.println("□ 입금기능 입니다.");
						System.out.print("본인확인ID : ");
						userId = scanner.next();
						System.out.print("본인확인pass : ");
						userPass = scanner.next();
						if (id.equals(userId) && pass.equals(userPass)) {
							System.out.print("입금할 금액을 입금해주세요> ");
							deposit = scanner.nextInt();
							balance += deposit;
							System.out.println("==잔액확인");
							System.out.println("ID : " + userId);
							System.out.println("pass : " + userPass);
							System.out.println("balance : " + (int)balance);
						} else
							System.out.println("다시 확인해 주세요.");
					} else if (num == 4) {
						System.out.println("□ 출금기능 입니다");
						System.out.print("본인확인ID : ");
						userId = scanner.next();
						System.out.print("본인확인pass : ");
						userPass = scanner.next();
						if (id.equals(userId) && pass.equals(userPass)) {
							System.out.print("출금할 금액을 출금해주세요> ");
							withdraw = scanner.nextInt();
							if (balance >= withdraw){
								balance -= withdraw;
								System.out.println("==잔액확인");
								System.out.println("ID : " + userId);
								System.out.println("pass : " + userPass);
								System.out.println("balance : " + (int)balance);
							} else System.out.println("잔액이 부족합니다.");
						} else
							System.out.println("다시 확인해 주세요.");
					} else if (num == 5) {
						System.out.println("□ 삭제기능 입니다.");
						System.out.print("본인확인ID : " );
						userId = scanner.next();
						System.out.print("본인확인Pass : ");
						userPass = scanner.next();
						if (id.equals(userId) && pass.equals(userPass)) {
							userId = "0"; userPass = "0"; balance = 0;
							System.out.println("==잔액확인");
							System.out.println("ID : " + userId);
							System.out.println("pass : " + userPass);
							System.out.println("balance : " + (int)balance);
						} else
							System.out.println("다시 확인해 주세요.");
					} else if (num == 9) {
						System.out.println("□ 종료기능입니다");
						break;
					} else
						System.out.println("숫자를 다시 입력해주세요.");
				}


	}
}
