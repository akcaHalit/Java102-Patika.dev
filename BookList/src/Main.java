import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		ArrayList<Book> bookList = new ArrayList<>();
	    bookList.add(new Book("�al�ku�u", 541, "Re�at Nuri G�ntekin", 1922));
	    bookList.add(new Book("Beyaz Zambaklar �lkesinde", 248, "Grigoriy Petrov", 1923));
	    bookList.add(new Book("Aylak Adam", 192, "Yusuf Atilgan", 1959));
	    bookList.add(new Book("Bu Ulke", 339, "Cemil Meric", 1975));
	    bookList.add(new Book("Sol Aya��m", 89, "Christy Brown", 1985));
	    bookList.add(new Book("D�n���m", 160, "Franz Kafka", 1940));
	    bookList.add(new Book("Siyah �nci", 150, "Anna Sewell", 2014));
	    bookList.add(new Book("Y�lk� At�", 95, "Peyami Safa", 1977));
	    bookList.add(new Book("Ate� ve Kan", 800, "George R. R. Martin", 2020));
	    bookList.add(new Book("Momo", 119, "Ende", 1980));
	    
        System.out.println("-----------------------------------------------------------------");

        Map<String,String> bookMap = new HashMap<>();
        
        bookList.stream().forEach(book -> bookMap.put(book.getBookName(), book.getAuthor()));
	    
        for(String i : bookMap.keySet()) {
        	System.out.println("Author: "+bookMap.get(i)+" Book: "+ i);
        }
	    
        System.out.println("-----------------------------------------------------------------");

        //List<Book> newBookList = new ArrayList<>(bookList);
        //newBookList.stream().filter(x -> x.getPageNumber()>100).toList();
        List<Book> newBookList = bookList.stream().filter(x -> x.getPageNumber()>100).toList();
        System.out.println("\n The books that have page numbers are greater than 100 : ");
        for(Book b : newBookList) {
        	System.out.println("Book: "+b.getBookName()+" Page: "+b.getPageNumber());
        }
	}

}
