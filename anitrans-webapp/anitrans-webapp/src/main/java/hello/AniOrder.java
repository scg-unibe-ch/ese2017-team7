package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/*
 * The object used to create the object table in the database. "Object" is a reserved keyword in SQL, so AniOrder is used as a 
 * combination of order and the name "aniTrans".
 * All of the variables are columns of the database table.
 */
@Entity // This tells Hibernate to make a table out of this class
public class AniOrder {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	@OneToOne
	public Address fromAddr;
	@OneToOne
	private Address toAddr;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy.mmmm.dd")
	private Date until;
	private String timeframe;
	private String typeOfAnimal;
	private Integer numberOfAnimals;
	private float timeEstimation;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-mm-dd'T'HH:mm")
	private Date startTime;
	private String driver;
	private int driverId;
	private String vehicle;
	private String orderStatus = "undelivered"; //can be either "delivered" or "undelivered"
	private String statusMessage = "";
	@Autowired
	
	public AniOrder(NewOrder order, Address fromAddressId, Address toAddressId) {
		setId(order.getOrderId());
		setFromAddr(fromAddressId);
		setToAddr(toAddressId);
		setUntil(order.getUntil());
		setTimeframe(order.getTimeframe());
		setNumberOfAnimals(order.getNumberOfAnimals());
		setTypeOfAnimal(order.getTypeOfAnimal());
		setTimeEstimation(order.getTimeEstimation());
		setStartTime(order.getStartTime());
		setDriver(order.getDriver());
		setDriverId(order.getDriver());
		setVehicle(order.getVehicle());
		setOrderStatus(order.getOrderStatus());
		setStatusMessage(order.getStatusMessage());
	}
	
	public AniOrder(EditedOrder order, Address fromAddressId, Address toAddressId) {
		setId(order.getOrderId());
		setFromAddr(fromAddressId);
		setToAddr(toAddressId);
		setUntil(order.getUntil());
		setTimeframe(order.getTimeframe());
		setNumberOfAnimals(order.getNumberOfAnimals());
		setTypeOfAnimal(order.getTypeOfAnimal());
		setTimeEstimation(order.getTimeEstimation());
		setStartTime(order.getStartTime());
		setDriver(order.getDriver());
		setDriverId(order.getDriver());
		setVehicle(order.getVehicle());
		setOrderStatus(order.getOrderStatus());
		setStatusMessage(order.getStatusMessage());
	}
	
	public AniOrder() {
		
	}
	

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Address getFromAddr() {
        return fromAddr;
    }

    public void setFromAddr(Address fromAddr) {
        this.fromAddr = fromAddr;
    }
    
    public Address getToAddr() {
        return toAddr;
    }

    public void setToAddr(Address toAddr) {
        this.toAddr = toAddr;
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
        this.driver = driver.substring(4);
    }
    
    public void setDriverId(String driver) {
    		if(!driver.equals("none")) {
			driverId = Integer.parseInt(driver.substring(0, 1));
		} else {
			driverId = -1;
		}
    }
    
    //returns -1 if the driver isn't set yet.
    public int getDriverId() {
    		return driverId;
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
    
    public boolean equals(AniOrder aniOrder) {
		if(this.getId() == aniOrder.getId() &&
    			this.getFromAddr().equals(aniOrder.getFromAddr()) &&
    			this.getToAddr() == aniOrder.getToAddr() &&
    			this.getUntil().equals(aniOrder.getUntil()) &&
    			this.getTimeframe().equals(aniOrder.getTimeframe()) &&
    			this.getNumberOfAnimals().equals(aniOrder.getNumberOfAnimals()) &&
    			this.getTypeOfAnimal().equals(aniOrder.getTypeOfAnimal()) &&
    			this.getTimeEstimation() == aniOrder.getTimeEstimation() &
    			this.getStartTime().equals(aniOrder.getStartTime()) &&
    			this.getDriver().equals(aniOrder.getDriver()) &&
    			this.getVehicle().equals(aniOrder.getVehicle()) &&
    			this.getOrderStatus().equals(aniOrder.getOrderStatus()) &&
    			this.getStatusMessage().equals(aniOrder.getStatusMessage())) {
			return true;
		} else {
			return false;
		}
	
}
   
   }

