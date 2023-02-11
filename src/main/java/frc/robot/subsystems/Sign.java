// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;



import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * The claw subsystem is a simple system with a motor for opening and closing.
 * If using stronger
 * motors, you should probably use a sensor so that the motors don't stall.
 */
public class Sign extends SubsystemBase {
    private final Servo m_servo = new Servo(0);
    private final double kCubeShowPosition = 0;
    private final double kConeShowPosition = 180;
    private boolean m_isCube = false; 

    /** Create a new claw subsystem. */
    public Sign() {

    }

    public void log() {
        //SmartDashboard.putData("Sign angle", Servo));
    }

    /** Set the sign to move in the open direction. */
    public void reset() {
        showCone();
    }

    public void showCube() {
        m_isCube = true; 
        m_servo.set(kCubeShowPosition);
    }

    /** Set the sign to move in the close direction. */
    public void showCone() {
        m_isCube = false; 
        m_servo.set(kConeShowPosition);
    }

    public boolean isCube() {
        return m_isCube; 
    }
    /** Stops the sign from moving. */
    public boolean isFinished() {
        return (m_servo.getPosition() == m_servo.getRaw());
    }


    /** Call log method every loop. */
    @Override
    public void periodic() {
        log();
    }
}
