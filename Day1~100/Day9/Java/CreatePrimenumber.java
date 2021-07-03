// 배열에서 3개의 숫자를 임의로 받아와 소수 만들기
// 프로그래머스 Level1 문제(아래 링크)
// https://programmers.co.kr/learn/courses/30/lessons/12977

// 문제 요약 : 
// 임의의 자연수 1~1000까지의 숫자를 가진 배열 nums[]가 있다.
// 이 배열에서 3개만 추출하여 더한 값이 소수(나누어 떨어지는 수가 자기자신과 1밖에없는 수)가 되는 경우의 수를 answer로 답하여라. 

package level1;

import java.util.ArrayList;

class FindPrimeNumber{
	int maxNumber = 998+999+1000; // 1부터 1000이하의 자연수의 3개를 더할 경우 최대의 수
	public ArrayList<Integer> list = new ArrayList<Integer>(); //소수의 리스트 만들기
	
	public FindPrimeNumber(){ // 생성자 선언
		
		for(int i =2; i<=maxNumber; i++) {
			int cnt = 0;
			
			for(int j=1; j<=i; j++) {
				if(i%j==0) {
					cnt++;
				}
			}
			if(cnt==2) {
				list.add(i);
			}
		} // for문 종료
	} // 생성자 종료
	

} // 클래스 종료

public class CreatePrimenumber {
	public static void main(String args[]) {
	int nums[] = {1,2,7,6,4};
	int answer = -1;
	//정답
	//=============================================
	ArrayList<Integer> list = new ArrayList<Integer>();
	FindPrimeNumber fpn = new FindPrimeNumber();
	
	int temp;
	for(int i=0; i<nums.length; i++) {
		if(i+1<nums.length) {
			for(int j=i+1; j<nums.length; j++) {
				if(j+1<nums.length) {
					for(int k=j+1; k<nums.length; k++) {
						temp = nums[i]+nums[j]+nums[k];
						list.add(temp);
					} // k for
				} // j+1 if
			} // j for
		} // i+1 if
		
	}

	int cnt=0;
	for(int i : list) {
		if(fpn.list.contains(i)) {
			cnt++;
		}
	}
	answer = cnt;
	//=============================================
	System.out.println(answer);
	} // main 함수 종료
}// class PressKeyboard의 종료

