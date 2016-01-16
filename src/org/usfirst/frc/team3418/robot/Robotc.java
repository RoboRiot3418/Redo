
package org.usfirst.frc.team3418.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robotc extends IterativeRobot {
	
	
Solenoid expander = new Solenoid (1); 
Solenoid clamp= new Solenoid (0);
Talon raise = new Talon(4);
Talon lift = new Talon(5);
Talon extend = new Talon(6);
Talon frontleft=new Talon(0);
Talon frontright=new Talon(1);
Talon backleft=new Talon(3);
Talon backright= new Talon(2);
Joystick stick= new Joystick(0);
double x = 0;
double y = 0;
double z = 0;
double r = 0;
boolean b = false;
boolean n  = false;
boolean once = true;
boolean output = false;
//Talon motor1 = new Talon (0);
//Talon motor2 = new Talon (1);
//Talon motor3 = new Talon (2);
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
    	//stick = new Joystick (5); 
    	//lift= new Talon(4);
    	//updown= new Joystick(?);
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
      
    	
    	
    	
    	
      	y=stick.getRawAxis(1);
    	r=stick.getRawAxis(3);
    	x=stick.getRawAxis(0);
    	z=stick.getRawAxis(2);
    	n=stick.getRawButton(2);
    	//lift.set());	
//    	extend.set(z*.25);
    	//raise.set(Math.cos(stick.getPOV(0)*Math.PI/180)*.5);
    	frontright.set(-z*(y+x+r));
    	frontleft.set(-z*(y*-1+x+r));
    	backleft.set(-z*(y*-1+x*-1+r));
    	backright.set(-z*(y+x*-1+r));
    	
    	
    	
    	
    	
    	
    	
    	System.out.println(n);
    	//button push
    	if(n==false){
    		once=false;
    		output=false;
    		System.out.println("n=false");
    	}else if(n==true && once==false){
			once = true;
    		output=true;
    		System.out.println("n=true, once=false");
    	}else 	if (once=true&&n==true){
    			once=true;
    			output=false;
    			System.out.println("n=true, once=true");
    	}
	
		if(output==true){
			b=!b;	
		
		}
 

    	if (stick.getRawButton(1)==true) { 
    		expander.set(true);
    	}
    	if (stick.getRawButton(1)== false){
    		expander.set(false);
    	}
   
//    	clamp.set(b);
    }
    
    
    
    
    private double getRawAxis(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
