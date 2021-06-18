package a2021_06_18_Fri;

public class Grade {

	private String bunho = "1";
	private String name = "이정성";
	private int kor = 97;
	private int eng = 87;
	private int math = 77;
	private int tot = kor + eng + math;
	private double avg = tot/3.0;
	private String gd;
	
	public String fGrade() {
		switch(tot/30) {
		case 10 :
		case 9 : gd = "A학점"; break;
		case 8 : gd = "B학점"; break;
		case 7 : gd = "C학점"; break;
		case 6 : gd = "D학점"; break;
		case 5 : gd = "E학점"; break;
		case 4 : 
		case 3 : 
		case 2 : 
		case 1 : gd = "F학점"; break;
		default : gd = "유효하지 않는 점수입니다."; break;
		}
		return gd;
	}

	public int fTot() {
		this.tot = this.kor + this.eng + this.math;
		return tot;
	}
		
	public double fAvg() {
		this.avg = this.tot/3.0;
		return avg;
	}
	
	public String getBunho() {
		return bunho;
	}
	public void setBunho(String bunho) {
		this.bunho = bunho;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public String getGrade() {
		return gd;
	}
	public void setGrade(String gd) {
		this.gd = gd;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}

}
