package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T> {

    SinglyLinkedListNode<T> firstNode;
    Integer size;

    public SinglyLinkedList(){
        this.firstNode = null;
        this.size = 0;
    }

    public void add(SinglyLinkedListNode<T> node){
        if(firstNode == null){
            firstNode = node;
        }
        else{
            SinglyLinkedListNode<T> lastNode = firstNode;
            while(lastNode.getNextNode() != null){
                lastNode = lastNode.getNextNode();
            }
            lastNode.setNextNode(node);
        }
        size++;
    }

    public Integer size(){
        return size;
    }

    public T get(Integer index){
        if(index >= size || index < 0 ){
            throw new IndexOutOfBoundsException();
        }
        else{
            Integer count = 0;
            SinglyLinkedListNode<T> node = firstNode;
            while(count <= index){
                if(count == index){
                    return node.getStoredObject();
                }
                node = node.getNextNode();
                count++;
            }
        }
        throw new IndexOutOfBoundsException("This should never have been reached");
    }
}
