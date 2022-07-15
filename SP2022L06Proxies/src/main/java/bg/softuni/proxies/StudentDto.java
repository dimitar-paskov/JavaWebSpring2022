package main.java.bg.softuni.proxies;

public class StudentDto {
	
	private final String name;
	private final int avgScore;
	private final int age;
		
	public StudentDto(String name, int avgScore, int age) {
		super();
		this.name = name;
		this.avgScore = avgScore;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAvgScore() {
		return avgScore;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "StudentDto [name=" + name + ", avgScore=" + avgScore + ", age=" + age + "]";
	}
	
	
	
	

}