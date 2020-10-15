public class QueDouble {
    private Double[] que;
    private int nElem1;  // текущее количество элементов в очереди
    private int front1;
    private int rear1;

    public QueDouble() {//Это счетная очередь для получения результата
        que = new Double[30];
        rear1 = -1;
        front1 = 0;
        nElem1 = 0;
    }


    public void insert(Double elem) {
        if (rear1 == que.length - 1) {  // циклический перенос
            rear1 = -1;
        }

        que[++rear1] = elem;//увеличение Rear и вставка
        nElem1++;  // увеличение количества элементов в очереди
    }

    public Double remove() {
        Double temp1 = que[front1++]; // получаем первый элемент из очереди

        if (front1 == que.length) { // циклический перенос
            front1 = 0;
        }
        nElem1--; // уменьшаем количество элементов в очереди
        return temp1;

    }

    public Double getFront() {
        return que[front1];
    }

    public Double getRear() {
        return que[rear1];
    }

    public boolean isFull() {
        return (nElem1 == que.length - 1);
    }

    public boolean isEmpty() {
        return (nElem1 == 0);
    }

    public int getSize() {
        return nElem1;
    }
}
