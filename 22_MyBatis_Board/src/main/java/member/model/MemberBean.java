package member.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class MemberBean {
	
	@NotBlank(message = "아이디는 필수로 입력해야 합니다")
	private String id;
	@NotBlank(message = "이름은 필수로 입력해야 합니다")
	private String name;
	@NotBlank(message = "비밀번호는 필수로 입력해야 합니다")
	private String password;
	@NotBlank(message = "성별은 필수로 입력해야 합니다")
	private String gender;
	@NotBlank(message = "관심분야는 필수로 입력해야 합니다")
	private String interest;
	@NotBlank(message = "직업은 필수로 입력해야 합니다")
	private String job;
	@NotBlank(message = "주소는 필수로 입력해야 합니다")
	private String address;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
