package comandos;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Aluno;
import daos.AlunoDAO;
import models.Aluno;

public class ListarAluno implements Comando {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {

		AlunoDAO dao = new AlunoDAO();
		
		List<Aluno> lista = dao.getLista();
		
		request.setAttribute("alunos", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("ListarAluno.jsp");
		rd.forward(request, response);
		return "ListarAluno.jsp";
	}
}
