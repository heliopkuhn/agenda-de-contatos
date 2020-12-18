package aplication;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import model.dao.implement.ContatoImpJdbc;
import model.dao.interfaces.ContatoDao;
import model.entidades.Contato;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = DB.getConnection();
		
		ContatoDao contatojdbl = new ContatoImpJdbc(conn);
		
		List<Contato> listaContato = new ArrayList<>();
		
		listaContato = contatojdbl.encontrarContato("RAFA@");
		
		for(Contato contato : listaContato) {
			System.out.println(contato);
		}
	
		DB.closeConection();
	
	}

}
