package problem04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GugudanGame {
	
	List<Map.Entry<Integer, Integer>> gugudanEntries = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	boolean[] answers;
	
	public void gameStart() {
		
		saveEntry();
		printGugudan();
		
		start();
		printScores();
		
	}
	
	private void printScores() {
		 try{
	            //파일 객체 생성
	            File file = new File("C:\\Users\\bit\\git\\solution-type-c\\scores.txt");
	            //입력 스트림 생성
	            FileReader filereader = new FileReader(file);
	            //입력 버퍼 생성
	            BufferedReader bufReader = new BufferedReader(filereader);
	            List<String> lines = new ArrayList<>();
	            List<Integer> scoresTemp = new ArrayList<>();
	            List<Integer> secondsTemp = new ArrayList<>();
	            String line = "";
	            while((line = bufReader.readLine()) != null){
	            	lines.add(line);
	            }
	            //.readLine()은 끝에 개행문자를 읽지 않는다.            
	            bufReader.close();
	            
	            for(String score : lines) {
	            	String[] temp = score.split("/");
	            	int scoretemp = Integer.parseInt(temp[0]);
	            	int second = Integer.parseInt(temp[1]);
	            }
	            
	        }catch (FileNotFoundException e) {
	            // TODO: handle exception
	        }catch(IOException e){
	            System.out.println(e);
	        }
	}
	
	private void start() {
		boolean[] selected = new boolean[gugudanEntries.size() + 1];
		
		int answers = 0;
		long seconds = 0;
		
		for(int i = 0; i < gugudanEntries.size(); i++) {
			int index = gugudanEntries.size();
			while(!selected[index]) {
				index = new Random().nextInt(gugudanEntries.size() - 1);
			}
			Map.Entry<Integer, Integer> questionEntry = gugudanEntries.get(i);
			System.out.println((i + 1) + ". " + questionEntry.getKey() + "x" + questionEntry.getValue() + " ?");
			long start = System.currentTimeMillis();
			int answer = scanner.nextInt();
			// 답을 맞추면..
			if(answer == questionEntry.getKey() * questionEntry.getValue()) {
				 System.out.println("맞습니다.");
				 answers++;
			} else {
				System.out.println("틀렸습니다.");
			}
			seconds += (System.currentTimeMillis() - start);
			selected[index] = true;
		}
		// 게임 끝
		try {
			File file = new File("C:\\Users\\bit\\git\\solution-type-c\\scores.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
			
			if(file.isFile() && file.canWrite()){
                bufferedWriter.write(answers + "/" + seconds);
                bufferedWriter.newLine();
                
                bufferedWriter.close();
            }

			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private int selectRandom() {
		return new Random().nextInt(9) + 1;
	}
	
	private void printGugudan() {
		for(int i = 0; i < gugudanEntries.size() / 2; i++) {
			for(int j = 0; j < 2; j++) {
				Map.Entry<Integer, Integer> entry = gugudanEntries.get(i*2 + j);
				System.out.print(entry.getKey() +  "x" + entry.getValue());
				if(j == 0) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
	}
	
	private void saveEntry() {
		// 1 ~ 9까지 각 단마다 돈다.
		for(int i = 1; i <= 9; i++) {
			
			// 하나의 단에 들어갈 2개의 엔트리를 저장할 리스트
			List<Map.Entry<Integer, Integer>> entries = new ArrayList<>();
			
			// 처음에 저장될 1~9사이의 랜덤한 변수 
			int selected = -1;
			// 엔트리에 2개의 문제가 들어가면 루프 끝
			while(entries.size() < 2) {
				// 현재 선택된 랜덤값
				int current = selectRandom();
				// 만약 랜덤한 값이 이전에 넣은 적이 있다면 
				if(current == selected) {
					continue;
				}
				// 이전에 넣지 않았다면 해당 값으로 엔트리 추가
				else {
					entries.add(new GugudanEntry(i, current));
					selected = current;
				}
			}
			this.gugudanEntries.addAll(entries);
		}
	}

}
