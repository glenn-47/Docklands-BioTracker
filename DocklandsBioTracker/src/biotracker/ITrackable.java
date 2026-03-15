/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package biotracker;

/**
 * Interface: ITrackable
 * @author glenn
 * Description: A secondary interface implemented to ensure all tracked objects 
 * have standard spatial and temporal data (location and date).
 */
public interface ITrackable {
    
    String getLocation();
    String getDateReported();
    
}
