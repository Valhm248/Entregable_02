package entity;

import java.util.Date;

public class Book {
    private int id_book;
    private String title;
    private Date publication_date;
    private double price;
    private int id;

    public Book() {

    }

    public Book(int idBook, String title, Date yearPublication, double price, int id) {
        this.id_book = idBook;
        this.title = title;
        this.publication_date = yearPublication;
        this.price = price;
        this.id = id;
    }

    public int getIdBook() {
        return id_book;
    }

    public void setIdBook(int idBook) {
        this.id_book = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public java.sql.Date getPublication_date() {
        return (java.sql.Date) publication_date;
    }

    public void setPublication_date(Date publication_date) {
        this.publication_date = publication_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + id_book +
                ", title='" + title + '\'' +
                ", Publication_date=" + publication_date +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}
