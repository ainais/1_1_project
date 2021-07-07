// 폰켓몬
// 프로그래머스 Level1 문제(아래 링크)
// https://programmers.co.kr/learn/courses/30/lessons/1845?language=java


// 문제 요약 :
// 입력된 int[] nums에는 짝수개의 포켓몬의 종류(숫자번호로 구별)가 담겨있다. 이에 대해서 포켓몬을 nums의 절반만큼을 선택했을 때,
// 선택할 수 있는 최대 갯수의 포켓몬 경우의 수는 몇인가?

package level1;

import java.util.ArrayList;

public class PhoneCketmon {

	public static void main(String[] args) {
		int[] nums = {3,1,2,3};
		int answer = 0;
		//=================================
		ArrayList<Integer> numArray = new ArrayList<Integer>();
		for(int i : nums) {
			if(!numArray.contains(i)) {
				numArray.add(i);
			}
		}
		answer = numArray.size();
		if(answer > (nums.length/2) ) {
			answer=nums.length/2;
		}
		
		//=================================
		System.out.println();
		System.out.println(answer);
	} // 메인종료

} // 메인 클래스 종료
