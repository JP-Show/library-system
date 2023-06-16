package application;

import application.utils.MenuUtils;
import db.DB;
import db.DbException;
import model.dao.AuthorDao;
import model.dao.BooksDao;
import model.dao.DaoFactory;
import model.dao.PublisherDao;
import model.dao.utils.BooksDaoUtils;
import model.entities.Author;
import model.entities.Books;
import model.entities.Publisher;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class MenuBook {
        private static final DateTimeFormatter ftm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        private static final BooksDao BD = DaoFactory.createBooksDao();
        private static final PublisherDao PD = DaoFactory.createPublisherDao();
        private static final AuthorDao AD = DaoFactory.createAuthorDao();
        private static final Scanner sc = new Scanner(System.in);
    public static void main (){
        System.out.println("Menu dos livros");
        System.out.println("1 - add book");
        System.out.println("2 - edit book");
        System.out.println("3 - list all books");
        System.out.println("4 - list by genre");
        System.out.println("5 - list by author");
        byte menuSelected = sc.nextByte();
        switch (menuSelected){
            case 1:
                addBook();
                break;
            case 2:
                editBook();
                break;
            case 3:
                listAllBooks();
                break;
            case 4:
                listByGenreBooks();
                break;
            case 5:
                listByAuthorBooks();
                break;

        }
    }
    public static void addBook() {
        BD.insert(MenuUtils.menuReturnBook(ftm, BD, PD, AD, sc ));

    }
    public static void editBook(){
        BD.update(MenuUtils.menuReturnBook(ftm, BD, PD, AD, sc ));
    }
    public static void listAllBooks() throws DbException{
        try{
         for(Books book : BD.findAll()){
             System.out.println(book);
        }
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public static void listByGenreBooks() throws DbException{
        System.out.println("type genre(EXAMPLE: Fantasy,Horror,Comedy):");
        String genres = sc.next();
        try{
            for(Books book : BD.findByGenre(genres)){
                System.out.println(book);
            }
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public static void listByAuthorBooks() throws DbException{
        Author author = MenuUtils.FindAuthor(sc, AD);
        System.out.println(author);
        System.out.println(author.getId());
        try{
            for(Books book : BD.findByAuthor(author.getId())){
                System.out.println(book);
            }
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
