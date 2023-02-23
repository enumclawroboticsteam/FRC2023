// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.Autonomous;
import frc.robot.commands.CloseGrabber;
import frc.robot.commands.MoveArm;
import frc.robot.commands.MoveWrist;
//import frc.robot.commands.MoveArmDownPID;
//import frc.robot.commands.MoveArmUpPID;
import frc.robot.commands.MoveElevator;
//import frc.robot.commands.MoveElevatorDownPID;
//import frc.robot.commands.MoveElevatorUpPID;
import frc.robot.commands.OpenGrabber;
import frc.robot.commands.ReachCruising;
import frc.robot.commands.ReachDoubleStation;
import frc.robot.commands.ReachFloor;
import frc.robot.commands.ReachMidConeNode;
import frc.robot.commands.ReachMidCubeNode;
//import frc.robot.commands.ReachOut;
import frc.robot.commands.ReachTopConeNode;
import frc.robot.commands.ReachTopCubeNode;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Grabber;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    private final Drivetrain m_drivetrain = new Drivetrain();
    private final Elevator m_elevator = new Elevator();
    private final Wrist m_wrist = new Wrist();
    private final Grabber m_grabber = new Grabber();
    private final Joystick m_reachButtons = new Joystick(1);
    private final Arm m_arm = new Arm();

    private final XboxController m_controller = new XboxController(0);
    private final XboxController m_Controller2 = new XboxController(2);

    private final CommandBase m_autonomousCommand = new Autonomous(m_drivetrain, m_elevator, m_arm, m_wrist, m_grabber);

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        /*
         * // Put Some buttons on the SmartDashboard
         * SmartDashboard.putData("Elevator Bottom", new SetElevatorSetpoint(0,
         * m_elevator));
         * SmartDashboard.putData("Elevator Top", new SetElevatorSetpoint(0.25,
         * m_elevator));
         * 
         * SmartDashboard.putData("Wrist Horizontal", new SetWristSetpoint(0, m_wrist));
         * SmartDashboard.putData("Raise Wrist", new SetWristSetpoint(-45, m_wrist));
         * 
         * SmartDashboard.putData("Open Claw", new OpenClaw(m_claw));
         * SmartDashboard.putData("Close Claw", new CloseClaw(m_claw));
         * 
         * SmartDashboard.putData(
         * "Deliver Soda", new Autonomous(m_drivetrain, m_claw, m_wrist, m_elevator));
         * 
         * // Assign default commands
         */
        m_drivetrain.setDefaultCommand(
                new ArcadeDrive(m_controller::getLeftY, m_controller::getRightY, m_drivetrain));

        /*
         * // Show what command your subsystem is running on the SmartDashboard
         * SmartDashboard.putData(m_drivetrain);
         * SmartDashboard.putData(m_elevator);
         * SmartDashboard.putData(m_wrist);
         * SmartDashboard.putData(m_claw);
         */

        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by
     * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its
     * subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
     * it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        // Create some buttons

        new JoystickButton(m_reachButtons, 1);
        new JoystickButton(m_reachButtons, 2);
        new JoystickButton(m_reachButtons, 3);
        new JoystickButton(m_reachButtons, 4);
        new JoystickButton(m_reachButtons, 5);
        new JoystickButton(m_reachButtons, 6);
        new JoystickButton(m_reachButtons, 7);

        /*
         * final JoystickButton dpadUp = new JoystickButton(m_controller, 5);
         * final JoystickButton dpadRight = new JoystickButton(m_controller, 6);
         * final JoystickButton dpadDown = new JoystickButton(m_controller, 7);
         * final JoystickButton dpadLeft = new JoystickButton(m_controller, 8);
         * final JoystickButton l2 = new JoystickButton(m_controller, 9);
         * final JoystickButton r2 = new JoystickButton(m_controller, 10);
         * final JoystickButton l1 = new JoystickButton(m_controller, 11);
         * final JoystickButton r1 = new JoystickButton(m_controller, 12);
         * 
         * // Connect the buttons to commands
         */


        // reachFloor.onTrue(new ReachFloor(m_elevator, m_arm));
        // reachMidCone.onTrue(new ReachMidConeNode(m_elevator, m_arm));
        // reachTopCone.onTrue(new ReachTopConeNode(m_elevator, m_arm));
        // reachMidCube.onTrue(new ReachMidCubeNode(m_elevator, m_arm));
        // reachTopCube.onTrue(new ReachTopCubeNode(m_elevator, m_arm));
        // reachDoubleStation.onTrue(new ReachOut(m_elevator, m_arm, 0, 0));
        // reachCruising.onTrue(new ReachOut(m_elevator, m_arm, 0, 0));

        /*
         * dpadUp.whenPressed(new SetElevatorSetpoint(0.25, m_elevator));
         * dpadDown.whenPressed(new SetElevatorSetpoint(0.0, m_elevator));
         * dpadRight.whenPressed(new CloseClaw(m_claw));
         * dpadLeft.whenPressed(new OpenClaw(m_claw));
         * 
         * r1.whenPressed(new PrepareToPickup(m_claw, m_wrist, m_elevator));
         * r2.whenPressed(new Pickup(m_claw, m_wrist, m_elevator));
         * l1.whenPressed(new Place(m_claw, m_wrist, m_elevator));
         * l2.whenPressed(new Autonomous(m_drivetrain, m_claw, m_wrist, m_elevator));
         */
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        return m_autonomousCommand;
    }

    public void runJoysticks() {

        if (m_Controller2.getLeftBumper()){
            new MoveArm(m_arm, .5).schedule();
        }

        if (m_Controller2.getLeftTriggerAxis() >= .25d) {
            new MoveArm(m_arm, -.5).schedule();
        }

        if (m_Controller2.getRightBumper()) {
            new MoveElevator(m_elevator, .5).schedule();
        }

        if (m_Controller2.getRightTriggerAxis() >= .25d) {
            new MoveElevator(m_elevator, -.5).schedule();
        }

        if (m_Controller2.getAButtonPressed()) {
            new OpenGrabber(m_grabber).schedule();
        }

        if (m_Controller2.getBButtonPressed()) {
            new CloseGrabber(m_grabber).schedule();
        }

        if (m_Controller2.getXButton()) {
            new MoveWrist(m_wrist, .5).schedule();
        }

        if (m_Controller2.getYButton()) {
            new MoveWrist(m_wrist, -.5).schedule();
        }

        if (m_reachButtons.getRawButtonPressed(1)) {
            new ReachFloor(m_elevator, m_arm).schedule();
        }

        if (m_reachButtons.getRawButtonPressed(2)) {
            new ReachMidConeNode(m_elevator, m_arm).schedule();
        }

        if (m_reachButtons.getRawButtonPressed(3)) {
            new ReachMidCubeNode(m_elevator, m_arm).schedule();
        }

        if (m_reachButtons.getRawButtonPressed(4)) {
            new ReachTopConeNode(m_elevator, m_arm).schedule();
        }

        if (m_reachButtons.getRawButtonPressed(5)) {
            new ReachTopCubeNode(m_elevator, m_arm).schedule();
        }

        if (m_reachButtons.getRawButtonPressed(6)) {
            new ReachDoubleStation(m_elevator, m_arm).schedule();
        }

        if (m_reachButtons.getRawButtonPressed(7)) {
            new ReachCruising(m_elevator, m_arm).schedule();
        }
    }
}
