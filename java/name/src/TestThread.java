/**
 * �̵߳Ĵ��������
 * @author Administrator
 *
 */
public class TestThread{
	public static void main(String[]args){
		Runner1 r = new Runner1();
		//r.run();   //ֻ�Ƿ�������
		Thread t = new Thread(r);
		t.start();
		for (int i=0;i<100;i++){ 
			System.out.println("Main Thread:"+i);
		}
		System.out.println("Thread main is over");
		r.shutDown();  	//�����߳� 
	}
}

class Runner1 implements Runnable{
	private boolean flag = true;
	@Override
	public void run() {		//��run��������ʱ���߳̽���
		System.out.println(Thread.currentThread().isAlive());	//��ǰ�߳��Ƿ񻹴��S
		for (int i=0;i<100 && flag==true;i++){
			System.out.println("Runner1:"+i);
		}
	}
	
	public void shutDown(){
		flag = false;
	}
}