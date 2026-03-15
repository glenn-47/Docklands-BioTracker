/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biotracker;

/**
 * Class: FloraRecord
 * @author glenn
 * Description: A subclass of EcoRecord representing plant life. 
 * Overrides displayDetails() to output flora-specific information.
 */
public class FloraRecord extends EcoRecord {
    
    // Using private for encapsulation.
    // Once a plant's species and initial health are logged, they are locked in. (final)
    private final String plantSpecies;
    private final String healthStatus;
    
    // Constructor to initialise both inherited fields and Flora-specific fields
    public FloraRecord(String recordId, String location, String dateReported, String plantSpecies, String healthStatus) {
        super(recordId, location, dateReported);
        this.plantSpecies = plantSpecies;
        this.healthStatus = healthStatus;
    }
    
    @Override
    public String displayDetails() {
        return "FLORA [" + recordId + "] - Species: " + plantSpecies + 
               " | Location: " + location + " | Health: " + healthStatus + 
               " | Date: " + dateReported;
    }
    
}
