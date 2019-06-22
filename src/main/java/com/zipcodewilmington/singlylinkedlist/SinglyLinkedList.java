package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable<T>> {

    private SinglyLinkedListNode<T> firstNode;
    private Integer size;

    public SinglyLinkedList(){
        this.firstNode = null;
        this.size = 0;
    }

    public void add(T o){
        SinglyLinkedListNode<T> node = new SinglyLinkedListNode<>(o);
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

    public void remove(Integer index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        SinglyLinkedListNode<T> node = firstNode;
        SinglyLinkedListNode<T> prevNode = firstNode;

        Integer count = 1;
        while(count <= index){
            node = node.getNextNode();

            if(count == index){
                prevNode.setNextNode(node.getNextNode());
                size--;
                return;
            }
            prevNode = node;
            count++;
        }

    }

    public Boolean contains(T o){
        return find(o) != -1;
    }

    public Integer find(T o){
        SinglyLinkedListNode<T> node = firstNode;
        for(int i = 0; i < size; i++){
            if(o.equals(node.getStoredObject())){
                return i;
            }
            node = node.getNextNode();
        }
        return -1;
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


    public void sort(){
        if(size < 2){
            return;
        }

        SinglyLinkedListNode<T> keepTrackNode = new SinglyLinkedListNode<>(null);
        keepTrackNode.setNextNode(firstNode);

        SinglyLinkedListNode<T> prevNode = keepTrackNode;
        SinglyLinkedListNode<T> thisNode = firstNode;
        SinglyLinkedListNode<T> nextNode = firstNode.getNextNode();

        for(int i = 0; i < size - 1; i++){
            Boolean swapped = false;
            for(int j = 0; j < size() - i -1; j++){
                if(thisNode.getStoredObject().compareTo(nextNode.getStoredObject()) > 0){
                    swapped = true;
                    thisNode.setNextNode(nextNode.getNextNode());
                    nextNode.setNextNode(thisNode);
                    prevNode.setNextNode(nextNode);

                    prevNode = nextNode;
                    nextNode = thisNode.getNextNode();
                }
                else {
                    nextNode = nextNode.getNextNode();
                    thisNode = thisNode.getNextNode();
                    prevNode = prevNode.getNextNode();
                }
            }
            if(!swapped){
                break;
            }
            prevNode = keepTrackNode;
            thisNode = prevNode.getNextNode();
            nextNode = thisNode.getNextNode();
        }
        firstNode = keepTrackNode.getNextNode();

    }

    public SinglyLinkedList<T> copy(){
        SinglyLinkedList<T> list = new SinglyLinkedList<>();

        SinglyLinkedListNode<T> node = firstNode;

        while(node != null){
            list.add(node.getStoredObject());
            node = node.getNextNode();
        }
        return list;
    }
}
