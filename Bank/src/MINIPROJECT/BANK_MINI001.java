package MINIPROJECT;

import java.util.Scanner;

public class BANK_MINI001 {

	public static void main(String[] args) {
		int num= 0; String result= ""; 
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("==========BANK==========\n"
						+ "1.추가\n" + "2.조회\n" + "3.입금\n" + "4.출금\n" + "5.삭제\n" + "9.종료\n" + "입력 >>>"); 
		num= scanner.nextInt();
		result= num==1 ? "추가기능 입니다." :  num==2 ? "조회기능 입니다." : 
				num==3 ? "입금기능 입니다." : num==4 ? "출금기능 입니다" : num==5 ? "삭제기능 입니다." : "종료기능 입니다.";
		
		System.out.println(result);
	
	
	}
}
