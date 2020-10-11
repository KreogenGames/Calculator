public class Queue {
    private Character[] queue;
    private int nElem;  // текущее количество элементов в очереди
    private int front;
    private int rear;

    public Queue() {//Это очередь для складирования знаков
        queue = new Character[20];
        rear = -1;
        front = 0;
        nElem = 0;
    }

    public void insert(char elem) {
        if (rear == queue.length - 1) {  // циклический перенос
            rear = -1;
        }

        queue[++rear] = elem;//увеличение Rear и вставка
        nElem++;  // увеличение количества элементов в очереди
    }

    public char remove() {
        char temp = queue[front++]; // получаем первый элемент из очереди

        if (front == queue.length) { // циклический перенос
            front = 0;
        }
        nElem--; // уменьшаем количество элементов в очереди
        return temp;

    }

    public char getFront() {
        return queue[front];
    }

    public char getRear() {
        return queue[rear];
    }

    public boolean isFull() {
        return (nElem == queue.length - 1);
    }

    public boolean isEmpty() {
        return (nElem == 0);
    }

    public int getSize() {
        return nElem;
    }
}
