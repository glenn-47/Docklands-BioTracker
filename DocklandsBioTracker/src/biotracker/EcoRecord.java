/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biotracker;

/**
 *
 * @author glenn
 */
public abstract class EcoRecord implements ITrackable {
    
    protected String recordId;
    protected String location;
    protected String dateReported;

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
