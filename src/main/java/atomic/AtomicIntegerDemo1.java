package atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述：演示AtomicInteger的基本用法，对比非原子类的线程安全问题，使用了原子类之后，不需要加锁，也可以保证线程安全。
 *
 * @author admin
 */
public class AtomicIntegerDemo1 implements Runnable {
    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();

    public void incrementAtomic() {
        ATOMIC_INTEGER.getAndAdd(-90);
    }

    private static volatile int basicCount = 0;

    public synchronized void incrementBasic() {
        basicCount++;
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerDemo1 r = new AtomicIntegerDemo1();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("原子类的结果：" + ATOMIC_INTEGER.get());
        System.out.println("普通变量的结果：" + basicCount);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            incrementAtomic();
            incrementBasic();
        }
    }
}
