/**
 * @author dimitar
 *
 */
package bg.softuni.errorhandling.model;

public class ApiErrorDto {
	
	private final Long objectId;
	private final String message;
	
	
	public ApiErrorDto(Long objectId, String message) {
		super();
		this.objectId = objectId;
		this.message = message;
	}


	public Long getObjectId() {
		return objectId;
	}


	public String getMessage() {
		return message;
	}
	
	

	
	
}
