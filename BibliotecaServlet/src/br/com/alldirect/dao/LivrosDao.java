package br.com.alldirect.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.alldirect.connection.Conexao;
import br.com.alldirect.model.Livros;


public class LivrosDao {

	private Connection conecta;

	public LivrosDao() {
		this.conecta = new Conexao().getConnection();
	}

	public void adicionaLivros(Livros livro) {
		String sql = "INSERT INTO LIVROS(ISBN, TITULO, ANO, EDITORA, AUTOR) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement stmt = conecta.prepareStatement(sql);
			stmt.setInt(1, livro.getIsbn());
			stmt.setString(2, livro.getTitulo());
			stmt.setString(3, livro.getAno());
			stmt.setString(4, livro.getEditora());
			stmt.setString(5, livro.getAutor());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Erro ao adicionar produto: " + e);
		}
	}
	
	public List<Livros> listaLivros() {
		String sql = "SELECT * FROM PRODUTOS";
		ArrayList<Livros> livros = new ArrayList<Livros>();
		try {
			PreparedStatement stmt = conecta.prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				Livros livro = new Livros();
				livro.setId(resultSet.getInt("ID"));
				livro.setIsbn(resultSet.getInt("ISBN"));
				livro.setTitulo(resultSet.getString("TITULO"));
				livro.setAno(resultSet.getString("ANO"));
				livro.setEditora(resultSet.getString("Editora"));
				livro.setAutor(resultSet.getString("Autor"));
				
				livros.add(livro);
			}
			return livros;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livros;
	}

	
}
