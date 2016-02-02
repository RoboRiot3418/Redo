
package org.usfirst.frc.team3418.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    SendableChooser chooser;
    
	RobotDrive drive = new RobotDrive(0,3,1,2);
	Talon lift = new Talon(4);
	Talon arm = new Talon(5);
	Joystick stick = new Joystick(0);
	Solenoid grabber = new Solenoid(0);
	Solenoid clamp = new Solenoid(1);
	DigitalInput top = new DigitalInput(5);
	DigitalInput bottom = new DigitalInput(4);
	Encoder bill = new Encoder(0,1);
	double x=0;
	double y=0;
	double z=0;
	double r=0;
	boolean e=false;
	boolean b=false;	
	boolean a=false;
	boolean c=false;
	boolean u=false;
	boolean d=false;
	boolean once = true;
	boolean output=false;
	double dzc = 0.1;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	
	public double dz(double origin) {
    	if (origin <= dzc && origin >= (-(dzc))){
    		return 0.0;
    	}
    	else{
    		return origin;
    	}
    }
	
    public void robotInit() {
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        SmartDashboard.putData("Auto choices", chooser);
        drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        
        
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
    	autoSelected = (String) chooser.getSelected();
//		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	switch(autoSelected) {
    	case customAuto:
        //Put custom auto code here   
            break;
    	case defaultAuto:
    	default:
    	//Put default auto code here
            break;
    	}
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	x=stick.getRawAxis(0);
		z=stick.getRawAxis(2);
    	y=stick.getRawAxis(1);
    	r=stick.getRawAxis(4);
    	a=stick.getRawButton(3);
    	c=stick.getRawButton(2);
    	e=stick.getRawButton(5);
    	b=stick.getRawButton(6);
    	u=stick.getRawButton(4);
    	d=stick.getRawButton(1);
    	System.out.println("x: " + x + "y: " + y + "z: " + z + "r: " + r);
    	System.out.println(bill.get());
    	/**
    	frontright.set(-x);
    	backright.set(-x);
    	frontleft.set(x);
    	backleft.set(x);
    	**/
    	
    	if (bottom.get()==false){
    		bill.reset();
    	}
    	
    	drive.mecanumDrive_Cartesian(-0.5*dz(x), -0.5*dz(y), -0.5*dz(r), 0.0);

    	
    	
   // mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm

    	

    	if (a==true){
    		grabber.set(true);
    	}
    	else{
    		grabber.set(false);
    	}
   // mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
    	if (c=true){
    		clamp.set(true);
    	}
    	else {
    		clamp.set(false);
    	}
  // mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm

    	if (u && top.get()==true && bill.get() <= -5950){
    		lift.set(.35);
    	}
    	else if (d && bottom.get()==true && bill.get() >= -400){
    		lift.set(-.35);
    	}
    	else if (d && bottom.get()==true){
    		lift.set(-.5);
    	}
    	else if (u && top.get()==true){
    		lift.set(.5);
    	}
    	else{
    		lift.set(0);
    	}
   // mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
   	
    	if(e){
    		arm.set(.5);
    	}
    	else if (b){
    		arm.set(-.5);
    	}
    	else{
    		arm.set(0);
    	}
    }
   // mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
