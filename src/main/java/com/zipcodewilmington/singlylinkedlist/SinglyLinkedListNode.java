package com.zipcodewilmington.singlylinkedlist;

public class SinglyLinkedListNode<T> {

    private T storedObject;
    private SinglyLinkedListNode<T> nextNode;

    public SinglyLinkedListNode(T storedObject){
        this.storedObject = storedObject;
        this.nextNode = null;
    }

    public T getStoredObject(){
        return storedObject;
    }

    public SinglyLinkedListNode<T> getNextNode(){
        return nextNode;
    }

    public void setNextNode(SinglyLinkedListNode<T> nextNode){
        this.nextNode = nextNode;
    }
}
