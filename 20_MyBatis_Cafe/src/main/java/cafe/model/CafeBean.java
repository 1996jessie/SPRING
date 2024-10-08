package cafe.model;

import org.hibernate.validator.constraints.NotBlank;

public class CafeBean {
	private int num;
	
	@NotBlank(message = "구분을 선택하세요")
	private String category;
	
	@NotBlank(message = "메뉴를 선택하세요")
	private String menu;
	
	@NotBlank(message = "온도를 선택하세요")
	private String temp;
	
	@NotBlank(message = "수량을 선택하세요")
	private String amount;
	
	@NotBlank(message = "하나라도 선택하세요")
	private String req;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getReq() {
		return req;
	}

	public void setReq(String req) {
		this.req = req;
	}

	public CafeBean(int num, String category, String menu, String temp, String amount, String req) {
		super();
		this.num = num;
		this.category = category;
		this.menu = menu;
		this.temp = temp;
		this.amount = amount;
		this.req = req;
	}

	public CafeBean() {
		super();
	}

	
	
}
