/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Pneumatics extends Subsystem {
  //compressor
  private Compressor compressor;

  //preasure
  private AnalogInput preasureSensor;

  //instance
  private static Pneumatics instance;

  public static Pneumatics getInstance(){
    if(instance==null)
     instance=new Pneumatics();

    return instance; 
  }

  private Pneumatics(){
    //implemention of the compressor
    compressor=new Compressor(RobotMap.PORT_COMPRESSOR);

    //implemention of the preasure sensor
    preasureSensor=new AnalogInput(RobotMap.PREASUR_SENSOR_PORT);
  }

  public void startCompressor(){
    compressor.start();
  }
  
  public void stopCompressor(){
    compressor.stop();
  }

  public void compressorState(){
    int preasure=250*(preasureSensor.getAverageValue()/RobotMap.VCC_CONSTANT)-25;
    SmartDashboard.putNumber("preasure:", preasure);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
