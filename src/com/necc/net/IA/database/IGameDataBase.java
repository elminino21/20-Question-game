package com.necc.net.IA.database;

import java.sql.ResultSet;

public interface IGameDataBase {
	
	ResultSet getRow(long rowid);
	ResultSet desisplayAll() ;

}
