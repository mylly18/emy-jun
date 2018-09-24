package models;

import java.util.Calendar;

public class Emprestimo {
	public final static int DIAS_DE_DURACAO = 14;
	public final static int MAXIMO_ALUNO = 3;
	
	int idLivro;
	int matriculaAluno;
	Calendar dataEmprestimo;
	Calendar dataDevolucao = null;
    boolean status;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getIdLivro() {
	 return idLivro;
 }
	public void setIdLivro(int idLivro) {
	 this.idLivro = idLivro;
 }
	public int getMatriculaAluno() {
	return matriculaAluno;
 }
	public void setMatriculaAluno(int matriculaAluno) {
	 this.matriculaAluno = matriculaAluno;
 }
	public Calendar getDataEmprestimo() {
	 return dataEmprestimo;
 }
	public void setDataEmprestimo(Calendar dataEmprestimo) {
	 this.dataEmprestimo = dataEmprestimo;
 }
	public Calendar getDataDevolucao() {
	 return dataDevolucao;
 }
	public void setDataDevolucao(Calendar dataDevolucao) {
	 this.dataDevolucao = dataDevolucao;
 }
}
