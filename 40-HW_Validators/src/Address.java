

import java.io.Serializable;

import telran.validation.constrains.Max;
import telran.validation.constrains.Min;
import telran.validation.constrains.NotEmpty;

public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotEmpty(msg = "\t❌ city ➖ can't be an empty string!")
	private String city;
	@NotEmpty(msg = "\t❌ street ➖ can't be an empty string!")
	private String street;
	@Min(value = 1,msg = "\t❌ building ➖ can't be lower than 1")
	private int building;
	@Max(value = 99,msg = "\t❌ aprtment ➖ we have only small houses only 99 apartments!")
	private int aprt;
 
	
	public Address() {

	}

	public Address(String city, String street, int aprt, int building) {
		super();
		this.city = city;
		this.street = street;
		this.aprt = aprt;
		this.building = building;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + ", aprt=" + aprt +", building="+building +"]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public int getAprt() {
		return aprt;
	}
	public int getBuilding() {
		return building;
	}
}
