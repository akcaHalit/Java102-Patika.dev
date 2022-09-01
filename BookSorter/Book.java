
public class Book implements Comparable<Book>{
	  private String bookName;
	  private int numberOfPages;
	  private String authorName;
	  private int releaseDate;
	  
	public Book(String bookName,String authorName,int numberOfPages,int releaseDate) {
		this.bookName = bookName;
		this.authorName = authorName;
		this.numberOfPages = numberOfPages;
		this.releaseDate = releaseDate;
	}
	


	@Override
	public int compareTo(Book o1) {
		return getBookName().compareTo(o1.getBookName());
	}
	
	
	  
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}




	
}
