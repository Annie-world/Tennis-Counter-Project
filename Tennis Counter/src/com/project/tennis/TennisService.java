package com.project.tennis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


//기능 구현 Class
public class TennisService {
	Scanner scan = new Scanner(System.in);
	TennisView view = new TennisView();
	
	int point = 0;
	int ralleyPointA = 0, ralleyPointB = 0;
	
	StringBuilder pointData = new StringBuilder();
	TennisDTO dto = new TennisDTO();
	StringBuilder matchData = new StringBuilder("");
	String ralleyPointA_Visible = "";
	String ralleyPointB_Visible = "";
	int gamePointA = 0, gamePointB = 0;
	int setPointA = 0, setPointB = 0;
	int ralleyAttempt = 1, setCount = 1, gameCount = 1;
	
	boolean loop = true;
	boolean pass = false;
	
	String path = "C:\\class\\dev\\eclipse\\Java project\\dat\\dummy3.txt";
	String line = null;
	String serialNum = "";	//더미에서 가져온 일련번호			(1번째 더미: 일련번호)
	String date = "";		//더미에서 가져온 날짜(ex:20001231) (2번째 더미: 날짜)
	String formattedDate = "";
	String name = "";		//더미에서 가져온 선수이름 저장		(3번째 더미: 선수이름)
	String data = "";		//더미에서 가져온 matchData 저장용	(마지막 더미: matchData)
	String result = "";		//승자, 패자 저장
	String dump = "";		//BufferedReader로 읽어온 line 저장용
	
	
	
	
	// 경기 데이터를 계수기 프로그램에 입력
	public void recordCreate(TennisDTO dto, TennisDAO dao) {
				
		dao.getInfo(); // 점수 데이터를 입력하기 전에 경기와 관련된 사전 정보를 입력받음.
		//dao.getInfo()는 TennisDAO 클래스 안에서 TennisDTO의 Setter를 사용해 사용자로부터 입력받은 각종 데이터를 TennisDTO(인스턴스화되지 않은 순수 데이터 필드)로 넣는 역할을 한다.
		//TennisDTO가 전달받은 데이터들은 TennisDAO 안에서는 실제 데이터로 살아있을 수 있다. TennisDTO가 TennisDAO 안에서 dto = new TennisDTO(); 라는 실존하는 객체로 선언되었기 때문이다. 
		//하지만 DTO 필드 내의 값들은 TennisDAO가 아닌 TennisService 클래스에서는 이용할 수 없다. 이 클래스에서 새로 DTO객체를 선언한다고 해도 이미 받은 값들은 날아갈 뿐이다.
		//이것은 dao.getInfo()의 실행이 종료되면서 [객체.변수](ex-이름을 입력받고 DTO로 값을 넘겨주는 ArrayList<String>형 인스턴스 dao.player) 형식으로 담겨지지 않은 나머지 DTO값들이 사라지기 때문인 것으로 보인다.
		//..예를 들면 int라고 해도 값을 직접 넣지 말고 int형 변수를 따로 만들어서 그 int형 변수가 DTO를 참조하게 만드는 느낌인듯...?
		
		dto.setPlayerList(dao.player);
		dto.setGamePointA(point);
		dto.setGamePointB(point);
		
		System.out.println("경기 데이터를 입력받겠습니다.");
				
		while(loop) {
			
			if (dao.player.size() == 2) {
				if (ralleyPointA == 1) {
					ralleyPointA_Visible = "15점";
				} else if (ralleyPointA == 2) {
					ralleyPointA_Visible = "30점";
				} else if (ralleyPointA == 3) {
					ralleyPointA_Visible = "40점";
				} else if (ralleyPointA == 4) {
					ralleyPointA_Visible = "match point";
				}
				if (ralleyPointB == 1) {
					ralleyPointB_Visible = "15점";
				} else if (ralleyPointB == 2) {
					ralleyPointB_Visible = "30점";
				} else if (ralleyPointB == 3) {
					ralleyPointB_Visible = "40점";
				} else if (ralleyPointB == 4) {
					ralleyPointB_Visible = "match point";
				}
				
				System.out.printf("%s(%s) VS %s(%s)\n\n", dto.getPlayerList().get(0), ralleyPointA_Visible, dto.getPlayerList().get(1), ralleyPointB_Visible);
			} else if (dao.player.size() == 4) {
				System.out.printf("%s, %s(%d) VS %s, %s(%d)\n\n",
								  dao.player.get(0), dao.player.get(1), ralleyPointA_Visible, dao.player.get(2), dao.player.get(3), ralleyPointB_Visible);
			}
			
			System.out.printf("%d세트 %d게임의 %d번째 랠리에서 왼쪽이 득점했다면 0을, 오른쪽이 득점했다면 1을 입력해주세요.: "
							  ,setCount, gameCount, ralleyAttempt);
			point = scan.nextInt();
			
			startRalley(dto, dao);
			
		}
	}
	
