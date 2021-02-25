package com.app.core;

public interface QueueInterface {
    public void push(int data);
    public int pop();
    public boolean isEmpty();
    public boolean isFull();
    public int top();
    
}
