package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "charity")
@DiscriminatorValue("c")

public class CharityRecipient extends Recipient {

	@Column(name = "TAX_ID")
	private String taxId;

	public CharityRecipient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CharityRecipient(String name, String streetAddress, String city, String state, String postalCode,
			String taxId) {
		super(name, streetAddress, city, state, postalCode);
		this.taxId = taxId;
	}

	public CharityRecipient(int id) {
		super(id);
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	@Override
	public String toString() {
		return "CharityRecipient [taxId=" + taxId + ", toString()=" + super.toString() + "]";
	}
	
	public String CRecipientDetails() {
		return "ID:" + getId() + "  NAME:" + getName() + "  STREET ADDRESS:" + getStreetAddress() + "  CITY:" + getCity() + "  STATE:" + getState() + "  POSTALCODE:" + getPostalCode() + "  TAXID:" + taxId;
	}

}
