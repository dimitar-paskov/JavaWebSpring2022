/**
 * @author dimitar
 *
 */
package bg.softuni.hateoas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bg.softuni.hateoas.model.dto.OrderDto;
import bg.softuni.hateoas.model.dto.StudentDto;
import bg.softuni.hateoas.model.entity.OrderEntity;
import bg.softuni.hateoas.model.entity.StudentEntity;
import bg.softuni.hateoas.repository.StudentRepository;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
		
	}
	
	public List<StudentDto> getAllStudents(){
		return studentRepository.findAll().stream()
				.map(this::map).toList();
	}
	
	
	public List<OrderDto> getStudentOrders(Long studentId){
		return getStudentById(studentId)
		.map(StudentDto::getOrders)
		.orElseGet(ArrayList::new);
	}
	
	
	public Optional<StudentDto> getStudentById(Long studentId){
		
		return studentRepository.findById(studentId)
				.map(this::map);
		
	}
	
	private StudentDto map(StudentEntity entity) {
		
		var orders = entity.getOrders().stream()
		.map(this::map).toList();
		
		StudentDto studentDto = new StudentDto();
		studentDto.setId(entity.getId());
		studentDto.setAge(entity.getAge());
		studentDto.setDeleted(entity.isDeleted());
		studentDto.setName(entity.getName());
		studentDto.setOrders(orders);
		
		return studentDto;
		
	}
	
	private OrderDto map(OrderEntity entity) {
		
		OrderDto orderDto = new OrderDto();
		orderDto.setCourseId(entity.getCourse().getId());
		orderDto.setStudentId(entity.getStudent().getId());
		
		
		return orderDto;
		
	}

}
