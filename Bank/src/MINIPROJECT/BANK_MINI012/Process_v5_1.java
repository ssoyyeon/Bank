package MINIPROJECT.BANK_MINI012;

import java.util.Scanner;

import MINIPROJECT.BANK_MINI010.Bank_v3;

public class Process_v5_1 {
	// 생성자
	public Process_v5_1(){	
	}
	// 멤버메서드
	public void input(Bank_v5 user1) {
		////// 변수
		Scanner scanner = new Scanner(System.in);

		////// 입력
		// ID 입력(생성)
		System.out.print("\n■ ID : ");
		user1.setId(scanner.next());
		System.out.print("■ PASS : ");
		user1.setPass(scanner.next());
		System.out.print("■ BALANCE : ");
		user1.setBalance(scanner.nextDouble());
		System.out.println("설정되었습니다.");
	}
	
	void show(Bank_v5 user1) {
		/////// 변수
		String tempId = "", tempPass = ""; // 아이디와 비밀번호 비교할 변수
		Scanner scanner = new Scanner(System.in);

		////// 입력
		System.out.println("\n2. 조회기능입니다.");
		System.out.print("■ 본인확인ID : ");
		tempId = scanner.next();
		System.out.print("■ 본인확인PASS : ");
		tempPass = scanner.next();

		////// 처리 및 출력
		// 생성된 ID,Pass와 ID와 Pass가 일치할 경우 정보 출력
		if (tempId.equals(user1.getId()) && tempPass.equals(user1.getPass())) {
			System.out.println("\n****************");
			System.out.println("반갑습니다. 고객님.");
			System.out.println("■ ID : " + user1.getId());
			System.out.println("■ PASS : " + user1.getPass());
			System.out.println("■ BALANCE : " + user1.getBalance());
		}
		// 생성된 ID,Pass와 ID와 Pass가 불일치할 경우 출력
		else {
			System.out.println("※※※※※※※※※※※※※※※※※※※※※\n ID와 PASS를 다시 확인해주세요.");
		}
	}

	void deposit(Bank_v5 user1) {
		/////// 변수
		String tempId = "", tempPass = ""; // 아이디와 비밀번호 비교할 변수
		int deposit = 0; // deposit = 예금
		double balance; // deposit을 입금한 값
		Scanner scanner = new Scanner(System.in);

		////// 입력
		System.out.println("\n3. 입금기능입니다.");
		System.out.print("■ 본인확인ID : ");
		tempId = scanner.next();
		System.out.print("■ 본인확인PASS : ");
		tempPass = scanner.next();

		////// 처리 및 출력
		if (tempId.equals(user1.getId()) && tempPass.equals(user1.getPass())) {
			System.out.print("\n입금할 금액을 입력해주세요 > ");
			deposit = scanner.nextInt();
			balance = user1.getBalance() + deposit;
			user1.setBalance(balance);
			System.out.println("\n****************");
			System.out.println("잔액확인");
			System.out.println("■ ID : " + user1.getId());
			System.out.println("■ PASS : " + user1.getPass());
			System.out.println("■ BALANCE : " + user1.getBalance());

		} else { // 생성된 ID,Pass와 ID와 Pass가 불일치할 경우 출력
			System.out.println("※※※※※※※※※※※※※※※※※※※※※\n ID와 PASS를 다시 확인해주세요.");
		}
	}

	void withdraw(Bank_v5 user1) {
		/////// 변수
		String tempId = "", tempPass = ""; // 아이디와 비밀번호 비교할 변수
		int withdraw = 0; // withdraw = 출금
		double balance; // withdraw을 출금한 값
		Scanner scanner = new Scanner(System.in);

		////// 입력
		// 본인확인
		System.out.println("\n4. 출금기능입니다.");
		System.out.print("■ 본인확인ID : ");
		tempId = scanner.next();
		System.out.print("■ 본인확인PASS : ");
		tempPass = scanner.next();

		////// 처리 및 출력
		if (tempId.equals(user1.getId()) && tempPass.equals(user1.getPass())) {
			System.out.print("\n출금할 금액을 입력해주세요 > ");
			withdraw = scanner.nextInt();
			// 출금할 금액이 잔액보다 크면 출력
			if (user1.getBalance() >= withdraw) {
				balance = user1.getBalance() - withdraw;
				user1.setBalance(balance);
				System.out.println("\n****************");
				System.out.println("잔액확인");
				System.out.println("■ ID : " + user1.getId());
				System.out.println("■ PASS : " + user1.getPass());
				System.out.println("■ BALANCE : " + user1.getBalance());

			} else { // 출금할 금액이 잔액보다 작으면 출력
				System.out.println("※※※※※※※※※※※※※※※※※※※※※\n잔액이 부족합니다.\n출금할 금액을 확인해주세요.");
			}

		} else // 생성된 ID,Pass와 ID와 Pass가 불일치할 경우 출력
			System.out.println("※※※※※※※※※※※※※※※※※※※※※\n ID와 PASS를 다시 확인해주세요.");

	}

	void delete(Bank_v5 user1) {
		////// 변수
		String tempId = "", tempPass = ""; // 아이디와 비밀번호 비교할 변수
		Scanner scanner = new Scanner(System.in);

		////// 입력
		// 본인확인
		System.out.println("\n5. 삭제기능입니다.");
		System.out.print("■ 본인확인ID : ");
		tempId = scanner.next();
		System.out.print("■ 본인확인PASS : ");
		tempPass = scanner.next();

		////// 처리 및 출력
		// 정보 삭제
		if (tempId.equals(user1.getId()) && tempPass.equals(user1.getPass())) {
			user1.setId("");
			user1.setPass("");
			user1.setBalance(0);
			System.out.println("\n****************");
			System.out.println("삭제되었습니다.");
			System.out.println("■ ID : " + user1.getId());
			System.out.println("■ PASS : " + user1.getPass());
			System.out.println("■ BALANCE : " + user1.getBalance());

		} else // 생성된 ID,Pass와 ID와 Pass가 불일치할 경우 출력
			System.out.println("※※※※※※※※※※※※※※※※※※※※※\n ID와 PASS를 다시 확인해주세요.");
	}

	public void menu(Bank_v5 user1) {
		////// 변수
		int num = 0; // 스캐너에서 입력 받을 번호
		Scanner scanner = new Scanner(System.in); // 클래스 받는 생성자 생성

		do {
			System.out.print("==========BANK==========\n" + "1.추가\n" + "2.조회\n" + "3.입금\n" + "4.출금\n" + "5.삭제\n"
					+ "9.종료\n" + "입력 >>>");
			num = scanner.nextInt();
			switch (num) {
			// 사용자 추가하기
			case 1:
				input(user1);
				break;
			// 사용자 조회하기
			case 2:
				show(user1);
				break;
			// 예금하기
			case 3:
				deposit(user1);
				break;
			// 출금하기
			case 4:
				withdraw(user1);
				break;
			// 사용자 정보 삭제하기
			case 5:
				delete(user1);
				break;
			// 프로그램 종료하기
			case 9:
				System.out.println("종료기능입니다.");
				break;
			}

		} while (num != 9);
		System.out.println("프로그램이 종료되었습니다.");// 프로그램 종료

	} // end do while

} // end Process_v5_1 class
