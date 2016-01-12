/* Nathan was here first :D
 * 
 * 
 * 
 * 
 */
package org.usfirst.frc.team3418.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	
	
	Solenoid clamp = new Solenoid(0);
	boolean once;
	int stick;
	
	
	
    public void robotInit() {

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        
    	
    	
    	
    	
    	
    	
    	
    // CLAMP
    	
    	
    	
    	
    if (stick.getrawbutton()>0){
    		if (once == true )
    		{
    			clamp.set(!clamp.get());
    			once = false;
    		}
    	}
    else {
    		once = true;
    	
    	}
    }
    
    
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
