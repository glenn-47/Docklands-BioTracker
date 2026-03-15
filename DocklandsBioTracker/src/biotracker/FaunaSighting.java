/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biotracker;

/**
 *
 * @author glenn
 */
public class FaunaSighting extends EcoRecord {
    
    private final String animalType;
    private final String behaviourObserved; // Updated spelling!

    public FaunaSighting(String recordId, String location, String dateReported, String animalType, String behaviourObserved) {
        super(recordId, location, dateReported);
        this.animalType = animalType;
        this.behaviourObserved = behaviourObserved;
    }

    @Override
    public String displayDetails() {
        return "FAUNA [" + recordId + "] - Animal: " + animalType + 
               " | Location: " + location + " | Behaviour: " + behaviourObserved + 
               " | Date: " + dateReported;
    }
    
}
