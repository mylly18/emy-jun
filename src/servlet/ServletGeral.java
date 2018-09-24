package servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comandos.Comando;
import comandos.ComandoAluno;
import comandos.ComandoEmprestimo;
import comandos.ComandoLivro;
import comandos.ListarAluno;
import comandos.ListarLivro;



@WebServlet("/ServletGeral")
public class ServletGeral extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String comando = request.getParameter("comando");
		
		String resposta = null;
		Comando logica = null;

		
		try {
			Class clazz = Class.forName("comandos." + comando);
			logica = (Comando) clazz.newInstance();
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			
			e.printStackTrace();
		}
		
		try {
			resposta = logica.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(resposta);
		rd.forward(request, response);
		
	}
       
   
    
}
