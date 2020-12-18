package model.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbException;
import model.dao.interfaces.ContatoDao;
import model.entidades.Contato;

public class ContatoImpJdbc implements ContatoDao {
	private Connection conn = null;
	
	public ContatoImpJdbc(Connection conn) {
		this.conn = conn;
	}
	
	public List<Contato> encontrarContato(String dadoContato) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			ps = conn.prepareStatement("select nm_contato,tel_cel_contato, email_contato from tb_contato where " + 
					"email_contato like ? " + 
					"or nm_contato like ? " + 
					"or tel_cel_contato like ? "
					+ "ORDER BY nm_contato");
			ps.setString(1, "%" +dadoContato + "%");
			ps.setString(2, "%" +dadoContato + "%");
			ps.setString(3, "%" +dadoContato + "%");
			rs = ps.executeQuery();
			List<Contato> listaContato = new ArrayList<>();
			while(rs.next()) {
				Contato contato = new Contato();
				contato.setNm_contato(rs.getString("nm_contato"));
				contato.setTel_cel_contato(rs.getString("tel_cel_contato"));
				contato.setEmail_contato(rs.getString("email_contato"));
				listaContato.add(contato);
				}
			return listaContato;
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
	}

	@Override
	public void salvarContato(Contato contado) {
		//
		
	}

}
