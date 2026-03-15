/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package biotracker;

import java.util.List;

/**
 *
 * @author glenn
 */
public interface IManageable {
    
    void addRecord(EcoRecord record);
    void deleteRecord(String id);
    List<EcoRecord> getAllRecords();
    
}
