package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MenuItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	private String options;
	private double price;

	public MenuItem() {
		super();
	}

	public MenuItem(long id, String name, String description, String options, double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.options = options;
		this.price = price;
	}

	public MenuItem(String name, String description, String options, double price) {
		super();
		this.name = name;
		this.description = description;
		this.options = options;
		this.price = price;
	}

	public MenuItem(String name, String description, double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public MenuItem(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", description=" + description + ", options=" + options
				+ ", price=" + price + "]";
	}

}
