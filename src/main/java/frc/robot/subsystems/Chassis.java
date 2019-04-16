/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;

/**
 * Add your docs here.
 */
public class Chassis extends Subsystem {
  //Talons SRX
  private  WPI_TalonSRX masterRight;
  private  WPI_TalonSRX masterLeft;
  private  WPI_TalonSRX slaveRight;
  private  WPI_TalonSRX slaveLeft;

  //Doubleselonoid controls the shifter
  private DoubleSolenoid shifterController;

  //DifferentialDrive
  private DifferentialDrive drive;
  
  //instance 
  private static Chassis instance;

  public static Chassis getInstance() {
    if(instance==null){
      instance=new Chassis();
    }
    return instance;
  }

  private Chassis(){
    //Talons for driving
    masterRight=new WPI_TalonSRX(RobotMap.RIGHT_MASTER_PORT);
    masterLeft=new WPI_TalonSRX(RobotMap.LEFT_MASTER_PORT);
    slaveRight=new WPI_TalonSRX(RobotMap.RIGHT_SLAVE_PORT);
    slaveLeft=new WPI_TalonSRX(RobotMap.LEFT_SLAVE_PORT);

    //Driving slaves follows the driving masters
    slaveLeft.follow(masterLeft);
    slaveRight.follow(masterRight);

    //Invertering the driving talons
    masterRight.setInverted(true);
    slaveRight.setInverted(InvertType.FollowMaster);
    masterLeft.setInverted(false);
    slaveLeft.setInverted(InvertType.FollowMaster);

    //sefety talons
    masterRight.setSafetyEnabled(true);
    masterLeft.setSafetyEnabled(true);

    //Impelementing the DifferentialDrive object
    drive=new DifferentialDrive(masterRight,masterLeft);

    //Implementing the doubleseloind object
    shifterController=new DoubleSolenoid(RobotMap.SHIFTERS_DOUBLE_SELONOIDES_PORTS[0], RobotMap.SHIFTERS_DOUBLE_SELONOIDES_PORTS[1]);
  }

  public void arcadeDrive(double x,double z){
    drive.arcadeDrive(x,z);
  }

  public void tankDrive(double leftSpeed,double rightSpeed){
    drive.tankDrive(leftSpeed, rightSpeed);
  }

  public void stop(){
    masterRight.stopMotor();
    masterLeft.stopMotor();
    slaveRight.stopMotor();
    slaveLeft.stopMotor();
  }

  public void forceMode(){
    shifterController.set(Value.kForward);
  }

  public void velocityMode(){
    shifterController.set(Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ArcadeDrive());
  }
  }

