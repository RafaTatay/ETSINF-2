public class Consumer extends Thread {
    private BoundedBuffer buf;
    private int id;

    public Consumer( BoundedBuffer buffer, int ident ) {
	buf = buffer;
	id = ident;
    }

    public void run() {
	int i;
	long el;

	for (i=0; i<10; i++) {
	    System.out.println("Consumer "+id+
			       ": obtaining element " +
			       "...");
	    el = buf.get();
	     try 
            {                sleep((int)(Math.random() * 150));            } 
            catch (InterruptedException e) { }
            
	    System.out.println("Consumer "+id+
			       ": Element "+el+".");
	}
	System.out.println("End of consumer "+id+".");
    }
}