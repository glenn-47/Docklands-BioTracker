/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biotracker;

/**
 * Abstract Class: EcoRecord
 * @author glenn
 * Description: The abstract superclass representing a generic biological 
 * record in the Smart Docklands. Implements the ITrackable interface and 
 * defines the abstract displayDetails() method for Polymorphism.
 */
public abstract class EcoRecord implements ITrackable {
    
    // Using the protected access modifier allows child classes (Flora/Fauna) 
    // to inherit and access these variables directly, while still keeping them 
    // hidden from the rest of the application (Encapsulation).
    protected String recordId;
    protected String location;
    protected String dateReported;
    
    // Constructor to initialise the core data shared by all biological records.
    public EcoRecord(String recordId, String location, String dateReported) {
        this.recordId = recordId;
        this.location = location;
        this.dateReported = dateReported;
    }

    public String getRecordId() {
        return recordId;
    }

    public String getLocation() {
        return location;
    }

    public String getDateReported() {
        return dateReported;
    }

    // Abstract method for Polymorphism
    public abstract String displayDetails();
    
}
