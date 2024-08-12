package com.breakingbad.jdkproxy;

public class Test {
    public static void main(String[] args) {
        BookFacadeImpl bookFacade = new BookFacadeImpl();
        ProxyFactory proxyFactory = new ProxyFactory();
        BookFacade bookFacadeProxy = (BookFacade) proxyFactory.bind(bookFacade);

        bookFacadeProxy.addBook(new Book("1","鹿鼎记"));

        bookFacadeProxy.addBook(new Book("1","倚天屠龙记"));

        Book book1 = (Book) bookFacadeProxy.queryBook("2");
        System.out.println(book1);

    }
}
