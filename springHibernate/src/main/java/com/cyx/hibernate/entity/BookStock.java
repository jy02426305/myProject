package com.cyx.hibernate.entity;

import java.util.Objects;

public class BookStock {
    private int id;
    private Integer stock;
    private Integer bookId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookStock bookStock = (BookStock) o;
        return id == bookStock.id &&
                Objects.equals(stock, bookStock.stock) &&
                Objects.equals(bookId, bookStock.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stock, bookId);
    }
}
