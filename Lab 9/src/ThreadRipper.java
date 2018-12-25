public class ThreadRipper implements Runnable{
    private String name = "";

    public ThreadRipper(String name) {
        this.name = name;
    }

    public void run() {
        for(int i = 0; i < 1000; i++) {
            if( Math.random() < .5) {   //on occasion
                try {	//lets go to sleep so the other threads have a chance
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    //do nothing other than a trace
                    e.printStackTrace();
                }
            }
            System.out.println( name + " : " + i);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadRipper("ripper1") );
        Thread t2 = new Thread(new ThreadRipper("ripper2") );

        t1.start();
        t2.start();
    }
}
