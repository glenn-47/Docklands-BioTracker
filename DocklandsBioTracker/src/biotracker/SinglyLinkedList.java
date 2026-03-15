/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biotracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: SinglyLinkedList
 * @author glenn
 * Description: A custom Singly Linked List ADT used to store approved 
 * EcoRecords.
 */
public class SinglyLinkedList {
    
    // The Node class (Inner class)
    // Acts as the fundamental building block of the linked list
    private class Node {
        EcoRecord data;
        Node next;
        
        Node(EcoRecord data) {
            this.data = data;
            this.next = null; // New nodes always point to null initially
        }
    }
    
    private Node head; // The starting point of the linked list
    private int size; // Tracks the total number of records for quick lookup

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Add a new record to the end (tail) of the list
    public void add(EcoRecord record) {
        Node newNode = new Node(record);
        
        // list empty
        if (head == null) {
            head = newNode;
        } 
        // list has items
        else {
            Node current = head;
            // traverse to last node
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++; // Increment the tracker
    }

    // Remove by ID and return the removed record (for the Undo Stack)
    public EcoRecord remove(String id) {
        if (head == null) return null;

        // If it's the very first node
        if (head.data.getRecordId().equals(id)) {
            EcoRecord removed = head.data;
            head = head.next;
            size--;
            return removed;
        }

        // If it's somewhere else in the list
        Node current = head;
        while (current.next != null && !current.next.data.getRecordId().equals(id)) {
            current = current.next;
        }

        if (current.next != null) {
            EcoRecord removed = current.next.data;
            current.next = current.next.next;
            size--;
            return removed;
        }

        return null; // Not found
    }

    // A helper to easily pass the data to GUI display
    public List<EcoRecord> toList() {
        List<EcoRecord> list = new ArrayList<>();
        Node current = head;
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

    public int size() {
        return size;
    }
    
}
