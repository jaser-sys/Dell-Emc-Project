package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dao.SqliteDB;
import model.VirtualMachine;

public class VirtualMachineQuery extends SqliteDB {
	
	public void addNewEntry(Object o) {
		String sqlCommand = "INSERT INTO virtualMachines (vmID, vmHostName, vmUsername, vmPassword) "
		 		+ "VALUES("+ ((VirtualMachine)o).getID() +",\'" + ((VirtualMachine)o).getIP() + "\',\'" + ((VirtualMachine)o).getUserName() + "\',\'" + ((VirtualMachine)o).getPassword() + "\');" ;
		
		 try (Connection conn = super.connect();
				 PreparedStatement stmt  = conn.prepareStatement(sqlCommand) ){				 
			 stmt.executeUpdate();
	        }
		 catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	
	public List<Object> getEntries() {
		String sqlCommand = "SELECT * FROM virtualMachines;" ;
		List<Object> myVirtualMachines= new ArrayList<Object>();
		
		try (Connection conn = this.connect();
	             Statement stmt  = conn.createStatement();
	             ResultSet result    = stmt.executeQuery(sqlCommand)){
	            while (result.next()) {
	            	VirtualMachine v1=new VirtualMachine();
	            	v1.setID(UUID.fromString(result.getString("vmID")));
	            	v1.setIP(result.getString("vmHostName"));
	            	v1.setUserName(result.getString("vmUsername"));
	            	v1.setPassword(result.getString("vmPassword"));
	            	myVirtualMachines.add((Object)v1);
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		return myVirtualMachines;
	}
	
	public void deleteEntryByID(int entryId) {
		String sql = "DELETE FROM virtualMachines WHERE vmID = " + entryId +";";  
		
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
