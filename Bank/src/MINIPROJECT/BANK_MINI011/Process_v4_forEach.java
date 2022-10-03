package MINIPROJECT.BANK_MINI011;

import java.util.Arrays;
import java.util.Scanner;

import MINIPROJECT.BANK_MINI012.Bank_v5;

public class Process_v4_forEach {

	public void input(Bank_v4[] users) {
		System.out.println(Arrays.toString(users));
		////// 변수
		boolean flag = false; // 신규 가입이 불가할 때 for문을 나가는 변수
		Scanner scanner = new Scanner(System.in);
		////// 입력
		for (Bank_v4 i : users) {
			// 빈공간 확인
			if (i.getId() == null) {
				// ID생성
				System.out.print("\n===========회원가입===========");
				System.out.print("\n■ ID : ");
				i.setId(scanner.next());
				System.out.print("■ PASS : ");
				i.setPass(scanner.next());
				System.out.print("■ BALANCE : ");
				i.setBalance(scanner.nextInt());
				System.out.println("설정되었습니다.");
				flag = true;
				break;
			}
		}
		if (flag == false)
			System.out.println("※※※※※※※※※※※※※※※※※※※※※\n 더이상 신규가입이 불가합니다.");
	}

	void show(Bank_v4[] users) {
		/////// 변수
		boolean flag = false; // 생성된 ID,Pass와 ID와 Pass가 불일치할 때 for문을 나가는 변수
		String tempId = "", tempPass = ""; // 아이디와 비밀번호 비교할 변수
		Scanner scanner = new Scanner(System.in);

		////// 입력
		System.out.print("\n============회원조회============");
		System.out.print("\n■ 본인확인ID : ");
		tempId = scanner.next();
		System.out.print("■ PASS : ");
		tempPass = scanner.next();

		////// 처리 및 출력
		// 생성된 ID,Pass와 ID와 Pass가 일치할 경우 정보 출력
		for (Bank_v4 j : users) {
			// 생성된 ID,Pass와 ID와 Pass가 일치할 경우 정보 출력
			if (tempId.equals(j.getId()) && tempPass.equals(j.getPass())) {
				System.out.println("\n***********조회결과************");
				System.out.println("반갑습니다. 고객님.");
				System.out.println("■ ID : " + j.getId());
				System.out.println("■ PASS : " + j.getPass());
				System.out.println("■ BALANCE : " + (int) j.getBalance());
				System.out.println("조회가 성공했습니다.");
				flag = true;
				break;
			}
		}
		// 생성된 ID,Pass와 ID와 Pass가 불일치할 경우 출력
		if (flag == false)
			System.out.println("\n※※※※※※※※※※※※※※※※※※※※※\n조회가 실패했습니다.\nID와 PASS를 다시 확인해주세요.");
		System.out.println("\n아무키나 누르세요. ");
	}

	void deposit(Bank_v4[] users) {
		/////// 변수
		boolean flag = false; // 생성된 ID,Pass와 ID와 Pass가 불일치할 때 for문을 나가는 변수
		String tempId = "", tempPass = ""; // 아이디와 비밀번호 비교할 변수
		int deposit = 0; // deposit = 예금
		double balance; // deposit을 입금한 값
		Scanner scanner = new Scanner(System.in);

		////// 입력
		System.out.print("\n============입금기능============");
		System.out.println("\n*****입금 계좌정보 입력*****");
		System.out.print("\n■ ID : ");
		tempId = scanner.next();
		System.out.print("■ PASS : ");
		tempPass = scanner.next();

		////// 처리 및 출력
		for (Bank_v4 j : users) {
			// 생성된 ID,Pass와 ID와 Pass가 일치할 경우 정보 출력
			if (tempId.equals(j.getId()) && tempPass.equals(j.getPass())) {
				System.out.print("\n입금할 금액을 입력해주세요 > ");
				deposit = scanner.nextInt();
				balance = j.getBalance() + deposit;
				j.setBalance(balance);
				System.out.println(deposit + "이 입금되었습니다.");
				flag = true;
				break;
			}
		}
		// 생성된 ID,Pass와 ID와 Pass가 불일치할 경우 출력
		if (flag == false) // 생성된 ID,Pass와 ID와 Pass가 불일치할 경우 출력
			System.out.println("※※※※※※※※※※※※※※※※※※※※※\n계좌 정보가 없습니다.\nID와 PASS를 다시 확인해주세요.");
	}

