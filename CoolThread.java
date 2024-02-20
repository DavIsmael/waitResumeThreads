public class CoolThread implements Runnable{
    Thread t;
    boolean suspendThread = false;
    public CoolThread(String name){
        t = new Thread(this, name);
        System.out.println("New thread " + name + " was created by " + Thread.currentThread().getName() + " thread!");
    }
    public void run(){
        try{
            for(int i = 20; i > 0; --i){
                System.out.println("Counter: " + i + " for " + Thread.currentThread().getName() + "...");
                Thread.sleep(1000);
                if(suspendThread){
                    synchronized(this){
                        System.out.println("Pausing thread...");
                        wait();
                    }
                }
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    synchronized public void setSuspendThread(){
        suspendThread = true;
    }
    synchronized public void setResumeThread(){
        notify();
        suspendThread = false;
        System.out.println("Resuming thread...");
    }
}