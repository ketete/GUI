/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ws
 */

public class Jdbc {

	private Connection conn;
	private String driverClass = "";
	private String url = "";
	private String username = "";
	private String password = "";

	public Jdbc() {
		init();
	}

	public void init() {
		//pro.load(in);
		//this.driverClass = pro.getProperty("jdbc.driverClassName");
                this.driverClass = "org.sqlite.JDBC";
                this.url = "jdbc:sqlite:wangshen.db";
		//this.driverClass = AppConfig.getProperty("jdbcDriver");
		//this.url = AppConfig.getProperty("jdbcUrl");
		//this.url = pro.getProperty("jdbc.url");
		//this.username = pro.getProperty("jdbc.userName");
		//this.username = AppConfig.getProperty("jdbcUserName");
		//this.password = AppConfig.getProperty("jdbcPassword");
		//this.password = pro.getProperty("jdbc.password");
	}

	public Connection openConnection(){
		try {
			Class.forName(driverClass);
			//conn = DriverManager.getConnection(url, username, password);
                        conn = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public void closeConnection(){
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

