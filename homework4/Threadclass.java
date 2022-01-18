class Threadclass extends Thread{

    public void run(){
        System.out.println("Thread is running");
    }

    public static void run_without_join(){
        Threadclass thread = new Threadclass();
        thread.start();
        System.out.println("Main thread");
    }

    public static void run_with_join() throws InterruptedException{
        Threadclass thread = new Threadclass();
        thread.start();
        thread.join();
        System.out.println("Main thread");
    }

    public static void main(String[] args) throws InterruptedException{
        System.out.println("========== without join ===================");
        run_without_join();
        System.out.println("========== with join ======================");
        run_with_join();

    }
    
}