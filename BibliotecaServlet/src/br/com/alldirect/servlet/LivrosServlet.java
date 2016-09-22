package br.com.alldirect.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alldirect.dao.LivrosDao;
import br.com.alldirect.model.Livros;


@WebServlet("/LivrosServlet")
public class LivrosServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 int isbn = Integer.parseInt(req.getParameter("isbn"));
		 String titulo = req.getParameter("titulo");
		 String ano = req.getParameter("ano");
		 String editora = req.getParameter("editora");
		 String autor = req.getParameter("autor");
		
		
		Livros livro = new Livros();
		
		
		LivrosDao livroDao = new LivrosDao();
		livroDao.adicionaLivros(livro);
	}
	
	
}
