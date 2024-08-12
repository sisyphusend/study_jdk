package com.breakingbad.jdkproxy;

public interface BookFacade {
    public Boolean addBook(Book book);
    public Book queryBook(String id);
}
