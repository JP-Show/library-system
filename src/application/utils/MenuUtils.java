package application.utils;

import db.DB;
import db.DbException;
import model.dao.AuthorDao;
import model.dao.BooksDao;
import model.dao.DaoFactory;
import model.dao.PublisherDao;
import model.entities.Author;
import model.entities.Books;
import model.entities.Publisher;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class MenuUtils {
    public static Books menuReturnBook(DateTimeFormatter ftm, BooksDao BD, PublisherDao PD, AuthorDao AD, Scanner sc) throws DbException {
        try {
            System.out.println("name");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("description");
            String desc = sc.nextLine();
            System.out.println("genre");
            String genre = sc.nextLine();
            System.out.println("Publisher");
            Publisher pub = null;
            System.out.println("This book has a Publisher? (y/n)");
            char hasPub = sc.next().charAt(0);
            if (hasPub == 'y') {
                System.out.println("Type Publisher's id, (if you not remember id, type '-1'): ");

                int idPub = sc.nextInt();
                if (idPub < 0) {
                    System.out.println("Y");
                } else {
                    pub = PD.findById(idPub);
                }
            }
            System.out.println("Publisher's date");
            LocalDate date = LocalDate.parse(sc.next(), ftm);
            System.out.println("Type author's id, (if you not remember id, type '-1'): ");
            Author author = null;
            int idAuthor = sc.nextInt();
            if (idAuthor < 0) {
                System.out.println("Y");
            } else {
                author = AD.findById(idAuthor);
            }
            return new Books(null, name, desc, genre, pub, date, author);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public static Author FindAuthor(Scanner sc, AuthorDao AD){
        System.out.println("Type author's id, (if you not remember id, type '-1'): ");
        Author author = null;
        int idAuthor = sc.nextInt();
        if (idAuthor < 0) {
            System.out.println("Y");
            //function will list all author with id
        } else {
            author = AD.findById(idAuthor);
        }
        return author;
    }
}