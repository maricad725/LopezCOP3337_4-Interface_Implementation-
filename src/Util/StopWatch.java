//==============================================================================
// StopWatch class is utilized to create an object that can track and return 
// The runtime for any algorithm.
//============================================================================== 
package Util;

public class StopWatch{
    
    //--------------------------
    // Private Class Objects
    //--------------------------
    private long elapsedTime;
    private long startTime;
    private boolean isRunning;
    
    //--------------------------------------------------------------
    // Default constructor:
    // uses reset function to intialize isRunning and elapsedtime 
    //--------------------------------------------------------------
    public StopWatch(){
        reset();
    }
    
    //-------------------------------
    // method that starts the timer
    //-------------------------------
    public void start(){
        // check for timer that is already running 
        if(isRunning){
            return;
        }
        
        isRunning = true;
        startTime = System.currentTimeMillis();
    }
    //------------------------------------
    // method that stops timer
    // also gets the elapsed time
    //------------------------------------
    public void stop(){
        // check for timer that isn't running
        if(!isRunning){
            return;
        }
        
        isRunning = false;
        long endTime = System.currentTimeMillis();
        elapsedTime += endTime - startTime;        
    }
        //---------------------------------
        // Returns elapsed time 
        //---------------------------------
    public long getElapsedtTime(){
        // Checks to see if timer is still running
        if (isRunning){
        long endTime = System.currentTimeMillis();
        elapsedTime += endTime - startTime; 
        }
        
        return elapsedTime;
    }
    
    //-------------------------------------
    // method that resets the timer 
    //-------------------------------------
    public void reset(){
        elapsedTime = 0;
        isRunning = false;
    }
                
}
