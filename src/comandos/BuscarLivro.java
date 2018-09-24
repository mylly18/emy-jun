package comandos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.LivroDAO;
import models.Livro;

public class BuscarLivro implements Comando {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		LivroDAO dao = new LivroDAO();
		Livro l = dao.getLivroPeloTitulo(titulo);
		List<Livro> livros = new ArrayList<>();
		
		if(l == null) {
			return "livroNaoEncontrado.html";
		}
		livros.add(l);
		request.setAttribute("livros", livros);
		
		return "FormularioEmprestimo.jsp";
	}
}
