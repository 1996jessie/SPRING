package sample5;

public class MessageBeanImpl implements MessageBean {

	private String name;
	private String greeting;
	
	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}


	public MessageBeanImpl(String name) {
		super();
		this.name = name;
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println(greeting + " " + name);
	}

}
