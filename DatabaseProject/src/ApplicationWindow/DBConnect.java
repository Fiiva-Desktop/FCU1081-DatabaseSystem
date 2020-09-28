package ApplicationWindow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnect {

	private Connection connection;
    private Statement statement;
	
	public DBConnect() {
        try {
            //Class 的靜態 forName() 方法實現動態加載類別
            Class.forName("com.mysql.jdbc.Driver");
            //3306|MySQL開放此端口
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/fast_food_delivered_managerment?useSSL=false",
            								"root", "FiivaLaptop0693694");
            
           //PreparedStatement prepareStatement = connection.prepareStatement(sql);
            statement= connection.createStatement();
            
             
        }catch(Exception ex){
            System.out.println("Error: "+ex);
        }
    }
	
	public Connection getConnection() {
		return connection;
	}
	
	public Statement getStatement() {
		return statement;
	}
}
