package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddController {
	
		
	    @FXML
	    private TextField rec;

	    @FXML
	    private TextField nme;
	    
	    @FXML
	    private TextField nme1;

	    @FXML
	    private TextField pst;

	    @FXML
	    private TextField deg;

	    @FXML
	    private TextField uni;

	    @FXML
	    private DatePicker dob;

	    @FXML
	    private TextField id;

	    @FXML
	    private Button savebtn;

	    @FXML
	    private Button canbtn;
	    
	    
	    
	    
	    @FXML
	    private TextField rec2;

	    @FXML
	    private TextField nme2;

	    @FXML
	    private TextField lstnme2;

	    @FXML
	    private TextField per2;

	    @FXML
	    private TextField deg2;

	    @FXML
	    private TextField uni2;

	    @FXML
	    private TextField id2;

	    @FXML
	    private Button savebtn2;

	    @FXML
	    private Button canbtn2;

	    @FXML
	    private DatePicker dob2;

	    
	    //insert into board of directors
	    
	    public void save(ActionEvent event) {
	    	
	    	  
	    	  try {
	    		  
	    	   Class.forName("org.postgresql.Driver");
	    		  
	    	   Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbName",
			            "user", "password");
	    	   
	    	   
	    		 
	    		int record = Integer.parseInt(rec.getText());
	    		
	    		String name = nme.getText();
	    		
	    		String lstName = nme1.getText();
	    		
	    		String post = pst.getText();
	    		
	    		String degree = deg.getText();
	    		
	    		String university = uni.getText();
	    		
	    		LocalDate birthDate = dob.getValue();
	    		
	    		int coId = Integer.parseInt(id.getText());
	    		
	    		
	    		
	    		String query = "insert into public.board_of_directors_members_specs "
	    		+ "values ('"+record+"','"+name+"','"+lstName+"','"+post+"','"+degree+"','"+university+"','"+birthDate+"','"+coId+"')";  
	    		  
	    		Statement statement = con.createStatement();
	    		
	    		statement.execute(query);
	    		
	    		statement.close();
	    		  
	    		  
				
			} catch (Exception e) {
				
				
				
				System.out.println("saving Error :" + e);
				
				
				
			}
	    	
	    	  ((Node)event.getSource()).getScene().getWindow().hide();	
	   }
	    
	    
	    //insert into shareholders
	    
	    public void shareSave(ActionEvent event) {
	    	
	    	
	    	  try {
				
	    		 Class.forName("org.postgresql.Driver");
	    		  
		    	 Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbName",
				            "user", "password");
		    	 
		    	 
		    	 int record = Integer.parseInt(rec2.getText());
	    		  
		    	 String name = nme2.getText();
		    	 
		    	 String lstName = lstnme2.getText();
		    	 
		    	 float sharePer = Float.parseFloat(per2.getText());
		    	 
		    	 String degree = deg2.getText();
		    	 
		    	 String university = uni2.getText();
		    	 
		    	 LocalDate birthDate = dob2.getValue();
		    	 
		    	 int coId = Integer.parseInt(id2.getText());
		    	 
		    	 
		    	
		    	 String query = "insert into public.shareholders_specs "
		    	 		+ " values ('"+record+"','"+name+"','"+lstName+"','"+sharePer+"','"+degree+"','"+university+"','"+birthDate+"','"+coId+"')";
		    	
		    	 
		    	 
		    	 Statement statement = con.createStatement();
		    		
		    	 statement.execute(query);
		    		
		      	 statement.close();
	    		  
	    		  
			} catch (Exception e) {
				
				
				System.out.println("saving 2 Error :" + e);
				
				e.printStackTrace();
					
				
			} 
	    	    	
	    	  ((Node)event.getSource()).getScene().getWindow().hide();
	}
	    
	    
	    
	    public void cancel(ActionEvent e) {
	    	
	    	((Node)e.getSource()).getScene().getWindow().hide();
	    	
	    }
	    
	    
	    
	    
	    
	    
	  
}
