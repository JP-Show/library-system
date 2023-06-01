package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Author;
import model.entities.Books;

public class Program {

	public static void main(String[] args) {
		Author author = new Author(2, "Andre", LocalDate.now(), LocalDate.now(), null);
		Books books = new Books(1, "Elder", "Um livro muito legal e divertido", "", null, null, author);
		
	}

}
