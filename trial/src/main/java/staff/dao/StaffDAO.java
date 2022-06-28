package staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import staff.db.*;
import staff.model.*;

public class StaffDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement st = null;
	static ResultSet rs = null;
	
	private String name, address, phone, email, role;
	private int id;
	
	//add Staff
		public void addStaff(Staff bean) {
			name = bean.getName();
			address = bean.getAddress();
			phone = bean.getPhone();
			email= bean.getEmail();
			role = bean.getRole();
			
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//create statement
				ps = con.prepareStatement("INSERT INTO staff(name, address, phone, email, role)VALUES(?,?,?,?,?)");
				ps.setString(1,name);
				ps.setString(2, address);
				ps.setString(3,phone);
				ps.setString(4,email);
				ps.setString(5,role);

				//execute query
				ps.executeUpdate();
				System.out.println("Successfully inserted");
				
				//close connection
				con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//get all Staffs
		public static List<Staff> getAllStaffs() {
			List<Staff> staffs = new ArrayList<Staff>();
			
			try {
				//call getConnection() method
				con = ConnectionManager.getConnection();
				
				//create statement
				st = con.createStatement();
				String sql = "SELECT * FROM staff ORDER BY id";
				
				//execute query
				rs = st.executeQuery(sql);
				
				while(rs.next()) {		//process result
					Staff s = new Staff();
					s.setId(rs.getInt("id"));
					s.setName(rs.getString("name"));
					s.setAddress(rs.getString("address"));
					s.setPhone(rs.getString("phone"));
					s.setEmail(rs.getString("email"));
					s.setRole(rs.getString("role"));
				
					staffs.add(s);
				}
				
				//close connection
				con.close();
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return staffs;
		}
		
		//get Staff by id
		public static Staff getStaffById(int id) {
			Staff s = new Staff();
			try {
				//call getConnection method
				con = ConnectionManager.getConnection();
				
				//create statement
				ps= con.prepareStatement("SELECT * FROM staff WHERE id=?");
				ps.setInt(1, id);
				
				//execute query
				rs = ps.executeQuery();
				if(rs.next()) {
					
					s.setId(rs.getInt("id"));
					s.setName(rs.getString("name"));
					s.setAddress(rs.getString("address"));
					s.setPhone(rs.getString("phone"));
					s.setEmail(rs.getString("email"));
					s.setRole(rs.getString("role"));
				}
				
				//close connection
				con.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return s;
		}
		
		//delete Staff
		public void deleteStaff(int id) {
			try {
				//call getConnection method
				con = ConnectionManager.getConnection();
				
				//create statement
				ps = con.prepareStatement("DELETE FROM staff WHERE id=?");
				ps.setInt(1, id);
				
				//execute query
				ps.executeUpdate();
				
				//close connection
				con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//update Staff
		public void updateStaff(Staff bean) {
			id = bean.getId();
			name = bean.getName();
			address = bean.getAddress();
			phone = bean.getPhone();
			email= bean.getEmail();
			role = bean.getRole();
			
			try {
				//call getConnection method
				con = ConnectionManager.getConnection();
				
				//create statement
				ps = con.prepareStatement("UPDATE staff SET name=?, address=?, phone=?, email=?,role=? WHERE id=?");
				ps.setString(1,name);
				ps.setString(2, address);
				ps.setString(3,phone);
				ps.setString(4,email);
				ps.setString(5,role);
				ps.setInt(6, id);
				
				//execute query
				ps.executeUpdate();
				
				System.out.println("Successfully updated");
				
				//close connection
				con.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	
}
