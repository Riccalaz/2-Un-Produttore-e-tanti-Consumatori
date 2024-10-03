package unpunc;

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
			notify();  //se il produttore inserisce un valore quando il buffer è vuoto notifica il consumatore
		}
		if(!pieno()) {
			b[coda]=val;
			coda=(coda+1)%size;
			n++;
		}else {
			wait(); //se il produttore voule inserire un valore a buffer pieno va in attesa
		}
		
	}
	
	public synchronized int rim() throws InterruptedException {
		int x=-2000;
		if(pieno()) {
			notify(); //se il consumatore rimuove un valore quando il buffer è pieno notifica il produttore
		}
		if(!vuoto()) {
			x=b[testa];
			b[testa]=0;
			testa=(testa+1)%size;
			n--;
		}else {
			wait(); //se il consumatore voule rimuovere un valore a buffer vouto va in attesa
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
