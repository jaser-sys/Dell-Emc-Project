package com.server.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.server.app.model.VirtualMachine;


@Repository
@CrossOrigin(origins = "http://localhost:4200")
public class VirtualMachineDao implements VirtualMachineDaoable {
	@Autowired
    DataSource dataSource;
	
	@Override
	public Connection connect() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public List<VirtualMachine> getVitualMachines() {
		String sqlCommand = "SELECT * FROM virtualMachine;" ;
		List<VirtualMachine> myVirtualMachines= new ArrayList<VirtualMachine>();
		
		try (Connection conn = this.connect();
	             Statement stmt  = conn.createStatement();
	             ResultSet result    = stmt.executeQuery(sqlCommand)){
	            while (result.next()) {
	            	VirtualMachine v1=new VirtualMachine();
	            	v1.setID(UUID.fromString(result.getString("ID")));
	            	v1.setUserId(UUID.fromString(result.getString("userId")));
	            	v1.setIP(result.getString("IP"));
	            	v1.setUserName(result.getString("userName"));
	            	v1.setPassword(result.getString("password_"));
	            	myVirtualMachines.add(v1);
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		return myVirtualMachines;
	}

	@Override
	public void addVirtualMachine(VirtualMachine vm) {
		String sqlCommand = "INSERT INTO virtualMachines (ID, userId, IP, userName, password_) "
		 		+ "VALUES(\'"+ vm.getID() +"\',\'"+vm.getUserId()+"\',\'" + vm.getIP() + "\',\'" + vm.getUserName() + "\',\'" + vm.getPassword() + "\');" ;
		 try (Connection conn = this.connect();
				PreparedStatement stmt  = conn.prepareStatement(sqlCommand) ){				 
			 	stmt.executeUpdate();
	        }
		 catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	
	@Override
	public void deleteVirtualMachineByIp(String ip) {
		String sql = "DELETE FROM virtualMachines WHERE IP = \'" + ip +"\';";  
		
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }	
	}
	
	public void updatePasswordByID(UUID vmID,String newPassword) {
		String sqlCommand = "UPDATE virtualMachines SET password_=\""+newPassword+"\" WHERE ID = \'" + vmID.toString() + "\';";
		
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sqlCommand)) {
			             pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}

	@Override
	public <S extends VirtualMachine> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends VirtualMachine> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<VirtualMachine> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<VirtualMachine> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<VirtualMachine> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(VirtualMachine entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends VirtualMachine> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public VirtualMachine getVirtualMachineByIp(String ip) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VirtualMachine> getVirtualMachineByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