	public void startRalley(TennisDTO dto, TennisDAO dao) {
		
		if (dao.player.size() == 2) {
			if (point == 0) { // 좌측 팀 득점
				System.out.printf("입력 완료. %s의 득점.\n", dao.player.get(0));
				pointData.append(Integer.toString(point));
				ralleyAttempt++;
				if (ralleyPointA < 3) {
					ralleyPointA++;
				} else if ((ralleyPointA == 3) && Math.abs(ralleyPointA - ralleyPointB) >= 2) {
					ralleyPointA = 4;
				} else {
					
				}
				
				isGameEnds(dto);
				isSetEnds(dto);
				isMatchEnds(dto);
				
			} else if (point == 1) { // 우측 팀 득점
				System.out.printf("입력 완료. %s의 득점.\n", dao.player.get(1));
				pointData.append(Integer.toString(point));
				dto.setRalleyPointB(ralleyAttempt);
				ralleyAttempt++;
				if (ralleyPointB < 3) {
					ralleyPointB++;
				} else if ((ralleyPointB == 3) && Math.abs(ralleyPointA - ralleyPointB) >= 2) {
					ralleyPointB = 4;
				} else {
					
				}
				isGameEnds(dto);
				isSetEnds(dto);
				isMatchEnds(dto);
			} else {
				System.out.println("올바르지 않은 데이터입니다. 다시 입력해주세요.");
			}
		} else if (dao.player.size() == 4) {
			if (point == 0) { // 좌측 팀 득점
				System.out.printf("입력 완료. %s, %s 팀의 득점.\n", dao.player.get(0),dao.player.get(1));
				pointData.append(Integer.toString(point));
				ralleyPointA++;
				ralleyAttempt++;
				isGameEnds(dto);
				isSetEnds(dto);
				isMatchEnds(dto);
				
			} else if (point == 1) { // 우측 팀 득점
				System.out.printf("입력 완료. %s, %s 팀의 득점.\n", dao.player.get(2),dao.player.get(3));
				pointData.append(Integer.toString(point));
				ralleyPointB++;
				ralleyAttempt++;
				isGameEnds(dto);
				isSetEnds(dto);
				isMatchEnds(dto);
			} else {
				System.out.println("올바르지 않은 데이터입니다. 다시 입력해주세요.");
			}
		}
		
	}

	public void isGameEnds(TennisDTO dto) {
		// 한 쪽이 4점(Match Point)에 도달했고 다른 쪽의 점수와 2점 이상 차이가 나면 한 '게임'의 승패가 가려짐
		if ((ralleyPointA >= 4 || ralleyPointB >= 4) && (Math.abs(ralleyPointA - ralleyPointB) >= 2)) {
			if (ralleyPointA > ralleyPointB) {
				gamePointA++;
				gameCount++;
				resetRalleys();
			}
			else if (ralleyPointA < ralleyPointB) {
				gamePointB++;
				gameCount++;
				resetRalleys();
			}
		}
	}

	public void resetRalleys() {
		ralleyPointA = 0;
		ralleyPointB = 0;
		ralleyAttempt = 1;
	}

	public void isSetEnds(TennisDTO dto) {
		// 두 팀의 '게임' 점수가 모두 6점에 도달하면 타이브레이크 룰을 적용함
		if (gamePointA == 6 && gamePointB == 6) {
			tieBreak(dto);
		} else if ((gamePointA >= 6 || gamePointB >= 6) && (Math.abs(gamePointA - gamePointB) >= 2)) {
			// 위의 경우가 아니면, 한 쪽이 6'게임' 이상을 땄고 다른 쪽의 게임점수와 2점 이상 차이가 날 때 한 '세트'의 승패가 가려지게 함
			if (gamePointA > gamePointB) {
				setCount++;
				resetGames();
			}
			else if (gamePointA < gamePointB) {
				setCount++;
				resetGames();
			}
		}
	}
	
	public void resetGames() {
		gameCount = 1;
		resetRalleys();
	}

