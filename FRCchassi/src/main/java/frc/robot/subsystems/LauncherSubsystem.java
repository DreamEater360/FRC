// importa as bibliotecas necessarias
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

// classe principal do lançador
public class LauncherSubsystem extends SubsystemBase{
    
    CANSparkMax launcherTop = new CANSparkMax(OperatorConstants.launcherLeft, MotorType.kBrushed);
    CANSparkMax launcherRight = new CANSparkMax(OperatorConstants.launcherRight, MotorType.kBrushed);
    Victor  launcherLeft = new Victor(11);
    

    DifferentialDrive launcher = new DifferentialDrive(launcherLeft, launcherRight);

    double launcherSpeed;

    //Calcula a velocidade que o lançador joga as notas conforme o botão esteja pressionado
    public static double calcLauncher(XboxController m_secundPiloController, double launcherSpeed){
        double cont;
        
        if (m_secundPiloController.getAButton()==true){
            cont = 1;
        }else {
            cont = 0.1;
        }  
        
        double ttspeed = (launcherSpeed/(3*cont));
        return ttspeed; 
    }

    public LauncherSubsystem(){
        launcherTop.follow(launcherRight);
    }
    //Pega os valores obtidos no joystick e calcula o movimento do lançador
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