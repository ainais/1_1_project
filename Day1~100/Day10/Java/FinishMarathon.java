// 완주하지 못한 마라톤 선수 return하기
// 프로그래머스 Level1 문제(아래 링크)
// https://programmers.co.kr/learn/courses/30/lessons/42576

// 문제 요약 :
// 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와
// 완주하지 못한 선수의 이름이 담긴 배열 completion이 주어질 때,
// 완주하지 못한 선수의 이름을 return하도록 Sol 함수를 작성하라.

package level1;

import java.util.ArrayList;

public class FinishMarathon {
	public static void main(String[] args) {
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		//==========================================
		String answer = "";
		ArrayList<String> part = new ArrayList<String>();
		ArrayList<String> comp = new ArrayList<String>();
		for(String p : participant) {
			part.add(p);
		}
		for(String c : completion) {
			comp.add(c);
		}
		part.sort(null);
		comp.sort(null);
		
		int index = 0;
		
		for(int i =0; i<comp.size(); i++) {
			if(!comp.get(i).equals(part.get(i))) {
				index = i; break;
			} 
		}
		if(index==0) {
			index=part.size()-1;
		}
		answer = part.get(index);
		//==========================================
		System.out.println(answer);
	}//메인 종료
}//클래스 FinishMarathon종료
