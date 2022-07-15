/**
 * @author dimitar
 *
 */
package main.java.bg.softuni.proxies;

import java.util.List;

public class StudentService implements StudentServiceIfc {
	
	private static List<StudentDto> allStudents = List.of(
			new StudentDto("Pesho",10, 28),
			new StudentDto("Anna",11, 21),
			new StudentDto("Gosho",9, 22)
			
			
			);
	
	

	@Override
	@Cacheable("students")
	public List<StudentDto> getAllStudents() {
		
		System.out.println("Complex calculation of all students");
		
		dummyWait();
		
		System.out.println("Students calculated");
		
		return allStudents;
	}
	
	private void dummyWait() {
		try {
			Thread.sleep(5000);
			// Dummy - imagine we need to perform complex operation to fetch student data
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
