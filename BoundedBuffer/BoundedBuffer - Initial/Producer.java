public class Producer extends Thread {
    private BoundedBuffer buf;
    private int id;

    public Producer( BoundedBuffer buffer, int ident ) {
	buf = buffer;
	id = ident;
    }

    public void run() {
	long i;

	for (i=0; i<10; i++) {
	    System.out.println("Producer "+id+
			       ": inserting element "+i+
			       "...");
	    buf.put(i);
	    System.out.println("Producer "+id+": OK!");
	     try 
            {                sleep((int)(Math.random() * 100));            } 
            catch (InterruptedException e) { }
	}
	System.out.println("End of producer "+id+".");
    }
}
