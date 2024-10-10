package com.project.tennis;

import java.util.Scanner;

//import com.github.lalyos.jfiglet.FigletFont;

public class TennisView {
	
	TennisDTO dto = new TennisDTO();
	public void mainMenu() {
		
	System.out.println("=========================================================================================================");
	
	System.out.println("                                    🎾테니스 계수기🎾");
	
	
	try {
		
	   // String asciiArt1 = FigletFont.convertOneLine("Tennis Counter");
	   //System.out.println(asciiArt1);
		
	} catch (Exception e) {
		System.out.println("TennisView.mainMenu");
		e.printStackTrace();
	}
	
	
	System.out.println("=========================================================================================================");
	System.out.println("-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-");
	System.out.println("      |1.기록 추가|  |2.기록 열람|  |3.기록 삭제|  |4.테니스 규칙|  |5.프로그램 종료|");
	System.out.println("---------------------------------------------------------------------------------------------------------");
//		System.out.println("2.기록 열람");
//		System.out.println("3.기록 삭제"); 
//		System.out.println("4.테니스 규칙 열람"); //4. 테니스 규칙 열람 > 점수 계산법이나 용어에 대해 지식 제공
//		System.out.println("5.프로그램 종료");
//		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println();
		System.out.print("🔢실행 번호를 숫자로 입력해주세요. : ");
		
	}

	public void subTitle(String title) {
		System.out.println();
		System.out.println("🥎"+ title +"🥎");		
	}
	
	public void pause() { //혹시 사용할 일 있을까 싶어 만들어놨는데 사용 안하면 지워버리기

		System.out.println();
		System.out.print("계속하시려면 엔터를 치세요.");
		Scanner scan = new Scanner(System.in);
		scan.nextLine(); //Block
		
		System.out.println();
	}
	
	public void selectError() {
		System.out.print("\n옳지 않은 입력입니다. 프로그램이 종료됩니다.");
		
	}
	
	//***** 스코어보드와 입력한 사전정보, 경기 결과 리포트 폼(구현 부분 완성되고 변수 확정되면 넣어서 확인)
	



//	
//
//		
//	
//	
//	
	// 보고서 출력 메서드
    public void preMatchInfo() {
        // 헤더 아스키 아트
    	System.out.println("╔═══════════════════════════════════════╗");
		System.out.println("║            입력한 사전 정보           ║");
	    System.out.println("╚═══════════════════════════════════════╝");



        // 경기 정보 출력
		System.out.println("\n\t\t[🗒️경기 정보]");
       	System.out.println("==============================================");
        System.out.println("-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-");
		System.out.println();
		System.out.println("      |📆경기 날짜|: " );
		System.out.println("      |🥎경기 형식|: " );
		System.out.println("      |🔢세트 수|: " );
		
		  // 참가 선수 출력
		System.out.println("\n\t\t[🧑🏼참가 선수]");
        System.out.println("-----------------------------------------------");
//        for (int i = 0; i < 4; i++) {
//            System.out.printf("%d. %s\n", (i + 1), dto.playerList[i]);
//        }    
	    System.out.println("-----------------------------------------------");
        
    }
	
	
	  public void MatchReport() {
		  // 헤더 아스키 아트
		  System.out.println("╔═══════════════════════════════════════╗");
		  System.out.println("║               경기 결과                 ║");
		  System.out.println("╚═══════════════════════════════════════╝");
		
		  // 경기 정보 출력
		  System.out.println("\n\t\t[🗒️경기 정보]");
	      System.out.println("==============================================");
		  System.out.println("-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-🎾-");
		  System.out.println();
		  System.out.println("      |📆경기 날짜|: " );
		  System.out.println("      |🥎경기 형식|: " );
		  System.out.println("      |🔢세트 수|: " );
		
		  // 참가 선수 출력
		  System.out.println("\n\t\t[🧑🏼참가 선수]");
		  System.out.println("-----------------------------------------------");
//		  for (int i = 0; i < 4; i++) {
//		      System.out.printf("%d. %s\n", (i + 1), dto.playerList[i]);
//	  	  }
		  System.out.println();
		  System.out.println("1선수가 세트스코어 2:0으로 이겼습니다.🎉");    
	      System.out.println("-----------------------------------------------");
	  }
	
//	//단식 스코어보드
//	public void singleScoreBoard() {
//	System.out.printf("===================================================================================\r\n");
//	System.out.printf("|             Player 1                  |               Player 2                  |\r\n");
//	System.out.printf("===================================================================================\r\n");
//	System.out.printf("|Name:       	   |Point:              |Name:             |Point:                |\r\n");
//	System.out.printf("|                                                                                 |\r\n");
//	System.out.printf("|GameScore:        |SetScore:           |GameScore:        |SetScore:             |\r\n");
//	System.out.printf("===================================================================================\r\n");
//}
//	
//	//복식 스코어보드
//	public void doubleScoreBoard()	{
//	System.out.printf("===================================================================================\r\n");
//	System.out.printf("|              Team 1                   |                Team 2                   |\r\n");
//	System.out.printf("===================================================================================\r\n");
//	System.out.printf("|Name1:        	 |Point:                |Name3:              |Point:              |\r\n");
//	System.out.printf("|Name2:                                  Name4:                                   |\r\n");
//	System.out.printf("|GameScore:      |SetScore:             |GameScore:          |SetScore:           |\r\n");
//	System.out.printf("===================================================================================\r\n");
//	}
	
//	   //새로운 단식 스코어보드
//	   private static void SingleScoreboard() {
//	        System.out.println("===============================");
//	        System.out.printf("%-12s | %-8s | %-8s%n", "Player", "Games", "Sets");
//	        System.out.println("===============================");
//	        System.out.printf("%-12s | %-8d | %-8d%n", player1Name, player1Games, player1Sets);
//	        System.out.printf("%-12s | %-8d | %-8d%n", player2Name, player2Games, player2Sets);
//	        System.out.println("===============================");
//	        System.out.println("Points:");
//	        System.out.printf("%-12s | %-8d%n", player1Name, player1Points);
//	        System.out.printf("%-12s | %-8d%n", player2Name, player2Points);
//	        System.out.println("===============================");
//	    }
//	   //새로운 복식 스코어보드
//	   private static void doubleScoreboard() {
//	        System.out.println("===============================");
//	        System.out.printf("%-12s | %-8s | %-8s%n", "Team", "Games", "Sets");
//	        System.out.println("===============================");
//	        System.out.printf("%-12s | %-8d | %-8d%n", teamAName, teamAGames, teamASets);
//	        System.out.printf("%-12s | %-8d | %-8d%n", teamBName, teamBGames, teamBSets);
//	        System.out.println("===============================");
//	        System.out.println("Points:");
//	        System.out.printf("%-12s | %-8d%n", teamAPlayer1 + " / " + teamAPlayer2, teamAPoints);
//	        System.out.printf("%-12s | %-8d%n", teamBPlayer1 + " / " + teamBPlayer2, teamBPoints);
//	        System.out.println("===============================");
	
