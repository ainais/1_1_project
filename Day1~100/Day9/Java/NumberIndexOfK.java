// K번째 수
// 프로그래머스 Level1 문제(아래 링크)
// https://programmers.co.kr/learn/courses/30/lessons/42748

// 문제 요약 : 
// 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬 했을 때, k번째에 있는 수를 구하려고 한다.
// 예를 들어, array가 [1,5,2,6,3,7,4], i=2,j=5,k=3이라면 array의 2번째부터 5번째까지 자르면[5,2,6,3]이 되고 여기서 나온
// 배열을 정렬하면 [2,3,5,6] 여기서 나온 배열의 3번째 숫자인 5를 찾는 함수를 구현하라.

package level1;

import java.util.ArrayList;
import java.util.Collections;

public class NumberIndexOfK {
	public static void main(String[] args) {
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		
		
	//================================================
		ArrayList<Integer> first = new ArrayList<Integer>();
		ArrayList<Integer> second = new ArrayList<Integer>();
		ArrayList<Integer> third = new ArrayList<Integer>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<Integer> newTemp = new ArrayList<Integer>();

		
		for(int i =0; i<commands.length; i++) {
			first.add(commands[i][0]);
			second.add(commands[i][1]);
			third.add(commands[i][2]);
		}

		for(int i=0; i<first.size(); i++) {
			temp = new ArrayList<Integer>();
			
			for(int j=first.get(i)-1; j<second.get(i); j++) {
				temp.add(array[j]);	
			}
			
			// 임시로 만든 ArrayList sort
			Collections.sort(temp);
			
			// get으로 값 가져와서 answer에 추가
			newTemp.add( temp.get( third.get(i)-1 ) );
		}
		
		int[] answer = new int[newTemp.size()];
		for(int i =0; i<answer.length; i++) {
			answer[i]=newTemp.get(i);
		}

		
	//================================================	
		for(int i : answer) {
			System.out.print(i);
		}

	} // 메인 종료
} // 클래스 종료
