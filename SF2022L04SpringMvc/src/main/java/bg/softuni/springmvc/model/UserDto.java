/**
 * @author dimitar
 *
 */
package bg.softuni.springmvc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDto {
	
	private String fname;
	private String lname;

}
