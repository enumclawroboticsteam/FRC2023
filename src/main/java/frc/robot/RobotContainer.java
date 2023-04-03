// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ChargeStationAuto;
import frc.robot.commands.LongAllyAuto;
import frc.robot.commands.ShortAllyAuto;
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
import frc.robot.commands.StopGrabber;
import frc.robot.commands.StopWrist;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Constants;
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
    private final Arm m_arm = new Arm();

    private final XboxController m_controller = new XboxController(0);
    private final XboxController m_Controller2 = new XboxController(1);
    //private final Joystick m_reachButtons = new Joystick(2);

    // private final CommandBase m_autonomousCommand = new Autonomous(m_drivetrain,
    // m_elevator, m_arm, m_wrist,
    // m_grabber);
    // private final CommandBase m_autonomousCommand2 = new
    // Autonomous2(m_drivetrain, m_elevator, m_arm, m_wrist,
    // m_grabber);

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        m_drivetrain.setDefaultCommand(
                new ArcadeDrive(m_drivetrain, m_controller::getRightX, m_controller::getLeftY));

        SmartDashboard.putStringArray("Auto List", new String[] { "Long Ally", "Short Ally", "Charge Station" });

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

        // new JoystickButton(m_reachButtons, 1);
        // new JoystickButton(m_reachButtons, 2);
        // new JoystickButton(m_reachButtons, 3);
        // new JoystickButton(m_reachButtons, 4);
        // new JoystickButton(m_reachButtons, 5);
        // new JoystickButton(m_reachButtons, 6);
        // new JoystickButton(m_reachButtons, 7);

        // reachFloor.onTrue(new ReachFloor(m_elevator, m_arm));
        // reachMidCone.onTrue(new ReachMidConeNode(m_elevator, m_arm));
        // reachTopCone.onTrue(new ReachTopConeNode(m_elevator, m_arm));
        // reachMidCube.onTrue(new ReachMidCubeNode(m_elevator, m_arm));
        // reachTopCube.onTrue(new ReachTopCubeNode(m_elevator, m_arm));
        // reachDoubleStation.onTrue(new ReachOut(m_elevator, m_arm, 0, 0));
        // reachCruising.onTrue(new ReachOut(m_elevator, m_arm, 0, 0));
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        String autoName = SmartDashboard.getString("Auto Selector", "");
        // Note: no default, only do something if there was a selection in the
        // SmartDashboard

        switch (autoName) {
            case "Long Ally":
                return new LongAllyAuto(m_drivetrain, m_elevator, m_arm, m_wrist, m_grabber);
            case "Short Ally":
                return new ShortAllyAuto(m_drivetrain, m_elevator, m_arm, m_wrist, m_grabber);
            case "Charge Station":
                return new ChargeStationAuto(m_drivetrain, m_elevator, m_arm, m_wrist, m_grabber);
            default:
                return null;
        }
    }

    public void runJoysticks() {

        m_arm.log();
        m_grabber.log();

        // out
        if (m_Controller2.getLeftY() < -.02) {
            new MoveArm(m_arm, m_Controller2.getLeftY() * Constants.kArmPowerLimit).schedule();
        }
        // in
        else if (m_Controller2.getLeftY() > .02) {
            new MoveArm(m_arm, m_Controller2.getLeftY() * Constants.kArmPowerLimit).schedule();
        } else {
            new MoveArm(m_arm, 0).schedule();
        }

        if (m_Controller2.getLeftBumper()) {
            new MoveElevator(m_elevator, Constants.kElevatorPowerLimit).schedule(); // Moves the elevator Up
        } else if (m_Controller2.getLeftTriggerAxis() > .5) {
            new MoveElevator(m_elevator, -Constants.kElevatorPowerLimit).schedule(); // Moves the elevator Down 
        } else {
            new MoveElevator(m_elevator, 0).schedule();
        }

        if (m_Controller2.getAButton()) {
            new OpenGrabber(m_grabber).schedule();
        } else if (m_Controller2.getBButton()) {
            new CloseGrabber(m_grabber, Constants.kGrabberCubeSpeed).schedule();
        } else if (m_Controller2.getXButton()) {
            new CloseGrabber(m_grabber, Constants.kGrabberConeSpeed).schedule();
        } else {
            new StopGrabber(m_grabber).schedule();
        }

        if (m_Controller2.getPOV() == 0  || m_Controller2.getPOV() == 45 || m_Controller2.getPOV() == 315 ) {
            new MoveWrist(m_wrist, -Constants.kDownWristPowerLimit).schedule();
        } else if (m_Controller2.getPOV() == 180  || m_Controller2.getPOV() == 135 || m_Controller2.getPOV() == 225) {
            new MoveWrist(m_wrist, Constants.kUpWristPowerLimit).schedule();
        } else {
            new StopWrist(m_wrist).schedule();
        }
        SmartDashboard.putNumber("POV", m_Controller2.getPOV());


        // if (m_reachButtons.getRawButtonPressed(1)) {
        //     new ReachFloor(m_elevator, m_arm).schedule();
        // }

        // if (m_reachButtons.getRawButtonPressed(2)) {
        //     new ReachMidConeNode(m_elevator, m_arm).schedule();
        // }

        // if (m_reachButtons.getRawButtonPressed(3)) {
        //     new ReachMidCubeNode(m_elevator, m_arm).schedule();
        // }

        // if (m_reachButtons.getRawButtonPressed(4)) {
        //     new ReachTopConeNode(m_elevator, m_arm).schedule();
        // }

        // if (m_reachButtons.getRawButtonPressed(5)) {
        //     new ReachTopCubeNode(m_elevator, m_arm).schedule();
        // }

        // if (m_reachButtons.getRawButtonPressed(6)) {
        //     new ReachDoubleStation(m_elevator, m_arm).schedule();
        // }

        // if (m_reachButtons.getRawButtonPressed(7)) {
        //     new ReachCruising(m_elevator, m_arm).schedule();
        // }
    }

    public void stop() {
        m_drivetrain.ArcadeDrive(0, 0);
    }
}
