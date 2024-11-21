public class CentralizedQueue {
    private static CentralizedQueue instance;
    private int currentQueueNumber;
    private boolean isQueueActive;



    private CentralizedQueue(){
        currentQueueNumber=0;
        isQueueActive=true;
    }

    public static synchronized CentralizedQueue getInstance(){
        if(instance == null){
            instance = new CentralizedQueue();
        }
        return instance;
    }
    public synchronized int getNextQueueNumber(){
        if(isQueueActive){
            currentQueueNumber++;
            return currentQueueNumber;
        }else{
            System.out.println("Current Queue is inactive");
            return-1;
        }
    }

    public void resetQueue(int resetNumber){
        if(resetNumber>=0){
            currentQueueNumber = resetNumber;
            System.out.println("The Queue has been reset to "+resetNumber);
        }else{
            System.out.println("invalid reset number.");
        }
    }
    public synchronized void deactivateQueue(){
        isQueueActive = false;
        System.out.println("The Queueing system is now inactive.");
    }

    public synchronized void reactiveQueue(){
        isQueueActive= true;
        System.out.println("The Queueing system is now active.");
    }

    public synchronized String getCurrentQueueNumber(){
        if(currentQueueNumber==0){
            return"No current Queue.";
        }else{
            return "" + currentQueueNumber;
        }
    }


}
