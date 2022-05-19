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

    public void put(long item) {
        if (numItems == capacity) try {
                synchronized(notFull) {
                    notFull.wait();
                }
            }catch(Exception e){};
        items[last] = item;

        try 
        {     Thread.currentThread().sleep((int)(Math.random() * 150));            } 
        catch (InterruptedException e) { }

        last = (last + 1) % capacity; 
        numItems++;
        synchronized(notEmpty){
            notEmpty.notify();
        }
    }

    public long get() {
        long valor;
        if (numItems == 0) try {
                synchronized(notEmpty){
                    notEmpty.wait();
                }
            }catch(Exception e){};

        valor = items[first];

        Thread.currentThread().yield();            

        first = (first + 1) % capacity;
        numItems--;
        synchronized(notFull){ 
            notFull.notify();
        }
        return valor;
    }
}
