package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class LauncherSubsystem extends SubsystemBase{
    
    CANSparkMax launcherLeft = new CANSparkMax(OperatorConstants.launcherLeft, MotorType.kBrushed);
    CANSparkMax launcherRight = new CANSparkMax(OperatorConstants.launcherRight, MotorType.kBrushed);

    DifferentialDrive launcher = new DifferentialDrive(launcherLeft, launcherRight);

    double launcherSpeed;

    public void launcherWithJoystick(XboxController m_secundPilotController, double launcherSpeed){
        launcher.arcadeDrive(m_secundPilotController.getRawAxis(4)*launcherSpeed, m_secundPilotController.getRawAxis(1)*launcherSpeed);
        this.launcherSpeed = launcherSpeed;
    }

    public void driveLauncher(double launcherSpeed){
        launcher.tankDrive(launcherSpeed, -launcherSpeed);
    }

    public void stop(){
        launcher.stopMotor();
    }
}