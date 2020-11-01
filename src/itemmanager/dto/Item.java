/**
 * 
 */
package itemmanager.dto;

import java.math.BigDecimal;

/**
 * @author Flavio Silva
 *
 */
public class Item {
	
	private String id;
	private String name;
	private ItemCategory type;
	private BigDecimal worth;
	private Double weight;
	
	public Item(String id){
		this.id = id;
	}
	
	public ItemCategory getType() {
		return type;
	}
	
	public void setType(ItemCategory type) {
		this.type = type;
	}
	
	public Double getWeight() {
		return weight;
	}
	
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getWorth() {
		return worth;
	}
	
	public void setWorth(BigDecimal worth) {
		this.worth = worth;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}
