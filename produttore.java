package unptantic;

import java.util.Random;

public class produttore extends Thread{
	buffer b;
	
	public produttore(buffer buf) {
		b=buf;
	}
	
	public void run() {
		Random ran = new Random();
		
		while(true) {
			int r=ran.nextInt(2048)-1024;
			
			try {
				b.ins(r);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(r>0) {
				try {
					Thread.sleep(r/100*50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
