package erp;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;

public class Control extends Application{
//------------------Control Ŭ���� ����
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("ErpGUI.fxml"));
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("ERP�ý��� �����");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	//---------------------------Main ����	
		// =======================================
		// table insert�κ�
		EmployeeInsert e = new EmployeeInsert();
		e.tableSelect();
		InfoEmployeeInsert ie = new InfoEmployeeInsert();
		ie.tableSelect();
		
		// =======================================
		// JavaFX �����κ�
		launch(args);
	//---------------------------Main ����
	}


//------------------Control Ŭ���� ����
}