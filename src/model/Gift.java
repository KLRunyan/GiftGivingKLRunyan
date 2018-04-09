package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import controller.DateConverterInterface;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "gift_type")
@Table(name="gift")

public class Gift {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "ID")
	private int id;
	@Column (name = "DATE_GIVEN")
	@Convert(converter = DateConverterInterface.class)
	private LocalDate dateGiven;
	@Column (name = "DESCRIPTION")
	private String description;
	@Column (name = "VALUE")
	private double value;
	@ManyToOne
	@JoinColumn (name = "RECIPIENT_ID")
	private Recipient recipient;
	
	public Gift() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gift(LocalDate dateGiven, String description, double value, Recipient recipient) {
		super();
		this.dateGiven = dateGiven;
		this.description = description;
		this.value = value;
		this.recipient = recipient;
	}
	

	public Gift(int id) {
		super();
		this.id = id;
	}

	public LocalDate getDateGiven() {
		return dateGiven;
	}

	public void setDateGiven(LocalDate dateGiven) {
		this.dateGiven = dateGiven;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Recipient getRecipient() {
		return recipient;
	}

	public void setRecipient(Recipient recipient) {
		this.recipient = recipient;
	}

	
	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Gift [dateGiven=" + dateGiven + ", description=" + description + ", value=" + value + ", recipient="
				+ recipient + "]";
	}
	
	

}
