package br.com.estante.aplicacao;

import java.util.Date;
import java.util.Scanner;

import br.com.estante.dao.LivroDAO;
import br.com.estante.model.Livro;

public class Main {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		LivroDAO livroDao = new LivroDAO();
		
	/*	Livro livro = new Livro();
		System.out.println("Título do livro: ");
		livro.setTitulo(entrada.nextLine());
		System.out.println("Nome do autor: ");
		livro.setAutor(entrada.nextLine());
		livro.setDataCad(new Date()); 

		livroDao.save(livro); */
		
		
		//Update
	/*	Livro l1 = new Livro();
		System.out.println("Título a corrigir: ");
		l1.setTitulo(entrada.nextLine());
		System.out.println("Autor a corrigir: ");
		l1.setAutor(entrada.nextLine());
		l1.setDataCad(new Date());
		System.out.println("ID da obra a corrigir: ");
		l1.setId(entrada.nextInt());
		livroDao.update(l1); */
		
		//Delete by ID
	/*	System.out.println("Deletar registro por ID: ");
		livroDao.deleteById(entrada.nextInt()); */
		
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("--------REGISTRO DE LIVROS--------");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//Exibir dados
		for(Livro l: livroDao.getLivros()) {
			System.out.println("Id: " + l.getId());
			System.out.println("Livro: " + l.getTitulo());
			System.out.println("Autor: " + l.getAutor());
			System.out.println("----------------------------------");
		}
		

	}

}
