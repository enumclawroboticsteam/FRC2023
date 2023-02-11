// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.Autonomous;
import frc.robot.commands.ReachOut;
import frc.robot.commands.ReachTopConeNode;
import frc.robot.commands.ReachFloor;
import frc.robot.commands.ReachTopCubeNode;
import frc.robot.commands.ReachMidConeNode;
import frc.robot.commands.ReachMidCubeNode;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Constants;
import frc.robot.subsystems.Grabber;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Wrist;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final Elevator m_elevator = new Elevator();
  private final Wrist m_wrist = new Wrist();
  private final Grabber m_grabber = new Grabber();
  private final Joystick m_reachButtons = new Joystick(1);
  private final Arm m_armA = new Arm(Constants.kArmACANId);
  private final Arm m_armB = new Arm(Constants.kArmBCANId);

  private final XboxController m_controller = new XboxController(1);

  private final CommandBase m_autonomousCommand =
      new Autonomous(m_drivetrain, m_grabber, m_wrist, m_elevator, m_armA, m_armB);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
 /*    // Put Some buttons on the SmartDashboard
    SmartDashboard.putData("Elevator Bottom", new SetElevatorSetpoint(0, m_elevator));
    SmartDashboard.putData("Elevator Top", new SetElevatorSetpoint(0.25, m_elevator));

    SmartDashboard.putData("Wrist Horizontal", new SetWristSetpoint(0, m_wrist));
    SmartDashboard.putData("Raise Wrist", new SetWristSetpoint(-45, m_wrist));

    SmartDashboard.putData("Open Claw", new OpenClaw(m_claw));
    SmartDashboard.putData("Close Claw", new CloseClaw(m_claw));

    SmartDashboard.putData(
        "Deliver Soda", new Autonomous(m_drivetrain, m_claw, m_wrist, m_elevator));

    // Assign default commands
    */
     m_drivetrain.setDefaultCommand(
        new ArcadeDrive(m_controller::getLeftY, m_controller::getRightY, m_drivetrain));
    /*
    // Show what command your subsystem is running on the SmartDashboard
    SmartDashboard.putData(m_drivetrain);
    SmartDashboard.putData(m_elevator);
    SmartDashboard.putData(m_wrist);
    SmartDashboard.putData(m_claw); */

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Create some buttons
    final JoystickButton reachFloor = new JoystickButton(m_reachButtons, 0);
    final JoystickButton reachMidCone = new JoystickButton(m_reachButtons, 1);
    final JoystickButton reachMidCube = new JoystickButton(m_reachButtons, 2);
    final JoystickButton reachTopCone = new JoystickButton(m_reachButtons, 3);
    final JoystickButton reachTopCube = new JoystickButton(m_reachButtons, 4);
    final JoystickButton reachDoubleStation = new JoystickButton(m_reachButtons, 5);
    final JoystickButton reachCruising = new JoystickButton(m_reachButtons, 6);
   /*  final JoystickButton dpadUp = new JoystickButton(m_controller, 5);
    final JoystickButton dpadRight = new JoystickButton(m_controller, 6);
    final JoystickButton dpadDown = new JoystickButton(m_controller, 7);
    final JoystickButton dpadLeft = new JoystickButton(m_controller, 8);
    final JoystickButton l2 = new JoystickButton(m_controller, 9);
    final JoystickButton r2 = new JoystickButton(m_controller, 10);
    final JoystickButton l1 = new JoystickButton(m_controller, 11);
    final JoystickButton r1 = new JoystickButton(m_controller, 12);

    // Connect the buttons to commands
    */
    reachFloor.whenPressed(new ReachFloor(m_elevator, m_armA, m_armB));
    reachMidCone.whenPressed(new ReachMidConeNode(m_elevator, m_armA, m_armB));
    reachTopCone.whenPressed(new ReachTopConeNode(m_elevator, m_armA, m_armB));
    reachMidCube.whenPressed(new ReachMidCubeNode(m_elevator, m_armA, m_armB));
    reachTopCube.whenPressed(new ReachTopCubeNode(m_elevator, m_armA, m_armB));
    reachDoubleStation.whenPressed(new ReachOut(m_elevator, m_armA, m_armB, 0, 0, 0));
    reachCruising.whenPressed(new ReachOut(m_elevator, m_armA, m_armB, 0, 0, 0));
    /*
    dpadUp.whenPressed(new SetElevatorSetpoint(0.25, m_elevator));
    dpadDown.whenPressed(new SetElevatorSetpoint(0.0, m_elevator));
    dpadRight.whenPressed(new CloseClaw(m_claw));
    dpadLeft.whenPressed(new OpenClaw(m_claw));

    r1.whenPressed(new PrepareToPickup(m_claw, m_wrist, m_elevator));
    r2.whenPressed(new Pickup(m_claw, m_wrist, m_elevator));
    l1.whenPressed(new Place(m_claw, m_wrist, m_elevator));
    l2.whenPressed(new Autonomous(m_drivetrain, m_claw, m_wrist, m_elevator)); */
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_autonomousCommand;
  }
}
