package com.cyx.hibernate.entity;

import java.util.Objects;

public class BookShop {
    private int id;
    private String bookName;
    private Integer price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookShop bookShop = (BookShop) o;
        return id == bookShop.id &&
                Objects.equals(bookName, bookShop.bookName) &&
                Objects.equals(price, bookShop.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, price);
    }
}
