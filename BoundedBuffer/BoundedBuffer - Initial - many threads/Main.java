public class Main {
    static public void main(String[] args) {
	BoundedBuffer buf = new BoundedBuffer(4);
	Consumer c = new Consumer(buf,1);
	Producer p = new Producer(buf,1);

	Consumer c2 = new Consumer(buf,2);
	Producer p2 = new Producer(buf,2);
	
	Consumer c3 = new Consumer(buf,3);
	Producer p3 = new Producer(buf,3);
	
	Consumer c4 = new Consumer(buf,4);
	Producer p4 = new Producer(buf,4);
	
	Consumer c5 = new Consumer(buf,5);
	Producer p5 = new Producer(buf,5);
	
	Consumer c6 = new Consumer(buf,6);
	Producer p6 = new Producer(buf,6);

	
	p.start();
	c.start();
	p2.start();
	c2.start();
	p3.start();
	c3.start();
	p4.start();
	c4.start();
	p5.start();
	c5.start();
	p6.start();
	c6.start();
	
    }
}