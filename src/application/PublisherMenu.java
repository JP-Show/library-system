package application;

import application.utils.DIF;
import db.DbException;
import model.entities.Publisher;

public class PublisherMenu {
    public static void menu (){
        System.out.println("Mene of Publishers");
        System.out.println("1 - add Publishers");
        System.out.println("2 - edit Publishers");
        System.out.println("3 - list all Publishers");
        System.out.println("4 - find Publishers by ID");
        byte menuSelected = DIF.sc.nextByte();
        switch (menuSelected) {
            case 1 -> addPublisher();
            case 2 -> editPub();
            case 3 -> listAllPub();
            case 4 -> findPubById();
        }
    }
    public static void addPublisher() throws DbException {
        System.out.println("name");
        DIF.PD.insert(new Publisher(null ,DIF.sc.nextLine()));
    }
    private static void editPub() {
        System.out.println("Publisher's ID");
        int id = DIF.sc.nextInt();
        System.out.println("name");
        DIF.PD.update(new Publisher(id ,DIF.sc.nextLine()));
    }
    private static void findPubById() {
        System.out.println("type Publisher's ID");
        System.out.println(DIF.sc.nextInt());

    }
    private static void listAllPub() {
        for (Publisher pub:
                DIF.PD.findAll()) {
            System.out.println(pub);
        }
    }
}
