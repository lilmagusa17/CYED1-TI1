package util;

class MaxHeap<T extends Comparable<T>> {

        private T[] heapData;
        private int sizeOfHeap;
        private int heapMaxSize;

        private static final int FRONT = 1;


        //TODO change array to ArrayList

        public MaxHeap(T[] datos)  {
            this.heapMaxSize = datos.length;
            this.sizeOfHeap = 0;
            heapData = datos;
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
            temp = heapData[firstNode];
            heapData[firstNode] = heapData[secondNode];
            heapData[secondNode] = temp;
        }


        private void maxHeapify(int position)  {

        //check whether the given node is non-leaf and greater than its right and left child
            if (!checkLeaf(position)) {
                if ((heapData[position].compareTo(heapData[getLeftChildPosition(position)])<=-1 || (heapData[position].compareTo(heapData[getRightChildPosition(position)]))<=-1)) {

                // swap with left child and then heapify the left child
                if (heapData[getLeftChildPosition(position)].compareTo(heapData[getRightChildPosition(position)])>=1) {
                    swap(position, getLeftChildPosition(position));
                    maxHeapify(getLeftChildPosition(position));
                }

                // Swap with the right child and heapify the right child
                else {
                    swap(position, getRightChildPosition(position));
                    maxHeapify(getRightChildPosition(position));
                    }
                }
            }
        }

        public void insertNode(T data)  {
            heapData[sizeOfHeap] = data;
            int current = sizeOfHeap;

            while (heapData[current].compareTo(heapData[getParentPosition(current)])>=1) {
            swap(current, getParentPosition(current));
            current = getParentPosition(current);
            }
            sizeOfHeap++;
        }

        public void displayHeap()  {
            System.out.println("PARENT NODE" + "\t" + "LEFT CHILD NODE" + "\t" + "RIGHT CHILD NODE");
            for (int k = 0; k <sizeOfHeap / 2; k++) {
                System.out.print(" " + heapData[k] + "\t\t" + heapData[2 * k + 1] + "\t\t" + heapData[2 * k + 2]);
                System.out.println();
            }
        }

        public void designMaxHeap()  {
            for (int position = 0;  position < (sizeOfHeap / 2); position++) {
                maxHeapify(position);
            }
        }

        public T removeRoot()  {
            T popElement = heapData[FRONT];
            heapData[FRONT] = heapData[sizeOfHeap--];
            maxHeapify(FRONT);
            return popElement;
        }
}
