package java;

public class Problem9_Singleton {
	// 정적 필드를 private으로 선언
	private static Problem9_Singleton singleton = new Problem9_Singleton();
	
	// 생성자를 private으로 선언
	private Problem9_Singleton() {
		
	}
	
	// 생성자를 호출 할 수 있도록 getInstance 메소드 추가
	static Problem9_Singleton getInstance() {
		return singleton;
	}
}
