/**
 * @author dimitar
 *
 */
package bg.softuni.hateoas.model.dto;

import java.util.List;

import org.springframework.hateoas.server.core.Relation;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Relation(collectionRelation = "students")
public class StudentDto {
	
	private Long id;	
	private String name;
	private int age;
	private boolean deleted;
	
	private List<OrderDto> orders;

}
