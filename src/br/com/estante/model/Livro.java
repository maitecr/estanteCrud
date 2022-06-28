package br.com.estante.model;

import java.util.Date;

public class Livro {

	private int id;
	private String titulo;
	private String autor;
	private Date dataCad;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Date getDataCad() {
		return dataCad;
	}
	public void setDataCad(Date dataCad) {
		this.dataCad = dataCad;
	}
}
