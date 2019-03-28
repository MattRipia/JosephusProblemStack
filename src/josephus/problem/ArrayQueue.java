package josephus.problem;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements QueueADT<E> {

    private final int INITIAL_CAPACITY = 20;
    protected int numElements;
    protected int currentFront;
    protected int currentBack;
    protected E[] elements;
    
    public ArrayQueue()
    {
        elements = (E[]) new Object[INITIAL_CAPACITY];
        numElements = 0;
        currentBack = 0;
        currentFront = 0;
    }
    
    @Override
    public boolean isEmpty() {
        return numElements == 0;
    }

    @Override
    public int size() {
        return numElements;
    }
    
    @Override
    public void enqueue(E element) {
        
        if(numElements >= elements.length){
            System.out.println("Expand hit");
            expandCapacity();
        }

        
        elements[currentBack] = element;
        
        // increment current back, if it reaches the end of the array, set it to 0
        currentBack++;
        if(currentBack >= elements.length){
            currentBack = 0;
        }
        
        numElements++;
    }

    @Override
    public E dequeue() throws NoSuchElementException {
        
        if(isEmpty())
            throw new NoSuchElementException();
        
        // save the front element to be returned
        E returnElement = elements[currentFront];
        
        // remove the reference
        elements[currentFront] = null;
        
        // increment current front, if it reaches the end of the array, set it to 0
        currentFront++;
        if(currentFront >= elements.length){
            currentFront = 0;
        }
        
        numElements--;
        return returnElement;
    }

    @Override
    public E first() throws NoSuchElementException {
        if(isEmpty())
            throw new NoSuchElementException();
        else
            return elements[currentFront];
    }

    @Override
    public String toString(){
        
        String returnString = "";
        int k = currentFront;
        
        for (int i = 0; i < numElements; i++){
            
            returnString += elements[k] + " ";
            k++;
            
            // reset k to 0 when it expands the length of the array
            if(k >= elements.length){
                k = 0;
            }
        }
        
        return returnString;
    }
    
    // helper method which doubles the current size of the array
    private void expandCapacity()
    {  
         E[] largerArray =(E[])(new Object[elements.length*2]);
         int k = currentFront;
         
        // copy the elements array to the largerArray
        for (int i = 0; i < numElements; i++){
            
            largerArray[i] = elements[k];
            
            // reset k to 0 when it expands the length of the array
            k++;
            if(k >= elements.length){
                k = 0;
            }
        }
        
        currentFront = 0;
        currentBack = numElements;
        System.out.println("Expanded Array to: " + largerArray.length);
        elements = largerArray;
    }
}
