package com.kodewala.kodekart;

import java.sql.Connection;

import com.kodewala.kodekart.controller.UserController;
import com.kodewala.kodekart.jdbc.DataBaseConnection;

public class KodeKartApp 
{
	public static void main(String[] args)
	{
		DataBaseConnection dataBaseConnection = new DataBaseConnection();
		Connection con = dataBaseConnection.connectDataBase();
		UserController controller = new UserController();
		controller.controlUser(con);
		
		dataBaseConnection=null;
		controller=null;
	}
}