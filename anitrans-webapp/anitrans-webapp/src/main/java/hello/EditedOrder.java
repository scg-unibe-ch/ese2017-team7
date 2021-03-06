package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.*;

/*
 * The object that is created when the user creates a new order. Contains both AniOrder and Address information.
 * Implements requirements for the fields. If these requirements aren't met, the user will be presented with
 * understandable error information.
 */
//starTime can be at the most 24 hours after the until field.
@ScriptAssert(lang = "javascript", script = "if(_this.startTime != null && _this.until != null){(_this.startTime.getTime() - _this.until.getTime()) < 86400000}else {false}", message = "Start time needs to be before 'until'.")
@Entity
public class EditedOrder {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	private Integer orderId;
	@Size(min=1, max=255, message = "Please enter your name.")
	private String fromName;
    @Size(min=1, max=255, message = "Please enter your street and street number.")
    private String fromStreet;
    @Size(min=1, max=255, message = "Please enter your town.")
    private String fromTown;
    @NotNull(message = "Please enter a valid PLZ.")
    private int fromPlz;
    
    @NotNull
    @Size(min=1, max=255, message = "Please enter your name.")
	private String toName;
    @NotNull
    @Size(min=1, max=255, message = "Please enter your street and street number.")
    private String toStreet;
    @NotNull
    @Size(min=1, max=255, message = "Please enter your town.")
    private String toTown;
    @NotNull(message = "Please enter a valid PLZ.")
    private int toPlz;
    
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	@NotNull(message="Please enter a valid date of the format dd.MM.yyyy.")
	private Date until;
	@NotNull
	@Pattern(regexp = "([0-1]?[0-9]|2[0-3]):([0-5][0-9])\\s?[-]\\s?([0-1]?[0-9]|2[0-3]):([0-5][0-9])", message = "Please enter a timeframe in the form HH:mm - HH:mm")
	private String timeframe; //needs to conform to the format HH:mm-HH:mm or HH:mm - HH:mm
	@NotNull
	@Size(min=1, max=255, message = "Please enter a type of animal.")
	private String typeOfAnimal;
	@NotNull(message = "Please enter the number of animals to be transported.")
	private Integer numberOfAnimals;
	@NotNull
	private float timeEstimation; //needs to conform to the format HH hour or HH hours
	@NotNull(message="Please enter a valid date of the format dd.MM.yyyy, HH:mm.")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd.MM.yyyy, HH:mm")
	private Date startTime;
	private String driver;
	private String vehicle;
	private String orderStatus = "undelivered";
	private String statusMessage = "";
	
	
	public EditedOrder(AniOrder order, Address fromAddress, Address toAddress) {
		setOrderId(order.getId());
		setFromName(fromAddress.getName());
		setFromStreet(fromAddress.getStreet());
		setFromTown(fromAddress.getTown());
		setFromPlz(fromAddress.getPlz());
		setToName(toAddress.getName());
		setToStreet(toAddress.getStreet());
		setToTown(toAddress.getTown());
		setToPlz(toAddress.getPlz());
		setUntil(order.getUntil());
		setTimeframe(order.getTimeframe());
		setNumberOfAnimals(order.getNumberOfAnimals());
		setTypeOfAnimal(order.getTypeOfAnimal());
		setTimeEstimation(order.getTimeEstimation());
		setStartTime(order.getStartTime());
		setDriver(order.getDriverId() + " - " + order.getDriver());
		setVehicle(order.getVehicle());
		setOrderStatus(order.getOrderStatus());
		setStatusMessage(order.getStatusMessage());	
	}

    
    public EditedOrder() {

    }
    
    public Integer getId() {
		return id;
    }

    public void setId(Integer id) {
    		this.id = id;
    }

    
    public Integer getOrderId() {
    		return orderId;
    }
    
    public void setOrderId(Integer orderId) {
    		this.orderId = orderId;
    }
    
    public String getToName() {
		return toName;
	}

	public void setToName(String name) {
		this.toName = name;
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
	

	
	
    
    public Date getUntil() {
        return until;
    }

    public void setUntil(Date until) {
        this.until = until;
    }
    
    public String getTimeframe() {
        return timeframe;
    }

    public void setTimeframe(String timeframe) {
        this.timeframe = timeframe;
    }
    
    public String getTypeOfAnimal() {
        return typeOfAnimal;
    }

    public void setTypeOfAnimal(String typeOfAnimal) {
        this.typeOfAnimal = typeOfAnimal;
    }
    
    public Integer getNumberOfAnimals() {
        return numberOfAnimals;
    }

    public void setNumberOfAnimals(Integer numberOfAnimals) {
        this.numberOfAnimals = numberOfAnimals;
    }
    
    public float getTimeEstimation() {
        return timeEstimation;
    }

    public void setTimeEstimation(float timeEstimation) {
        this.timeEstimation = timeEstimation;
    }
    
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
    
  //returns -1 if the driver isn't set yet.
    public int getDriverId() {
    		if(!getDriver().equals("none")) {
    			return Integer.parseInt(driver.substring(0, 1));
    		} else {
    			return -1;
    		}
    }
    
    public String getVehicle() {
    		return vehicle;
    }
    
    public void setVehicle(String vehicle) {
    		this.vehicle = vehicle;
    }
    
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

}