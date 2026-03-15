/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package biotracker;

import java.util.List;

/**
 * Interface: IManageable
 * @author glenn
 * Description: Defines the core CRUD (Create, Read, Update, Delete) operations 
 * required for managing biological records within the application.
 */
public interface IManageable {
    
    void addRecord(EcoRecord record);
    boolean deleteRecord(String id);
    List<EcoRecord> getAllRecords();
    
}
