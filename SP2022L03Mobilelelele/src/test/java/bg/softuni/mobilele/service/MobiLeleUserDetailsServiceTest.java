/**
 * @author dimitar
 *
 */
package bg.softuni.mobilele.service;

import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import bg.softuni.mobilele.model.entity.UserEntity;
import bg.softuni.mobilele.model.entity.UserRoleEntity;
import bg.softuni.mobilele.model.enums.UserRoleEnum;
import bg.softuni.mobilele.model.user.MobiLeleUserDetails;
import bg.softuni.mobilele.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class MobiLeleUserDetailsServiceTest {
	
	@Mock
	private UserRepository mockUserRepo;
	
	private MobiLeleUserDetailsService toTest;
	
	@BeforeEach
	void setUp() {
		toTest = new MobiLeleUserDetailsService(mockUserRepo);
	}
	
	
	@Test
	void testLoadUserByUsername_UserExists() {
		//arrange
		UserEntity testUserEntity = new UserEntity()
				.setEmail("pesho@example.com")
				.setPassword("topsecret")
				.setFirstName("Pesho")
				.setLastName("Petrov")
				.setActive(true)
				.setImageUrl("http://image.com/image")
				.setUserRoles(
						List.of(
							new UserRoleEntity().setUserRole(UserRoleEnum.ADMIN),
							new UserRoleEntity().setUserRole(UserRoleEnum.USER) 
						)
				);
		
		when(mockUserRepo.findByEmail(testUserEntity.getEmail())).thenReturn(Optional.of(testUserEntity));
		
		//act
		MobiLeleUserDetails userDetails = (MobiLeleUserDetails)
		toTest.loadUserByUsername(testUserEntity.getEmail());
		
		//assert
		Assertions.assertEquals(testUserEntity.getEmail(), userDetails.getUsername());
		
		Assertions.assertEquals(testUserEntity.getFirstName(), userDetails.getFirstName());
		Assertions.assertEquals(testUserEntity.getLastName(), userDetails.getLastName());
		Assertions.assertEquals(testUserEntity.getPassword(), userDetails.getPassword());
		Assertions.assertEquals(testUserEntity.getFirstName() + " " + testUserEntity.getLastName(), userDetails.getFullName());
		
		
		var authorities = userDetails.getAuthorities(); 
		Assertions.assertEquals(2, authorities.size());
		
		var authoritiesIter = authorities.iterator();
		
		Assertions.assertEquals("ROLE_" + UserRoleEnum.ADMIN.name(), authoritiesIter.next().getAuthority());
		Assertions.assertEquals("ROLE_" + UserRoleEnum.USER.name(), authoritiesIter.next().getAuthority());


	}
	
	@Test
	void testLoadUserByUsername_UserDoesNotExist() {
		
		//arrange
		//NOTE: No need to arrange anything, mocks return empty optionals.
		
		//act and assert
		Assertions.assertThrows(UsernameNotFoundException.class, () -> toTest.loadUserByUsername("non-existent@example.com"));

		
	}

}
