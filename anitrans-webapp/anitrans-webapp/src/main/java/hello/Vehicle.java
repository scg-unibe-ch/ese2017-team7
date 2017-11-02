package hello;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

/*
 * Models the Vehicle for the database. Every type of vehicle is only stored once, if the same vehicle is added again, 
 * the counter is increased.
 */
@Entity // This tells Hibernate to make a table out of this class
public class Vehicle {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @NotNull
    private int numberOfVehicles = 1;
    @NotNull
    @Pattern(regexp = "[\\s\\S]+((.png)|(.jpg)|(.jpeg)|(.JPG)|(.JPEG)|(.PNG))", message = "Please add the name of an image as name.jpg or name.png.")
    private String image; //images can be .jpg or .png
    @NotNull
    @Size(min=2, max=255, message = "Please enter the name of the vehicle (at least two characters in length).")
    private String name; 
    
    
    public Vehicle(Integer id, int numberOfVehicles, String image, String name) {
    		this.id = id;
    		this.numberOfVehicles = numberOfVehicles;
    		this.image = image;
    		this.name = name;
    }
    
    public Vehicle(Vehicle vehicle) {
    		this.id = vehicle.getId();
    		this.numberOfVehicles = vehicle.getNumberOfVehicles();
    		this.image = vehicle.getImage();
		this.name = vehicle.getName();
    }
    
    public Vehicle() {
    	
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getNumberOfVehicles() {
		return numberOfVehicles;
	}

	public void setNumberOfVehicles(Integer numberOfVehicles) {
		this.numberOfVehicles = numberOfVehicles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String toString() {
		return name;
}

}

