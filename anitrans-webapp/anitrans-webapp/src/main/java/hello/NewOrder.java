package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * Used to send the order from the html form to the database
 */
@Entity
public class NewOrder {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	private Integer orderId;
	@NotNull
	@Size(min=1, max=255)
	private String fromName;
    @NotNull
    @Size(min=1, max=255)
    private String fromStreet;
    @NotNull
    @Size(min=1, max=255)
    private String fromTown;
    @NotNull
    private int fromPlz;
    
    @NotNull
    @Size(min=1, max=255)
	private String toName;
    @NotNull
    @Size(min=1, max=255)
    private String toStreet;
    @NotNull
    @Size(min=1, max=255)
    private String toTown;
    @NotNull
    private int toPlz;
    
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date until;
	@NotNull
	@Size(min=1, max=255)
	private String timeframe;
	@NotNull
	@Size(min=1, max=255)
	private String typeOfAnimal;
	@NotNull
	private Integer numberOfAnimals;
	@NotNull
	@Size(min=1, max=255)
	private String timeEstimation;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd.MM.yyyy, HH:mm")
	private Date startTime;
	private String driver;
	private String orderStatus = "undelivered";
	private String statusMessage = "";
	
	
	public NewOrder(AniOrder order, Address fromAddress, Address toAddress) {
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
		setDriver(order.getDriver());
		setOrderStatus(order.getOrderStatus());
		setStatusMessage(order.getStatusMessage());	
	}

    
    public NewOrder() {

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
    
    public String getTimeEstimation() {
        return timeEstimation;
    }

    public void setTimeEstimation(String timeEstimation) {
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