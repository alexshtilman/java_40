
import java.io.Serializable;
import java.time.LocalDate;

import telran.validation.constrains.Email;
import telran.validation.constrains.Future;
import telran.validation.constrains.Max;
import telran.validation.constrains.Min;
import telran.validation.constrains.NotEmpty;
import telran.validation.constrains.NotNull;
import telran.validation.constrains.Past;
import telran.validation.constrains.Valid;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final int MIN_SALARY = 5000;
	private static final int MAX_HOURS = 8;

	private long id;
	@NotNull(msg = "\t❌ name ➖ can't be null")
	private String name;
	@Past(msg = "\t❌ birt day ➖ can't be in future!")
	private LocalDate birtDay;
	@Future(msg = "\t❌ retirement date ➖ can't be in past!")
	private LocalDate retirementDate;
	@NotEmpty(msg = "\t❌ department ➖ can't be an empty string!")
	private String department;
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Min(value = MIN_SALARY, msg = "\t❌ salary ➖ can't be an lower than " + MIN_SALARY)
	private int salary;
	@Max(value = MAX_HOURS, msg = "\t❌ working time ➖ can't be an greather than " + MAX_HOURS)
	private int workingHoursPerDay;
	@Email(msg = "\t❌ email ➖ shuld contan valid email string (user@domain.domain)")
	private String email;
	@Valid
	private Address address;

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirtDay(LocalDate birtDay) {
		this.birtDay = birtDay;
	}

	public void setRetirementDate(LocalDate retirementDate) {
		this.retirementDate = retirementDate;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirtDay() {
		return birtDay;
	}

	public String getDepartment() {
		return department;
	}

	public int getSalary() {
		return salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Long compareTo(Employee empl) {
		Long emplid = empl.getId();
		return this.id - emplid;
	}

	public Employee(long id, String name, LocalDate birtDay, LocalDate retirementDate, String department, int salary,
			int workingHoursPerDay, String email, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.birtDay = birtDay;
		this.retirementDate = retirementDate;
		this.department = department;
		this.salary = salary;
		this.workingHoursPerDay = workingHoursPerDay;
		this.email = email;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", birtDay=" + birtDay + ", retirementDate=" + retirementDate
				+ ", department=" + department + ", salary=" + salary + ", workingHoursPerDay=" + workingHoursPerDay
				+ ", email=" + email + ", address=" + address + "]";
	}

	public int getWorkingHoursPerDay() {
		return workingHoursPerDay;
	}

	public void setWorkingHoursPerDay(int workingHoursPerDay) {
		this.workingHoursPerDay = workingHoursPerDay;
	}

	
}
