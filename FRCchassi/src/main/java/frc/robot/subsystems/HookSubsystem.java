package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;
import frc.robot.RobotContainer;

public class HookSubsystem extends SubsystemBase{
    
// declarar motores
    CANSparkMax hookMotorRight = new CANSparkMax(OperatorConstants.hookMotorRight, MotorType.kBrushed);
    CANSparkMax hookMotorLeft = new CANSparkMax(OperatorConstants.hookMotorLeft, MotorType.kBrushed);

    DifferentialDrive hook = new DifferentialDrive(hookMotorLeft, hookMotorRight);

// declarar velocidade do gancho
    double hookSpeed;

//Pega os valores obtidos no joystick e calcula o movimento do robô
    public void hookWithJoystick(XboxController m_secundPilotController, double hookSpeed){
        hook.arcadeDrive(-RobotContainer.m_firstPilotController.getLeftTriggerAxis()*hookSpeed, 
        RobotContainer.m_firstPilotController.getRightTriggerAxis()*hookSpeed);
        this.hookSpeed = hookSpeed;
        hook.tankDrive(m_secundPilotController.getLeftTriggerAxis()*(-hookSpeed),
        m_secundPilotController.getRightTriggerAxis()*hookSpeed);
}

    //Para os motores quando o joystick fica neutro
    public void stop(){
        hook.stopMotor();
    }
    
}

