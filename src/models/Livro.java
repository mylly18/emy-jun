package models;

import java.util.Calendar;

import daos.EmprestimoDAO;

public class Livro {
	private int id;
	private String titulo;
	private String autor;
	private String editora;
	private int anoPublicacao;
	private String edicao;
	
	
	
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
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String Edicao) {
		this.edicao = Edicao;
	}

	}

