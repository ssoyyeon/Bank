/*
 작성자 :  박소연
 작성일 : 2022.05.25
 프로그램명 : 은행 입출금 관리 시스템
 설명 : id, pass 생성 및 조회 , 입출금, 삭제 종료 기능 구현 프로그램.  
 */
package MINIPROJECT;

import java.util.Scanner;

public class BANK_MINI007 {
	public static int menu() {
		////// 변수
		int num = 0; // 스캐너에서 입력 받을 번호
		Scanner scanner = new Scanner(System.in);

		System.out.print("\n===========BANK===========\n" + "1.추가\n" + "2.조회\n" + "3.입금\n" + "4.출금\n" + "5.삭제\n" + "9.종료\n"
				+ "입력 >>>");
		num = scanner.nextInt();

		return num;
	}

	public static void input(String[][] users) {
		////// 변수
		boolean tempCheck = false;
		// user 생성 갯수
		int userIdx = -1;
		Scanner scanner = new Scanner(System.in);

		// ID 입력 가능 공간이 있는지 체크 반복문
		for (int i = 0; i < users.length; i++) {
			if (users[i][0].equals("")) {
				userIdx = i;
				break;
			}
		}
		if (userIdx == -1) {
			System.out.println("※※※※※※※※※※※※※※※※※※※※※\n 더이상 신규가입이 불가합니다.");
			return ;
		}

		////// 입력
		// ID 입력(생성)
		System.out.print("\n===========회원가입===========");
		System.out.print("\n■ ID : ");
		users[userIdx][0] = scanner.next();
		System.out.print("■ PASS : ");
		users[userIdx][1] = scanner.next();
		System.out.print("■ BALANCE : ");
		users[userIdx][2] = scanner.next();
		System.out.println("설정되었습니다.");
	}

	public static void show(String[][] users) {
		/////// 변수
		boolean tempCheck = false;
		String tempId = "", tempPass = ""; // 아이디와 비밀번호 비교할 변수
		Scanner scanner = new Scanner(System.in);

		////// 입력
		System.out.print("\n============회원조회============");
		System.out.print("\n■ 본인확인ID : ");
		tempId = scanner.next();
		System.out.print("■ 본인확인PASS : ");
		tempPass = scanner.next();

		////// 처리 및 출력
		// 생성된 ID배열 전체에서 ID와 Pass가 일치한 케이스가 있을 경우 정보 출력
		for (int i = 0; i < users.length; i++) {
			if (tempId.equals(users[i][0]) && tempPass.equals(users[i][1])) {
				System.out.println("\n******************************");
				System.out.println("반갑습니다. 고객님.");
				System.out.println("■ ID : " + users[i][0]);
				System.out.println("■ PASS : " + users[i][1]);
				System.out.println("■ BALANCE : " + users[i][2]);
				tempCheck = true;
				break;
			}
		}
		// 위 과정에서 ID와 Pass가 일치한 케이스가 없을 경우에만 출력
		if (tempCheck == false) {
			System.out.println("※※※※※※※※※※※※※※※※※※※※※\n ID와 PASS를 다시 확인해주세요.");
			return ;
		}
	}

	public static void deposit(String[][] users) {
		/////// 변수
		boolean tempCheck = false;
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
		for (int i = 0; i < users.length; i++) {
			if (users[i][0].equals(tempId) && users[i][1].equals(tempPass)) {
				System.out.print("\n입금할 금액을 입력해주세요 > ");
				deposit = scanner.nextInt();
				users[i][2] = Integer.parseInt(users[i][2]) + deposit + "";
				System.out.println("\n**************************");
				System.out.println("잔액확인");
				System.out.println("■ ID : " + users[i][0]);
				System.out.println("■ PASS : " + users[i][1]);
				System.out.println("■ BALANCE : " + users[i][2]);
				tempCheck = true;
				break;
			}
		}
		if (tempCheck == false) {
			System.out.println("※※※※※※※※※※※※※※※※※※※※※\n ID와 PASS를 다시 확인해주세요.");
			return ;
		}
	}

	public static void withdraw(String[][] users) {
		/////// 변수
		boolean tempCheck = false;
		String tempId = "", tempPass = ""; // 아이디와 비밀번호 비교할 변수
		int withdraw = 0; // withdraw = 출금
		Scanner scanner = new Scanner(System.in);

		////// 입력
		System.out.print("\n============출금기능============");
		System.out.print("\n■ 본인확인ID : ");
		tempId = scanner.next();
		System.out.print("■ 본인확인PASS : ");
		tempPass = scanner.next();

		////// 처리 및 출력
		for (int i = 0; i < users.length; i++) {
			if (users[i][0].equals(tempId) && users[i][1].equals(tempPass)) {
				System.out.print("\n출금할 금액을 입력해주세요 > ");
				withdraw = scanner.nextInt();
				if (Integer.parseInt(users[i][2]) >= withdraw) {
					users[i][2] = users[i][2] = Integer.parseInt(users[i][2]) - withdraw + "";
					System.out.println("\n**************************");
					System.out.println("잔액확인");
					System.out.println("■ ID : " + users[i][0]);
					System.out.println("■ PASS : " + users[i][1]);
					System.out.println("■ BALANCE : " + users[i][2]);
					tempCheck = true;
					break;
				} else {
					System.out.println("※※※※※※※※※※※※※※※※※※※※※\n잔액이 부족합니다.\n 출금할 금액을 확인해주세요.");
					tempCheck = true;
					break;
				}
			}
		}
		if (tempCheck == false) {
			System.out.println("※※※※※※※※※※※※※※※※※※※※※\nID와 PASS를 다시 확인해주세요.");
			return ;
		}

	}

	public static void delete(String[][] users) {
		////// 변수
		String tempId = "", tempPass = ""; // 아이디와 비밀번호 비교할 변수
		Scanner scanner = new Scanner(System.in);

		////// 입력
		System.out.print("\n============삭제기능============");
		System.out.print("\n■ 본인확인ID : ");
		tempId = scanner.next();
		System.out.print("■ 본인확인PASS : ");
		tempPass = scanner.next();

		////// 처리 및 출력
		for (int i = 0; i < users.length; i++) {
			// 정보 삭제
			if (users[i][0].equals(tempId) && users[i][1].equals(tempPass)) {
				users[i][0] = "";
				users[i][1] = "";
				users[i][2] = "";
				System.out.println("\n**********************");
				System.out.println("삭제되었습니다.");
				System.out.println("■ ID : " + users[i][0]);
				System.out.println("■ PASS : " + users[i][1]);
				System.out.println("■ BALANCE : " + users[i][2]);
			}
		}
	}

	public static void main(String[] args) {
		/////// ※ 옵션1 : 3명까지만 입력가능하게 - 3명이 넘어가면 더이상신규가입이 불가합니다.
		/////// 변수
		String[][] users = { { "", "", "" }, // 00 01 02
				{ "", "", "" }, // 10 11 12
				{ "", "", "" } // 20 21 22
		};
		int num = 0;

		do {
			num = menu();
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
			
			// 숫자 외 입력하였을때
			default :
				if(num != 9) {
				System.out.println("메뉴 숫자를 입력해주세요.");
				}
				break;	
			}
		} while (num != 9); System.out.println("프로그램이 종료되었습니다.");// 프로그램 종료

	} // end main

} // end class
