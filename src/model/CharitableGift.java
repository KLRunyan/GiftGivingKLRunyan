//Kristen Runyan
package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import controller.BooleanTFConverterInterface;

@Entity
@Table(name="gift")
@DiscriminatorValue("c")

public class CharitableGift extends Gift {

	@Column (name = "TAX_DEDUCTIBLE")
	@Convert(converter = BooleanTFConverterInterface.class)
	private boolean taxDeductible;
	@Convert(converter = BooleanTFConverterInterface.class)
	@Column (name = "HAVE_RECEIPT")
	private boolean haveReceipt;

	
	public CharitableGift() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CharitableGift(LocalDate dateGiven, String description, double value, Recipient recipient,
			boolean isTaxDeductible, boolean haveReceipt) {
		super(dateGiven, description, value, recipient);
		this.taxDeductible = isTaxDeductible;
		this.haveReceipt = haveReceipt;
	}
	
	public CharitableGift(int id) {
		super(id);
	}

	public boolean isTaxDeductible() {
		return taxDeductible;
	}

	public void setTaxDeductible(boolean isTaxDeductible) {
		this.taxDeductible = isTaxDeductible;
	}

	public boolean isHaveReceipt() {
		return haveReceipt;
	}

	public void setHaveReceipt(boolean haveReceipt) {
		this.haveReceipt = haveReceipt;
	}

	@Override
	public String toString() {
		return "CharitableGift [isTaxDeductible=" + taxDeductible + ", haveReceipt=" + haveReceipt + ", toString()="
				+ super.toString() + "]";
	}
	
	public String CGiftDetails() {
		return "DATE GIVEN:" + getDateGiven() + "  DESCRIPTION:" + getDescription() + "  VALUE:" + getValue() + "  TAX DEDUCTIBLE:" + taxDeductible + "  HAVE RECEIPT:" + haveReceipt;
	}

}
