package application.utils;

import model.dao.AuthorDao;
import model.dao.BooksDao;
import model.dao.DaoFactory;
import model.dao.PublisherDao;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DIF {
    public static final DateTimeFormatter ftm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final BooksDao BD = DaoFactory.createBooksDao();
    public static final PublisherDao PD = DaoFactory.createPublisherDao();
    public static final AuthorDao AD = DaoFactory.createAuthorDao();
    public static final Scanner sc = new Scanner(System.in);
}
