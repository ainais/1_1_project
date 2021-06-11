package erp;

public class Project {

	public int EmployeeID;
	public String Name;
	public int ProjectCode;
	public int ProjectCount;
	
	public Project() {
	}

	public Project(int employeeID, String name, int projectCode, int projectCount) {
		EmployeeID = employeeID;
		Name = name;
		ProjectCode = projectCode;
		ProjectCount = projectCount;

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

	public int getProjectCode() {
		return ProjectCode;
	}

	public void setProjectCode(int projectCode) {
		ProjectCode = projectCode;
	}

	public int getProjectCount() {
		return ProjectCount;
	}

	public void setProjectCount(int projectCount) {
		ProjectCount = projectCount;
	}


	
	
	

}
