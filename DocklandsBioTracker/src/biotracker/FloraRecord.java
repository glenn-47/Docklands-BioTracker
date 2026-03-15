/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biotracker;

/**
 *
 * @author glenn
 */
public class FloraRecord extends EcoRecord {
    
    private final String plantSpecies;
    private final String healthStatus;

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
