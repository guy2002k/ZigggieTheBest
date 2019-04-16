/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {
 //TalonSrxes
 private  WPI_TalonSRX masterElevator;
 private  WPI_TalonSRX slaveElevator;

 //micro-switch
 private DigitalInput limitSwitchDown;

 //Elevetor instance
 private static Elevator instance;

 public static Elevator getInstance(){
   if(instance==null)
     instance=new Elevator();
   
    return  instance; 
 }

 private Elevator(){
   //Talons for Elevator
   masterElevator=new WPI_TalonSRX(RobotMap.MASTER_ELEVATOR_PORT);
   slaveElevator=new WPI_TalonSRX(RobotMap.SLAVE_ELEVATOR_PORT);
   
   //Limit-switch 
   limitSwitchDown=new DigitalInput(RobotMap.LIMIT_SWITCH_PORT);

   //Elevator slave follows the Elevator master
   slaveElevator.follow(masterElevator);
   
   //Invertering the Elevator talons
   masterElevator.setInverted(false);
   slaveElevator.setInverted(InvertType.FollowMaster);

   //talonSRX safe
   masterElevator.setSafetyEnabled(true);
   slaveElevator.setSafetyEnabled(true);
 }

 public void liftUp(){
     masterElevator.set(RobotMap.MOVE);
 }

 public void stopElevator(){
   masterElevator.set(RobotMap.STOP);
 }

 public void liftDown(){
     if(!limitSwitchDown.get())
        masterElevator.set(-RobotMap.MOVE);
    else
       stopElevator();    
 }

 public void stop(){
   masterElevator.stopMotor();
   slaveElevator.stopMotor();
 }

 @Override
 public void initDefaultCommand() {
   //nothing
 }
}
