/**
 * @author dimitar
 *
 */
package bg.softuni.cache.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import bg.softuni.cache.model.StudentDto;

@Repository
public class StudentRepository {
	
	private static List<StudentDto> allStudents = List.of(
			new StudentDto("Pesho",10, 28),
			new StudentDto("Anna",11, 21),
			new StudentDto("Gosho",9, 22)
			
			
			);
	
	public List<StudentDto> getAllStudents(){
		
		dummyWait();
		
		return allStudents;
		
	}
	
	public StudentDto findStudentByName(String name){
		
		dummyWait();
		
		
		return allStudents.stream().filter(s -> s.getName().equals(name)).findAny().orElse(null);
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
