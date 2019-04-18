/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CollectBall extends Command {
  public CollectBall() {
    requires(Robot.collectorBalls);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.oi.getLeftTriggerSpeed()>Robot.oi.getRightTriggerSpeed())
      Robot.collectorBalls.PushIn(Robot.oi.getLeftTriggerSpeed());
    else if(Robot.oi.getLeftTriggerSpeed()<Robot.oi.getRightTriggerSpeed())
      Robot.collectorBalls.PushOut(Robot.oi.getRightTriggerSpeed());
    else
      Robot.collectorBalls.stop();   
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.collectorBalls.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
