package pojos;

import javax.persistence.*;
import java.time.LocalDate;

@Entity // mandatory class level annotation
@Table(name = "users_table")
public class User {
	private Integer userId;
	private String name, email, password;
	private Role userRole;
	private String confirmPassword;
	private double regAmount;
	private LocalDate regDate;
	private byte[] image;

	public User() {
		System.out.println("in user constructor");
	}

	public User(String name, String email, String password, Role userRole, String confirmPassword, double regAmount,
			LocalDate regDate) {

		this.name = name;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
		this.confirmPassword = confirmPassword;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}

	public User(String name, double regAmount, LocalDate regDate) {
		
		this.name = name;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "User [userIdInteger=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", userRole=" + userRole + ", confirmPassword=" + confirmPassword + ", regAmount=" + regAmount
				+ ", regDate=" + regDate + "]";
	}

	@Id // Mandatory : telling hibernate : PK constraint : must be assigned by user
	// @GeneratedValue //auto ID generation by hibernate: native DB scheme
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto id generation by hibernate: auto_increment (best suited
														// for mysql DB)
	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(length = 20) // varchar(20) or else will get 255 char and name= "name"
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 20, unique = true ,nullable = false) // unique constraint
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 15, nullable = false) // not null
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Enumerated(EnumType.STRING) // string format or default is int
	@Column(length = 30, name = "user_role")
	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	@Transient // skip from persistance: No column generation for this property
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Column(name = "reg_amount")
	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	@Column(name = "reg_date")
	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	@Lob // large object => column type longblob
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