	void isMatchEnds(TennisDTO dto) {
		ArrayList<String> winPlayer = new ArrayList<>();
		StringBuilder multiWinners = new StringBuilder();
//--------------------------------------------------------------------------변수들 TennisService변수에 맞게 바꿔넣고 데이터 DTO에 넣으면 될듯
		if (dto.getMatchSets() == 3) { // 3세트전 경기일 경우
			if (dto.getMatchType() == "단식") {
				if (setPointA == 2) { // A팀이 승리
					System.out.println("계수가 종료되었습니다.\n");
					winPlayer.add(dto.getPlayerList().get(0)); // 승리자의 이름을 winPlayer ArrayList에 따로 추가
					dto.setWinnerList(winPlayer); // dto에 데이터 적재
					dto.setWinnerName(winPlayer.get(0)); // String형 승리자명만 따로 dto.winnerName에 저장
					System.out.printf("경기의 승리자는 %s입니다.", dto.getWinnerName());
					loop = false;
				} else if (setPointB == 2) { // B팀이 승리
					System.out.println("계수가 종료되었습니다.\n");
					winPlayer.add(dto.getPlayerList().get(1));
					dto.setWinnerList(winPlayer);
					dto.setWinnerName(winPlayer.get(0));
					loop = false;
				} else {
					return;
				}
			} else if (dto.getMatchType() == "복식") {
				if (dto.getSetPointA() == 2) { // A팀이 승리
					System.out.println("계수가 종료되었습니다.\n");
					winPlayer.add(dto.getPlayerList().get(0)); // 승리자의 이름을 winPlayer ArrayList에 따로 추가
					winPlayer.add(dto.getPlayerList().get(1)); // 처음 입력받을 때 팀 관계인 두 명을 같이 입력받았으니까
					dto.setWinnerList(winPlayer); // dto에 데이터 적재
					multiWinners.append(winPlayer.get(0));
					multiWinners.append(",");
					multiWinners.append(winPlayer.get(1));
					dto.setWinnerName(multiWinners.toString());
					System.out.printf("경기의 승리자는 %s입니다.", dto.getWinnerName());
					loop = false;
				} else if (dto.getSetPointB() == 2) {
					System.out.println("계수가 종료되었습니다.\n");
					winPlayer.add(dto.getPlayerList().get(2));
					winPlayer.add(dto.getPlayerList().get(3));
					dto.setWinnerList(winPlayer); // dto에 데이터 적재
					multiWinners.append(winPlayer.get(2));
					multiWinners.append(",");
					multiWinners.append(winPlayer.get(3));
					dto.setWinnerName(multiWinners.toString());
					System.out.printf("경기의 승리자는 %s입니다.", dto.getWinnerName());
					loop = false;
				} else {
					return;  
				}
			}
			
		} else if (dto.getMatchSets() == 5) {  // 5세트전 경기일 경우
			if (dto.getMatchType() == "단식") {
				if (dto.getSetPointA() == 3) {
					System.out.println("계수가 종료되었습니다.\n");
					winPlayer.add(dto.getPlayerList().get(0)); // 승리자의 이름을 winPlayer ArrayList에 따로 추가
					dto.setWinnerList(winPlayer); // dto에 데이터 적재
					dto.setWinnerName(winPlayer.get(0));
					System.out.printf("경기의 승리자는 %s입니다.", dto.getWinnerName());
					loop = false;
				} else if (dto.getSetPointB() == 3) {
					System.out.println("계수가 종료되었습니다.\n");
					winPlayer.add(dto.getPlayerList().get(1));
					dto.setWinnerList(winPlayer);
					dto.setWinnerName(winPlayer.get(0));
					loop = false;
				} else {
					return;
				}
			} else if (dto.getMatchType() == "복식") {
				if (dto.getSetPointA() == 3) { // A팀이 승리
					System.out.println("계수가 종료되었습니다.\n");
					winPlayer.add(dto.getPlayerList().get(0)); // 승리자의 이름을 winPlayer ArrayList에 따로 추가
					winPlayer.add(dto.getPlayerList().get(1)); // 처음 입력받을 때 팀 관계인 두 명을 같이 입력받았으니까
					dto.setWinnerList(winPlayer); // dto에 데이터 적재
					multiWinners.append(winPlayer.get(0));
					multiWinners.append(",");
					multiWinners.append(winPlayer.get(1));
					dto.setWinnerName(multiWinners.toString());
					System.out.printf("경기의 승리자는 %s입니다.", dto.getWinnerName());
					loop = false;
				} else if (dto.getSetPointB() == 3) {
					System.out.println("계수가 종료되었습니다.\n");
					winPlayer.add(dto.getPlayerList().get(2));
					winPlayer.add(dto.getPlayerList().get(3));
					dto.setWinnerList(winPlayer); // dto에 데이터 적재
					multiWinners.append(winPlayer.get(2));
					multiWinners.append(",");
					multiWinners.append(winPlayer.get(3));
					dto.setWinnerName(multiWinners.toString());
					System.out.printf("경기의 승리자는 %s입니다.", dto.getWinnerName());
					loop = false;
				} else {
					return;  
				}
			}
		}
	}
	
