package com.breakingbad.jdkproxy;

import java.util.HashSet;
import java.util.Iterator;

public class BookFacadeImpl implements BookFacade{

    static HashSet<Book> set;

    static{
        set = new HashSet<Book>();
        set.add(new Book("1","倚天屠龙记"));
        set.add(new Book("2","射雕英雄传"));
        set.add(new Book("3","神雕侠侣"));
    }
    @Override
    public Boolean addBook(Book book) {
        if(BookFacadeImpl.set.contains(book)) {
            System.out.println("书已经存在");
            return false;
        }
        BookFacadeImpl.set.add(book);
        System.out.println("添加: " + book);
        return true;
    }

    public Book queryBook(String id) {
        Iterator iterator = BookFacadeImpl.set.iterator();
        if(iterator.hasNext()){
            Book book = (Book) iterator.next();
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }
}
