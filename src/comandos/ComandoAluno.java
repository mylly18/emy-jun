package comandos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.AlunoDAO;
import models.Aluno;

public class ComandoAluno implements Comando {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String nome = request.getParameter("nome");
		int matricula = Integer.parseInt(request.getParameter("matricula"));
		String endereco = request.getParameter("endereco");
		String dataNascimento = request.getParameter("dataNascimento");
		String cpf = request.getParameter("cpf");
		
		
		Calendar dataFinal = null;
		try {
			Date dataProvisoria = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
			dataFinal = Calendar.getInstance();
			dataFinal.setTime(dataProvisoria);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Aluno aluno = new Aluno();
		
		aluno.setNome(nome);
		aluno.setMatricula(matricula);
		aluno.setEndereco(endereco);
		aluno.setDataNascimento(dataFinal);
		aluno.setCpf(cpf);
		
		AlunoDAO dao = new AlunoDAO();
		dao.inserir(aluno);
        
		RequestDispatcher rd = request.getRequestDispatcher("AlunoCadastrado.jsp");
        rd.forward(request, response);
		return nome;	
	}

}
