package sample6;

public class MyInfo {
	private Person per;
	private Student stu;
	
	public Person getPer() {
		return per;
	}
	public void setPer(Person per) {
		this.per = per;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	
	public void personPrint() {
		System.out.println("이름 : " + per.getName());
		System.out.println("나이 : " + per.getAge());
		System.out.println("키 : " + per.getHeight());
		System.out.println("취미 : " + per.getHobby());
	}
	
	public void studentPrint() {
		System.out.println("국어 : " + stu.getKor());
		System.out.println("영어 : " + stu.getEng());
		System.out.println("이름 : "  + stu.getPer().getName());
		System.out.println("나이 : " + stu.getPer().getAge());
		System.out.println("키 : " + stu.getPer().getHeight());
		System.out.println("취미 : " + stu.getPer().getHobby());
	}
}
