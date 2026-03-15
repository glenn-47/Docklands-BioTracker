/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biotracker;

/**
 * Class: Main
 * @author glenn
 * Description: The main entry point of the program. Goes through a series of 
 * console testing of the Queue, Stack, and SinglyLinkedList ADTs to clearly 
 * demonstrate functionality before automatically launching the MainGUI.
 */
public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("=============================================");
        System.out.println("   STARTING CONSOLE TEST   ");
        System.out.println("=============================================\n");

        // Initialise the Manager
        DataManager testManager = new DataManager();
        System.out.println("[TEST] DataManager initialised with pre-loaded data.");
        System.out.println("Initial Registry Size: " + testManager.getAllRecords().size());

        // Test the Queue (Add & Peek)
        System.out.println("\n--- TESTING QUEUE (ENQUEUE & PEEK) ---");
        EcoRecord testFlora = new FloraRecord("TEST-001", "Trinity College", "2026-03-15", "Rose", "Blooming");
        testManager.addRecord(testFlora);
        System.out.println("Added 'TEST-001' to Pending Queue.");
        System.out.println("Peek at Queue Front: " + testManager.peekNextPending().displayDetails());

        // Test Queue Dequeue (Approve Next)
        System.out.println("\n--- TESTING QUEUE (DEQUEUE TO LINKED LIST) ---");
        EcoRecord approved = testManager.approveNextPending();
        System.out.println("Approved Record: " + approved.getRecordId());
        System.out.println("Registry Size is now: " + testManager.getAllRecords().size());

        // Test Singly Linked List (Delete) & Stack (Push)
        System.out.println("\n--- TESTING SINGLY LINKED LIST (REMOVE) & STACK (PUSH) ---");
        boolean isDeleted = testManager.deleteRecord("TEST-001");
        System.out.println("Successfully deleted TEST-001? " + isDeleted);
        System.out.println("Registry Size after deletion: " + testManager.getAllRecords().size());

        // Test Stack (Pop / Undo)
        System.out.println("\n--- TESTING STACK (POP / UNDO) ---");
        EcoRecord restored = testManager.undoLastDeletion();
        System.out.println("Restored Record: " + restored.getRecordId());
        System.out.println("Final Registry Size: " + testManager.getAllRecords().size());

        System.out.println("\n=============================================");
        System.out.println("   CONSOLE TESTING COMPLETE. LAUNCHING GUI... ");
        System.out.println("=============================================\n");

        // Launch the GUI
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }
    
}
