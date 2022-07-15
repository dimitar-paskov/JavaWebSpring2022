/**
 * @author dimitar
 *
 */
package bg.softuni.cache.model;

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
	
	
	
	

}
