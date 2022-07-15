/**
 * @author dimitar
 *
 */
package bg.softuni.security.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
	
	@Column(nullable = false, unique = true)
	private String email;
	
	private String password;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<UserRoleEntity> userRoles = new ArrayList<>();
	
	public UserEntity addRole(UserRoleEntity userRole) {
		this.userRoles.add(userRole);
		return this;
	}
	

}
