class Notifyclassbase extends Thread {
    public void run() {
        synchronized (this) {
            System.out.println("Start " + Thread.currentThread().getName());
            try {
                System.out.println(Thread.currentThread().getName() + " waiting");
                this.wait();

            } catch (InterruptedException e) {
            }

            System.out.println(Thread.currentThread().getName() + " notified");
            this.notify();
        }
    }
}

class Notify_thread2 extends Thread {
    Notifyclassbase notify_obj;
    int a = 0;

    Notify_thread2(Notifyclassbase notify_obj) {
        this.notify_obj = notify_obj;
    }

    public void run() {
        synchronized (this.notify_obj) {
            System.out.println("Start " + Thread.currentThread().getName());
            try {
                System.out.println(Thread.currentThread().getName() + " waiting");
                this.notify_obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " notified");
        }
    }
}

class Notify_thread3 extends Thread {
    Notifyclassbase notify_obj;

    Notify_thread3(Notifyclassbase notify_obj) {
        this.notify_obj = notify_obj;
    }

    public void run() {
        synchronized (this.notify_obj) {
            System.out.println("Start " + Thread.currentThread().getName());
            try {
                System.out.println(Thread.currentThread().getName() + " waiting");
                this.notify_obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " notified");
            this.notify_obj.notify();
        }
    }
    
}

class Notify_thread4 extends Thread {
    Notifyclassbase notify_obj;

    Notify_thread4(Notifyclassbase notify_obj) {
        this.notify_obj = notify_obj;
    }

    public void run() {
        synchronized (this.notify_obj) {
            System.out.println("Start " + Thread.currentThread().getName());
            this.notify_obj.notify();
            System.out.println(Thread.currentThread().getName() + "...notified");
        }
    }
}


public class WaitAndNotifyExample {
    public static void main(String[] args) throws InterruptedException {
        Notifyclassbase notify1 = new Notifyclassbase();
        Notify_thread2 notify2 = new Notify_thread2(notify1);
        Notify_thread3 notify3 = new Notify_thread3(notify1);
        Notify_thread4 notify4 = new Notify_thread4(notify1);

        
        Thread t1 = new Thread(notify1, "Thread-1");
        Thread t2 = new Thread(notify2, "Thread-2");
        Thread t3 = new Thread(notify3, "Thread-3");
        Thread t4 = new Thread(notify4, "Thread-4");

        
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(100);
        t4.start();
    }
}
