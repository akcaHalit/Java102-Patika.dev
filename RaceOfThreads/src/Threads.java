import java.util.ArrayList;
import java.util.List;

public class Threads implements Runnable{

	private int number = 1;
	private final Object LOCK = new Object();
	
	 private ArrayList<Integer> dividedList = new ArrayList<>();
	 private ArrayList<Integer> dividedList2 = new ArrayList<>();
	 private ArrayList<Integer> dividedList3 = new ArrayList<>();
	 private ArrayList<Integer> dividedList4 = new ArrayList<>();
	 
	 private ArrayList<Integer> oddNumbers = new ArrayList<>();
	 private  ArrayList<Integer> evenNumbers = new ArrayList<>();
	 
	 
	 
	@Override
	public void run() {
	
		synchronized(LOCK) {
			System.out.println(getNumber());
			
			if(this.number <= 2500) {
				this.dividedList.add(this.number);
				System.out.println(this.number+" "+" added to dividedList1");
			}else if(this.number > 2500 && this.number <=5000) {
				this.dividedList2.add(this.number);
                System.out.println(this.number +" " + "added to dividedList2");
            } else if (this.number > 5000 && this.number <= 7500) {
                this.dividedList3.add(this.number);
                System.out.println(this.number +" " + "added to dividedList3");
            } else {
                this.dividedList4.add(this.number);
                System.out.println(this.number +" " + "added to dividedList4");
            }
			
			if(this.number %2 == 0) {
				this.evenNumbers.add(this.number);
                System.out.println(this.number +" " +"added to Even Number List");
			}else {
				this.oddNumbers.add(this.number);
                System.out.println(this.number +" " +"added to Odd Number List");
			}
		
			
			this.number+=1;
		}
		
	}


	
	
	public ArrayList<Integer> getDividedList() {
		return dividedList;
	}

	public ArrayList<Integer> getDividedList2() {
		return dividedList2;
	}

	public ArrayList<Integer> getDividedList3() {
		return dividedList3;
	}

	public ArrayList<Integer> getDividedList4() {
		return dividedList4;
	}

	public ArrayList<Integer> getOddNumbers() {
		return oddNumbers;
	}

	public ArrayList<Integer> getEvenNumbers() {
		return evenNumbers;
	}






	public int getNumber() {
		return number;
	}
	public void setNumber(int firstNumber) {
		this.number = firstNumber;
	}

	
	
}
