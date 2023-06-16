package application;


import db.DB;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Program {


    public static void main(String[] args) {
        DateTimeFormatter ftm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
                    case 1:
                        MenuBook.main();
                        break;
                    default:
                        System.out.println("invalido! Não existe essa sessão");
                        break;
                }
            }
        }finally {
            DB.closeConnection();
        }

    }

}
