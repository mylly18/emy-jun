package models;

import java.util.Calendar;
import java.util.List;

import daos.EmprestimoDAO;

public class Aluno {

	private static final List<Emprestimo> emprestimo = null;
	private String nome;
	private int matricula;
	private String endereco;
	private Calendar dataNascimento;
	private String cpf;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<Emprestimo> getEmprestimo(){
		return emprestimo;
	}
	public boolean isStatus(){
		for(Emprestimo e : this.getEmprestimo()){
			if(!e.isStatus()){
				return e.isStatus();
			}
	

}
		return true;
	}
}
