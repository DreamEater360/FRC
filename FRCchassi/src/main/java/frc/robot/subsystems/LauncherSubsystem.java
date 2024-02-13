package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer.*;
import frc.robot.Constants.OperatorConstants;

public class LauncherSubsystem {
    
    CANSparkMax launcherLeft = new CANSparkMax(OperatorConstants.launcherLeft, MotorType.kBrushed)
    CANSparkMax launcherRight = new CANSparkMax(OperatorConstants.launcherRight, MotorType.kBrushed)

    DifferentialDrive launcher = new DifferentialDrive(launcherLeft, launcherRight);

    double launcherSpeed;

    public void launcherWithJoystick(XboxController m_secundPilotController, double launcherSpeed){
        launcher.arcadeDrive((m_secundPilotController.get(falta escolher)*launcherSpeed), -(m_secundPilotController.get(falta escolher)*launcherSpeed));
        this.launcherSpeed = launcherSpeed;
    }

    public void driveLauncher(double launcherSpeed){
        launcher.tankDrive(speed, -speed);
    }

    public void stop(){
        launcher.stopMotor();
    }
}
