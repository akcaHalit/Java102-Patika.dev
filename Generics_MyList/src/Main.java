
public class Main {

	public static void main(String[] args) {
/*
		MyList<Integer> myList = new MyList<>(1);
		System.out.println(myList.getCapacity());
		//System.out.println(myList.size());
		myList.add(3);
		System.out.println(myList.size());
		System.out.println("3'den sonra"+myList.getCapacity());
		myList.add(5);
		System.out.println("5'den sonra"+myList.getCapacity());
		System.out.println("5'ten sonra size:"+myList.size());
		myList.add(7);
		System.out.println("7'den sonra size: "+myList.size());
		System.out.println("7'den sonra"+myList.getCapacity());
		myList.add(79);
		System.out.println("79'den sonra"+myList.getCapacity());
		System.out.println(myList.size());
*/
		//MyList<Integer> myList = new MyList<>(1);
/*
		MyList<Integer> liste = new MyList<>();
        liste.add(10);
        liste.add(20);
        liste.add(30);
        System.out.println("2. indisteki deðer : " + liste.get(2));
        liste.remove(2);
        liste.add(40);
        
        liste.set(0, 100);
        System.out.println("2. indisteki deðer : " + liste.get(2));
        System.out.println(liste.toString());
*/
		
		MyList<Integer> liste = new MyList<>();
        System.out.println("Liste Durumu : " + (liste.isEmpty() ? "Boþ" : "Dolu"));
        liste.add(10);
        liste.add(20);
        liste.add(30);
        liste.add(40);
        liste.add(20);
        liste.add(50);
        liste.add(60);
        liste.add(70);

        System.out.println("Liste Durumu : " + (liste.isEmpty() ? "Boþ" : "Dolu"));

        // Bulduðu ilk indeksi verir
        System.out.println("Indeks : " + liste.indexOf(20));

        // Bulamazsa -1 döndürür
        System.out.println("Indeks :" + liste.indexOf(100));

        // Bulduðu son indeksi verir
        System.out.println("Indeks : " + liste.lastIndexOf(20));

        // Listeyi Object[] dizisi olarak geri verir.
        Object[] dizi = liste.toArray();
        System.out.println("Object dizisinin ilk elemaný :" + dizi[0]);

        // Liste veri türünde alt bir liste oluþturdu
        MyList<Integer> altListem = liste.subList(0, 3);
        System.out.println(altListem.toString());

        // Deðerim listedeki olup olmadýðýný sorguladý
        System.out.println("Listemde 20 deðeri : " + liste.contains(20));
        System.out.println("Listemde 120 deðeri : " + liste.contains(120));

        // Listeyi tamamen boþaltýr ve varsayýlan boyutuna çevirir
        liste.clear();
        System.out.println(liste.toString());
		
	}
	
}
