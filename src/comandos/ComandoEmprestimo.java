package comandos;


import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.EmprestimoDAO;
import daos.LivroDAO;
import models.Emprestimo;
import models.Livro;


public class ComandoEmprestimo implements Comando {
	
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)  throws Exception { 
        String titulo = request.getParameter("tituloBusca");
        int matricula = Integer.parseInt(request.getParameter("matricula"));
        
        
        LivroDAO dao = new LivroDAO();
        
		Livro livro = dao.getLivroPeloTitulo(titulo);
        
        EmprestimoDAO edao = new EmprestimoDAO();
        
        if(dao.livroEstaEmprestado(livro.getTitulo())) {
        	return "NaoEmprestado.jsp";
        }else {
        	Emprestimo e = new Emprestimo();
        	
        	e.setIdLivro(livro.getId());
			e.setMatriculaAluno(matricula);
			Calendar dataEmpretimo = Calendar.getInstance();
			e.setDataEmprestimo(dataEmpretimo);
        	
			if(edao.inserir(e)) {
				return "livroEmprestado.jsp";
			}
			return "NaoEmprestado.jsp";
        }
    }
}
