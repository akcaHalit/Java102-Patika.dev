import java.util.Arrays;

public class MyList <T>{
	
	private T[] list;
	private T[] tempList;
 	private int capacity;
	
	MyList(){
		this.capacity = 10;
		this.list = (T[]) new Object[capacity];
	}
	MyList(int capacity) {
		this.capacity = capacity;
		this.list = (T[]) new Object[capacity];
 	}
	
	
	public int size() {  
		int countSize = 0;
		for(int i =0; i<getCapacity(); i++) { 
			if( list[i] != null) {
				countSize++;
			}
		}
		return countSize;
	}
	
	
	public void add (T data) {
		if(size()+1 > getCapacity()) {
			this.tempList = this.list;
			setCapacity(getCapacity()*2);
			this.list = (T[]) new Object[getCapacity()];
			this.list = Arrays.copyOf(tempList, getCapacity());
		}
		this.list[size()] = data;
	}
	
	
	public T get(int index) {
		if(index > size() || index < 0) {
			System.out.println("INVALID INDEX!!");
			return null;
		}
		return this.list[index];
	}
	
	
	public T remove(int index) {
		if(index > size() || index < 0) {
			System.out.println("INVALID INDEX!!");
			return null;
		}
		this.tempList = this.list;
		this.list[index] = null;
		for(int i = index; i<size(); i++) {
			if(size()-i == 1 ) {
				this.list[i] = null;   //Sondaki deðeri-indexi bulup null yapýyor 
			}else{
				this.list[i] = tempList[i+1];
			}
		}
		return this.list[index];	
	}
	
	
	public T set(int index,T data) {
		if(index > size() || index < 0) {
			System.out.println("INVALID INDEX!!");
			return null;
		}
		this.list[index] = data;
		return this.list[index];
	}
	
	
	public int indexOf(T data) {
		for(int i=0; i<size(); i++) {
			if(this.list[i] == data) {
				return i;
			}
		}
		return -1;
	}
	public int lastIndexOf(T data) {
		for(int i=size();i>=0;i--) {
			if(this.list[i] == data) {
				return i;
			}
		}
		return -1;
	}
	
	
	public boolean isEmpty() {
		for(int i=0;i<size(); i++) {
			if(list[i] != null) {
				return false;
			}
		}
		return true;
	}

	
	public T[] toArray() {
		return this.list;
	}
 	
	
	public void clear() {
		for(int i=0; i<size(); i++) {
			this.list[i] = null;
		}
	}
	
	
	public boolean contains(T data) {
		for(int i=0; i<size(); i++) {		
			if(this.list[i] == data) {
				return true;
			}
		}
		return false;
	}
	
	
	public MyList<T> subList(int start, int finish){
        MyList<T> subList = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
        	subList.add(this.list[i]);
        }
        return subList;
	}
	
	
	@Override
	public String toString() {
		int counter = 0;
		T[] temp2List = (T[]) new Object[capacity];
		for(int i=0; i<size(); i++) {
			if(list[i] != null) {
				temp2List[i] = list[i];
				counter++;
			}
		}
		T[] tempList2 = (T[]) new Object[counter];
		for(int i=0; i<tempList2.length; i++) {
			tempList2[i] = temp2List[i];
		}
 		return Arrays.toString(tempList2);
	}
	
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
}
