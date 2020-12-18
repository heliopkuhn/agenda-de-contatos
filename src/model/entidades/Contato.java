package model.entidades;

import java.io.Serializable;

public class Contato implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id_contato;
	private String nm_contato;
	private String tel_cel_contato;
	private String email_contato;
	
	public Contato() {
		
	}
	
	public Contato(Integer id_contato, String nm_contato, String tel_cel_contato, String email_contato) {
		this.id_contato = id_contato;
		this.nm_contato = nm_contato;
		this.tel_cel_contato = tel_cel_contato;
		this.email_contato = email_contato;
	}

	public Integer getId_contato() {
		return id_contato;
	}

	public void setId_contato(Integer id_contato) {
		this.id_contato = id_contato;
	}

	public String getNm_contato() {
		return nm_contato;
	}

	public void setNm_contato(String nm_contato) {
		this.nm_contato = nm_contato;
	}

	public String getTel_cel_contato() {
		return tel_cel_contato;
	}

	public void setTel_cel_contato(String tel_cel_contato) {
		this.tel_cel_contato = tel_cel_contato;
	}

	public String getEmail_contato() {
		return email_contato;
	}

	public void setEmail_contato(String email_contato) {
		this.email_contato = email_contato;
	}
	@Override
	public String toString() {
		return " NOME: " + nm_contato + ", E-MAIL: " + email_contato + ", TELEFONE CELULAR: " + tel_cel_contato;
	}
}
