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
        String str1 = "Grr";
        String expected = "Arg";
        Integer expectedSize = 2;
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        // Act
        list.add(str1);
        list.add(expected);
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
        String str1 = "Grr";
        String str2 = "Arg";

        // Act
        list.add(str1);
        list.add(str2);
        String actual = list.get(2);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addTest3(){
        // Arrange
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        String str1 = "Grr";
        String str2 = "Arg";

        // Act
        list.add(str1);
        list.add(str2);
        String actual = list.get(-2);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeTest1(){
        // Arrange
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        String str1 = "Grr";
        String str2 = "Arg";

        // Act
        list.add(str1);
        list.add(str2);
        list.remove(-2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeTest2(){
        // Arrange
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        String str1 = "Grr";
        String str2 = "Arg";

        // Act
        list.add(str1);
        list.add(str2);
        list.remove(3);
    }

    @Test
    public void removeTest3(){
        // Arrange
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        String str1 = "Grr";
        String str2 = "Arg";
        String str3 = "Mutant";
        String str4 = "Enemy";
        Integer expectedLength = 3;
        String expectedValue = "Enemy";


        // Act
        list.add(str1);
        list.add(str2);
        list.add(str3);
        list.add(str4);
        list.remove(1);
        Integer actualLength = list.size();
        String actualValue = list.get(2);

        // Assert
        Assert.assertEquals(expectedLength, actualLength);
        Assert.assertEquals(expectedValue, actualValue);

    }

    @Test
    public void removeTest4(){
        // Arrange
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        String str1 = "Grr";
        String str2 = "Arg";
        String str3 = "Mutant";
        String str4 = "Enemy";
        Integer expectedLength = 3;
        String expectedValue = "Mutant";


        // Act
        list.add(str1);
        list.add(str2);
        list.add(str3);
        list.add(str4);
        list.remove(3);
        Integer actualLength = list.size();
        String actualValue = list.get(2);

        // Assert
        Assert.assertEquals(expectedLength, actualLength);
        Assert.assertEquals(expectedValue, actualValue);

    }

    @Test
    public void sortTest1(){
        // Arrange;
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        Integer e1 = 1;
        Integer e2 = 2;
        Integer e3 = 3;
        Integer e4 = 4;
        Integer e5 = 5;
        list.add(e5);
        list.add(e4);
        list.add(e3);
        list.add(e2);
        list.add(e1);

        // Act
        list.sort();
        Integer a1 = list.get(0);
        Integer a2 = list.get(1);
        Integer a3 = list.get(2);
        Integer a4 = list.get(3);
        Integer a5 = list.get(4);

        // Assert
        Assert.assertEquals(e1, a1);
        Assert.assertEquals(e2, a2);
        Assert.assertEquals(e3, a3);
        Assert.assertEquals(e4, a4);
        Assert.assertEquals(e5, a5);

    }

    @Test
    public void sortTest2(){
        // Arrange
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("Eat");
        list.add("Shit");
        list.add("And");
        list.add("Die");

        // Act
        list.sort();
        String a1 = list.get(0);
        String a2 = list.get(1);
        String a3 = list.get(2);
        String a4 = list.get(3);

        // Assert
        Assert.assertEquals("And", a1);
        Assert.assertEquals("Die", a2);
        Assert.assertEquals("Eat", a3);
        Assert.assertEquals("Shit",a4);

    }

    @Test
    public void containsTest1(){
        // Arrange
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Grr");
        list.add("Arg");
        list.add("Mutant");
        list.add("Enemy");

        // Act
        Boolean actual = list.contains("Mutant");

        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void containsTest2(){
        // Arrange
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Grr");
        list.add("Arg");
        list.add("Mutant");
        list.add("Enemy");

        // Act
        Boolean actual = list.contains("Entertainment");

        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void findTest1(){
        // Arrange
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Grr");
        list.add("Arg");
        list.add("Mutant");
        list.add("Enemy");
        Integer expected = 2;

        // Act
        Integer actual = list.find("Mutant");

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findTest2(){
        // Arrange
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Grr");
        list.add("Arg");
        list.add("Mutant");
        list.add("Enemy");
        Integer expected = -1;

        // Act
        Integer actual = list.find("Entertainment");

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void copyTest1(){
        // Arrange
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("Grr");
        list.add("Arg");
        list.add("Mutant");
        list.add("Enemy");
        Integer expected = 4;

        // Act
        SinglyLinkedList<String> list2 = list.copy();
        Integer actual = list2.size();

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void copyTest2(){
        // Arrange
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("Grr");
        list.add("Arg");
        list.add("Mutant");
        list.add("Enemy");
        String expected = "Mutant";

        // Act
        SinglyLinkedList<String> list2 = list.copy();
        String actual = list2.get(2);

        // Assert
        Assert.assertEquals(expected, actual);
    }
}
