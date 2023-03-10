package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * The claw subsystem is a simple system with a motor for opening and closing.
 */
public class Grabber extends SubsystemBase {
    private final CANSparkMax m_motor = new CANSparkMax(Constants.kGrabberCANId, MotorType.kBrushless);

    /** Create a new claw subsystem. */
    public Grabber() {
        super();
        m_motor.setSmartCurrentLimit(40);
        m_motor.setInverted(false);
        m_motor.setIdleMode(IdleMode.kBrake);
    }

    public void log() {
    }

    public void open() {
        m_motor.set(Constants.kGrabberOpenSpeed);
    }

    public void close(double speed) {
        if (speed > 0) {                // protect against coding opening by accident
            m_motor.set(speed);
        }
        else {
            this.stop();
        }
    }

    /** Stops the claw motor from moving. */
    public void stop() {
        m_motor.set(0);
    }

    /** Call log method every loop. */
    @Override
    public void periodic() {
        log();
    }
}
