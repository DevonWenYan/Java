/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw7;

/**
 *
 * @author Yan
 */
public class TimeLength {
    private static final double hour_minute =60.0;
    private static final double minute_second =60.0;
    private static final double hour_second =3600.0;
    private double time;
    
    public TimeLength(){
        time=0.0;
    }
    
    //Set the number of seconds, the parameter is seconds
    public void setTime(double time){
        this.time=time;
    }
    
    //Set the number of seconds, the parameters are hours and minutes
    public void setTime(int hour,int minute,int second){
        double timesecond=convertToSecond(hour,minute,second);
        time=timesecond;
    }
    
    //Hours and minutes converted to seconds
    private double convertToSecond(int hour,int minute,int second){
        
            return hour*hour_second+minute*minute_second+second;
      
        
    }
    
    //Adjust the length of time, the parameter is seconds
    public void adjustTime(double time){
        this.time+=time;
    }
    
    //Adjust the length of time, the parameter is seconds
    public void adjustTime(int hour,int minute,int second){
        
        adjustTime(convertToSecond(hour,minute,second));
    }
    
    //Get minutes
    public double getminute(){
        
        return (int)Math.floor(time/minute_second)%hour_minute;
    }
    //Get seconds
    public double getTime(){
        return time;
    }
    
    //Get hours
    public double gethour(){
        return (int) Math.floor(time/hour_second); 
    }
}
