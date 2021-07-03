// [카카오 인턴] 키패드 누르기
// 프로그래머스 Level1 문제(아래 링크)
// https://programmers.co.kr/learn/courses/30/lessons/67256?language=java

// 문제 요약 : 
// 휴대폰 키패드를 누를 때 1,4,7은 왼손으로 3,6,9는 오른손으로 누른다.
// 단 8,5,2,0을 누르는 곳은 더 가까운 손으로 누르되 거리가 같은 결우 주손(오른손잡이는 오른손)으로 누르도록 한다.
// 최종적으로 내가 사용한 손을 L과 R의 문자열로 저장하여 answer에 답하여라.
package level1;

class PointXY{ // 좌표 값으로 변환
	public int x;
	public int y;
	
	public PointXY() { // 기본 생성자
		
	}
	public PointXY(String input){
		if(input.equals("*")) {			this.x=1; this.y=1;		}
		else if(input.equals("0")) {			this.x=2; this.y=1;		}
		else if(input.equals("#")) {			this.x=3; this.y=1;		}
		else if(input.equals("7")) {			this.x=1; this.y=2;		}
		else if(input.equals("8")) {			this.x=2; this.y=2;		}
		else if(input.equals("9")) {			this.x=3; this.y=2;		}
		else if(input.equals("4")) {			this.x=1; this.y=3;		}
		else if(input.equals("5")) {			this.x=2; this.y=3;		}
		else if(input.equals("6")) {			this.x=3; this.y=3;		}
		else if(input.equals("1")) {			this.x=1; this.y=4;		}
		else if(input.equals("2")) {			this.x=2; this.y=4;		}
		else if(input.equals("3")) {			this.x=3; this.y=4;		}


	} // 생성자
	
	public static double distance(int x1, int y1, int x2, int y2) {
		double dis = (Math.abs(x1-x2)) + (Math.abs(y1-y2));
		return dis;
	}
} // 클래스

public class PressKeyboard {
	public static void main(String[] args) {
		int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand = "left";
	//wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
		String answer = "";
		PointXY lpos = new PointXY("*");
		PointXY rpos = new PointXY("#");
		
		for(int i : numbers) {
			// 기본 147 369에 대한 값 처리
			if(i==1 || i==4 || i==7) {
				answer += "L";
				lpos = new PointXY(Integer.toString(i));
			}
			else if(i==3 || i==6 || i==9) {
				answer += "R";
				rpos = new PointXY(Integer.toString(i));
			}
			// 2580에 대한 값 처리
			else {
				PointXY npos = new PointXY(Integer.toString(i));
				double ldis = PointXY.distance(npos.x, npos.y, lpos.x, lpos.y);
				double rdis = PointXY.distance(npos.x, npos.y, rpos.x, rpos.y);

				if(ldis==rdis) {
					if(hand.equals("right")) {
						answer += "R";
						rpos = new PointXY(Integer.toString(i));
					}
					else if(hand.equals("left")) {
						answer += "L";
						lpos = new PointXY(Integer.toString(i));
					}
				}
				else if(ldis>rdis) {
					answer += "R";
					rpos = new PointXY(Integer.toString(i));
				}
				else if(rdis>ldis) {
					answer += "L";
					lpos = new PointXY(Integer.toString(i));
				}
			}
		} // for
		System.out.println(answer);
	//wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
	}//main 함수 종료

} //class의 종료

