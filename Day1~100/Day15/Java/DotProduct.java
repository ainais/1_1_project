// 내적
// 프로그래머스 Level1 문제(아래 링크)
// https://programmers.co.kr/learn/courses/30/lessons/70128?language=java

// 문제 요약 : 길이가 같은 두 1차원 정수 배열 a,b가 매개변수로 주어질 때,
// a와 b의내적을 return 하세요.

package level1;

public class DotProduct {

	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		int[] b = {-3,-1,0,2};
		int answer = 0;
		// ======================================
		for(int i =0; i<a.length; i++) {
			answer += (a[i]*b[i]);
		}
		// ======================================
		System.out.println(answer);

	}

}
