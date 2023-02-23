// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ColorSensorV3;
//import com.revrobotics.DistanceSensor;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * The claw subsystem is a simple system with a motor for opening and closing.
 * If using stronger
 * motors, you should probably use a sensor so that the motors don't stall.
 */
public class Grabber extends SubsystemBase {
    private final CANSparkMax m_motor = new CANSparkMax(Constants.kGrabberCANId, MotorType.kBrushless);
    private final ColorSensorV3 m_color = new ColorSensorV3(Port.kOnboard); 
    private final RelativeEncoder m_encoder = m_motor.getEncoder();
    private final double kCubeClosePosition = 200; // TODO: figure out right values
    private final double kConeClosePosition = 400;

    /** Create a new claw subsystem. */
    public Grabber() {
        super();
    }

    public void log() {
        //SmartDashboard.putData("Game piece range", Double.toString(m_contact.getDistance()));
        //SmartDashboard.putData("Game piece color", m_color.getColor());
    }

    /** Set the claw motor to move in the open direction. */
    public void open() {
        m_motor.set(-1);
    }

    /** Set the claw motor to move in the close direction. */
    public void close() {
        m_motor.set(1);
    }

    /** Stops the claw motor from moving. */
    public void stop() {
        m_motor.set(0);
    }

    /**
     * Return true when the robot is grabbing an object hard enough to trigger the
     * limit switch.
     */
    public boolean isGrabbing() {
        if (m_encoder.getPosition() >= kCubeClosePosition) { // TODO: add only purple
            return true;
        }
        if (m_encoder.getPosition() >= kConeClosePosition) { // TODO: add only yellow
            return true;
        }
        return false;
    }

    public boolean isGamePiece() {
        //TODO: if we see purple or yellow and the distance is less than 2 in, then return true
        return (m_color.getProximity() <= 2000);
    }

    /** Call log method every loop. */
    @Override
    public void periodic() {
        log();
    }
}
