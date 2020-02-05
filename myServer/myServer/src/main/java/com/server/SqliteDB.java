package com.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SqliteDB {
	
		private Connection connect() {
	        String DB_url = "jdbc:sqlite:C:\\Users\\abeer\\Desktop\\Dell-Emc-Project\\mySqliteDB\\myDatabase.db";
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(DB_url);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return conn;
	  }
		

		public boolean addVirtualMachine(int id, String hostName, String userName, String password) {
			String sqlCommand = "INSERT INTO virtualMachines (vmID, vmHostName, vmUsername, vmPassword) "
			 		+ "VALUES("+ id +",\'" + hostName + "\',\'" + userName + "\',\'" + password + "\');" ;
			
			 try (Connection conn = this.connect();
					 PreparedStatement stmt  = conn.prepareStatement(sqlCommand) ){				 
				 stmt.executeUpdate();
		        }
			 catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
			return true;
		}



		public List<VirtualMachine> getAllVirtualMachines() {
			String sqlCommand = "SELECT * FROM virtualMachines;" ;
			List<VirtualMachine> myVirtualMachines= new ArrayList<VirtualMachine>();
			
			try (Connection conn = this.connect();
		             Statement stmt  = conn.createStatement();
		             ResultSet result    = stmt.executeQuery(sqlCommand)){
		            while (result.next()) {
		            	VirtualMachine v1=new VirtualMachine();
		            	v1.setVmID(result.getInt("vmID"));
		            	v1.setVmHostName(result.getString("vmHostName"));
		            	v1.setVmUserName(result.getString("vmUsername"));
		            	v1.setVmPassword(result.getString("vmPassword"));
		            	myVirtualMachines.add(v1);
		            }
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
			return myVirtualMachines;
		}

		public void deleteVirtualMachineByID(int vmID) {
			String sql = "DELETE FROM virtualMachines WHERE vmID = " + vmID +";";  
			
	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }	
		}

		public void updatePasswordByID(int vmID,String newPassword) {
			String sqlCommand = "UPDATE virtualMachines SET vmPassword=\""+newPassword+"\" WHERE vmID = "+vmID+";";
			
	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sqlCommand)) {
				             pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		}
		
	}
