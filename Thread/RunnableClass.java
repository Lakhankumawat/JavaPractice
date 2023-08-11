package Thread;

public class RunnableClass implements Runnable {
    
        public void run(){
            for(int i=0;i<5;i++){
                System.out.println("Thread is running");
            }
        }
    
        public static void main(String[] args) {
            RunnableClass r1 = new RunnableClass();
            RunnableClass r2 = new RunnableClass();
            Thread t1 = new Thread(r1);
            Thread t2 = new Thread(r2);
            t1.start();
            t2.start();
        }
    
}
