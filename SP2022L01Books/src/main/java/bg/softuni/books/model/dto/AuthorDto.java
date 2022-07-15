/**
 * @author dimitar
 *
 */
package bg.softuni.books.model.dto;

public class AuthorDto {
	
	private String name;

	public String getName() {
		return name;
	}

	public AuthorDto setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String toString() {
		return "AuthorDto [name=" + name + "]";
	}
	
	

}
