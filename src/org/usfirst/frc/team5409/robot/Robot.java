
package org.usfirst.frc.team5409.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;

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
	
	Joystick driver;
	Talon leftFrontMotor;
	Talon leftBackMotor;
	Talon rightFrontMotor;
	Talon rightBackMotor;
    public void robotInit() {
    	driver = new Joystick(0);
    	leftFrontMotor = new Talon(0); // port number refers to PWM port on roborio
    	leftBackMotor = new Talon(1);
    	rightFrontMotor = new Talon(2);
    	rightBackMotor = new Talon(3);
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
    	double leftYAxis = driver.getRawAxis(1) * -1;
    	double rightYAxis = driver.getRawAxis(5) * -1;
    	boolean button = driver.getRawButton(1); // B button on XBOX Controller
    	
    	if(button){
    		System.out.println("Brake"); //prints Brake
    		leftFrontMotor.set(0);
    		leftBackMotor.set(0);
    		rightFrontMotor.set(0);
    		rightBackMotor.set(0);
    	}else{
    		leftFrontMotor.set(leftYAxis);
    		leftBackMotor.set(leftYAxis);
        	rightFrontMotor.set(rightYAxis);
        	rightBackMotor.set(rightYAxis);
    	}
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
