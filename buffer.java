package unptantic;

public class buffer {
	private int[] b;
	private int coda;
	public int testa;
	private int n;
	private int size;
	
	public buffer(){
		n=0;
		testa=0;
		coda=0;
		size=10;
		b=new int[size];
	}
	
	public synchronized void ins(int val) throws InterruptedException {
		if(vuoto()) {
			notify();
		}
		if(!pieno()) {
			b[coda]=val;
			coda=(coda+1)%size;
			n++;
		}else {
			wait();
		}
		
	}
	
	public synchronized int rim() throws InterruptedException {
		int x=-2000;
		if(pieno()) {
			notify();
		}
		if(!vuoto()) {
			x=b[testa];
			b[testa]=0;
			testa=(testa+1)%size;
			n--;
		}else {
			wait();
		}
		return x;
	}
	
	public boolean pieno() {
		return size==n;
	}
	
	public boolean vuoto() {
		return n==0;
	}
	
	public void stampa() {
		for(int i=0;i<size;i++) {
			System.out.print(b[i]+" ");
		}
		System.out.println();
	}
}
