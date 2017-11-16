package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * This class models the user's address in the database. All of its variables are columns in the database table. 
 */
@Entity // This tells Hibernate to make a table out of this class
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String street;
    @NotNull
    private String town;
    @NotNull
    private int plz;
    
    public Address(String name, String street, String town, int plz){
    		setName(name);
    		setStreet(street);
    		setTown(town);
    		setPlz(plz);
    }
    
    public Address() {
    	
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}
	
	public int getPlz() {
		return plz;
	}
	
	public void setPlz(int plz) {
		this.plz = plz;
	}
	
	public String toString() {
		return(name + ",\n" + street + ",\n" + plz + " " + town);
	}
    
    
}

