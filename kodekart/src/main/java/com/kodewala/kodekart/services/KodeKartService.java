package com.kodewala.kodekart.services;

import java.sql.Connection;

public interface KodeKartService 
{
	int basePage();

	boolean register(Connection con);

	boolean isAdmin(Connection con);

	int login(Connection con);
}
