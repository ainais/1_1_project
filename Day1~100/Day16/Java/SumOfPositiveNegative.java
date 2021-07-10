// 음양 더하기
// 프로그래머스 Level1 문제(아래 링크)
// https://programmers.co.kr/learn/courses/30/lessons/76501

// 문제 요약 : 배열에 담긴 숫자에 대해서 signs를 true나 false로 주어진다.
// true일 경우 배열의 숫자가 양수, false일 경우 배열의 숫자가 음수로 계산되어 최종 합을 도출하라.

package level1;

public class SumOfPositiveNegative {
	public static void main(String args[]) {
		int[] absolutes = {4,7,12};
		boolean[] signs = {true,false,true};
		//================================
		int answer = 0;
		for(int i=0; i<absolutes.length; i++) {
			if(signs[i]) {
				answer += absolutes[i];
			}
			else {
				answer -= absolutes[i];
			}
		}
		//================================
		System.out.println(answer);
	} // end of main
} // end of class
