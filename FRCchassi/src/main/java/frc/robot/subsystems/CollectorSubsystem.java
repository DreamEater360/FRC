package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class CollectorSubsystem extends SubsystemBase{
    
// declarar motores
    CANSparkMax colMotorForward = new CANSparkMax(OperatorConstants.colMotorForward, MotorType.kBrushed);
    CANSparkMax colMotorReverse = new CANSparkMax(OperatorConstants.colMotorReverse, MotorType.kBrushed);

    DifferentialDrive collect = new DifferentialDrive(colMotorForward, colMotorReverse);

// declarar velocidade do coletor
    double colSpeed;

//Pega os valores obtidos no joystick e calcula o movimento do robô
    public void playWithJoystick(XboxController m_secundPilotController, double colSpeed){
        collect.arcadeDrive((m_secundPilotController.getRawAxis(1)*colSpeed), -(m_secundPilotController.getRawAxis(1)*colSpeed));
        this.colSpeed = colSpeed;
}

//Organiza o sentido dos motores no movimentos (Frente)
     public void driveFoward(double speed){
        collect.tankDrive(speed, -speed);
    }

//Organiza o sentido dos motores no movimentos (Trás)
    public void driveBackwards(double speed){
        collect.tankDrive(speed, -speed);
    }

    //Para os motores quando o joystick fica neutro
    public void stop(){
        collect.stopMotor();
    }
    
}
