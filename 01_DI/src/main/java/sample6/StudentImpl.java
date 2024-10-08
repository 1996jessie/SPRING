package sample6;

public class StudentImpl implements Student{
	
	private int kor;
	private int eng;
	private Person per;
	
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
	public Person getPer() {
		return per;
	}
	public void setPer(Person per) {
		this.per = per;
	}
	
}
