package staff.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import staff.db.ConnectionManager;
import staff.model.*;


public class PrayerDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement st = null;
	static ResultSet rs = null;
	
	private String prayerName;
	private int id;
	
			//add Prayer
			public void addPrayer(Prayer bean) {
				prayerName = bean.getPrayerName();
				
				try {
					//call getConnection() method
					con = ConnectionManager.getConnection();
					
					//create statement
					ps = con.prepareStatement("INSERT INTO prayer(prayerName)VALUES(?)");
					ps.setString(1,prayerName);

					//execute query
					ps.executeUpdate();
					System.out.println("Successfully inserted");
					
					//close connection
					con.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			//get all Prayers
			public static List<Prayer> getAllPrayers() {
				List<Prayer> prayers = new ArrayList<Prayer>();
				
				try {
					//call getConnection() method
					con = ConnectionManager.getConnection();
					
					//create statement
					st = con.createStatement();
					String sql = "SELECT * FROM prayer ORDER BY id";
					
					//execute query
					rs = st.executeQuery(sql);
					
					while(rs.next()) {		//process result
						Prayer p = new Prayer();
						p.setId(rs.getInt("id"));
						p.setPrayerName(rs.getString("prayerName"));

						prayers.add(p);
					}
					
					//close connection
					con.close();
					
					
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				return prayers;
			}
			
			//get Prayer by id
			public static Prayer getPrayerById(int id) {
				Prayer p = new Prayer();
				try {
					//call getConnection method
					con = ConnectionManager.getConnection();
					
					//create statement
					ps= con.prepareStatement("SELECT * FROM prayer WHERE id=?");
					ps.setInt(1, id);
					
					//execute query
					rs = ps.executeQuery();
					if(rs.next()) {
						
						p.setId(rs.getInt("id"));
						p.setPrayerName(rs.getString("prayerName"));
					}
					
					//close connection
					con.close();
					
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				return p;
			}
			
			//delete Prayer
			public void deletePrayer(int id) {
				try {
					//call getConnection method
					con = ConnectionManager.getConnection();
					
					//create statement
					ps = con.prepareStatement("DELETE FROM prayer WHERE id=?");
					ps.setInt(1, id);
					
					//execute query
					ps.executeUpdate();
					
					//close connection
					con.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			//update Prayer
			public void updatePrayer(Prayer bean) {
				id = bean.getId();
				prayerName = bean.getPrayerName();
				
				try {
					//call getConnection method
					con = ConnectionManager.getConnection();
					
					//create statement
					ps = con.prepareStatement("UPDATE prayer SET prayerName=? WHERE id=?");
					ps.setString(1,prayerName);
					ps.setInt(2, id);
					
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
