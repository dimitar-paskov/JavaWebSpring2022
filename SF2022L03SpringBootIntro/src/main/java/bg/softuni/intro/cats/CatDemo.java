/**
 * @author dimitar
 *
 */
package bg.softuni.intro.cats;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import bg.softuni.intro.cats.model.dto.CreateOwnerDto;
import bg.softuni.intro.cats.service.OwnerService;

@Component
public class CatDemo implements CommandLineRunner{
	
	private OwnerService ownerService; 

	public CatDemo(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		CreateOwnerDto createOwnerDto = new CreateOwnerDto();
		createOwnerDto.setOwnerName("Pesho");
		createOwnerDto.setCatNames(List.of("Chinchila", "Pesho"));
		
		ownerService.createOwner(createOwnerDto);
	}

}
