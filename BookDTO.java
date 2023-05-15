package DTO;

public class BookDTO {
    //java bean clas ==> DTO class
    private int bookId;
    private String bookName;
    private double bookPrice;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice;
    }
}
