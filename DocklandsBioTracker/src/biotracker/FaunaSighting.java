/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biotracker;

/**
 * Class: FaunaSighting
 * @author glenn
 * Description: A subclass of EcoRecord representing animal sightings. 
 * Overrides displayDetails() to output fauna-specific behaviour and details.
 */
public class FaunaSighting extends EcoRecord {
    
    // Using private for encapsulation.
    // Once an animal type and its behaviour are logged, they should not be altered. (final)
    private final String animalType;
    private final String behaviourObserved;
    
    // Constructor to initialise both the inherited fields and the specific fields
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
