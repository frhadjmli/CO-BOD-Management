package controllers;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import application.PostgresqlAccess;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Board;
import model.CompanyInfos;
import model.Share;

public class MainController {
	
	  @FXML
	    private Tab logtab;

	    @FXML
	    private TextField user;

	    @FXML
	    private PasswordField pass;

	    @FXML
	    private ImageView userpic;

	    @FXML
	    private ImageView passpic;

	    @FXML
	    private Separator sep;

	    @FXML
	    private Button logbtn;

	    @FXML
	    private ImageView logpic;

	    @FXML
	    private Tab overtab;

	    @FXML
	    private TableView<CompanyInfos> overtbl;

	    @FXML
	    private TableColumn<CompanyInfos,String> coname;

	    @FXML
	    private TableColumn<CompanyInfos,String> ceoname;

	    @FXML
	    private TableColumn<CompanyInfos,String> natid;

	    @FXML
	    private TableColumn<CompanyInfos,String> cotype;

	    @FXML
	    private TableColumn<CompanyInfos,String> regdate;

	    @FXML
	    private TableColumn<CompanyInfos,String> street;

	    @FXML
	    private TableColumn<CompanyInfos,String> alley;

	    @FXML
	    private TableColumn<CompanyInfos,String> post;

	    @FXML
	    private Button refbtn;

	    @FXML
	    private Tab bodtab;

	    @FXML
	    private TableView<Board> bodtbl;

	    @FXML
	    private TableColumn<Board, String> rec;

	    @FXML
	    private TableColumn<Board, String> name;

	    @FXML
	    private TableColumn<Board, String> semat;

	    @FXML
	    private TableColumn<Board, String> deg;

	    @FXML
	    private TableColumn<Board, String> uni;

	    @FXML
	    private TableColumn<Board, String> birth1;

	    @FXML
	    private TableColumn<Board, String> conat;

	    @FXML
	    private Button ldbtn;

	    @FXML
	    private Button addbtn;

	    @FXML
	    private Button delbtn;

	    @FXML
	    private Button edbtn;

	    @FXML
	    private Tab sharetab;

	    @FXML
	    private TableView<Share> sharetbl;

	    @FXML
	    private TableColumn<Share,String> rec2;

	    @FXML
	    private TableColumn<Share,String> name2;

	    @FXML
	    private TableColumn<Share,String> shareper;

	    @FXML
	    private TableColumn<Share,String> deg2;

	    @FXML
	    private TableColumn<Share,String> uni2;

	    @FXML
	    private TableColumn<Share,String> birth2;

	    @FXML
	    private TableColumn<Share,String> conat2;

	    @FXML
	    private Button ldbtn2;

	    @FXML
	    private Button addbtn2;

	    @FXML
	    private Button delbtn2;

	    @FXML
	    private Button edbtn2;
	    
	    @FXML
	    private Button logoutbtn;
	    
	    
	    
	    public void login(ActionEvent event) {
	    	
	    	String username = "admin";
	    	String password = "admin";
	    	
	    	if(user.getText().equals(username) && pass.getText().equals(password) ) {
	    		
	    		overtab.setDisable(false);
	    		bodtab.setDisable(false);
	    		sharetab.setDisable(false);
	    		logtab.setDisable(true);
	    		user.clear();
	    		pass.clear();
	    	}
	    }
	    
	    public void logout(ActionEvent event) {
	    	
	    	overtab.setDisable(true);
    		bodtab.setDisable(true);
    		sharetab.setDisable(true);
    		logtab.setDisable(false);
	    	
	    }
	    
	    //select data from database
	    			
