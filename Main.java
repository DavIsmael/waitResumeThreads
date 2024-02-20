public class Main{
    public static void main(String[] args){
        CoolThread thread1 = new CoolThread("Thread 1");
        thread1.t.start();
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.setSuspendThread();
        for(int i = 1; i < 6; ++i){
            try{
                Thread.sleep(1000);
                System.out.println("What state is " + thread1.t.getName() + " in? " + thread1.t.getState() + " for: " + i + "s");
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        thread1.setResumeThread();
    }
}