package JavaBasics;

import java.util.ArrayList;

public class Arraylist {

	public static void main(String[] args) {
		 ArrayList<String> alist=new ArrayList<String>();  
	      alist.add("harika");
	      alist.add("ravalia");
	      alist.add("Rinky");
	      alist.add("sarika");
	      
	      System.out.println(alist);
	  
	      alist.add(3, "harshitha");
	  
	      System.out.println(alist);
	      
	      alist.set(2, "harshitha");
	      
	      System.out.print(alist);
	}

}
