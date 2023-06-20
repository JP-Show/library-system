package application;

import application.utils.DIF;
import application.utils.MenuUtils;
import db.DbException;
import model.entities.Author;
import model.entities.Books;

public class MenuBook {

    public static void menu (){
        System.out.println("Menu dos livros");
        System.out.println("1 - add book");
        System.out.println("2 - edit book");
        System.out.println("3 - list all books");
        System.out.println("4 - list by genre");
        System.out.println("5 - list by author");
        byte menuSelected = DIF.sc.nextByte();
        switch (menuSelected) {
            case 1 -> addBook();
            case 2 -> editBook();
            case 3 -> listAllBooks();
            case 4 -> listByGenreBooks();
            case 5 -> listByAuthorBooks();
        }
    }
    public static void addBook() {
        DIF.BD.insert(MenuUtils.menuReturnBook(DIF.ftm, DIF.PD, DIF.AD, DIF.sc ));

    }
    public static void editBook(){
        System.out.println("What's book's id?");
        int id = DIF.sc.nextInt();
        Books book = MenuUtils.menuReturnBook(DIF.ftm, DIF.PD, DIF.AD, DIF.sc);
        book.setId(id);
        DIF.BD.update(book);
    }
    public static void listAllBooks() throws DbException{
        try{
         for(Books book : DIF.BD.findAll()){
             System.out.println(book);
        }
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public static void listByGenreBooks() throws DbException{
        System.out.println("type genre(EXAMPLE: Fantasy,Horror,Comedy):");
        String genres = DIF.sc.next();
        try{
            for(Books book : DIF.BD.findByGenre(genres)){
                System.out.println(book);
            }
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public static void listByAuthorBooks() throws DbException{
        Author author = MenuUtils.FindAuthor(DIF.sc, DIF.AD);
        System.out.println(author);
        System.out.println(author.getId());
        try{
            for(Books book : DIF.BD.findByAuthor(author.getId())){
                System.out.println(book);
            }
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
