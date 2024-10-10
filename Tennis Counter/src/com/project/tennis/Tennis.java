package com.project.tennis;

import java.util.Scanner;


public class Tennis {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TennisView view = new TennisView();
		TennisService service = new TennisService();
		TennisDAO dao = new TennisDAO();
		TennisDTO dto = new TennisDTO();
		
		view.printCharcter();
		
		boolean loop = true;
		
		while(loop) {
			
			view.mainMenu();
			
			System.out.print("원하시는 메뉴 번호를 숫자로 입력해주세요. : ");
			String select = scan.nextLine();
			
			if (select.equals("1")) {
				service.recordCreate(dto,dao);
			} else if (select.equals("2")) {
				service.recordRead();
			} else if (select.equals("3")) {
				service.recordDelete();
			} else if (select.equals("4")) {
				service.tennisRules();
			} else if (select.equals("5")) {
				loop = false;
			} else {
				view.selectError();
				break;
			}

		}
		scan.close();
		System.out.println("\n프로그램을 종료합니다.");
		
	}

  }
