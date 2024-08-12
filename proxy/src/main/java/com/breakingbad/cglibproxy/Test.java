package com.breakingbad.cglibproxy;

import com.breakingbad.jdkproxy.Book;
import com.breakingbad.jdkproxy.BookFacadeImpl;

public class Test {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        BookFacadeImpl proxy = (BookFacadeImpl) proxyFactory.bind(new BookFacadeImpl());
        proxy.addBook(new Book("100","天书"));
    }
}