	//최종 스코어보드(로직 완성되면 변수 넣어보면 됨)- 이게 더 깔끔한거 같긴한데 팀원들 의견 듣기
//	private static void Scoreboard() {
//		
//		System.out.println("===============================");
//	        if (matchType.equals("단식")) {
//	            System.out.printf("%-13s | %-7s | %-7s%n", "Player", "Games", "Sets");
//	            System.out.println("===============================");
//	            System.out.printf("%-11s | %-7d | %-7d%n", player1, gamePointA, setPointA);
//	            System.out.printf("%-11s | %-7d | %-7d%n", player2, gamePointB, setPointB);
//	        } else {
//	        	System.out.printf("%-13s | %-7s | %-7s%n", "Team", "Games", "Sets");
//	        	System.out.println("===============================");
//	        	System.out.printf("%-13s | %-7d | %-7d%n", "Team 1", gamePointA, setPointA);
//	        	System.out.printf("%-13s | %-7d | %-7d%n", "Team 2", gamePointB, setPointB);
//	        }
//	    System.out.println("===============================");
//        System.out.println("Points:");
//        	if (matchType.equals("단식")) {
//           System.out.printf("%-15s | %-8d%n", player1, ralleyPointA);
//           System.out.printf("%-15s | %-8d%n", player2, ralleyPointB);
//        	} else {
//           System.out.printf("%-18s | %-5d%n", player1 + " / " + player2, ralleyPointA);
//           System.out.printf("%-18s | %-5d%n", player3 + " / " + player4, ralleyPointB);
//        	}
//        System.out.println("===============================");
//   }
	
	
	
	
	public void printCharcter() {
	System.out.println("\r\n"
			+ "⠀⠀⠀⠀       ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀     ⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⠀⠀⣀⣀⣀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⣿⣶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⠀⠀⠀⠀⠀⠚⠋⢉⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣦⡄⠀⠀⠀⠀⠙⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣿⣿⣷⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀⠀⢸⣿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⠀⣠⣴⣶⣶⣿⣿⣿⣿⣿⣿⣿⡿⣿⣛⣿⠂⠸⠟⣯⣿⣿⡟⠀⠀⠀⡐⣶⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⣰⣿⢿⣻⡹⣿⣿⣿⣿⣿⣿⣿⡇⠺⣿⣿⠀⠀⠀⠹⢿⣿⠃⠀⠀⢰⠀⢁⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⢠⣿⡟⢏⣧⢧⢻⣿⣿⣿⣿⣿⡇⠁⠀⢁⣀⠀⠀⢀⣀⠀⠀⡆⢀⠔⠀⡔⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⢿⣿⡝⡼⠞⢻⣿⣿⣿⣿⣿⣇⠀⠀⣿⣿⣿⣿⣿⣿⠁⠠⡠⠂⢀⠜⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⠈⢿⣿⡴⠚⣌⢿⣿⣿⣿⣧⣬⣤⡀⠀⠙⠿⠻⠟⢁⣤⣿⡇⣠⠎⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⠀⠈⠻⣷⣷⣝⣞⣽⡿⠻⠟⠻⣿⣿⣷⣶⣶⣶⣾⣿⣿⣿⣿⠿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⠀⠀⠀⠈⠙⠻⣿⣟⡇⠀⠀⠀⠈⢩⣾⣿⣿⣿⣿⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⣿⡀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⢻⣷⣀⣀⣰⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⠀⢺⣳⠀⣸⣤⡄⠀⠘⣽⣿⠉⣉⣁⡬⢹⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⠀⢨⣿⡎⣹⠲⣄⠀⠀⠘⠿⠃⠈⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⠀⠘⠋⠀⠁⢀⣈⡃⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⠀⠀⠐⣟⣡⣬⠵⠇⠀⠀⠀⠀⣾⣿⣶⠿⢿⣿⡿⠁⠟⠉⢁⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⠀⠀⢩⣹⠷⠘⠄⢖⡀⠀⠀⢸⣿⣿⢇⡀⠀⣠⣿⣦⡄⠄⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⠀⠀⠀⠛⠛⠛⠋⠉⠀⠀⠀⠈⠛⣋⠀⠈⢹⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡄⠀⡇⠀⢠⠞⠁⠀⠀⠘⠻⠿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⡀⡇⢠⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠁⠘⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀             ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
			+ "⠀⠀⠀⠀       ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀         ⠀⠀⠀⠀⠀⠀\r\n"
			+ "");
	
	}
	
}
