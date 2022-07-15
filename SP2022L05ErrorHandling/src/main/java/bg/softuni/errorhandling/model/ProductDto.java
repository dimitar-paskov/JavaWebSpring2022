/**
 * @author dimitar
 *
 */
package bg.softuni.errorhandling.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductDto {
	
	private final String name;
	private final BigDecimal price;
	
	
	public ProductDto(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public BigDecimal getPrice() {
		return price;
	}


	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDto other = (ProductDto) obj;
		return Objects.equals(name, other.name) && Objects.equals(price, other.price);
	}
	
	
	

}
