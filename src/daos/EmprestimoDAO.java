package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import daos.ConnectionFactory;
import models.Aluno;
import models.Emprestimo;
import models.Livro;

public class EmprestimoDAO {
	private Connection connection;
	
	public EmprestimoDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	
    public boolean estarEmprestado(int id) {
    	String sql = "select emprestimo.id_livro, data_davolucao from emprestimo where emprestimo.id_livro = ?;";
    	
    	try {
    		PreparedStatement stmt = connection.prepareStatement(sql);
    		stmt.setInt(1, id);
    		ResultSet rs = stmt.executeQuery();
    	
    	if(rs.next()) {
    		return true;
    	}
    	stmt.close();
    	rs.close();
    	}catch (SQLException e) {
    		e.printStackTrace();
    		return false;
    	}
    	
    	return true;
    }


	public boolean inserir(Emprestimo e) {
		
		String sql = "INSERT INTO emprestimos (matricula_aluno, id_livro, data_emprestimo, data_davolucao) VALUES ( ?, ?, ?, null);";
		try {
    		PreparedStatement stmt = connection.prepareStatement(sql);
    		stmt.setInt(1, e.getMatriculaAluno());
    		stmt.setInt(2, e.getIdLivro());
    		stmt.setDate(3, new java.sql.Date(e.getDataEmprestimo().getTimeInMillis()));
    		stmt.execute();
	    	stmt.close();
    	}catch (SQLException exc) {
    		exc.printStackTrace();
    		return false;
    	}
		return true;
	}
	
	public List<Emprestimo> getLista() {
		List<Emprestimo> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimos;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Emprestimo e = new Emprestimo();
				
				e.setIdLivro(rs.getInt("id_livro"));
				e.setMatriculaAluno(rs.getInt("matricula_aluno"));
				
				Calendar datae = Calendar.getInstance();
				datae.setTime(rs.getDate("data_emprestimo"));
				e.setDataEmprestimo(datae);
				
				result.add(e);
			}
		
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}


	public boolean getListaByAluno(Livro livro) {
		
		return true;
	}
}