// 신규 아이디 추천
// 프로그래머스 Level1 문제(아래 링크)
// https://programmers.co.kr/learn/courses/30/lessons/72410


// 문제 요약 :
// 새로 가입하는 유저들이 규칙에 맞는 아이디를 입력했을 때,
// 입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천해주는 프로그램 개발

package level1;

public class RecommendNewID {
	public static void main(String args[]) {
		String new_id ="    1     ";
		//================================
		String answer = "";
		//1단계 : 모든 대문자를 대응되는 소문자로 치환
		new_id = new_id.toLowerCase();
		//2단계 : 알파벳 소문자, 숫자, 빼기(-), 밑줄, 마침표를 제외한 모든 문자를 제거
		new_id = new_id.replaceAll("[^-_.a-z0-9]", "");
		//3단계 : 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
		new_id = new_id.replaceAll("[.]{2,}", "."); // 2개 이상이면 .하나로 치환
		//4단계 : 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
		new_id = new_id.replaceAll("^[.]|[.]$", ""); // 시작이 .이거나 마무리가 .이면 공백으로 치환
		//5단계 : new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
		new_id = new_id.replace(" ", ""); // 띄어쓰기가 있을 수 있으니 제거하여 무결성 추가
		if(new_id.equals("") || new_id == null) {
			new_id += "a";
		}
		//6단계 : 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
		//만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
		if(new_id.length() >= 16) {
			new_id = new_id.substring(0,15); // new_id가 16자 이상이면 index 0번부터 15번까지 추출
			new_id = new_id.replaceAll("[.]$",""); // .으로 끝난다면 제거
		}

		//7단계 : 길이가 2자 이하라면, new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
		if(new_id.length() < 3) {
			while(new_id.length() < 3) {
				new_id += new_id.charAt(new_id.length()-1); // 길이가 3이 될때까지 마지막 문자를 추가
			}
		}
		answer = new_id;
		//================================
		System.out.println(answer);
		
	}// 메인 종료
}// 클래스 종료
