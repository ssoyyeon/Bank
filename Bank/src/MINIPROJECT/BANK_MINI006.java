/*
 작성자 :  박소연
 작성일 : 2022.05.19
 프로그램명 : 은행 입출금 관리 시스템
 설명 : 2차원 배열을 이용한 id, pass 생성 및 조회 , 입출금, 삭제 종료 기능 구현 프로그램.  
 */

package MINIPROJECT;

import java.util.Scanner;

public class BANK_MINI006 {

	public static void main(String[] args) {
		// ※ 옵션1 : 3명까지만 입력가능하게 - 3명이 넘어가면 더이상 신규가입이 불가합니다.
		// 변수
		String[][] users = { // USER3명 : id, pass, balance
				{ "", "", "" }, { "", "", "" }, { "", "", "" } };

		// 00 01 02
		// 10 11 12
		// 20 21 22
		int num = 0; // 스캐너에서 입력 받을 번호
		int deposit = 0, withdraw = 0; // deposit = 예금, withdraw = 출금

		String tempId = "", tempPass = ""; // 아이디와 비밀번호 비교할 변수
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome! SY_BANK");
		for (;;) {

			System.out.print("===========BANK=============\n" + "1.추가\n" + "2.조회\n" + "3.입금\n" + "4.출금\n" + "5.삭제\n"
					+ "9.종료\n" + "입력 >>>");
			num = scanner.nextInt();

			switch (num) {
			case 1: {
				////// 변수
				boolean tempCheck = false;
				// user 생성 갯수
				int userIdx = -1;

				// ID 입력 가능 공간이 있는지 체크 반복문
				for (int i = 0; i < users.length; i++) {
					if (users[i][0].equals("")) {
						userIdx = i;
						break;
					}
				}
				if (userIdx == -1) {
					System.out.println("※※※※※※※※※※※※※※※※※※※※※\n 더이상 신규가입이 불가합니다.");
					break;
				}

				////// 입력
				// ID 입력(생성)
				System.out.print("\n■ ID : ");
				users[userIdx][0] = scanner.next();
				System.out.print("■ PASS : ");
				users[userIdx][1] = scanner.next();
				System.out.print("■ BALANCE : ");
				users[userIdx][2] = scanner.next();
				System.out.println("설정되었습니다.");

			}
				break;

			// 조회기능
			case 2: {
				/////// 변수R
				boolean tempCheck = false;
				////// 입력
				System.out.println("\n2. 조회기능입니다.");
				System.out.print("■ 본인확인ID : ");
				tempId = scanner.next();
				System.out.print("■ 본인확인PASS : ");
				tempPass = scanner.next();

				////// 처리 및 출력
				// 생성된 ID배열 전체에서 ID와 Pass가 일치한 케이스가 있을 경우 정보 출력
				for (int i = 0; i < users.length; i++) {
					if (tempId.equals(users[i][0]) && tempPass.equals(users[i][1])) {
						System.out.println("\n****************");
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
				}
				break;
			}
			// 입금기능
			case 3: {
				/////// 변수
				boolean tempCheck = false;

				////// 입력
				System.out.println("\n3. 입금기능입니다.");
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
						System.out.println("\n**********************");
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
				}
			}
				break;

			// 출금기능
			case 4: {
				/////// 변수
				boolean tempCheck = false;

				////// 입력
				System.out.println("\n4. 출금기능입니다.");
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
							System.out.println("\n**********************");
							System.out.println("잔액확인");
							System.out.println("■ ID : " + users[i][0]);
							System.out.println("■ PASS : " + users[i][1]);
							System.out.println("■ BALANCE : " + users[i][2]);
							tempCheck = true;
							break;
						} else {
							System.out.println("※※※※※※※※※※※※※※※※※※※※※\n잔액이 부족합니다.\n 출금할 금액을 확인해주세요.");
							break;
						}
					}
				}
				if (tempCheck == false) {
					System.out.println("※※※※※※※※※※※※※※※※※※※※※\nID와 PASS를 다시 확인해주세요.");
				}
			}
				break;

			// 삭제기능
			case 5: {
				/////// 변수
				boolean tempCheck = false;

				////// 입력
				System.out.println("\n5. 삭제기능입니다.");
				System.out.print("\n■ 본인확인ID : ");
				tempId = scanner.next();
				System.out.print("■ 본인확인PASS : ");
				tempPass = scanner.next();

				////// 처리 및 출력
				for (int i = 0; i < users.length; i++) {
					// 정보 삭제
					if (users[i][0].equals(tempId) && users[i][1].equals(tempPass)) {
						if (Integer.parseInt(users[i][2]) >= withdraw) {
							users[i][0] = "";
							users[i][1] = "";
							users[i][2] = "";
							System.out.println("\n**********************");
							System.out.println("삭제되었습니다.");
						}
						tempCheck = true;
						break;
					}
				}
				if (tempCheck == false) {
					System.out.println("※※※※※※※※※※※※※※※※※※※※※\n ID와 PASS를 다시 확인해주세요.");
				}

			}
				break;

			// 종료 기능
			case 9:
				System.out.println("BANK를 종료합니다.");
				System.exit(0);
				break;
				
			default:
				System.out.println("해당하는 메뉴번호를 입력해주세요.");

			} // switch end
			System.out.println();
		}

	} // end main
}
// end class