package application;


import model.dao.AuthorDao;
import model.dao.BooksDao;
import model.dao.DaoFactory;
import model.dao.GenreDao;
import model.entities.Author;
import model.entities.Books;
import model.entities.Genre;
import model.entities.Publisher;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Program {


    public static void main(String[] args) {
        DateTimeFormatter ftm = DateTimeFormatter.ofPattern("dd/MM/yyyy");


//		Author author = new Author(2, "Andre", LocalDate.now(), LocalDate.now(), null);
//		Books books = new Books(1, "Elder", "Um livro muito legal e divertido", "", null, null, author);

        GenreDao genreDao = DaoFactory.createGenreDao();

//        genreDao.insert(new Genre(null, "Drama"));
//        genreDao.update(new Genre(19, "Fantasy"));
//        genreDao.deleteByName("Drama");
//        for(Genre pub2 : genreDao.findAll()){
//            System.out.println(pub2.toString());
//        }
        AuthorDao authorDao = DaoFactory.createAuthorDao();


//        authorDao.insert(new Author(null, "Tappei Nagatsuki", LocalDate.parse("01/04/2022", ftm),null , list));
//        authorDao.update(new Author(1, "Tappei Nagatsuki", LocalDate.parse("01/04/2022", ftm),null , list));
        //authorDao.deleteById(4);
//       System.out.println(authorDao.findById(1));
        //List<Author> list = new ArrayList<>();
        //list = authorDao.findAll();

//        for (Author author: list) {
//            System.out.println(author);
//        }
        List<Books> list = new ArrayList<>();
        Author author = new Author(1, "Tappei", LocalDate.parse("01/04/1982", ftm), null, list);
        Publisher pub = new Publisher(1, "KADOKAWA");
        Books book = new Books(3, "re:zero", "um grande livro do escritor Tappei, Livro de volta no tempo", "Fantasia, viagem no tempo, isekai", pub,LocalDate.parse("01/04/2015", ftm),author  );

        BooksDao booksDao = DaoFactory.createBooksDao();

        booksDao.deleteByName("re:zero");

    }

}
