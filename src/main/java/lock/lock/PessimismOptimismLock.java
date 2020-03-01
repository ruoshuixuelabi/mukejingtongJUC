package lock.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述：乐观锁的演示，原子类内部使用的是乐观锁
 * @author admin
 */
public class PessimismOptimismLock {
    int a;

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
    }

    public synchronized void testMethod() {
        a++;
    }
}
