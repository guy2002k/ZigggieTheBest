/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class CollectorDiscs extends Subsystem {
  //DoubleSelenoid
  private DoubleSolenoid doubleSolenoid;

  //instance
  private static CollectorDiscs instance;

  public static CollectorDiscs getInstance(){
    if(instance==null)
      instance=new CollectorDiscs();

    return instance;  
  }

  private CollectorDiscs(){
    //DoubleSelenoid implemention
    doubleSolenoid=new DoubleSolenoid(RobotMap.DISCS_DOUBLE_SELONOIDES_PORTS[0], RobotMap.DISCS_DOUBLE_SELONOIDES_PORTS[1]);

  }

  public void pushIn(){
    doubleSolenoid.set(Value.kReverse);
  }

  public void pushOut(){
    doubleSolenoid.set(Value.kForward);
  }

  @Override
  public void close(){
    doubleSolenoid.set(Value.kOff);
  }

  public void initDefaultCommand() {
    //nothing
  }
}
