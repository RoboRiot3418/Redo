/** 
Eclipse Mars can go get bent.
Eclipse Mars can go get bent.
Eclipse Mars can go get bent.
Eclipse Mars can go get bent.
*/
package org.usfirst.frc.team3418.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import java.lang.Math;

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
	 
	 Talon motor8 = new Talon (4);
	 
	 Joystick stick = new Joystick (5);
	 /** the number is the usb port
	 */
	 
	 double a = 0;
	 double deadzone = .2;
	 
	 /**public double deadzone(double original){
		 if (original>(deadzone*-1) && original <deadzone){
			return 0
		 }
		 */
		 return original
	 }
	 
	 
	 
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
    public void teleopPeriodic() 
		
		a=stick.getRawAxis(1);
/* 
pushing forward is -1
*/
		
        //if (stick.getRawButton(4))
			
		motor8.set(a);
		
		
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
