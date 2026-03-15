/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biotracker;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Class: DataManager
 * @author glenn
 * Description: The backend of the application. Implements IManageable 
 * and controls data flow using 3 ADTs: a Queue (for pending records), 
 * a Stack (for undoing deletions), and a custom SinglyLinkedList (main registry).
 */
public class DataManager implements IManageable {
    
     // ADTs
    private final SinglyLinkedList mainRegistry; // Verified records
    private final Queue<EcoRecord> pendingQueue;     // Waiting to be verified
    private final Stack<EcoRecord> undoStack;        // Deleted records (LIFO)
    
    public DataManager() {
        mainRegistry = new SinglyLinkedList();
        pendingQueue = new LinkedList<>(); // LinkedList acts as Queue
        undoStack = new Stack<>();
        
        // --- EXISTING RECORDS ---
        mainRegistry.add(new FloraRecord("REC-001", "Mayor Square", "2025-10-20", "Oak Tree", "Healthy"));
        mainRegistry.add(new FaunaSighting("REC-002", "Grand Canal Dock", "2025-10-21", "Swan", "Nesting"));
        mainRegistry.add(new FloraRecord("REC-003", "Spencer Dock", "2025-10-22", "Fern", "Needs Water"));
        mainRegistry.add(new FaunaSighting("REC-004", "Samuel Beckett Bridge", "2025-10-23", "Seagull", "Scavenging"));
    }

    // --- INTERFACE METHODS ---
    
    // Add
    @Override
    public void addRecord(EcoRecord record) {
        // New records go to the queue first
        pendingQueue.add(record);
    }
    // Delete
    @Override
    public boolean deleteRecord(String id) {
        EcoRecord deletedRecord = mainRegistry.remove(id);
        
        if (deletedRecord != null) {
            undoStack.push(deletedRecord);
            return true;
        }
        return false;
    }

    @Override
    public List<EcoRecord> getAllRecords() {
        return mainRegistry.toList(); // Uses helper method so the GUI doesn't break
    }
    
    // Peek at the front of the queue without removing it
    public EcoRecord peekNextPending() {
        return pendingQueue.peek(); // Returns the record, or null if empty
    }
    
    // Approve
    // dequeue the next pending record and add it to the main registry
    public EcoRecord approveNextPending() {
        if (!pendingQueue.isEmpty()) {
            EcoRecord approvedRecord = pendingQueue.poll(); // Removes from front of Queue
            mainRegistry.add(approvedRecord);
            return approvedRecord; // Return it so the GUI can display
        }
        return null; // Nothing to approve
    }
    
    // Undo
    // Pop the last deleted record off the stack and put it back in the registry
    public EcoRecord undoLastDeletion() {
        if (!undoStack.isEmpty()) {
            EcoRecord restoredRecord = undoStack.pop(); // Removes from top of Stack
            mainRegistry.add(restoredRecord);
            return restoredRecord;
        }
        return null; // Nothing to undo
    }
    
    // Helper to check how many are waiting in the queue
    public int getPendingCount() {
        return pendingQueue.size();
    }
    
}
