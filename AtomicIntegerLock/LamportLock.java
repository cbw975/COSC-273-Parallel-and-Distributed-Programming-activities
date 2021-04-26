public class LamportLock {

    private AtomicInteger ai1 = new AtomicInteger(0); 
    private AtomicInteger ai2 = new AtomicInteger(0);

    public void lock () {
        // implement me
        int i = ThreadID.get();
        flag[i] = true;
        label[i] = max(label[0],..., label[n-1])+1;
        while(!hasPriority(i)) {}
    }

    public void unlock () {
        // implement me
        flag[ThreadID.get()] = false;
    }
}