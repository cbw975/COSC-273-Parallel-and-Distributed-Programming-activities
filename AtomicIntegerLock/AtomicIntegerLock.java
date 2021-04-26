public class AtomicIntegerLock{
    private static AtomicInteger ticketPriorityMax = new AtomicInteger(0); //akin to ticket line number dispenser
    private static AtomicInteger threadCount = new AtomicInteger(0); //tracks thread count

    // Each thread has a private/local int value --> intent flag
    
    public boolean hasPriority(){
        for(int j=0; j<threadCount.get(); j++){
            if(j==ThreadID.get()) continue; //skip current thread
            if(Thread[j].getValue() < Thread.getValue()) return false; //another thread has higher priority than current thread
        }
        return true;
    }

    public void lock () {
        int i = ThreadID.get();
        //flag[i] = true; ==> implied if the thread's value is not the MAX_VALUE
        Thread.setValue(ticketPriorityMax.getAndIncrement()); //label[i] = max(label[0],..., label[n-1]) + 1;
        while(!hasPriority(i)) {}
    }

    public void unlock () {
        Thread.setValue(Integer.MAX_VALUE); //flag[ThreadID.get()] = false;
        //basically setting flag to false, since can't have worse (larger value) priority than MAX_VALUE
    }
}