	    public  void refresh(ActionEvent event) {
	    	
	    	ObservableList<CompanyInfos> obsl = FXCollections.observableArrayList();
	    	
	    	try {
	    		
	    		Connection con = PostgresqlAccess.connector();
	    		
	    		
	    		ResultSet res = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY).executeQuery("select * from public.company_general_specs natural join public.company_type ;");
	    		
	    		
	    		while(res.next()) {
	    				
	    			
	    			obsl.add(new CompanyInfos(res.getString("coname"), res.getString("ceoname"), res.getString("nationalid"),res.getString("cotypetitle") ,res.getString("regdate"), res.getString("street"), res.getString("alley"), res.getString("postcode")) );
	    			
	    			 
	    			
	    		}
	    		
	    		
	    		coname.setCellValueFactory(new PropertyValueFactory<CompanyInfos,String>("coName"));
		    	
		    	ceoname.setCellValueFactory(new PropertyValueFactory<CompanyInfos,String>("ceoName"));
		    	
		    	natid.setCellValueFactory(new PropertyValueFactory<CompanyInfos,String>("nationalId"));
		    	
		    	cotype.setCellValueFactory(new PropertyValueFactory<CompanyInfos,String>("coType"));
		    	
		    	regdate.setCellValueFactory(new PropertyValueFactory<CompanyInfos,String>("regDate"));
		    	
		    	street.setCellValueFactory(new PropertyValueFactory<CompanyInfos,String>("street"));
		    	
		    	alley.setCellValueFactory(new PropertyValueFactory<CompanyInfos,String>("alley"));
		    	
		    	post.setCellValueFactory(new PropertyValueFactory<CompanyInfos,String>("postCode"));
		    	
		    	overtbl.setItems(obsl);
		    	
		    	
			} catch (Exception e) {

				System.out.println("refresh Error :" +e);
				
			
		  }
	    	
	 }	
	    
	   
	    public void load() {
		   
		   
		   ObservableList<Board> boardlist = FXCollections.observableArrayList();
		   
		   Connection c;
		   
		   try {
			   
			   
			   c = PostgresqlAccess.connector();
			   
			   String query = "select * from public.board_of_directors_members_specs;";
			   
			   Statement st = c.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			   
			   ResultSet rs = st.executeQuery(query);
			   
			   while(rs.next()) {
				   
				   
				   Board board = new Board();
				   
				   board.setRecord(rs.getString("record"));
				   
				   board.setName(rs.getString("fname") +"  "+  rs.getString("lname"));
				   
				   board.setPost(rs.getString("post"));
				   
				   board.setDegree(rs.getString("lastdegree"));
				   
				   board.setUniversity(rs.getString("university"));
				   
				   board.setBirthdate(rs.getString("dob"));
				   
				   board.setCoNationalId(rs.getString("nationalid"));
				   
				   
				   
				   boardlist.add(board);
				      
				   
			   }
			   
			   rec.setCellValueFactory(new PropertyValueFactory<Board,String>("record"));
			   
			   name.setCellValueFactory(new PropertyValueFactory<Board,String>("name"));
			   
			   semat.setCellValueFactory(new PropertyValueFactory<Board,String>("post"));
			   
			   deg.setCellValueFactory(new PropertyValueFactory<Board,String>("degree"));
			   
			   uni.setCellValueFactory(new PropertyValueFactory<Board,String>("university"));
			   
			   birth1.setCellValueFactory(new PropertyValueFactory<Board,String>("birthdate"));
			   
			   conat.setCellValueFactory(new PropertyValueFactory<Board,String>("coNationalId"));
			   
			   
			   
			   bodtbl.setItems(boardlist);
			   
			   editTableCol();
			   
			   
			
		} catch (Exception e) {
			
			System.out.println("load Error :" + e);
			
		 		}
		    
	   	}
	   
	   
	    public void load2() {
		   
		   
		   ObservableList<Share> sharelist = FXCollections.observableArrayList();
		   
		   
		   Connection c;
		   
		   
		   try {
			   
			   
			   
			   c = PostgresqlAccess.connector();
			   
			   String query = "select * from public.shareholders_specs;";
			   
			   Statement st = c.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			   
			   ResultSet rs = st.executeQuery(query);
			   
			   while(rs.next()) {
				   
				   
				   Share share = new Share();
				   
				   share.setRecord(rs.getString("record"));
				   
				   share.setName(rs.getString("fname") +"  "+  rs.getString("lname"));
				   
				   share.setSharePer(rs.getString("sharepercentage"));
				   
				   share.setDegree(rs.getString("lastdegree"));
				   
				   share.setUniversity(rs.getString("university"));
				   
				   share.setBirthdate(rs.getString("dob"));
				   
				   share.setCoNationalId(rs.getString("nationalid"));
				   
				   
				  sharelist.add(share);
				 
				   
			  }
			   
			 
			   rec2.setCellValueFactory(new PropertyValueFactory<Share,String>("record"));
			   
			   name2.setCellValueFactory(new PropertyValueFactory<Share,String>("name"));
			   
			   shareper.setCellValueFactory(new PropertyValueFactory<Share,String>("sharePer"));
			   
			   deg2.setCellValueFactory(new PropertyValueFactory<Share,String>("degree"));
			   
			   uni2.setCellValueFactory(new PropertyValueFactory<Share,String>("university"));
			   
			   birth2.setCellValueFactory(new PropertyValueFactory<Share,String>("birthdate"));
			   
			   conat2.setCellValueFactory(new PropertyValueFactory<Share,String>("coNationalId"));
			   
			   
			   sharetbl.setItems(sharelist);
			   
			   editShareTable();
			  
		} catch (Exception e) {
			
			System.out.println("load2 Error :" + e);
		
			
	  }
		      
    }
	   
	   //initialize add window
	    public void add() {
	    	
	    	
	    	 Stage stage = new Stage();
	    	 
	    	 
	    	 try {
	    	 
	    	 AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/AddFX.fxml"));
		     Scene scene = new Scene(root);
		     scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());	
		     stage.setTitle("Add");
		     stage.setResizable(false);
		     stage.setScene(scene);
		     Image image = new Image("/application/Image/add.png");
		     stage.getIcons().add(image);
		     stage.setTitle("Add Member");
		     stage.show();
				 
				
			} catch (Exception e) {
				
				System.out.println("adding Error :" + e);
				
			}
	    	
	    	
	    	
	    	
	    	
	    }
	   
	   
	    public void shareAdd() {
	    	
	    	 Stage stage = new Stage();
	    	 
	    	try {
	    		
	    		
	    		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/AddFX2.fxml"));
			     Scene scene = new Scene(root);
			     scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());	
			     stage.setTitle("Add");
			     stage.setResizable(false);
			     stage.setScene(scene);
			     Image image = new Image("/application/Image/add.png");
			     stage.getIcons().add(image);
			     stage.setTitle("Add Member");
			     stage.show();
	    		
	 
				
			} catch (Exception e) {
				
				System.out.println("share Add Error :" + e);
				
				
			}
	    	
		                       
	    	
	    }
	   
	  
	    public void delete() {
	    	
	    	
	    	try {
	    		
	    		Connection	c = PostgresqlAccess.connector();
	    		
	    		Board board = (Board) bodtbl.getSelectionModel().getSelectedItem();
	    		
	    		bodtbl.getItems().removeAll(bodtbl.getSelectionModel().getSelectedItem());
	    		
	    		String query = "delete from public.board_of_directors_members_specs where record = '"+Integer.valueOf(board.getRecord())+"' ";
	    		
	    		Statement statement = c.createStatement();
	    	
	    		statement.executeUpdate(query);
	    		
	    		statement.close();
	    		
	    		
				
			} catch (Exception e) {
				
				System.out.println("delete Error :" + e);
			
			}
	    	
	    }    
	    
	    
	    public void shareDel() {
	    	
	    	try {
	    	
	    		Connection	c = PostgresqlAccess.connector();
	    	
	    		Share share = (Share) sharetbl.getSelectionModel().getSelectedItem();
	    		
	    		sharetbl.getItems().removeAll(sharetbl.getSelectionModel().getSelectedItem());
	    	
	    		String query = "delete from public.shareholders_specs where record = '"+Integer.valueOf(share.getRecord())+"'";
	    	
	    		Statement stmt = c.createStatement();
	    	
	    		stmt.executeUpdate(query);
	    	
	    		stmt.close();
	    	
	    	} catch(Exception e) {
	    		
	    		System.out.println("Share Del Error :" + e);
	    		
	    		
	    }
	    	
	    	 	
	 }
	    
	    
	    //make table editable
	    
	    public void editTableCol() {
	    	
	    	
	    	
	    	rec.setCellFactory(TextFieldTableCell.forTableColumn());
	    	
	    	rec.setOnEditCommit(e-> {
	    		
	    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setRecord(e.getNewValue());
	    		
	    	});
	    	
	    	
	    	name.setCellFactory(TextFieldTableCell.forTableColumn());
	    	
	    	name.setOnEditCommit(e-> {
	    		
	    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setName(e.getNewValue());
	    		
	    	});
	    	
	    	
	    	
	    	semat.setCellFactory(TextFieldTableCell.forTableColumn());
	    	
	    	semat.setOnEditCommit(e-> {
	    		
	    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setPost(e.getNewValue());
	    		
	    	});
	    	
	    	
	    	deg.setCellFactory(TextFieldTableCell.forTableColumn());
	    	
	    	deg.setOnEditCommit(e-> {
	    		
	    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setDegree(e.getNewValue());
	    		
	    	});
	    	
	    	
	    	uni.setCellFactory(TextFieldTableCell.forTableColumn());
	    	
	    	uni.setOnEditCommit(e-> {
	    		
	    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setUniversity(e.getNewValue());
	    	
	    	});
	    	
	    	
	    	birth1.setCellFactory(TextFieldTableCell.forTableColumn());
	    	
	    	birth1.setOnEditCommit(e-> {
	    		
	    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setBirthdate(e.getNewValue());
	    	
	    	});
	    	
	    	
	    	uni.setCellFactory(TextFieldTableCell.forTableColumn());
	    	
	    	uni.setOnEditCommit(e-> {
	    		
	    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setUniversity(e.getNewValue());
	    	
	    	});
	    	
	    	
	    	conat.setCellFactory(TextFieldTableCell.forTableColumn());
	    	
	    	conat.setOnEditCommit(e-> {
	    		
	    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setCoNationalId(e.getNewValue());
	    	
	    	});
	    	
	    	
	    	
	    	bodtbl.setEditable(true);
	    	
	    }
	    
	    
	    
	    public void update() {
	    	
	    	
	    	try {
				
	    		 Class.forName("org.postgresql.Driver");
	    		 
	    		 Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbName",
				            "user", "password");
	    		 
	    		 
	    		 Board board = (Board) bodtbl.getSelectionModel().getSelectedItem();
	    	 
	    	 
	    		 int record = Integer.parseInt(rec.getCellData(board));
	    		 
	    		 String Name = name.getCellData(board);
	    		 
	    		 char whiteSpace = ' ';
	    		 
	    		 String fName = Name.substring(0,Name.indexOf(whiteSpace));
	    		 
	    		 String lName = Name.substring(Name.lastIndexOf(whiteSpace)+1);
	    		
	    		 String post = semat.getCellData(board);
	    		 
	    		 String degree = deg.getCellData(board);
	    		 
	    		 String university = uni.getCellData(board);
	    		 
	    		 LocalDate birthdate = LocalDate.parse(birth1.getCellData(board));
	    		 
	    		 int coId = Integer.parseInt(conat.getCellData(board));
	    		 
	    		 
	    		 String query = "update public.board_of_directors_members_specs"
	    		 		+ " set record = '"+record+"', fname ='"+fName+"',lname = '"+lName+"',post = '"+post+"', lastdegree = '"+degree+"', university = '"+university+"',"
	    		 				+ " dob = '"+birthdate+"', nationalid = '"+coId+"' where record = '"+Integer.valueOf(board.getRecord())+"' ";
	    		 
	    		 Statement stmt = con.createStatement();
	    		 
	    		 stmt.execute(query);
	    		 
	    		 stmt.close();
	    		
	    		
			} catch (Exception e) {
				
				System.out.println("Update Error :" + e);
				
			}
	    		
	   } 


	    public void editShareTable() {
	    	
	    	rec2.setCellFactory(TextFieldTableCell.forTableColumn());
	    	
	    	rec2.setOnEditCommit(e-> {
	    		
	    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setRecord(e.getNewValue());
	    		
	    	});
	    	
	    	
	    	name2.setCellFactory(TextFieldTableCell.forTableColumn());
	    	
	    	name2.setOnEditCommit(e-> {
	    		
	    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setName(e.getNewValue());
	    		
	    	});
	    	
	    	shareper.setCellFactory(TextFieldTableCell.forTableColumn());
	    	
	    	shareper.setOnEditCommit(e-> {
	    		
	    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setSharePer(e.getNewValue());
	    		
	    	});
	    	
	    	deg2.setCellFactory(TextFieldTableCell.forTableColumn());
	    	
	    	deg2.setOnEditCommit(e-> {
	    		
	    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setDegree(e.getNewValue());
	    		
	    	});
	    	
	    	uni2.setCellFactory(TextFieldTableCell.forTableColumn());
	    	
	    	uni2.setOnEditCommit(e-> {
	    		
	    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setUniversity(e.getNewValue());
	    		
	    	});
	    	
	    	birth2.setCellFactory(TextFieldTableCell.forTableColumn());
	    	
	    	birth2.setOnEditCommit(e-> {
	    		
	    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setBirthdate(e.getNewValue());
	    		
	    	});
	    	
	    	conat2.setCellFactory(TextFieldTableCell.forTableColumn());
	    	
	    	conat2.setOnEditCommit(e-> {
	    		
	    		e.getTableView().getItems().get(e.getTablePosition().getRow()).setCoNationalId(e.getNewValue());
	    		
	    	});
	    	
	    	sharetbl.setEditable(true);
	    	
	    }
	    
	    
	    public void updateShareTable() {
	    	
	    	try {
	    		
	    		 Class.forName("org.postgresql.Driver");
	    		
	    		 Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbName",
				            "user", "password");
	    		 
	    		 
	    		 Share share = (Share) sharetbl.getSelectionModel().getSelectedItem();
	    		 
	    		 
	    		 int record = Integer.parseInt(rec2.getCellData(share));
	    		 
	    		 String Name = name2.getCellData(share);
	    		 
	    		 char whiteSpace = ' ';
	    		 
	    		 String fName = Name.substring(0,Name.indexOf(whiteSpace));
	    		
	    		 String lName = Name.substring(Name.lastIndexOf(whiteSpace)+1);
	    		 
	    		 float sharePer = Float.parseFloat(shareper.getCellData(share));
	    		 
	    		 String degree = deg2.getCellData(share);
	    		 
	    		 String university = uni2.getCellData(share);
	    		 
	    		 LocalDate birthdate = LocalDate.parse(birth2.getCellData(share));
	    		
	    		 int coId = Integer.parseInt(conat2.getCellData(share));
	    		 
	    		 
	    		 String query = "update public.shareholders_specs set record = '"+record+"',fname = '"+fName+"', lname = '"+lName+"',sharepercentage = '"+sharePer+"',lastdegree = '"+degree+"',university = '"+university+"',dob = '"+birthdate+"',nationalid = '"+coId+"' where record = '"+Integer.valueOf(share.getRecord())+"'";
	    		
	    		 Statement stmt = con.createStatement();
	    		 
	    		 stmt.execute(query);
	    		 
	    		 stmt.close();
				
			} catch (Exception e) {
				
				System.out.println("ShareUpd Error :"+ e);
				
			}
	    	
	    	
	    }
	    
	    
	    
 }
