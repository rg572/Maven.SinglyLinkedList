package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void addTest1(){
        // Arrange
        String expected = "Arg";
        Integer expectedSize = 2;
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        SinglyLinkedListNode<String> node1 = new SinglyLinkedListNode<>("Grr");
        SinglyLinkedListNode<String> node2 = new SinglyLinkedListNode<>(expected);

        // Act
        list.add(node1);
        list.add(node2);
        String actual = list.get(1);
        Integer actualSize = list.size();

        // Assert
        Assert.assertEquals(expectedSize,actualSize);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addTest2(){
        // Arrange
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        SinglyLinkedListNode<String> node1 = new SinglyLinkedListNode<>("Grr");
        SinglyLinkedListNode<String> node2 = new SinglyLinkedListNode<>("Arg");

        // Act
        list.add(node1);
        list.add(node2);
        String actual = list.get(2);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addTest3(){
        // Arrange
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        SinglyLinkedListNode<String> node1 = new SinglyLinkedListNode<>("Grr");
        SinglyLinkedListNode<String> node2 = new SinglyLinkedListNode<>("Arg");

        // Act
        list.add(node1);
        list.add(node2);
        String actual = list.get(-2);

    }
}
