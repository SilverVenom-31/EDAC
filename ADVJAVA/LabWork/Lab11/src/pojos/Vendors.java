//Created by @AkhilD on 07/02/2021
package pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vendors_tbl")
public class Vendors extends BaseEntity {
	@Column(length = 20)
	private String name;
	@Column(length = 20, nullable = false, unique = true)
	private String email;
	@Column(length = 15, nullable = false)
	private String password;
	@Column(name = "reg_amount")
	private double regAmount;
	private LocalDate regDate;
	@OneToMany(mappedBy = "accountOwner", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BankAccounts> bankAccounts = new ArrayList<>();

	// entity to value type(payment details)
	@Embedded // optional annotation: for understanding
	private PaymentDetails paymentDetails;

	// tell HB: collection of basic value types
	// one to many uni dir mapping between vendor to multiple phone nos
	@ElementCollection // mandatory else throws mapping exception
	// optional: specify name,fk
	@CollectionTable(name = "vendor_phones", joinColumns = @JoinColumn(name = "vendor_id"))
	@Column(name = "phone_no", length = 10, unique = true)
	private List<String> phoneNumber = new ArrayList<>();

	// one to many uni dir mapping between vendor to multiple services
	@ElementCollection
	@CollectionTable(name = "vendor_services", joinColumns = @JoinColumn(name = "vendor_id"))
	private List<VendorServices> vendorServices = new ArrayList<>();

	public List<VendorServices> getVendorServices() {
		return vendorServices;
	}

	public void setVendorServices(List<VendorServices> vendorServices) {
		this.vendorServices = vendorServices;
	}

	public List<String> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
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

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public List<BankAccounts> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccounts> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public Vendors(String name, String email, String password, double regAmount, LocalDate regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;

	}

	public Vendors() {
		System.out.println("in vendor const");
	}

	@Override
	public String toString() {
		return "Vendors [name=" + name + ", email=" + email + ", password=" + password + ", regAmount=" + regAmount
				+ ", regDate=" + regDate + "]";
	}

	public void addAccount(BankAccounts b) { // linking
		bankAccounts.add(b);
		b.setAccountOwner(this);
	}

	public void removeAccount(BankAccounts b) {// delinking
		bankAccounts.remove(b);
		b.setAccountOwner(null);
	}

}
