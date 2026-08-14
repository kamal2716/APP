class Book{
    String title,author;
    int price;
    void disp(){
        System.out.print("Title : " + title);
        System.out.print("\nAuthor: " + author);
        System.out.print("\nPrice : " + price);
    }
    public static void main(String[] args) {
        Book b1 = new Book();
        b1.title="Book title";
        b1.author="author of book";
        b1.price= 155;
        b1.disp();
    }
}
