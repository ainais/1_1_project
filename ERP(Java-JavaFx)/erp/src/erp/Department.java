package erp;

public class Department {

	public int EmployeeID;
	public String Name;
	public String Department;
	public String ChiefDepart;
	
	public Department() {
	}

	public Department(int employeeID, String name, String department, String chiefDepart) {
		EmployeeID = employeeID;
		Name = name;
		Department = department;
		ChiefDepart = chiefDepart;
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

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getChiefDepart() {
		return ChiefDepart;
	}

	public void setChiefDepart(String chiefDepart) {
		ChiefDepart = chiefDepart;
	}


	
	

}
