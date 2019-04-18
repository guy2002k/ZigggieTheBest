/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ForceMode;
import frc.robot.commands.LiftDown;
import frc.robot.commands.LiftUp;
import frc.robot.commands.VelocityMode;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
      //Joysticks
      private Joystick leftStick;
      private Joystick rightStick;
  
      //Xbox controller
      private XboxController xbox; 
  
      //Buttons for Elevator
      private Button elevatorUpButton; //Button A
      private Button elevatorDownButton; //Button b
  
      private Button collectInButton; //Left bumper
      private Button collectOutButton; //Right bumber
  
      private Button openPiston;//Button x
      private Button closePiston;//Button y

      private Button forceMode;
      private Button velocityMode;
  
      public OI(){
        //Controllers implemention
        leftStick=new Joystick(RobotMap.PORT_JOYSTICK_LEFT);
        rightStick=new Joystick(RobotMap.PORT_JOYSTICK_RIGHT);
        xbox=new XboxController(RobotMap.PORT_XBOX_CONTROLLER);
  
        //Buttons implemention
         //elevator
        elevatorUpButton=new JoystickButton(xbox, RobotMap.RIGHT_BUMPER_PORT);
        elevatorDownButton=new JoystickButton(xbox, RobotMap.LEFT_BUMPER_PORT);
         //collector
        collectInButton=new JoystickButton(xbox, RobotMap.LEFT_BUMPER_PORT);
        collectOutButton=new JoystickButton(xbox, RobotMap.RIGHT_BUMPER_PORT);
         //piston
        openPiston=new JoystickButton(xbox, RobotMap.X_BUTTON_PORT);
        closePiston=new JoystickButton(xbox, RobotMap.Y_BUTTON_PORT);
         //shifters
        forceMode=new JoystickButton(leftStick, RobotMap.FORCE_BUTTON_PORT);
        velocityMode=new JoystickButton(leftStick, RobotMap.VELOCITY_BUTTON_PORT);

        //For the switching shifters mode
        forceMode.whenPressed(new ForceMode());
        velocityMode.whenPressed(new VelocityMode());
  
        //For the elevator buttons
        elevatorUpButton.whileHeld(new LiftUp());
        elevatorDownButton.whileHeld(new LiftDown());
  
        //For the Collect balls buttons
        collectInButton.whileHeld(new CollectBallIn());
        collectOutButton.whileHeld(new CollectBallOut());
  
        //For opening and closing the piston
        openPiston.whenPressed(new OpenPiston());
        closePiston.whenPressed(new ClosePiston());
      }
  
      //Gets for the joysticks coordinates
      public double getLeftX(){
        return leftStick.getX();
      }
  
      public double getRightX(){
        return rightStick.getX();
      }
  
      public double getLeftY(){
        return leftStick.getY();
      } 
  
      public double getRightY(){
        return rightStick.getY();
      }
  
      public double getLeftZ(){
        return rightStick.getY();
      }
  
      public double getRightZ(){
        return rightStick.getY();
      }
}
