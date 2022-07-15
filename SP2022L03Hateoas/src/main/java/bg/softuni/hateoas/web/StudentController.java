/**
 * @author dimitar
 *
 */
package bg.softuni.hateoas.web;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bg.softuni.hateoas.model.dto.OrderDto;
import bg.softuni.hateoas.model.dto.StudentDto;
import bg.softuni.hateoas.service.StudentService;

@RequestMapping("/students")
@RestController
public class StudentController {
	
	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
		// TODO Auto-generated constructor stub
	}
	
	
	
	@GetMapping
	public ResponseEntity<CollectionModel<EntityModel<StudentDto>>> getStudents() {
		
		List<EntityModel<StudentDto>> studentEntityModels = studentService.getAllStudents().stream()
				.map(s -> EntityModel.of(s, getStudentLinks(s)))
				.toList();

		return ResponseEntity.ok(CollectionModel.of(studentEntityModels));
		
	}
	
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<StudentDto>> getStudentById(@PathVariable("id") Long id) {
		
		var studentOpt = studentService.getStudentById(id);
		
		if(studentOpt.isEmpty()) {
			ResponseEntity.notFound().build();
		}
		
		var student = studentOpt.get();
		
		
		
		return ResponseEntity.ok(EntityModel.of(student, getStudentLinks(student)));
		
	}
	
	
	
	
	
	@GetMapping("/{id}/orders")
	public ResponseEntity<CollectionModel<EntityModel<OrderDto>>> getStudentOrders(@PathVariable("id") Long id) {
		
		var orders = studentService.getStudentOrders(id).stream()
		.map(o -> EntityModel.of(o, getOrderLinks(o)))
		.toList();
		
		return ResponseEntity.ok(CollectionModel.of(orders));
	}
	
	
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<EntityModel<StudentDto>> updateStudent(@PathVariable("id") Long id, StudentDto studentDto) {
		throw new UnsupportedOperationException("Not important right now!");
	}
	
	
	
	
	private Link[] getStudentLinks(StudentDto studentDto) {
		
		List<Link> studentLinks = new ArrayList<>();
		
		Link selfRel = linkTo(methodOn(StudentController.class).getStudentById(studentDto.getId())).withSelfRel();
		
		studentLinks.add(selfRel);
		
		if(!studentDto.isDeleted()) {
			Link orderLink = linkTo(methodOn(StudentController.class).getStudentOrders(studentDto.getId())).withRel("orders"); 
			studentLinks.add(orderLink);
			
			
			Link updateLink = linkTo(methodOn(StudentController.class).updateStudent(studentDto.getId(), studentDto)).withRel("update"); 
			studentLinks.add(updateLink);
		}
		
		return studentLinks.toArray(new Link[0]);
//		return studentLinks.toArray(new Link[studentLinks.size()]);
		
		
	}
	
	
	
	
	private Link getOrderLinks(OrderDto orderDto) {
		
	return linkTo(methodOn(StudentController.class).getStudentById(orderDto.getStudentId())).withRel("student");
		

		
	}

}
