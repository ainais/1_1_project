package erp;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxController {

    @FXML
    private Button btnRegister;
    
    @FXML
    private Button btnFinalRegister;
    
    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancel;
    //--
    @FXML
    private Button btnInfoEmp;
    
    @FXML
    private Button btnVac;
    
    @FXML
    private Button btnDepartment;
    
    @FXML
    private Button btnProject;
    
    @FXML
    private Button btnRegInfoEmp;
    
    @FXML
    private Button btnRegVac;
    
    @FXML
    private Button btnRegDep;
    
    @FXML
    private Button btnRegProject;
    
    @FXML
    private TextField txtEmployeeID;
    
    @FXML
    private TextField txtName;
    
    @FXML
    private TextField txtDepartment;
    
    @FXML
    private DatePicker txtEnteringDate;
    
    @FXML
    private TextField txtRemainVacation;
    
    @FXML
    private DatePicker txtBirthday;
    
    @FXML
    private TextField txtResidentNumber;
    
    @FXML
    private Button btnDeleteInfo;

    
// ErpGUI 화면에서의 화면 전환
    @FXML
    void deleteInfo(ActionEvent event) {

    }
    //각종 등록화면으로 들어가기---------------------------- 
    @FXML
    void register(ActionEvent event) {
		btnRegister.getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("신규 등록");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void departmentRegister(ActionEvent event) {
		btnRegister.getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("DepartmentRegister.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("부서 등록");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void infoEmployeeRegister(ActionEvent event) {
		btnRegister.getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("InfoEmployeeRegister.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("직원 정보 등록");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void projectRegister(ActionEvent event) {
		btnRegister.getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ProjectRegister.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("프로젝트 등록");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void VactionRegister(ActionEvent event) {
		btnRegister.getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("VacationRegister.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("휴가 등록");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    //각종 조회화면으로 들어가기
    @FXML
    void departmentOpen(ActionEvent event) {
		btnRegister.getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("DepartmentOpen.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("부서 조회");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void infoEmployeeOpen(ActionEvent event) {
		btnRegister.getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("InfoEmployeeOpen.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("직원 정보 조회");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void projectOpen(ActionEvent event) {
		btnRegister.getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ProjectOpen.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("프로젝트 조회");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void vactionOpen(ActionEvent event) {
		btnRegister.getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("VacationOpen.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("휴가 조회");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

//Register.fxml의 메서드 정리   =============================================
    @FXML
    void finalRegister(ActionEvent event) {
    	String tempID = txtEmployeeID.getText();
    	int employeeID = Integer.parseInt(tempID);
    	
    	String name = txtName.getText();
    	String department = txtDepartment.getText();
    	String enteringDate = txtEnteringDate.getEditor().getText();
    	int RemainVac = 0;
    	EmployeeInsert e = new EmployeeInsert();
    	e.tableInsert(employeeID, name, department, enteringDate, RemainVac);
    	
    	String birthday = txtBirthday.getEditor().getText();
    	String resNumber = txtResidentNumber.getText();
    	InfoEmployeeInsert ie = new InfoEmployeeInsert();
    	int salary = 0;
    	ie.tableInsert(employeeID, name, resNumber, salary, enteringDate ,birthday);
    }

    @FXML
    void reset(ActionEvent event) {
    	txtEmployeeID.setText("");
    	txtName.setText("");
    	txtDepartment.setText("");
    	txtEnteringDate.getEditor().clear();
    	txtRemainVacation.setText("");
    	txtRemainVacation.setText("");
    	txtBirthday.getEditor().clear();
    }
    
    @FXML
    void cancel(ActionEvent event) {
    	Platform.exit();
    }
    
    // 정보삭제
}
