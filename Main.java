package unptantic;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner myObj = new Scanner(System.in);
		buffer bu=new buffer();
		
		int T = myObj.nextInt();
		produttore p=new produttore(bu);
		consumatore[] th=new consumatore[T];
		p.start();
		
		for(int i=0;i<T;i++){
			th[i]= new consumatore(bu);
			th[i].start(); //avvio i thread
		}
		
		
		
	}

}
