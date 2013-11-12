package com.youtube.dao;

import javax.naming.*;
import javax.sql.*;

public class OracleDao {

	private static DataSource OracleDao = null;
	private static Context context = null;

	public static DataSource OracleDaoConn() throws Exception {

		if (OracleDao != null) {
			return OracleDao;
		}

		try {
			if (context == null) {
				context = new InitialContext();
			}

			OracleDao = (DataSource) context.lookup("ipdexdev");
		} catch (Exception e) {

		}
		return OracleDao;
	}

}
