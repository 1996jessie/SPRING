package movie.model;

import org.hibernate.validator.constraints.NotBlank;

public class MovieBean {
	private int num;
	
	@NotBlank(message = "필수 입력사항입니다.")
	private String title;
	
	@NotBlank(message = "대륙 필수 입력사항입니다.")
	private String continent;
	
	@NotBlank(message = "나라 필수 입력사항입니다.")
	private String nation;
	
	@NotBlank(message = "최소 1개 이상 선택하세요.")
	private String genre;
	
	@NotBlank(message = "필수 입력사항입니다.")
	private String grade;
	
	private String actor;
	
	public MovieBean() {
		
	}
	public MovieBean(int num, String title, String continent, String nation, String genre, String grade, String actor) {
		super();
		this.num = num;
		this.title = title;
		this.continent = continent;
		this.nation = nation;
		this.genre = genre;
		this.grade = grade;
		this.actor = actor;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	
}
