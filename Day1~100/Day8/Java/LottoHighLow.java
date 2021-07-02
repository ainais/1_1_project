// 로또의 최고 순위와 최저 순위
// 프로그래머스 Level1 문제(아래 링크)
// https://programmers.co.kr/learn/courses/30/lessons/77484?language=java
package level1;

public class LottoHighLow {
    public int[] solution(int[] lottos, int[] win_nums) {
    	//-------------------------------
    	int minCnt = 7;
    	int maxCnt = 7;
        for(int i : lottos) {
        	for(int j : win_nums) {
        		if(i==j) {
        			minCnt--;
        			maxCnt--;
        		}
        	}//win_nums for문
        	
    		if(i==0) {
    			maxCnt--;
    		}

        }//lottos for문		
		if(minCnt==7) {
			minCnt=6;
		}
		if(maxCnt==7) {
			maxCnt=6;
		}
        int[] answer = {maxCnt,minCnt};
        return answer;
        //-------------------------------
    }
}
