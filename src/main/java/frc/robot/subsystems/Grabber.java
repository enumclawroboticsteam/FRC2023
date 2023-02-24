// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.util.Color8Bit;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.ColorMatch;

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

    private final Color8Bit kPurpleTarget = new Color8Bit(63,42,148);
    private final Color8Bit kYellowTarget = new Color8Bit(94, 138, 22);

    /** Create a new claw subsystem. */
    public Grabber() {
        super();

    }

    public void log() {
        //Color8Bit x = new Color8Bit(kPurpleTarget);
        SmartDashboard.putNumber("ColorSensorv3 Proximity", m_color.getProximity());
        SmartDashboard.putString("ColorSensorv3 Color", new Color8Bit(m_color.getColor()).toString());
        SmartDashboard.putNumber("ColorSensorv3 Red",new Color8Bit( m_color.getColor()).red);
        SmartDashboard.putNumber("ColorSensorv3 Green", new Color8Bit(m_color.getColor()).green);
        SmartDashboard.putNumber("ColorSensorv3 Blue", new Color8Bit(m_color.getColor()).blue);
        SmartDashboard.putString("Found Purple", (isMatch(new Color8Bit(m_color.getColor()), kPurpleTarget, 6)) ? "TRUE" : "FALSE");
        SmartDashboard.putString("Found Yellow", (isMatch(new Color8Bit(m_color.getColor()), kYellowTarget, 4)) ? "TRUE" : "FALSE");
    }

    private boolean isMatch(Color8Bit color, Color8Bit targetcolor, int tolerance) {
        // return true if the red is +-tolerance and green is +- tolerance and blue is
        // +- tolerance

        return (Math.abs(color.red - targetcolor.red) <= tolerance
                && Math.abs(color.green - targetcolor.green) <= tolerance
                && Math.abs(color.blue - targetcolor.blue) <= tolerance);
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
        // TODO: if we see purple or yellow and the distance is less than 2 in, then
        // return true
        return (m_color.getProximity() <= 2000);
    }

    /** Call log method every loop. */
    @Override
    public void periodic() {
        log();

    }

}
