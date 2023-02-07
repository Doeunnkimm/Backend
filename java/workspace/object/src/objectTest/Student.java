package objectTest;

public class Student {
	private int number;
	private String name;
	
	public Student() {;}
	
	public Student(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	// Alt+Shift+O
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 부모인 Object 클래스의 toString() 메소드를 재정의하는 것
	// Alt + Shift + S -> S
	@Override
	public String toString() {
		return "Student [number=" + number + ", name=" + name + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof Student) {
			Student anotherStudent = (Student) obj; // 다운캐스팅
			return true;
		}
		return false;
	}
	
	
	
	
	
	
}
