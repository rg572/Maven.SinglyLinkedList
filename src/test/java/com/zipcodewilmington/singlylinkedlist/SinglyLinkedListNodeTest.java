package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedListNodeTest {

    @Test
    public void constructorTest(){
        // Arrange
        String expected = "Thpp";
        SinglyLinkedListNode<String> node = new SinglyLinkedListNode(expected);

        // Act
        String actual = node.getStoredObject();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setNextNodeTest(){
        // Arrange
        SinglyLinkedListNode<String> node = new SinglyLinkedListNode<String>("Grr");
        SinglyLinkedListNode<String> expected = new SinglyLinkedListNode<String>("Arg");

        // Act
        node.setNextNode(expected);
        SinglyLinkedListNode actual = node.getNextNode();

        // Assert
        Assert.assertEquals(expected, actual);
    }

}