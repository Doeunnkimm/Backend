package classTest;

class Student {
	String studentNum;
	int korScore;
	int engScore;
	int mathScore;
	int total;
	double average;
	
	public Student(String studentNum, int korScore, int engScore, int mathScore) {
		this.studentNum = studentNum;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
		this.total = korScore + engScore + mathScore;
		this.average = total / 3.0;
	}
	
}

public class ClassTask2 {
	public static void main(String[] args) {
		Student student = new Student("2022001", 90, 90, 100);
		System.out.println(student.total);
		System.out.println(student.average);
	}
}
