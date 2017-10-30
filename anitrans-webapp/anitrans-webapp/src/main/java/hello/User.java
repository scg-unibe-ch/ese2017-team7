package hello;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

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
    @Size(min=1, max=255, message = "Please enter your name.")
    private String name;
    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9_\\-\\.]+@[a-zA-Z0-9_\\-\\.]+\\.\\w+", message = "Please enter a valid email address.")
    private String email; //needs to conform to a regular email address (characters, digits, _, - and ., then @, then characters, digits, _, - and ., then ., then characters)
    @NotNull
    @Size(min=5, max=30, message = "Please enter a password of between 5 and 30 characters.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])[a-zA-Z0-9_$@$!%*?&£öäüéàè\\-]+", message = "The password has to contain a regular letter, a capital letter and a number. Allowed special characters are _ @ $ ! % * ? & £ ö ä ü é à è.")
    private String password; //needs to contain a capital letter, a small letter and a number.
    private String role = "ROLE_USER"; //Standard role is ROLE_USER. ROLE_ADMIN login info: email: mathias.fuchs@anitrans.ch password: theboss.
    boolean enabled = true;
    
    public User(Integer id, String name, String email, String password, String role) {
    		this.id = id;
    		this.name = name;
    		this.email = email;
    		this.password = password;
    		this.role = role;
    }
    
    public User(User user) {
    		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.role = user.getRole();
    }
    
    public User() {
    	
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

