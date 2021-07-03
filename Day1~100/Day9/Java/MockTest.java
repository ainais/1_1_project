// MockTest
// 프로그래머스 Level1 문제(아래 링크)
// https://programmers.co.kr/learn/courses/30/lessons/42840

// 문제 요약 : 
// 시험은 최대 10,000문제로 구성되어 있습니다. 이 중 문제의 정답은 1,2,3,4,5 중 하나인데
// 이 답을 랜덤으로 찍었을 때 가장 높은 점수를 받은 사람 순으로 정렬해 주세요.

package level1;

import java.util.ArrayList;

class WayToSelect{
	ArrayList<Integer> human1 = new ArrayList<Integer>();
	ArrayList<Integer> human2 = new ArrayList<Integer>();
	ArrayList<Integer> human3 = new ArrayList<Integer>();

	WayToSelect(int len){ // 생성자 선언
		// 1번 수포자의 찍는 방식
		for(int i =0; i<len; i++) {
			if(i%5 == 0) {				human1.add(1);			}
			else if(i%5==1) {				human1.add(2);			}
			else if(i%5==2) {				human1.add(3);			}
			else if(i%5==3) {				human1.add(4);			}
			else if(i%5==4) {				human1.add(5);			}
		}
		// 2번 수포자의 찍는 방식
		for(int i =0; i<len; i++) {
			if(i%8 == 0) {				human2.add(2);			}
			else if(i%8==1) {				human2.add(1);			}
			else if(i%8==2) {				human2.add(2);			}
			else if(i%8==3) {				human2.add(3);			}
			else if(i%8==4) {				human2.add(2);			}
			else if(i%8==5) {				human2.add(4);			}
			else if(i%8==6) {				human2.add(2);			}
			else if(i%8==7) {				human2.add(5);			}
		}
		// 3번 수포자의 찍는 방식
		for(int i =0; i<len; i++) {
			if(i%10 == 0) {				human3.add(3);			}
			else if(i%10==1) {				human3.add(3);			}
			else if(i%10==2) {				human3.add(1);			}
			else if(i%10==3) {				human3.add(1);			}
			else if(i%10==4) {				human3.add(2);			}
			else if(i%10==5) {				human3.add(2);			}
			else if(i%10==6) {				human3.add(4);			}
			else if(i%10==7) {				human3.add(4);			}
			else if(i%10==8) {				human3.add(5);			}
			else if(i%10==9) {				human3.add(5);			}
		}
		
	}//생성자종료
}//클래스종료

public class MockTest {
	public static void main(String[] args) {
		int[] answers = {1,3,2,4,2};
		// =====================================================
		WayToSelect wts = new WayToSelect(answers.length);

		int cnt1=0,cnt2=0,cnt3=0;
		for(int i=0; i<answers.length; i++) {
			if(answers[i]==wts.human1.get(i)) {
				cnt1++;
			}
			if(answers[i]==wts.human2.get(i)) {
				cnt2++;
			}
			if(answers[i]==wts.human3.get(i)) {
				cnt3++;
			}
		} // for문 종료
		ArrayList<Integer> temp = new ArrayList<Integer>();
		if(cnt1==cnt2 && cnt2==cnt3) {
			temp.add(1);
			temp.add(2);
			temp.add(3);
		}
		else if(cnt1==cnt2) {
			if(cnt3>cnt1) {
				temp.add(3);
			}
			else {
				temp.add(1);
				temp.add(2);
			}
		}
		else if(cnt1==cnt3) {
			if(cnt2>cnt1) {
				temp.add(2);
			}
			else {
				temp.add(1);
				temp.add(3);
			}
		}
		else if(cnt2==cnt3) {
			if(cnt1>cnt2) {
				temp.add(1);
			}
			else {
				temp.add(2);
				temp.add(3);
			}
		}
		else {
			if(cnt1>cnt2 && cnt1>cnt3) {
				temp.add(1);
			}
			else if(cnt2>cnt1 && cnt2>cnt3) {
				temp.add(2);
			}
			else if(cnt3>cnt1 && cnt3>cnt2) {
				temp.add(3);
			}
		}
		int[] answer = new int[temp.size()];
		for(int i=0; i < temp.size(); i++) {
			answer[i]=temp.get(i);
		}
		// =====================================================
		for(int i : answer) {
			System.out.println(i);
		}

	} // 메인 종료
} // 클래스 종료
