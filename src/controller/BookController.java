package controller;

import entity.Author;
import entity.Book;
import model.AuthorModel;
import model.BookModel;

import javax.swing.*;
import java.util.List;

public class BookController {
    BookModel objBookModel;

    public BookController(){
        this.objBookModel = new BookModel();
    }

    public void update() {
        //Listamos
        String listBooks = this.getAll(this.objBookModel.findAllBook());

        //Pedimos el id
        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(listBooks +"\nEnter the ID of the Book to edit"));

        //Verificamos el id
        Book objBook = (Book) this.objBookModel.findByIdBook(idUpdate);

        if (objBook == null) {
            JOptionPane.showMessageDialog(null,"Book not found.");
        }else {
            String title = JOptionPane.showInputDialog(null,"Enter new title", objBook.getTitle());
            String publication_date = JOptionPane.showInputDialog(null,"Enter new publication_date", objBook.getPublication_date());
            String price = JOptionPane.showInputDialog(null,"Enter new price", objBook.getPrice());


            objBook.setTitle(title);
            objBook.setPublication_date(publication_date);
            objBook.setPrice(price);

            this.objBookModel.updateBook(objBook);
        }
    }
    public void findByName(){

        String nameBook = JOptionPane.showInputDialog(null, "Enter the name of the Book for search");

        String list = "List Book: \n";

        for (Object obj : this.objBookModel.findByNameBook(nameBook)){

            Book objBook = (Book) obj;
            list += objBook.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, list);
    }
    public void delete() {
        String listaBookString = this.getAll(this.objBookModel.findAllBook());

        int confirm = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listaBookString + " Enter the ID of the Book to delete"));
        Book objBook = (Book) this.objBookModel.findByIdBook(idDelete);

        if (objBook == null) {
            JOptionPane.showMessageDialog(null," Book not found.");
        }else {
            confirm = JOptionPane.showConfirmDialog(null,"Are your sure want to delete the Book: \n" + objBook.toString());

            //Si el usuario escogió que sí, entonces eliminamos
            if (confirm == 0) {
                this.objBookModel.deleteBook(objBook);
            }
        }
    }
    public void getAll(){

        String list = this.getAll(this.objBookModel.findAllBook());

        //Mostramos toda lista
        JOptionPane.showMessageDialog(null, list);

    }
    public String getAll(List<Object> listObject) {
        String list = "List Books \n";

        //Iteramos sobre la lista que devuelve el método find All
        for (Object obj : listObject){

            // Convertimos o castemos el objeto tipo Object a un Book
            Book objBook = (Book) obj;

            //Concatenamos la información
            list += objBook.toString()+ "\n";
        }
        return list;

    }
    public void create(){

        Book objBook = new Book();

        String name = JOptionPane.showInputDialog("Insert Book name: ");
        String nationality = JOptionPane.showInputDialog("Insert Book nationality: ");

        objBook.setTitle(title);
        objBook.setPublication_date(publication_date);
        objBook.setPrice(price);

        objBook = (Book) this.objBookModel.insertBook(objBook);

        JOptionPane.showMessageDialog(null, objBook.toString());

    }
}
