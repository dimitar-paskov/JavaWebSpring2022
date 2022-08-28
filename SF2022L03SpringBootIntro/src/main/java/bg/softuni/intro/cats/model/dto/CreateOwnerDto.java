/**
 * @author dimitar
 *
 */
package bg.softuni.intro.cats.model.dto;

import java.util.List;


public class CreateOwnerDto {
	
	private String ownerName;
	private List<String> catNames;
	
	
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public List<String> getCatNames() {
		return catNames;
	}
	public void setCatNames(List<String> catNames) {
		this.catNames = catNames;
	}
	
	

}
