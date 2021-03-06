/**
 * 生产者消费者问题
 * 生产窝头，消费窝头
 * @author Administrator
 *
 */
public class ProducerConsumer {
	public static void main(String[]args){
		Container cc = new Container();
		Producer p1 = new Producer(cc);
		Consumer c1 = new Consumer(cc);
		new Thread(p1).start();
		new Thread(c1).start();
	}
}

class Container {
	Wotou [] wotou  = new Wotou[8];
	int num = 0;

	public synchronized void push(Wotou w){
		while(num == wotou.length){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();
		wotou[num]=w;
		num++;
	}
	
	public synchronized Wotou pop(){
		while(num == 0){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();
		num--;
		return wotou[num];
	}
}

class Wotou {
	int id ;
	Wotou (int id){
		this.id = id;
	}
	public String toString(){
		return "Wotou :"+id;
	}
}

class Producer implements Runnable {
	Container cc = null;
	Producer(Container c){
		cc = c;
	}
	
	public void run(){
		for (int i=0;i<20;i++){
			Wotou w = new Wotou(i);
			System.out.println("生产了"+w.toString());	
			cc.push(w);
			try{
				Thread.sleep((int)Math.random()*1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable{
	Container cc = null;
	Consumer (Container c){
		cc = c;
	}
	
	public void run(){
		for (int i=0;i<20;i++){
			Wotou w = cc.pop();
			System.out.println("消费了"+w.toString());
			
			try{
				Thread.sleep((int)Math.random()*1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}