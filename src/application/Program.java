package application;


import db.DB;

import java.util.Scanner;


public class Program {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte menuSelected = -1;
        try{
            while(menuSelected != 0) {
                System.out.println("Bem-vindo a Biblioteca virtual :)");
                System.out.println("1 - Livros");
                System.out.println("2 - Autor");
                System.out.println("3 - Publicadora");
                menuSelected = sc.nextByte();
                switch (menuSelected) {
                    case 1 -> MenuBook.menu();
                    case 2 -> AuthorMenu.menu();
                    case 3 -> PublisherMenu.menu();
                    default -> System.out.println("invalido! Não existe essa sessão");
                }
            }
        }finally {
            DB.closeConnection();
        }

    }

}
