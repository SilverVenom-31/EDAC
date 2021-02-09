//Created by @AkhilD on 08/02/2021
package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class AadharCard {
@Column(length = 20,name = "card_number" , unique = true)
	private String cardNumber;
	@Column(name = "creation_date")
	private LocalDate creationDate;
	public AadharCard(String cardNumber, LocalDate creationDate) {
		super();
		this.cardNumber = cardNumber;
		this.creationDate = creationDate;
	}
	public AadharCard() {
		System.out.println("in aadhar card constr");	
		}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public String toString() {
		return "AadharCard [cardNumber=" + cardNumber + ", creationDate=" + creationDate + "]";
	}
	
	
}
