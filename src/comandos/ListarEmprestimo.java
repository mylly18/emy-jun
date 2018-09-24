package comandos;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.AlunoDAO;
import daos.EmprestimoDAO;
import models.Aluno;
import models.Emprestimo;

public class ListarEmprestimo implements Comando {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {

	    EmprestimoDAO dao = new EmprestimoDAO();
		
		List<Emprestimo> lista = dao.getLista();
		
		request.setAttribute("emprestimo", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("ListarEmprestimo.jsp");
		rd.forward(request, response);
		return "ListarEmprestimo.jsp";
	}
}
