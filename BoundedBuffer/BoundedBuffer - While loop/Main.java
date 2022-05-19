public class Main {
    static public void main(String[] args) {
	BoundedBuffer buf = new BoundedBuffer(4);
	Consumer c = new Consumer(buf,1);
	Producer p = new Producer(buf,1);

	p.start();
	c.start();
    }
}