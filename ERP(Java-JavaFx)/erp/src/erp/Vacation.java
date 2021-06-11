package erp;

public class Vacation {

	public int EmployeeID;
	public String Name;
	public int TotVac;
	public int UseVac;
	public int RemainVac;
	
	public Vacation() {
	}

	public Vacation(int employeeID, String name, int totVac, int useVac, int remainVac) {
		EmployeeID = employeeID;
		Name = name;
		TotVac = totVac;
		UseVac = useVac;
		RemainVac = remainVac;
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

	public int getTotVac() {
		return TotVac;
	}

	public void setTotVac(int totVac) {
		TotVac = totVac;
	}

	public int getUseVac() {
		return UseVac;
	}

	public void setUseVac(int useVac) {
		UseVac = useVac;
	}

	public int getRemainVac() {
		return RemainVac;
	}

	public void setRemainVac(int remainVac) {
		RemainVac = remainVac;
	}

	
	

}
