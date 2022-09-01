import java.util.TreeSet;
import java.util.Comparator;


public class Main {
	public static void main(String[] args) {
		
		TreeSet<Book> bookSet = new TreeSet<>();
		
		Book book1=new Book("Þeker Portakalý","José Mauro de Vasconcelos",183, 1968);
        Book book2=new Book("Delifiþek","José Mauro de Vasconcelos",163,1960);
        Book book3=new Book("Kürk Mantolu Madonna","Sabahattin Ali",177, 1943);
        Book book4=new Book("Fahrenheit 451","Ray Bradbury",350,1953);
        
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);

        System.out.println("Sorted by name : \n------------------------------");
        for(Book b : bookSet) {
        	System.out.println("Book Name: "+b.getBookName()
        						+"\nAuthor Name: "+b.getAuthorName()
        						+"\nNumber of Pages: "+b.getNumberOfPages()
        						+"\nReleased Date: "+b.getReleaseDate());
        	System.out.println("###################################");
        }
        
        TreeSet<Book> bookSet2 = new TreeSet<>(new Comparator<Book>() {
        	@Override
        	public int compare(Book o1,Book o2) {
        		return o1.getNumberOfPages() - o2.getNumberOfPages();
        	}
        });
        
        bookSet2.add(book1);
        bookSet2.add(book2);
        bookSet2.add(book3);
        bookSet2.add(book4);

        System.out.println("----------------------------------");
        
        System.out.println("Sorted by number of Page :\n-----------------");
        for(Book b : bookSet2) {
        	System.out.println("Book Name: "+b.getBookName()
			+"\nAuthor Name: "+b.getAuthorName()
			+"\nNumber of Pages: "+b.getNumberOfPages()
			+"\nReleased Date: "+b.getReleaseDate());
        	System.out.println("###################################");
        }
	}
	
}
