package com.daos;

import java.sql.Connection;
import java.sql.SQLException;

import com.util.DbUtil;

public class Dao implements AutoCloseable {
	Connection con=null;
	public Dao() throws Exception {
		// TODO Auto-generated constructor stub
		con=DbUtil.getConnection();
	}
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		if(con!=null) {
			con.close();
		}
		
	}
	

}
