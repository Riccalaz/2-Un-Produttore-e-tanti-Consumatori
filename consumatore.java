package unptantic;

import java.util.LinkedList;

public class consumatore extends Thread{
	private int neg;
	private  LinkedList<Integer> numeri;  //utilizzo una lista per i cinque numeri positivi di cui devo fare la media
	private int pos;
	private int sumpos;
	buffer b;
	
	public consumatore(buffer bu) {
		neg=0;
		numeri=new LinkedList<>();
		b=bu;
		sumpos=0;
	}
	
	public void run() {
		int val;
		while(true) {
			try {
				val=b.rim();
				if(val!=-2000) {
					if(val<0) {
						neg++;
					}else {
						if(pos==5) {
							sumpos-=numeri.poll();
							numeri.add(val);
						}else {
							numeri.add(val);
							pos++;
						}
						sumpos+=val;
						
					}
					System.out.print("sono "+threadId()+" e negativi: "+neg+" media positivi: ");
					if(pos>0) {
						System.out.print(sumpos/pos);
						System.out.println();
					}else {
						System.out.println();
					}
				}
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		

}
