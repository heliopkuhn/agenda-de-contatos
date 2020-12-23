package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
	private static Connection conn = null;
	//conexao com o banco
	public static Connection getConnection() {
		if(conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url,props);
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}	
		}
		return conn;
	}
	
	
	//fechar conexao com o banco
	public static void closeConection() {
		if(conn!=null) {
			try {
				conn.close();
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	
	//carregar propriedades do banco;
	private static Properties loadProperties() {
		try(FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;
		}
		catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closePreparedStatement(PreparedStatement pst) {
		if(pst!=null) {
			try {
			pst.close();
			}catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
