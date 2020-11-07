import java.time.LocalDate;
import java.util.List;

import telran.validation.Validator;

public class CnstraintsTestAppl {
	public static final String NAME = "EMPLOYEE";
	public static final LocalDate BIRTH_DATE = LocalDate.of(1969, 10, 3);
	public static final LocalDate RETIRE_DATE = LocalDate.of(2069, 10, 3);
	public static final String DEPARTMENT = "QA";
	public static final int SALARY = 15000;
	public static final String EMAIL = "test@domain.com";
	public static final int WORKING_HOURS = 8;
	public static final String CITY = "Jerusalem";
	public static final String STREET = "Lenin";
	public static final int BUILDING = 1;
	public static final int APART = 1;
	public static final Address ADDRESS = new Address(CITY, STREET, BUILDING, APART);

	public static void main(String[] args) {
		Employee[] employees = {
				new Employee(0, NAME, BIRTH_DATE, RETIRE_DATE, DEPARTMENT, SALARY, WORKING_HOURS, EMAIL, ADDRESS),
				new Employee(1, null, RETIRE_DATE, BIRTH_DATE, "", 2000, 9, "test@t.e.s.t.3", ADDRESS),
				new Employee(2, NAME, BIRTH_DATE, RETIRE_DATE, DEPARTMENT, SALARY, WORKING_HOURS, EMAIL,
						new Address("", "", 102, 0)) };
		for (Employee employee : employees) {
			List<String> result = Validator.validate(employee);
			if (result.isEmpty()) {
				System.out.println("✅ All fields are valid of Employee with id=" + employee.getId());
			} else {
				System.out.println("⚠️ Validation error of Employee with id=" + employee.getId());
				Validator.validate(employee).forEach(System.out::println);
			}
		}

	}

}