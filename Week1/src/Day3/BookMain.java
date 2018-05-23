/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;

/**
 *
 * @author cb-sudarshan
 */
public class BookMain {
    
    private final String name;
    private final Author[] authors;
    private double price;
    private int qtyInStock;

    public BookMain(String name, Author[] authors, double price, int qtyInStock) {
        int iter = 0;
        this.name = name;
        this.price = price;
        this.qtyInStock = qtyInStock;
        this.authors =new Author[authors.length];
        for(Author a : authors)
            this.authors[iter++] = a;
    }
    
    public BookMain(String name, Author author, double price, int qtyInStock) {
        int iter = 0;
        this.name = name;
        this.price = price;
        this.qtyInStock = qtyInStock;
        this.authors = new Author[1];
        this.authors[0] = author;
    }

    public String getName() {
        return name;
    }
    
    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }
    
    public String toDisplay(){
        String temp = "";
        for(Author author : authors){
            temp += author.toDisplay();
            temp += ", ";
        }
        return " Name : " + this.name + " by " + temp + " \n Price : $" + this.price;  
    }
    
    public static void main(String[] args){
        
        Author[] author = new Author[2];
        author[0] = new Author("R.K. Narayan", "rknarayan@gmail.com", 'M');
        System.out.println(author[0].toDisplay());
        author[0].setEmail("rknarayan@hotmail.com");
        System.out.println(author[0].toDisplay());
        
        author[1] = new Author("J.K. Narayani", "jknarayani@gmail.com", 'F');
        BookMain book = new BookMain("The Wall",author,1200,2000);
        System.out.println(book.toDisplay());
    }
}
