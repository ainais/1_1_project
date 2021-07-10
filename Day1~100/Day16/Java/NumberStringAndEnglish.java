// 숫자 문자열과 영단어
// 프로그래머스 Level1 문제(아래 링크)
// https://programmers.co.kr/learn/courses/30/lessons/81301

// 문제 요약 : 숫자의 일부 자릿수를 영단어로 바꾸는 문제입니다.
// 가령 1478이 주어지면 => "one4seveneight"를 출력하면 됩니다.

package level1;

public class NumberStringAndEnglish {
	public static void main(String args[]) {
		String s = "23four5six7";
		int answer = 0;
		
		//================================
		String list = "";
		String result = "";
		for(int i =0; i<s.length(); i++) {
			list += s.substring(i,i+1);
			switch(list) {
			case("zero") : result+="0"; list=""; break; 
			case("0") : result+="0"; list=""; break; 
			case("one") : result+="1"; list=""; break; 
			case("1") : result+="1"; list=""; break; 
			case("two") : result+="2"; list=""; break; 
			case("2") : result+="2"; list=""; break; 
			case("three") : result+="3"; list=""; break; 
			case("3") : result+="3"; list=""; break; 
			case("four") : result+="4"; list=""; break; 
			case("4") : result+="4"; list=""; break; 
			case("five") : result+="5"; list=""; break; 
			case("5") : result+="5"; list=""; break; 
			case("six") : result+="6"; list=""; break; 
			case("6") : result+="6"; list=""; break; 
			case("seven") : result+="7"; list=""; break; 
			case("7") : result+="7"; list=""; break; 
			case("eight") : result+="8"; list=""; break; 
			case("8") : result+="8"; list=""; break; 
			case("nine") : result+="9"; list=""; break; 
			case("9") : result+="9"; list=""; break; 
			
			}
		}
		
		answer = Integer.parseInt(result);
		//================================
		System.out.println(answer);
		System.out.println(list);
	} // end of main
} // end of class