	public void tieBreak(TennisDTO dto) {
		System.out.println("=======Tiebreak에 돌입합니다.======");
		resetRalleys();
		while(loop){
			System.out.print("입력: "); //승패 결정: 0(왼쪽: A), 1(오른쪽: B) 승 입력
			point = scan.nextInt();
			
			try {
				if (!(point == 0) || (point == 1)) {
				throw new IllegalArgumentException("올바른 값을 입력하세요.");
				}
				
				if (point == 0) {
					System.out.println("A가 득점하였습니다.");
					dto.setRalleyPointA(ralleyAttempt);
					ralleyAttempt++;
				}
				else if (point == 1){
					System.out.println("B가 득점하였습니다.");
					dto.setRalleyPointB(ralleyAttempt);
					ralleyAttempt++;
				}
				
				System.out.println();
				//현재 점수 현황
				System.out.printf("[현재 점수] %d : %d%n", dto.getRalleyPointA(), dto.getRalleyPointB()); 
				System.out.println();
				
				if((dto.getRalleyPointA() >= 7 || dto.getRalleyPointB() >= 7) && (Math.abs(dto.getRalleyPointA() - dto.getRalleyPointB()) >= 2)) { //abs절댓값 표현 //==7하면 7점이 될때까지 끝나지 않음
					System.out.printf("%d : %d 의 결과로 경기가 종료되었습니다.",dto.getRalleyPointA(), dto.getRalleyPointB());
					break;
				}
				
				//Deuce 6:6 => 연속해서 2점 & 불연속시 연속 2점이 될때까지 진행 // Deuce 멘트 동점 상황에 출력될 수 있게 
				
				if(dto.getRalleyPointA() >= 6 && dto.getRalleyPointB() >= 6 && dto.getRalleyPointA() == dto.getRalleyPointB()) {
					System.out.println("==========Deuce=========");
					if (Math.abs(dto.getRalleyPointA() - dto.getRalleyPointB()) >= 2 ) {
						System.out.printf("%d : %d 의 결과로 경기가 종료되었습니다.",dto.getRalleyPointA(), dto.getRalleyPointB());
						break;
					}					
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println();
			}
					
		}
	}
	
	public void recordRead() {
		
			
			view.subTitle("기록열람");
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println("[번호]\t[날짜]");
			
			collectDateSet();

			//사용자로부터 입력받기
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.print("열람하고 싶은 기록의 날짜(yyyy-MM-dd)를 입력해주세요.: ");
			String input = scan.nextLine().trim();
			input = input.replace("-", "");	

			searchRecord(input);	
			
			view.pause();
		
		}	
		
		
		private void searchRecord(String input) {
			
			try {
				
				System.out.println("-----------------------------------------------------------------------------------------------");
				
				BufferedReader reader = new BufferedReader(new FileReader(path));
				
				while ((line = reader.readLine()) != null) {
		
					String[] temp = line.split(",");
					date = temp[1];
					formattedDate = date.substring(0,4) + "-" + date.substring(4,6) + "-" + date.substring(6,8); //date 가공(ex: 2000-12-31)
					name = temp[2];
					data = temp[3];
					
					if(date.equals(input)) {
						dump = line;			//dump에 한줄씩 저장하면서 내려옴
						printRecord(input);
					}
				}
				
				if(dump.isEmpty()) {
					System.out.println("입력하신 날짜가 일치하는 정보가 없습니다.");
					System.out.print("\n다시 입력해주세요. : ");	
					input = scan.nextLine().trim();					//재검색을 위한 재입력
					printRecord(input);
				}
				
				reader.close();
			
			} catch (Exception e) {
				System.out.println("TennisService.recordRead");
				e.printStackTrace();
			}	
			
		}
		

		private void printRecord(String input) {
			char lastData = data.charAt(data.length()-1);
			result = (lastData == '1') ? "승리" : "패배";
		
			System.out.println();
			System.out.println("경기 날짜: " + formattedDate);
			System.out.println("선수 이름: " + name);
			System.out.println("경기 결과: " + result);
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------------------------");		
		}

		
		private void collectDateSet() {
			
			try {

				HashSet<String> dateHashSet = new HashSet<String>(); 				//더미에 있는 모든 날짜 > dateHashSet
				BufferedReader reader = new BufferedReader(new FileReader(path));

				String line = null;
				
				while((line = reader.readLine()) != null){
					
					String[] temp = line.split(",");
					String date = temp[1];;				//date: 더미데이터에서 가져온 날짜 저장 (2번째 더미: 날짜)
					dateHashSet.add(date);	
				}	
				
				List<String> sortedDateList =new ArrayList<>(dateHashSet); 	//sortDateList: dateHashSet을 정렬하기 위한 list 
				Collections.sort(sortedDateList);							//오름차순 정렬
				
				int index = 1;
				String formattedDate = "";
				
				for (String date : sortedDateList) {
					formattedDate = date.substring(0,4) + "-" + date.substring(4,6) + "-" + date.substring(6,8); //date 포맷 수정
					System.out.printf("%5d\t%s\n", index, formattedDate);
					index++;
				}

				reader.close();
				
			} catch (Exception e) {
				System.out.println("TennisService.recordRead");
				e.printStackTrace();
			}	
			
		}
	
	
	
	public void recordUpdate() {
		
	}
	
	public void recordDelete() {
		
		view.subTitle("기록 삭제");
		System.out.println();

		String dateToDelete;
		boolean isValidDate = false;

		do {
		  System.out.print("삭제하고 싶은 경기일정을 입력하세요 (YYYYMMDD): ");
		  dateToDelete = scan.nextLine();

		  if (!dateToDelete.matches("\\d{8}")) {//\d{8}는 정규 표현식으로, \d는 숫자(0-9)를 의미하고, {8}은 8번 반복을 의미함. 8개의 숫자가 연속되는 패턴
		    System.out.println("잘못된 날짜 형식입니다. YYYYMMDD 형식으로 입력해주세요.");
		  } else {
		    try {
		      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		      dateFormat.setLenient(false);
		      dateFormat.parse(dateToDelete);
		      isValidDate = true;
		    } catch (ParseException e) {
		      System.out.println("유효하지 않은 날짜입니다.");
		    }
		  }
		} while (!isValidDate);

		boolean isDeleted = false;

		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
		  String line;
		  StringBuilder temp = new StringBuilder();

		  while ((line = reader.readLine()) != null) {
		    line = line.trim(); // 앞뒤 공백 제거 (선택 사항)

		    if (line.length() >= 8) {
		      String dateInFile = line.substring(1, 9); // 쉼표(`,`) 다음 8자리를 가져옴

		      if (!dateInFile.equals(dateToDelete)) {
		        temp.append(line).append("\n");
		      } else {
		        isDeleted = true;
		        // break; // 삭제할 경기일정을 찾았으므로 while 루프 종료 (제거)
		      }
		    } else {
		      System.out.println("잘못된 데이터 형식: " + line);
		    }
		  }

		  // 삭제 성공 시에만 파일 덮어쓰기
		  if (isDeleted) {
		    try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, false))) {
		      writer.write(temp.toString());
		    }
		    System.out.println("기록이 성공적으로 삭제되었습니다.");
		  } else {
		    System.out.println("해당 경기일정을 찾을 수 없습니다.");
		    recordDelete(); // 재귀 호출
		  }
		} catch (IOException e) {
		  System.out.println("TennisService.recordDelete");
		  e.printStackTrace();
		  System.out.println("기록 삭제에 실패했습니다. 다시 시도해주세요.");
		}
	}
	public void tennisRules() {
	String path2 ="C:\\class\\dev\\eclipse\\Java project\\Rules\\TennisRules.txt";
	
	try {
		BufferedReader reader = new BufferedReader(new FileReader(path2));
	
		String line ;
		
		while((line = reader.readLine())!= null) {
			System.out.println(line);
		}
		
		reader.close();
		
	} catch (Exception e) {
		System.out.println("TennisService.tennisRules");
		e.printStackTrace();
	
	}
}



	}
