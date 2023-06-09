package application;


import model.dao.AuthorDao;
import model.dao.DaoFactory;
import model.dao.GenreDao;
import model.entities.Author;
import model.entities.Books;
import model.entities.Genre;

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

        List<Books> list = new ArrayList<>();

        authorDao.insert(new Author(null, "Re:Zero", LocalDate.parse("01/04/2022", ftm), LocalDate.parse("01/04/2000", ftm), list));
    }

}
