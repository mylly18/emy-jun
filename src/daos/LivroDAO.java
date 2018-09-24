package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import models.Livro;

public class LivroDAO {

	private Connection connection;

	public LivroDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Livro livro) {

		String sql = "insert into livro (titulo, autor, editora, anoDePublicacao, edicao) values (?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getEditora());
			stmt.setInt(4, livro.getAnoPublicacao());
			stmt.setString(5, livro.getEdicao());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Livro> getLista() {
		List<Livro> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from livro;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Livro livro = new Livro();
				
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setEditora(rs.getString("editora"));
				livro.setAnoPublicacao(rs.getInt("anoDePublicacao"));
				livro.setEdicao(rs.getString("edicao"));
				// adicionando o objeto � lista
				result.add(livro);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean alterar(Livro livro) {
		String sql = "update livro set titulo=?, autor=?, editora=?, anoPublicacao=?, edicao=? where titulo=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getEditora());
			stmt.setInt(4, livro.getAnoPublicacao());
			stmt.setString(5, livro.getEdicao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Livro livro) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from livro where titulo=?;");
			stmt.setString(1, livro.getTitulo());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Livro getByTitulo(Object titulo) {
		Livro result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from aluno where matricula = ?;");
			stmt.setString(1, (String) titulo);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				result = new Livro();
				
				result.setTitulo(rs.getString("titulo"));
				result.setAutor(rs.getString("autor"));
				result.setEditora(rs.getString("editora"));
				result.setAnoPublicacao(rs.getInt("anoPublicacao"));
				result.setEdicao(rs.getString("edicao"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}


	public boolean livroEstaEmprestado(String titulo) {
		
		return false;
	}

	public Livro getLivroPeloTitulo(String titulo) {
		Livro l = null;
		
		String sql = "select * from livro";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if(rs.getString("titulo").equals(titulo)) {
					l = new Livro();
					l.setId(rs.getInt("id"));
					l.setTitulo(rs.getString("titulo"));
				}
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return l;
	}
}
