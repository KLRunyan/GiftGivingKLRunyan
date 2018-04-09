package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import controller.OccasionConverterInterface;

@Entity
@Table(name = "gift")
@DiscriminatorValue("p")

public class PersonalGift extends Gift {

	@Column(name = "OCCASION_ID")
	@Convert(converter = OccasionConverterInterface.class)
	private String occasion;

	public PersonalGift() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonalGift(LocalDate dateGiven, String description, double value, Recipient recipient, String occasion) {
		super(dateGiven, description, value, recipient);
		this.occasion = occasion;
	}

	
	public PersonalGift(int id) {
		super(id);
	}

	public String getOccasion() {
		return occasion;
	}

	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}

	@Override
	public String toString() {
		return "PersonalGift [occasion=" + occasion + ", toString()=" + super.toString() + "]";
	}
	
	public String PGiftDetails() {
		return "DATE GIVEN:" + getDateGiven() + "  DESCRIPTION:" + getDescription() + "  VALUE:" + getValue() + "  OCCASION:" + occasion;
	}

}
