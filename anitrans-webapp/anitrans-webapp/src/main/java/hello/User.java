package hello;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * Models the User for the database. Since every user can only have one role, this is stored here as well and not 
 * in a separate table.
 */
@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @NotNull
    @Size(min=1, max=255, message = "Please enter your first name.")
    private String firstName;
    @NotNull
    @Size(min=1, max=255, message = "Please enter your last name.")
    private String lastName;
    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9_\\-\\.]+@[a-zA-Z0-9_\\-\\.]+\\.\\w+", message = "Please enter a valid email address.")
    private String email; //needs to conform to a regular email address (characters, digits, _, - and ., then @, then characters, digits, _, - and ., then ., then characters)
    @NotNull
    @Size(min=1, max=255, message = "Please enter your phone number.")
    private String phone;
    @OneToOne
	public Address address;
    @NotNull
    private String password; //needs to contain a capital letter, a small letter and a number.
    private String role = "ROLE_USER"; //Standard role is ROLE_USER. ROLE_ADMIN login info: email: mathias.fuchs@anitrans.ch password: theboss.
    boolean enabled = true;
    
    public User(Integer id, String firstName, String lastName, String email, String phone, Address address, String password, String role) {
    		this.id = id;
    		this.firstName = firstName;
    		this.lastName = lastName;
    		this.email = email;
    		this.phone = phone;
    		this.address = address;
    		this.password = password;
    		this.role = role;
    }
    
    public User(User user) {
    		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.phone = user.getPhone();
		this.address = user.getAddress();
		this.password = user.getPassword();
		this.role = user.getRole();
    }
    
    public User(NewUser newUser, Address address) {
		this.firstName = newUser.getFirstName();
		this.lastName = newUser.getLastName();
		this.email = newUser.getEmail();
		this.phone = newUser.getPhone();
		this.address = address;
		setPassword(newUser.getPassword());
		this.role = newUser.getRole();
    }
    
    public User() {
    	
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void serFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();		
		this.password = encoder.encode(password);
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
    
    
}

