/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  //PORTS FOR THE TALONS THAT DRIVING
  public static final int RIGHT_MASTER_PORT=1;
  public static final int RIGHT_SLAVE_PORT=2;
  public static final int LEFT_MASTER_PORT=3;
  public static final int LEFT_SLAVE_PORT=4;

  //PORTS FOR THE TALONS THAT ELEVATORING
  public static final int MASTER_ELEVATOR_PORT=5;
  public static final int SLAVE_ELEVATOR_PORT=6;

  //PORTS FOR THE COLLECTOR TALON
  public static final int COLLECTOR_PORT=7;

  //PORTS FOR JOYSTICKS AND CONTROLLERS
  public static final int PORT_JOYSTICK_LEFT=0;
  public static final int PORT_JOYSTICK_RIGHT=1;
  public static final int PORT_XBOX_CONTROLLER=2;

  //PORTS FOR BUTTONS
  public static final int A_BUTTON_PORT=1;
  public static final int B_BUTTON_PORT=2;
  public static final int X_BUTTON_PORT=3;
  public static final int Y_BUTTON_PORT=4;
  public static final int LEFT_BUMPER_PORT=5;
  public static final int RIGHT_BUMPER_PORT=6;

  //Limit Switch port
  public static final int LIMIT_SWITCH_PORT=1;

  //Speed constatns
  public static final double MOVE=0.7;
  public static final double STOP=0;

  //Compressor port
  public static final int PORT_COMPRESSOR=0;

  //DoubleSelonoides ports for the discs
  public static final int[] DISCS_DOUBLE_SELONOIDES_PORTS= {2,3};

  //DoubleSelonoides ports for the shifters
  public static final int [] SHIFTERS_DOUBLE_SELONOIDES_PORTS={0,1};
}
