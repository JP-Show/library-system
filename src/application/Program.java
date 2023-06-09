package application;


import model.dao.DaoFactory;
import model.dao.GenreDao;
import model.entities.Author;
import model.entities.Books;
import model.entities.Genre;


public class Program {


	public static void main(String[] args) throws ClassNotFoundException {

//		Author author = new Author(2, "Andre", LocalDate.now(), LocalDate.now(), null);
//		Books books = new Books(1, "Elder", "Um livro muito legal e divertido", "", null, null, author);
	
		GenreDao genreDao = DaoFactory.createGenreDao();
		
		genreDao.insert(new Genre(null, "Drama"));
	
	}

}
