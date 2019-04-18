/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.CollectBall;

/**
 * Add your docs here.
 */
public class CollectorBalls extends Subsystem {
  //victor
  private VictorSPX victor;

  //instance
  private static CollectorBalls instane;

  public static CollectorBalls getInstance(){
    if(instane==null)
      instane=new CollectorBalls();
    return instane;  
  }

  private CollectorBalls(){
    //Victor implemention
    victor=new WPI_VictorSPX(RobotMap.COLLECTOR_PORT);

  }

  public void PushIn(double speed){
    victor.set(ControlMode.PercentOutput,speed);
  }

  public void PushOut(double speed){
    victor.set(ControlMode.PercentOutput,-speed);
  }

  public void stop(){
    victor.set(ControlMode.PercentOutput,RobotMap.STOP);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new CollectBall());
  }
}