	void withdraw(Bank_v4[] users) {
		/////// 변수
		boolean flag = false; // 생성된 ID,Pass와 ID와 Pass가 불일치할 때 for문을 나가는 변수
		String tempId = "", tempPass = ""; // 아이디와 비밀번호 비교할 변수
		int withdraw = 0; // withdraw = 출금
		double balance; // withdraw를 출금한 값
		Scanner scanner = new Scanner(System.in);

		////// 입력
		// 본인확인
		System.out.print("\n============출금기능============");
		System.out.println("\n*****출금 계좌정보 입력*****");
		System.out.print("\n■ ID : ");
		tempId = scanner.next();
		System.out.print("■ PASS : ");
		tempPass = scanner.next();

		////// 처리 및 출력
		for (Bank_v4 j : users) {
			// 생성된 ID,Pass와 ID와 Pass가 일치할 경우 정보 출력
			if (tempId.equals(j.getId()) && tempPass.equals(j.getPass())) {
				System.out.print("\n출금할 금액을 입력해주세요 > ");
				withdraw = scanner.nextInt();
				// 출금할 금액이 잔액보다 크면 출력
				if (j.getBalance() >= withdraw) {
					balance = j.getBalance() - withdraw;
					j.setBalance(balance);
					System.out.println(withdraw + "이 출금되었습니다.");
				} else { // 출금할 금액이 잔액보다 작으면 출력
					System.out.println("※※※※※※※※※※※※※※※※※※※※※\n잔액이 부족합니다.\n출금할 금액을 확인해주세요.");
				}
				flag = true;
				break;
			}
		}
		// 생성된 ID,Pass와 ID와 Pass가 불일치할 경우 출력
		if (flag == false)
			System.out.println("※※※※※※※※※※※※※※※※※※※※※\n계좌 정보가 없습니다.\nID와 PASS를 다시 확인해주세요.");
	}

	void delete(Bank_v4[] users) {
		////// 변수
		boolean flag = false; // 생성된 ID,Pass와 ID와 Pass가 불일치할 때 for문을 나가는 변수
		String tempId = "", tempPass = ""; // 아이디와 비밀번호 비교할 변수
		char tmp; // 삭제여부 입력받는 변수
		Scanner scanner = new Scanner(System.in);

		////// 입력
		// 본인확인
		System.out.print("\n============삭제기능============");
		System.out.println("\n*****삭제할 계좌정보 입력*****");
		System.out.print("\n■ ID : ");
		tempId = scanner.next();
		System.out.print("■ PASS : ");
		tempPass = scanner.next();

		////// 처리 및 출력
		// 정보 삭제
		for (Bank_v4 j : users) {
			// 생성된 ID,Pass와 ID와 Pass가 일치할 경우 삭제 진행
			if (tempId.equals(j.getId()) && tempPass.equals(j.getPass())) {
				System.out.println("\n**************************");
				System.out.println("삭제하시겠습니까 ? (Y/N)");
				tmp = scanner.next().charAt(0);
				if (tmp == 'Y' || tmp == 'y') {
					j.setId("");
					j.setPass("");
					j.setBalance(0);
					System.out.println("계좌 정보가 삭제되었습니다.");
					flag = true;
					break;
				} else {
					System.out.println("메인으로 돌아갑니다.");
				}
				flag = true;
				break;
			}
		}
		// 생성된 ID,Pass와 ID와 Pass가 불일치할 경우 출력
		if (flag == false)
			System.out.println("※※※※※※※※※※※※※※※※※※※※※\n계좌정보가 없습니다.\nID와 PASS를 다시 확인해주세요.");
	}

	public void menu(Bank_v4[] users) {
		////// 변수
		int num = 0; // 스캐너에서 입력 받을 번호
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("\n==========BANK==========\n" + "1.추가\n" + "2.조회\n" + "3.입금\n" + "4.출금\n" + "5.삭제\n"
					+ "9.종료\n" + "입력 >>>");
			num = scanner.nextInt();
			switch (num) {
			// 사용자 추가하기
			case 1:
				input(users);
				break;
			// 사용자 조회하기
			case 2:
				show(users);
				break;
			// 예금하기
			case 3:
				deposit(users);
				break;
			// 출금하기
			case 4:
				withdraw(users);
				break;
			// 사용자 정보 삭제하기
			case 5:
				delete(users);
				break;
			// 프로그램 종료하기
			case 9:
				System.out.println("프로그램이 종료되었습니다.");// 프로그램 종료
				System.exit(0);
				// 숫자 외 입력하였을때
			default:
				if (num != 9) {
					System.out.println("메뉴 숫자를 입력해주세요.");
				}
				break;
			} // end switch
		} while (num != 9);
	} // end do while
} // end class
