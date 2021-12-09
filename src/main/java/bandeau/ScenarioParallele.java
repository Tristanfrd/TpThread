/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bandeau;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author tristanfrederick
 */
public class ScenarioParallele extends Thread{
    
    private Bandeau b;
    private List<ScenarioElement> myElements = new LinkedList<>();
    
    public ScenarioParallele(Bandeau bandeau, List<ScenarioElement> mesElements){
        this.b = bandeau;
        this.myElements= mesElements;
    }
    
    
    
    public void run(){
        synchronized(b){
            for (ScenarioElement element : myElements) {
                for (int repeats = 0; repeats < element.repeats; repeats++) {
                    element.effect.playOn(b);
                }
            }
        }
    
}
    
}
