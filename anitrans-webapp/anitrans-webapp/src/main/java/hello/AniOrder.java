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

@Entity // This tells Hibernate to make a table out of this class
public class AniOrder {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	@NotNull
	@Size(min=2, max=255)
	public String fromAddr;
	@NotNull
	@Size(min=2, max=255)
	private String toAddr;
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd.MM.yyy")
	private Date until;
	@NotNull
	@Size(min=2, max=255)
	private String timeframe;
	@NotNull
	@Size(min=2, max=255)
	private String typeOfAnimal;
	@NotNull
	private Integer numberOfAnimals;
	@NotNull
	@Size(min=2, max=255)
	private String timeEstimation;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd.MM.yyy, HH:mm")
	private Date startTime;
	private String driver;
	private String orderStatus = "undelivered";
	private String statusMessage = "";
	

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromAddr() {
        return fromAddr;
    }

    public void setFromAddr(String fromAddr) {
        this.fromAddr = fromAddr;
    }
    
    public String getToAddr() {
        return toAddr;
    }

    public void setToAddr(String toAddr) {
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