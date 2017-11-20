package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class newUser {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer nameId;
	@Size(min=1, max=255, message = "Please enter your name.")
	private String fromName;
	@Size(min=1, max=255, message = "Please enter your Familyname.")
	private String fromfamilyName;
	@Size(min=1, max=255, message = "Please enter your street and street number.")
    private String fromStreet;
    @Size(min=1, max=255, message = "Please enter your town.")
    private String fromTown;
    @NotNull(message = "Please enter a valid PLZ.")
    private int fromPlz;
    @Size(min=1, max=255, message = "Please enter your Telephone.")
	private String fromPhone;
    
    @NotNull
    @Size(min=1, max=255, message = "Please enter your name.")
	private String toName;
    @NotNull
    @Size(min=1, max=255, message = "Please enter your Family name.")
	private String tofamilyName;
    @NotNull
    @Size(min=1, max=255, message = "Please enter your street and street number.")
    private String toStreet;
    @NotNull
    @Size(min=1, max=255, message = "Please enter your town.")
    private String toTown;
    @NotNull(message = "Please enter a valid PLZ.")
    private int toPlz;
    @NotNull
    @Size(min=1, max=255, message = "Please enter your Telephone.")
	private String toPhone;
    
    
    
    
    public Integer getId() {
		return id;
    }

    public void setId(Integer id) {
    		this.id = id;
    }
    public Integer getOrderId() {
		return nameId;
}

public void setNameId(Integer nameId) {
		this.nameId = nameId;
}

public String getToName() {
	return toName;
}

public void setToName(String name) {
	this.toName = name;
}

public String getToFamilyName(String familyName) {
	return tofamilyName;
}
public String getToPhone(String phone) {
	return toPhone;
}



public String getToStreet() {
	return toStreet;
}

public void setToStreet(String street) {
	this.toStreet = street;
}

public String getToTown() {
	return toTown;
}

public void setToTown(String town) {
	this.toTown = town;
}

public int getToPlz() {
	return toPlz;
}

public void setToPlz(int plz) {
	this.toPlz = plz;
}

public String getFromName() {
	return fromName;
}

public void setFromName(String name) {
	this.fromName = name;
}

public String getFromStreet() {
	return fromStreet;
}

public void setFromStreet(String street) {
	this.fromStreet = street;
}

public String getFromTown() {
	return fromTown;
}

public void setFromTown(String town) {
	this.fromTown = town;
}

public int getFromPlz() {
	return fromPlz;
}

public void setFromPlz(int plz) {
	this.fromPlz = plz;
}

}
