package br.com.estante.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.estante.factory.ConnectionFactory;
import br.com.estante.model.Livro;

public class LivroDAO {
	
	public void save(Livro livro) {
		
		String sql = "INSERT INTO livro(titulo, autor, dataCad) VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, livro.getTitulo());
			pstm.setString(2, livro.getAutor());
			pstm.setDate(3, new Date(livro.getDataCad().getTime()));
			
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
			
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	public void update(Livro livro) {

		String sql = "UPDATE livro SET titulo = ?, autor = ?, datacad = ? " +
					 "WHERE id = ? ";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, livro.getTitulo());
			pstm.setString(2, livro.getAutor());
			pstm.setDate(3, new Date(livro.getDataCad().getTime()));
			
			//Id do registro para atualizar
			pstm.setInt(4, livro.getId());
			
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}

	
	public void deleteById(int id) {
		String sql = "DELETE FROM livro WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public List<Livro> getLivros() {
		
		String sql = "SELECT * FROM livro";
		
		List<Livro> livros = new ArrayList<Livro>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//Classe que recupera os dados do banco - select
		ResultSet rset = null; 
		
		try {
			conn =  ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Livro livro = new Livro();
				
				livro.setId(rset.getInt("id"));
				livro.setTitulo(rset.getString("titulo"));
				livro.setAutor(rset.getString("autor"));
				livro.setDataCad(rset.getDate("dataCad"));
				
				livros.add(livro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset != null) {
					rset.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return livros;
		
	}

	
	
}