public class BoundedBuffer {
    private long numItems;
    private int first,last,capacity;
    private long items[];
    private Object notFull;
    private Object notEmpty;

    public BoundedBuffer(int size){
       capacity = size;
       items = new long[size];
       numItems = first = last = 0;
       notFull = new Object();
       notEmpty = new Object();
    }
    public synchronized void put(long item) {
	while (numItems == capacity) try {
		synchronized(notFull) {
		    notFull.wait();
		}
	    }catch(Exception e){};
       items[last] = item;
       last = (last + 1) % capacity; 
       numItems++;
       synchronized(notEmpty){
	   notEmpty.notify();
       }
    }
    public synchronized long get() {
       long valor;
       while (numItems == 0) try {
	       synchronized(notEmpty){
		   notEmpty.wait();
	       }
	   }catch(Exception e){};
	  
       valor = items[first];
       first = (first + 1) % capacity;
       numItems--;
       synchronized(notFull){ 
	   notFull.notify();
       }
       return valor;
    }
}
