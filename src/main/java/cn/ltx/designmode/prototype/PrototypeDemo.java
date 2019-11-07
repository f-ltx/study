package cn.ltx.designmode.prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypeDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Book b1 = new Book();
        b1.setTitle("书1");
        b1.getImages().add("图1-1");
        System.out.println(b1);
        Book b2 = b1.clone();
        b2.setTitle("书2");
        b2.getImages().add("图2-1");
        System.out.println(b2);
        System.out.println(b1);
        System.out.println("==============================");
        Person p1 = new Person();
        p1.setName("人1");
        p1.setAge(10);
        p1.setBook(b1);
        System.out.println(p1);
        Person p2 = p1.clone();
        p2.setName("人2");
        p2.setAge(20);
        p2.getBook().setTitle("hahah");
        p2.getBook().getImages().add("hahah");
        System.out.println(p2);
        System.out.println(p1);
    }
}

class Book implements Cloneable {

    private String title;
    private List<String> images = new ArrayList<>();

    @Override
    protected Book clone() throws CloneNotSupportedException {
        return (Book) super.clone();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", images=" + images +
                '}';
    }
}
class Person implements Cloneable{
    private String name ;
    private int age;
    private Book book;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", book=" + book +
                '}';
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        Person clone = (Person) super.clone();
        Book book = clone.getBook();
        clone.setBook(book.clone());
        return clone;
    }
}