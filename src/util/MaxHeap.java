package util;
import java.util.ArrayList;
import java.util.Arrays;
class MaxHeap<T extends Comparable<T>> {

    private int sizeOfHeap;
    private int heapMaxSize;
    private ArrayList<T> heapData;

    private static final int FRONT = 1;

    public MaxHeap(T[] datos)  {
        this.heapMaxSize = datos.length;
        this.sizeOfHeap = 0;
        heapData = new ArrayList<>(Arrays.asList(datos));
    }


    private int getParentPosition(int position)  {
        return (position - 1) / 2;
    }


    private int getLeftChildPosition(int position)  {
        return (2 * position);
    }


    private int getRightChildPosition(int position)  {
        return (2 * position) + 1;
    }


    private boolean checkLeaf(int position)  {
        if (position > (sizeOfHeap / 2) && position <= sizeOfHeap) {
            return true;
        }
        return false;
    }


    private void swap(int firstNode, int secondNode)  {
        T temp;
        temp = heapData.get(firstNode);
        heapData.set(firstNode, heapData.get(secondNode));
        heapData.set(secondNode, temp);
    }


    private void maxHeapify(int position) {
        int leftChild = getLeftChildPosition(position);
        int rightChild = getRightChildPosition(position);
        int largest = position;
        // Check if the given node is not a leaf and bigger than its right and left child
        if (!checkLeaf(position)) {
            if (leftChild < sizeOfHeap && heapData.get(position).compareTo(heapData.get(leftChild)) <= -1) {
                largest = leftChild;
            }
            if (rightChild < sizeOfHeap && heapData.get(position).compareTo(heapData.get(rightChild)) <= -1) {
                largest = rightChild;
            }
            // Change with the larger child and then heap the child
            if (largest != position) {
                swap(position, largest);
                maxHeapify(largest);
            }
        }
    }

    public void insertNode(T data) {
        heapData.add(data);
        sizeOfHeap++;
        int current = sizeOfHeap - 1;
        while (current > 0 && heapData.get(current).compareTo(heapData.get(getParentPosition(current))) >= 1) {
            swap(current, getParentPosition(current));
            current = getParentPosition(current);
        }
    }
    //FIXME: ILEGALIDAD DE PRINT TERRIBLE
    public void displayHeap() {
        System.out.println("PARENT NODE" + "\t" + "LEFT CHILD NODE" + "\t" + "RIGHT CHILD NODE");
        for (int k = 0; k < sizeOfHeap / 2; k++) {
            int leftChild = getLeftChildPosition(k);
            int rightChild = getRightChildPosition(k);
            System.out.print(" " + heapData.get(k) + "\t\t" + (leftChild < sizeOfHeap ? heapData.get(leftChild) : "N/A") + "\t\t" + (rightChild < sizeOfHeap ? heapData.get(rightChild) : "N/A"));
            System.out.println();
        }
    }

    public void designMaxHeap() {
        for (int position = sizeOfHeap / 2 - 1; position >= 0; position--) {
            maxHeapify(position);
        }
    }

    public T removeRoot() {
        if (sizeOfHeap == 0) {
            return null; 
        }
        T popElement = heapData.get(FRONT - 1);
        heapData.set(FRONT - 1, heapData.get(sizeOfHeap - 1));
        heapData.remove(sizeOfHeap - 1);
        sizeOfHeap--;
        maxHeapify(FRONT - 1);
        return popElement;
    }
}
