package erp;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 

/*Database Access Object�Դϴ�.*/ 
public class ProjectInsert { 
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; // jdbc ����̹� �ּ� 
	static final String DB_URL = "jdbc:mysql://localhost:3306/erp?useSSL=false"; 
		// DB ���� �ּ� 
		//localhost�� �����Ϸ��� �����ͺ��̽� �ּҸ� �Է��Ͻø� �˴ϴ�. localhost�� ����ϸ� �˴ϴ�. 
		//3306�� �����ͺ��̽��� �����Ҷ� ����ϴ� ���͹�ȣ�Դϴ�. ��ġ�Ҷ� ������ ��Ʈ��ȣ�� ����մϴ�. 
		//databasename���� �����Ϸ��� database�� name�� �Է����ݴϴ�. 
	static final String USERNAME = "root"; // DB ID 
	static final String PASSWORD = "!Dlwjdtjd16"; // DB Password 
	private Connection conn = null; 
	private Statement stmt = null; 
	private ResultSet rs = null; //�����ͺ��̽� ������ Ȯ���մϴ�. 
	public ProjectInsert(){ // DB ����
		System.out.print("DatabaseName �����ͺ��̽� ���� : "); 
		try { Class.forName(JDBC_DRIVER); 
		conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD); 
		if (conn != null){System.out.println("����");} 
		else{System.out.println("����");} 
		} catch (ClassNotFoundException e) { 
			System.out.println("Class Not Found Exection"); 
			e.printStackTrace(); 
			} 
		catch (SQLException e) { 
			System.out.println("SQL Exception"); 
			e.printStackTrace(); } 
		}//UserDAO // �����ͺ��̽��� �����͸� Insert�ϴ� Method�Դϴ�. 
	
	public void tableInsert(int employeeID, String name, int projectCode, int projectCount){ 
		Project prj = new Project(employeeID, name, projectCode, projectCount); //�ܺο��� �Ű������� �����͸� �޾� Qurey���� ����� �ݴϴ�. 
		//INSERT INTO Project VALUES(2105220002,'�̼���','�������κμ�','2021-05-22',17);
		String query = "INSERT INTO Project " + "VALUES (" + prj.EmployeeID + ", '" + prj.Name +"', '"+prj.ProjectCode+"', '"+prj.ProjectCount+"');"; 
		System.out.println(query); // Query�� Ȯ�� 
		try { // �����ͺ��̽��� �����մϴ�. 
			Class.forName(JDBC_DRIVER); 
			conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD); 
			stmt = conn.createStatement(); //�����ͺ��̽��� query���� �ѱ� Statement�� ������ݴϴ�.
			stmt.executeUpdate(query); // query�� �����ŵ�ϴ�. 
			stmt.close(); conn.close(); } 
		catch (ClassNotFoundException e) { 
			System.out.println("Class Not Found Exection"); 
			} 
		catch (SQLException e) { 
			System.out.println("SQL Exception : " + e.getMessage()); 
			} 
		} 
	public void tableSelect() {
		String query = "SELECT * FROM Project"; // table�� ��� ���ڵ带 ����ϴ� query���Դϴ�. 
		Project prj = new Project(); // TableName ��ü�� ������ݴϴ�. 
		try { // �����ͺ��̽��� �����մϴ�.
			Class.forName(JDBC_DRIVER); 
			conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD); 
			stmt = conn.createStatement(); //�����ͺ��̽��� query���� �ѱ� Statement�� ������ݴϴ�. 
			rs = stmt.executeQuery(query); // query�� �����ŵ�ϴ�. //executeQuery()�� executeUpdate()�ٸ� ��Ȳ�� ����ϴ� ���ɾ��Դϴ�. 
										   //executeUpdate() 
										   // INSERT, UPDATE, DELETE ���� ���� ���¿��� ����մϴ�.. 
										   //executeQuery() 
										   //DDL���� SELECT������ ����Ͻø� �˴ϴ�. 
										   //��ü���� ������ ���� �����͸� ����մϴ�.
			//employeeID, name, department, enteringDate, remainVac
			while (rs.next()){ 
				prj.setEmployeeID(rs.getInt("EmployeeID")); 
				prj.setName(rs.getString("Name")); 
				prj.setProjectCode(rs.getInt("ProjectCode")); 
				prj.setProjectCount(rs.getInt("ProjectCount")); 
				System.out.println("EmployeeID : " + prj.getEmployeeID() + ", Name : " + prj.getName()+ ", ProjectCode : "+prj.getProjectCode()+ ", ProjectCount : "+prj.getProjectCount()); 
				} 
			stmt.close(); 
			stmt.close(); 
			conn.close(); } 
		catch (ClassNotFoundException e) { 
			System.out.println("Class Not Found Exection"); 
			} 
		catch (SQLException e) { 
			System.out.println("SQL Exception : " + e.getMessage()); } 
		} 

	}


