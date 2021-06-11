package erp;

public class InfoEmployee {

	public int EmployeeID;
	public String Name;
	public String ResidNumber;
	public int Salary;
	public String EnteringDate;
	public String Birthday;
	
	public InfoEmployee() {
	}

	public InfoEmployee(int employeeID, String name, String residNumber, int salary, String enteringDate, String birthDay) {
		EmployeeID = employeeID;
		Name = name;
		ResidNumber = residNumber;
		Salary = salary;
		EnteringDate = enteringDate;
		Birthday = birthDay;
	}

	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getResidNumber() {
		return ResidNumber;
	}

	public void setResidNumber(String residNumber) {
		ResidNumber = residNumber;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

	public String getEnteringDate() {
		return EnteringDate;
	}

	public void setEnteringDate(String enteringDate) {
		EnteringDate = enteringDate;
	}

	public String getBirthday() {
		return Birthday;
	}

	public void setBirthday(String birthday) {
		Birthday = birthday;
	}

	

}
