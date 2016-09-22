package br.com.alldirect.util;

import br.com.alldirect.dao.LivrosDao;
import br.com.alldirect.model.Livros;

public class TesteConnection {
	
	public static void main(String[] args) {

		Livros livro = new Livros();
		livro.setIsbn(1324556);
		livro.setTitulo("Como Programar em 10 passos");
		livro.setAno("12/56/1999");
		livro.setEditora("Trebson");
		livro.setAutor("Blebs");

		LivrosDao livroDao = new LivrosDao();
		livroDao.adicionaLivros(livro);

	}
	
	
}
