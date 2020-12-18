package model.dao.interfaces;

import java.util.List;

import model.entidades.Contato;

public interface ContatoDao {
	
	List<Contato> encontrarContato(String dadoContato);
	
	void salvarContato(Contato contado);
}
