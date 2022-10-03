/*
 작성자 :  박소연
 작성일 : 2022.05.25
 프로그램명 : 은행 입출금 관리 시스템
 설명 : id, pass 생성 및 조회 , 입출금, 삭제 종료 기능 구현 프로그램.  
 */

package MINIPROJECT;

import java.util.Arrays;
import java.util.Scanner;

public class BANK_MINI005 {
	public static void main(String[] args) {
		// ※ 옵션1 : 3명까지만 입력가능하게 - 3명이 넘어가면 더이상 신규가입이 불가합니다.
		int num = 0; // 스캐너에서 입력 받을 번호
		int deposit = 0, withdraw = 0; // deposit = 예금, withdraw = 출금
		int[] balance = { 0, 0, 0 }; // 잔액 저장
		String[] id = new String[3]; // 사용자 아이디 저장
		String[] pass = new String[3]; // 사용자 비밀번호 저장
		String tempId = "", tempPass = ""; // 아이디와 비밀번호 비교할 변수
		int cnt = 0; // 아이디 비밀번호 저장할 때마다 올라가는 카운트
		int i = 0;
		Scanner scanner = new Scanner(System.in);

		for (;;) {
			System.out.print("==========BANK==========\n" + "1.추가\n" + "2.조회\n" + "3.입금\n" + "4.출금\n" + "5.삭제\n"
					+ "9.종료\n" + "입력 >>>");
			num = scanner.nextInt();
			// 사용자 추가
			if (num == 1) {
				cnt++;
				// 3명까지만 입력 가능한 조건
				if (cnt > 3) {
					System.out.println("더이상 신규가입이 불가합니다.\n");
				} else {
				////// 입력	
					// 아이디 입력
					System.out.print("ㅁ 아이디 : ");
					id[i] = scanner.next();
					System.out.print("ㅁ 비밀번호 : ");
					pass[i] = scanner.next();
					System.out.print("ㅁ 잔액 : ");
					balance[i] = scanner.nextInt();
					System.out.println("설정되어 있습니다.");
					i++;
				}
				
			// 조회하기
			} else if (num == 2) {
			////// 변수	
				boolean flag = false;
				int k = -1;			
			
			////// 입력	
				// 본인확인
				System.out.println("ㅁ 조회기능입니다");
				System.out.print("본인확인ID : ");
				tempId = scanner.next();
				System.out.print("본인확인pass : ");
				tempPass = scanner.next();
			
			////// 처리
				// 사용자 추가 유무 확인
				for (int j = 0; j < i; j++) {
					if (tempId.equals(id[j]) && tempPass.equals(pass[j])) {
						// 사용자의 아이디 번호를 찾는다.
						k = j;
						
			////// 출력	
							System.out.println("**************************");
							System.out.println("반갑습니다 고객님~^^");
							System.out.println("아이디 : " + id[k]);
							System.out.println("비밀번호 : " + pass[k]);
							System.out.println("잔액: " + balance[k]);
						flag = true;
						break;
					} 
				}
				if (flag == false) { // 아이디와 비밀번호가 다를 때 
					System.out.println("다시 확인해 주세요.\n");
					continue;
				}
		

			// 입금하기	
			} else if (num == 3) {
			/////// 변수
				boolean	flag = false;
				
			//////// 입력
				// 본인확인
				System.out.println("□ 입금기능 입니다.");
				System.out.print("본인확인ID : ");
				tempId = scanner.next();
				System.out.print("본인확인pass : ");
				tempPass = scanner.next();
			
				////// 처리
				for (int j = 0; j < i; j++) {
					if (tempId.equals(id[j]) && tempPass.equals(pass[j])) {
						System.out.print("입금할 금액을 입금해주세요> ");
						deposit = scanner.nextInt();
						balance[j] += deposit;
						flag = true;
						
				/////// 출력		
						System.out.println("**************************");
						System.out.println("잔액확인");
						System.out.println("ID : " + id[j]);
						System.out.println("pass : " + pass[j]);
						System.out.println("balance: " + balance[j] + "\n");
						break;
					}
				} // 아이디와 비밀번호가 다를 때 
				if (flag == false) {
					System.out.println("다시 확인해 주세요.\n");
					continue;
				}
				
			// 출금하기 
			} else if (num == 4) {
			////// 변수
				boolean	flag = false;
				
			////// 입력	
				System.out.println("□ 출금기능 입니다");
				System.out.print("본인확인ID : ");
				tempId = scanner.next();
				System.out.print("본인확인pass : ");
				tempPass = scanner.next();
		
			////// 처리 
				for (int j = 0; j < i; j++) {
					if (id[j].equals(tempId) && pass[j].equals(tempPass)) {
						flag = true;
						// 출금할 금액이 잔액보다 작거나 같은지 확인
						System.out.print("출금할 금액을 출금해주세요> ");
						withdraw = scanner.nextInt();
						if (balance[j] >= withdraw) {
							balance[j] -= withdraw;
		   ////// 출력
							System.out.println("**************************");
							System.out.println("잔액확인");
							System.out.println("ID : " + id[j]);
							System.out.println("pass : " + pass[j]);
							System.out.println("balance: " + balance[j]);
						} else { // 잔액 부족 시
							System.out.println("잔액이 부족합니다.");
						}
						break;
					}
				} // 아이디와 비밀번호가 다를 때 
				if (flag == false) {
					System.out.println("다시 확인해 주세요.\n");
				continue;
				}
				
			// 삭제하기
			} else if (num == 5) {
			////// 변수
			boolean	flag = false;
			
			////// 입력
				System.out.println("□ 삭제기능 입니다.");
				System.out.print("본인확인ID : ");
				tempId = scanner.next();
				System.out.print("본인확인pass : ");
				tempPass = scanner.next();
				
			////// 처리
				for (int j = 0; j < i; j++) {
					if (id[j].equals(tempId) && pass[j].equals(tempPass)) {
						// 사용자 정보 초기화
						id[j] = "0";
						pass[j] = "0";
						balance[j] = 0;
						
			////// 출력
						System.out.println("**************************");
						System.out.println("잔액확인");
						System.out.println("ID : " + id[j]);
						System.out.println("pass : " + pass[j]);
						System.out.println("balance: " + balance[j]);
						flag = true;
						cnt--;
						break;
					}
				} // 아이디와 비밀번호가 다를 때 
				if (flag == false) {
					System.out.println("다시 확인해 주세요.");
					continue;
				}
				
			// 종료하기	
			} else if (num == 9) {
				System.out.println("□ 종료기능입니다");
				break;
				
			// 메뉴 이외의 번호를 입력했을 때
			} else
				System.out.println("숫자를 다시 입력해주세요.");
			System.out.println();
		}

	}
}
