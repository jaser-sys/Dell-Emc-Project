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
	public boolean existsByIp(String ip) {
		String sqlCommand = "SELECT * FROM virtualMachine WHERE IP=\'"+ip+"\';" ;
		
		try (Connection conn = this.connect();
	             Statement stmt  = conn.createStatement();
	             ResultSet result    = stmt.executeQuery(sqlCommand)){
	            if (result.next()) {
	            	return true;
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }

		return false;
	}

	public List<VirtualMachine> getVitualMachines(UUID userId) {
		String sqlCommand = "SELECT * FROM virtualMachine WHERE userID=\'"+userId+"\';" ;
		List<VirtualMachine> myVirtualMachines= new ArrayList<VirtualMachine>();
		
		try (Connection conn = this.connect();
	             Statement stmt  = conn.createStatement();
	             ResultSet result    = stmt.executeQuery(sqlCommand)){
	            while (result.next()) {
	            	VirtualMachine vm=new VirtualMachine();
	            	vm.setID(UUID.fromString(result.getString("ID")));
	            	vm.setUserId(UUID.fromString(result.getString("userId")));
	            	vm.setIP(result.getString("IP"));
	            	vm.setUserName(result.getString("username_"));
	            	vm.setPassword(result.getString("password_"));
	            	vm.setPath(result.getString("path_"));
	            	myVirtualMachines.add(vm);
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		return myVirtualMachines;
	}

	@Override
	public void addVirtualMachine(VirtualMachine vm) {
		System.out.println(vm.toString());

		String sqlCommand = "INSERT INTO virtualMachine (ID, userId, IP, username_, password_, path_) "
		 		+ "VALUES(\'"+ vm.getID() +"\',\'"+ vm.getUserId()+"\',\'" + vm.getIP() + "\',\'" + vm.getUserName() + "\',\'" + vm.getPassword() + "\',\'"+vm.getPath()+"\');" ;
		 try (Connection conn = this.connect();
				PreparedStatement stmt  = conn.prepareStatement(sqlCommand) ){				 
			 	stmt.executeUpdate();
	        }
		 catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	
	@Override
	public void deleteVirtualMachineByIP(String ip) {
		String sql = "DELETE FROM virtualMachine WHERE IP = \'" + ip +"\';";  
		
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }	
	}
	
	@Override
	public VirtualMachine getVirtualMachineByIP(String ip) {
		String sqlCommand = "SELECT * FROM virtualMachine WHERE IP=\'"+ip+"\';" ;
		VirtualMachine vm=new VirtualMachine();
		
		try (Connection conn = this.connect();
	             Statement stmt  = conn.createStatement();
	             ResultSet result    = stmt.executeQuery(sqlCommand)){
	            while (result.next()) {
	            	vm.setID(UUID.fromString(result.getString("ID")));
	            	vm.setUserId(UUID.fromString(result.getString("userId")));
	            	vm.setIP(result.getString("IP"));
	            	vm.setUserName(result.getString("username_"));
	            	vm.setPassword(result.getString("password_"));
	            	vm.setPath(result.getString("path_"));
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		return vm;
	}
	
	@Override
	public List<VirtualMachine> getVirtualMachineByUsername(String username) {
		String sqlCommand = "SELECT * FROM virtualMachine WHERE username_=\'"+username+"\';" ;
		List<VirtualMachine> myVirtualMachines= new ArrayList<VirtualMachine>();
		
		try (Connection conn = this.connect();
	             Statement stmt  = conn.createStatement();
	             ResultSet result    = stmt.executeQuery(sqlCommand)){
	            while (result.next()) {
	            	VirtualMachine vm=new VirtualMachine();
	            	vm.setID(UUID.fromString(result.getString("ID")));
	            	vm.setUserId(UUID.fromString(result.getString("userId")));
	            	vm.setIP(result.getString("IP"));
	            	vm.setUserName(result.getString("username_"));
	            	vm.setPassword(result.getString("password_"));
	            	vm.setPath(result.getString("path_"));
	            	myVirtualMachines.add(vm);
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		return myVirtualMachines;
	}
	
	@Override
	public List<String> getVirtualMachineByIP(UUID userId){
		String sqlCommand = "SELECT IP FROM virtualMachine WHERE userID=\'"+userId+"\';" ;
		List<String> ips= new ArrayList<String>();
		
		try (Connection conn = this.connect();
	             Statement stmt  = conn.createStatement();
	             ResultSet result    = stmt.executeQuery(sqlCommand)){
			
	            while (result.next()) {
	            	ips.add(result.getString("IP"));
	            
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		return ips;
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
	public void deleteVirtualMachineByUsername(String username) {
		// TODO Auto-generated method stub	
	}



}
