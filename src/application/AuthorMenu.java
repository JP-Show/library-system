package application;

import application.utils.DIF;
import application.utils.MenuUtils;
import db.DbException;
import model.entities.Author;

public class AuthorMenu {

    public static void main (){
        System.out.println("Menu of Author");
        System.out.println("1 - add Author");
        System.out.println("2 - edit Author");
        System.out.println("3 - list all Author");
        System.out.println("4 - find author by id");
        byte menuSelected = DIF.sc.nextByte();
        switch (menuSelected){
            case 1:
                addAuthor();
                break;
            case 2:
                updateAuthor();
                break;
            case 3:
                listAllAuthor();
                break;
            case 4:
                listById();
                break;
        }
    }
    public static void addAuthor() throws DbException{
        DIF.AD.insert(MenuUtils.menuReturnAuthor(DIF.ftm, DIF.sc));
    }
    public static void updateAuthor()throws DbException {
        System.out.println("What's his or her id?");
        int id = DIF.sc.nextInt();
        Author author = MenuUtils.menuReturnAuthor(DIF.ftm, DIF.sc);
        author.setId(id);
        DIF.AD.update(author);
    }
    public static void listAllAuthor()throws DbException{
        for(Author author : DIF.AD.findAll()){
            System.out.println(author);
        }
    }
    public static void listById()throws DbException{
        System.out.println("type id's author");
        int id = DIF.sc.nextInt();
        System.out.println(DIF.AD.findById(id));

    }
}
