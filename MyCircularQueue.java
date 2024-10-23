package org.example;

public class MyCircularQueue {
    private final int[] queue;
    private int front;
    private int rear;
    private int size;
    private final int capacity;

    // Constructor to initialize the circular queue
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    // Method to add an item to the queue
    public boolean enQueue(int value) {
        if (isFull()) {
            return false; // Queue is full
        }
        queue[rear] = value; // Insert the value
        rear = (rear + 1) % capacity; // Move rear in circular way
        size++; // Increment the size
        return true;
    }

    // Method to remove an item from the queue
    public boolean deQueue() {
        if (isEmpty()) {
            return false; // Queue is empty
        }
        front = (front + 1) % capacity; // Move front in circular way
        size--; // Decrement the size
        return true;
    }

    // Method to get the front item from the queue
    public int Front() {
        if (isEmpty()) {
            return -1; // Queue is empty
        }
        return queue[front]; // Return front item
    }

    // Method to get the last item from the queue
    public int Rear() {
        if (isEmpty()) {
            return -1; // Queue is empty
        }
        // Calculate the index of the last element
        return queue[(rear - 1 + capacity) % capacity];
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0; // If size is 0, the queue is empty
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return size == capacity; // If size equals capacity, the queue is full
    }
}