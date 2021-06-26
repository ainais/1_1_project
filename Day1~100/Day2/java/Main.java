package java;

public class Main {
	public static void main(String[] args) {
		// 문제 1번 : 아래 자료형에 대해서 Casting을 진행할 때, 컴파일 에러가 발생하는 변수는?
		// char는 ascii코드 값의 숫자 형태로 저장되는 자료형인데, String은 참조형으로 문자를 저장하는 것이다.
		// 그래서 서로 형변환 할 수 있는 타입이 아니므로 컴파일 에러가 발생한다.
		int intValue1 = 10;
		char charValue1 = 'A';
		double doubleValue1 = 5.7;
		String strValue1 = "A";
		
		double var1 = (double) intValue1;
		byte var2 = (byte) intValue1;
		int var3 = (int) doubleValue1;
		// char var4 = (char) strValue; => 컴파일 에러발생
		
		// ===============================================
		// 문제 2번 : 아래 자료형에서 연산을 진행할 때 컴파일 에러가 발생하는 것은?
		// long 타입을 제외한 정수의 산술 연산은 무조건 int 타입으로 변환 후 연산을 수행하고, 산출 타입이 int이기 때문에
		// int 타입 변수에 산출 값을 대입해야한다.
		byte byteValue2 = 10;
		float floatValue2 = 2.5F;
		double doubleValue2 = 2.5;
		
		// byte result1 = byteValue2 + byteValue2; => 컴파일 에러 발생
		int result2 = 5 + byteValue2;
		float result3 = 5 + floatValue2;
		double result4 = 5 + doubleValue2;
		
		// ===============================================
		// 문제 3번 : 아래 자료형의 계산에서 에러가 발생하는 이유는?
		char c1 = 'A';
		// char c2 = c1 + 1; => 컴파일 에러 발생
		// c2에서 c1을 대입하는 순간 c1은 int 타입이 된다. 그래서 char 형태와 맞지 않으므로 아래와 같이 수정해야한다.
		char c3 = (char) (c1 + 1);
		
		// ===============================================
		// 문제 4번 : 아래는 비트연산자를 통해 연산을 진행하였다. 결과값은?
		int output1 = 1 << 3 ;
		int output2 = -8 >> 3 ;
		int output3 = -8 >>> 3 ;
		
		// ===============================================
		// 문제 5번 : for문에 이름을 주어 안쪽에서 바깥쪽의 for문을 종료시켜라.
		Outter : for(char upper = 'A'; upper<='z'; upper++) {
			for(char lower='a'; lower<='z'; lower++) {
				System.out.println(upper + "-" + lower);
				if(lower=='g') {
					break Outter;
				}
			}
		}
		System.out.println("문제 5번 종료");
		
		// ===============================================
		// 문제 6번 : 아래 배열을 선언하였을 때, add method를 적용하여 새로운 배열을 추가하여라.
		System.out.println(add(new int[] {85, 77, 46}));
		
		// ===============================================
		// 문제 7번 : ...를 사용해서 매개변수를 선언하여 자동으로 배열을 생성하는 add2 method를 적용해라.
		System.out.println(add2(1,2,3));
		
		// ===============================================
		// 문제 8번 : 두 수를 입력받아 plus 값을 도출하는 method를 만들어야한다.
		// 여기서 두 수는 int 일 때와, double일 때를 가정하여 오버로딩하여 만들어라.
		System.out.println(plus(10,20) + "   " + plus(10.2,20.3) +"   "+ plus(10,20.3));
		
		// ===============================================
		// 문제 9번 : 싱글톤을 설계하는 법을 설명하고, 간단한 예제를 설계하라
		// 싱글톤은 첫 째로 정적 필드를 private으로 선언하여 외부에서 필드에 대해 관여하지 못하도록 한다.
		// 둘 째, 생성자를 private으로 선언하여 외부에서 생성자를 만들 수 없도록 한다.
		// 셋 째, getInstacne 메소드를 추가하여 외부에서는 호출만 할 수 있도록 한다.
		
		// ===============================================
		// 문제 10번 : setter 메소드를 통해 데이터를 변경하는 이유와 예시를 설계하여라.
		// 예를 들면 음수가 될 수 없는 값에 음수가 들어가게 될 경우 데이터의 무결성을 해칠 수 있다.
		// 그래서 변수에 직접적으로 관여하지 않고 메소드를 통해 매개 값을 검증해 유효한 값들만 input 할 수 있기 때문에 setter 메소드를 사용한다.
		
	}
	
	// ------------------------------------------
	// method 선언 한 곳
	// 문제 6번
	private static int add(int[] is) {
		int sum = 0;
		for(int i =0; i<is.length; i++) {
			sum += is[i];
		}
		return sum;
	}
	// 문제 7번
	private static int add2(int ... values) {
		int sum = 0;
		for(int i =0; i<values.length; i++){
			sum = sum + values[i];
		}
		return sum;
	}
	// 문제 8번
	private static double plus(double x, double y) {
		double result = x+y;
		return result;
	}
	private static int plus(int x, int y) {
		int result = x+y;
		return result;
	}	
}
//----------------------------------
// 클래스 선언 한 곳
// 문제 10번
class Speed{
	private double speed;
	
	public void setSpeed(double speed) {
		if(speed < 0 ) {
			this.speed = 0;
			return;
		} else {
			this.speed = speed;
		}
		
	}
	
	public double getSpeed() {
		double km = speed*1.6;
		return km;
	}
}
