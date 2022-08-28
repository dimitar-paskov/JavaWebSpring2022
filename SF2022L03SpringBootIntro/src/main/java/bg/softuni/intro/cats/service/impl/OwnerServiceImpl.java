/**
 * @author dimitar
 *
 */
package bg.softuni.intro.cats.service.impl;

import org.springframework.stereotype.Service;

import bg.softuni.intro.cats.model.dto.CreateOwnerDto;
import bg.softuni.intro.cats.model.entity.CatEntity;
import bg.softuni.intro.cats.model.entity.OwnerEntity;
import bg.softuni.intro.cats.repository.OwnerRepository;
import bg.softuni.intro.cats.service.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService {
	
	private OwnerRepository ownerRepository; 

	public OwnerServiceImpl(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
		
		
	}

	@Override
	public void createOwner(CreateOwnerDto createOwnerDto) {
		
		OwnerEntity owner = new OwnerEntity();
		owner.setOwnerName(createOwnerDto.getOwnerName());
		
		
		createOwnerDto.getCatNames().forEach(name -> {
			CatEntity cat = new CatEntity();
			cat.setCatName(name);
			cat.setOwner(owner);
			
			owner.addCat(cat);
		});
		
		ownerRepository.save(owner);
		
	}

}
