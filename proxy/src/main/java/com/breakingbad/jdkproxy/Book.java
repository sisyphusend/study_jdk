package com.breakingbad.jdkproxy;

import java.util.Objects;

public class Book {
    @Override
    public String toString() {
        return "Book{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    private String Id;
    private String name;

    public void setId(String id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public Book(String id, String name) {
        Id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(Id, book.Id) && Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name);
    }
}
