package hello;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * Models the User for the database. Since every user can only have one role, this is stored here as well and not 
 * in a separate table.
 */
@Entity // This tells Hibernate to make a table out of this class
public class NewUser {
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
    @NotNull
    @Size(min=1, max=255, message = "Please enter your street and number.")
    String street;
    @NotNull(message = "Please enter a valid PLZ.")
    private int plz;
    @NotNull
    @Size(min=1, max=255, message = "Please enter your town.")
    String town;
    @NotNull
    @Size(min=5, max=30, message = "Please enter a password of between 5 and 30 characters.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])[a-zA-Z0-9_$@$!%*?&£öäüéàè\\-]+", message = "The password has to contain a regular letter, a capital letter and a number. Allowed special characters are _ @ $ ! % * ? & £ ö ä ü é à è.")
    private String password; //needs to contain a capital letter, a small letter and a number.
    private String role = "ROLE_USER"; //Standard role is ROLE_USER. ROLE_ADMIN login info: email: mathias.fuchs@anitrans.ch password: theboss.
    boolean enabled = true;

    
    public NewUser(NewUser user) {
    		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.phone = user.getPhone();
		this.street = user.getStreet();
		this.plz = user.getPlz();
		this.town = user.getTown();
		this.password = user.getPassword();
		this.role = user.getRole();
    }
    
    public NewUser() {
    	
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

	public void setFirstName(String firstName) {
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
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
    
    
}

