package josephus.problem;

public class JosephusProblem {
    
    public static void main(String[] args) {
        
        JosephusProblem.JosephusProb(9, 5);
    }

    public static void JosephusProb(int soliders, int gap){
        
        ArrayQueue originalQueue = new ArrayQueue();
        
        // adds the soilders to the queue
        for(int i = 1; i <= soliders; i++)
        {
            originalQueue.enqueue(i);
        }
        
        // prints out all soilders in order
        System.out.println(originalQueue.toString());
        
        while(!originalQueue.isEmpty()){
            
            for(int i = 0; i < gap; i++)
            {
                // save
                if(i < gap - 1)
                {
                    System.out.println("Saved : " + originalQueue.first());
                    originalQueue.enqueue(originalQueue.dequeue());
                }
                // kill
                else
                {
                    System.out.println("Queue : " + originalQueue.toString());
                    System.out.println("Killed: " + originalQueue.first());
                    originalQueue.dequeue();
                    System.out.println("Queue : " + originalQueue.toString() + "\n");
                }
            }
        }
    }
    
//    int size = originalQueue.size();
//        int currentIndex = 1;
//        while(size > 2)
//        {
//            if(currentIndex % gap != 0)
//            {
//                System.out.println("Saved: " + originalQueue.first());
//                originalQueue.enqueue(originalQueue.dequeue());
//            }
//            else
//            {
//                System.out.println("Killed: " + originalQueue.first());
//                originalQueue.dequeue();
//                System.out.println("Queue: " + originalQueue.toString() + "\n");
//            }
//            
//            currentIndex++;
//            size = originalQueue.size();
//        }
//
//        // deal with the last two soilders
//        System.out.println("Size is 2 or less!: " + originalQueue.size());
//        for(int i = 1; i < gap; i ++)
//        {
//            originalQueue.enqueue(originalQueue.dequeue());
//        }
//        
//        System.out.println("Killed: " + originalQueue.first());
//        originalQueue.dequeue();
//        System.out.println("Last Element remaining is: " + originalQueue.first());
}
