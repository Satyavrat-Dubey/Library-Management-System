package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.LoginDao;
import Utility.DBUtility;

public class LoginDaoImpl implements LoginDao  {

	@Override
	public boolean adminLogin(String adminemail, String adminpass) {
		// TODO Auto-generated method stub
		Connection con=DBUtility.getConnection();
		String sql="select * from login where emailId=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, adminemail);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				String pass=rs.getString("password");
				if(pass.equals(adminpass)) {
					return true;
				}
				else {
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
