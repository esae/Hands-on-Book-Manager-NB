/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.fhnw.esae.bookmanager.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ch.fhnw.esae.bookmanager.business.BookEJB;
import ch.fhnw.esae.bookmanager.domain.Book;

/**
 *
 * @author andreas.martin
 */
@Named
@RequestScoped
public class BookController {

    public BookController() {
    }
    @EJB
    private BookEJB bookEJB;
    private Book book = new Book();
    private List<Book> bookList = new ArrayList<>();

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBookList() {
        bookList = bookEJB.findBooks();
        return bookList;
    }

    public String doCreateBook() {
        book = bookEJB.createBook(book);
        bookList = bookEJB.findBooks();
        return "doCreateBook_success";
    }
    
    public String shouldCreateBook() {
        return "shouldCreateBook";
    }
}

