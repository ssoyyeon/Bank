/*
Bank_v1  user1 = new Bank_v1();
		user1.menu(); 작성자 :  박소연
 작성일 : 2022.05.25
 프로그램명 : 은행 입출금 관리 시스템
 설명 : id, pass 생성 및 조회 , 입출금, 삭제 종료 기능 구현 프로그램.  
 */
package MINIPROJECT;

import java.util.Scanner;

class Bank_v2 {
	//// 멤버변수
	private String id;
	private String pass;
	private double balance;
	static String Company = "(주) 박소연회사";

	//// 생성자
	public Bank_v2() {
		super();
	}

	public Bank_v2(String id, String pass, double balance) {
		super();
		this.id = id;
		this.pass = pass;
		this.balance = balance;
	}

	//// 멤버메서드
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

	int menu() {
		////// 변수
		// 스캐너에서 입력 받을 번호
		int num = 0; 
		Scanner scanner = new Scanner(System.in); 
		// 클래스 받는 생성자 생성
		Bank_v2 user1 = new Bank_v2();

		do {
			System.out.print("==========BANK==========\n" + "1.추가\n" + "2.조회\n" + "3.입금\n" + "4.출금\n" + "5.삭제\n"
					+ "9.종료\n" + "입력 >>>");
			num = scanner.nextInt();
			switch (num) {
			// 사용자 추가하기
			case 1:
				user1.input();
				break;
			// 사용자 조회하기
			case 2:
				user1.show();
				break;
			// 예금하기
			case 3:
				user1.deposit();
				break;
			// 출금하기
			case 4:
				user1.withdraw();
				break;
			// 사용자 정보 삭제하기
			case 5:
				user1.delete();
				break;
			// 프로그램 종료하기
			case 9:
				System.out.println("종료기능입니다.");
				break;
			// 숫자 외 입력하였을때
			default:
				if (num != 9) {
					System.out.println("메뉴 숫자를 입력해주세요.");
				}
				break;
			}
		} while (num != 9);
		System.out.println("프로그램이 종료되었습니다.");// 프로그램 종료
		return num;
	}

	void input() {
		////// 변수
		Scanner scanner = new Scanner(System.in);

		////// 입력
		// ID 입력(생성)
		System.out.print("\n===========회원가입===========");
		System.out.print("\n■ ID : ");
		id = scanner.next();
		System.out.print("■ PASS : ");
		pass = scanner.next();
		System.out.print("■ BALANCE : ");
		balance = scanner.nextDouble();
		System.out.println("설정되었습니다.");
	}

	void show() {
		/////// 변수
		String tempId = "", tempPass = ""; // 아이디와 비밀번호 비교할 변수
		Scanner scanner = new Scanner(System.in);

		////// 입력
		System.out.print("\n============회원조회============");
		System.out.print("\n■ 본인확인ID : ");
		tempId = scanner.next();
		System.out.print("■ 본인확인PASS : ");
		tempPass = scanner.next();

		////// 처리 및 출력
		// 생성된 ID,Pass와 ID와 Pass가 일치할 경우 정보 출력
		if (tempId.equals(id) && tempPass.equals(pass)) {
			System.out.println("\n******************************");
			System.out.println("반갑습니다. 고객님.");
			System.out.println("■ ID : " + id);
			System.out.println("■ PASS : " + pass);
			System.out.println("■ BALANCE : " + (int) balance);
		}
		// 생성된 ID,Pass와 ID와 Pass가 불일치할 경우 출력
		else {
			System.out.println("※※※※※※※※※※※※※※※※※※※※※\n ID와 PASS를 다시 확인해주세요.");
		}
	}

	void deposit() {
		/////// 변수
		String tempId = "", tempPass = ""; // 아이디와 비밀번호 비교할 변수
		int deposit = 0; // deposit = 예금
		Scanner scanner = new Scanner(System.in);

		////// 입력
		System.out.print("\n============입금기능============");
		System.out.print("\n■ 본인확인ID : ");
		tempId = scanner.next();
		System.out.print("■ 본인확인PASS : ");
		tempPass = scanner.next();

		////// 처리 및 출력
		if (tempId.equals(id) && tempPass.equals(pass)) {
			System.out.print("\n입금할 금액을 입력해주세요 > ");
			deposit = scanner.nextInt();
			balance += deposit;
			System.out.println("\n**************************");
			System.out.println("잔액확인");
			System.out.println("■ ID : " + id);
			System.out.println("■ PASS : " + pass);
			System.out.println("■ BALANCE : " + (int) balance);
		} else { // 생성된 ID,Pass와 ID와 Pass가 불일치할 경우 출력
			System.out.println("※※※※※※※※※※※※※※※※※※※※※\n ID와 PASS를 다시 확인해주세요.");
		}
	}

	void withdraw() {
		/////// 변수
		String tempId = "", tempPass = ""; // 아이디와 비밀번호 비교할 변수
		int withdraw = 0; // withdraw = 출금
		Scanner scanner = new Scanner(System.in);

		////// 입력
		// 본인확인
		System.out.print("\n============출금기능============");
		System.out.print("\n■ 본인확인ID : ");
		tempId = scanner.next();
		System.out.print("■ 본인확인PASS : ");
		tempPass = scanner.next();

		////// 처리 및 출력
		if (tempId.equals(id) && tempPass.equals(pass)) {
			System.out.print("\n출금할 금액을 입력해주세요 > ");
			withdraw = scanner.nextInt();
			// 출금할 금액이 잔액보다 크면 출력
			if (balance >= withdraw) {
				balance -= withdraw;
				System.out.println("\n**************************");
				System.out.println("잔액확인");
				System.out.println("■ ID : " + id);
				System.out.println("■ PASS : " + pass);
				System.out.println("■ BALANCE : " + (int) balance);
			} else { // 출금할 금액이 잔액보다 작으면 출력
				System.out.println("※※※※※※※※※※※※※※※※※※※※※\n잔액이 부족합니다.\n 출금할 금액을 확인해주세요.");
			}

		} else // 생성된 ID,Pass와 ID와 Pass가 불일치할 경우 출력
			System.out.println("※※※※※※※※※※※※※※※※※※※※※\n ID와 PASS를 다시 확인해주세요.");

	}

	void delete() {
		////// 변수
		String tempId = "", tempPass = ""; // 아이디와 비밀번호 비교할 변수
		Scanner scanner = new Scanner(System.in);

		////// 입력
		// 본인확인
		System.out.print("\n============삭제기능============");
		System.out.print("\n■ 본인확인ID : ");
		tempId = scanner.next();
		System.out.print("■ 본인확인PASS : ");
		tempPass = scanner.next();

		////// 처리 및 출력
		// 정보 삭제
		if (tempId.equals(id) && tempPass.equals(pass)) {
			id = "";
			pass = "";
			balance = 0;
			System.out.println("\n**************************");
			System.out.println("삭제되었습니다.");
			System.out.println("■ ID : " + id);
			System.out.println("■ PASS : " + pass);
			System.out.println("■ BALANCE : " + (int) balance);
		} else // 생성된 ID,Pass와 ID와 Pass가 불일치할 경우 출력
			System.out.println("※※※※※※※※※※※※※※※※※※※※※\n ID와 PASS를 다시 확인해주세요.");
	}

} // end Bank_v2 class

public class BANK_MINI009 {
	public static void main(String[] args) {
		Bank_v2 user1 = new Bank_v2();
		user1.menu();

	} // end main
} // end class
