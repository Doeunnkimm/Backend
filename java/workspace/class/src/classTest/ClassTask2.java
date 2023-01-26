package classTest;

class Student {
	String studentNum;
	int korScore;
	int engScore;
	int mathScore;
	
	public Student(String studentNum, int korScore, int engScore, int mathScore) {
		this.studentNum = studentNum;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}
	
	void printScore() {
		int total = this.korScore + this.engScore + this.mathScore;
		System.out.println("ÃÑÁ¡: " + total);
		System.out.println("Æò±Õ: " + (total / 3));
	}
	
}

public class ClassTask2 {
	public static void main(String[] args) {
		Student student = new Student("2022001", 90, 90, 100);
		student.printScore();
	}
}
