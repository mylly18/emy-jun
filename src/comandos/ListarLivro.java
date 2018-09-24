package comandos;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.LivroDAO;
import models.Aluno;
import models.Livro;

public class ListarLivro implements Comando {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		LivroDAO dao = new LivroDAO();
		
		List<Livro> lista = dao.getLista();
		
		request.setAttribute("livros", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("ListarLivro.jsp");
		rd.forward(request, response);
		return "ListarLivro.jsp";
	}
}
