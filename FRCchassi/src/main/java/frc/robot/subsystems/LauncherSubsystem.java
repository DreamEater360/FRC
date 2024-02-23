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

    //Calcula a velocidade que o robô tem
    public static double calcLauncher(XboxController m_secundPiloController, double launcherSpeed){
        double ttspeed = (launcherSpeed/3);
        return ttspeed; 
    
    }
    //Pega os valores obtidos no joystick e calcula o movimento do robô
    public void launcherWithJoystick(XboxController m_secundPilotController, double launcherSpeed){
        launcher.arcadeDrive(-m_secundPilotController.getRawAxis(5)*launcherSpeed, 0);
        this.launcherSpeed = launcherSpeed;
        launcher.tankDrive(m_secundPilotController.getRawAxis(5)*(-launcherSpeed),
        m_secundPilotController.getRawAxis(5)*launcherSpeed);

    }
   //Para os motores quando o joystick fica neutro     
    public void stop(){
        launcher.stopMotor();
    }
}