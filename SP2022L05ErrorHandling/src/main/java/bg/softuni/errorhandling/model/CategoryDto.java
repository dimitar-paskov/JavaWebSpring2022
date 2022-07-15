/**
 * @author dimitar
 *
 */
package bg.softuni.errorhandling.model;

public class CategoryDto {
	
	private final String categoryName;

	public CategoryDto(String categoryName) {
		super();
		this.categoryName = categoryName;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	

}
