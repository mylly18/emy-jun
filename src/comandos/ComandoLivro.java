package comandos;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.LivroDAO;
import models.Livro;

public class ComandoLivro implements Comando {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {

		
//		int id = Integer.parseInt(request.getParameter("id"));
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String editora = request.getParameter("editora");
		int anoPublicacao = Integer.parseInt(request.getParameter("anoPublicacao"));
		String edicao = request.getParameter("edicao");
		
		Livro livro = new Livro();
		
//		livro.setId(id);
		livro.setTitulo(titulo);
		livro.setAutor(autor);
		livro.setEditora(editora);
		livro.setAnoPublicacao(anoPublicacao);
		livro.setEdicao(edicao);
		
		LivroDAO dao = new LivroDAO();
		
		dao.inserir(livro);
		
		RequestDispatcher rd = request.getRequestDispatcher("LivroCadastrado.jsp");
		rd.forward(request, response);
		return titulo;
	}
}
