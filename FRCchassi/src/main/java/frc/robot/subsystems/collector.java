package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class collector extends SubsystemBase{
    
// declarar motores
    CANSparkMax colMotorForward = new CANSparkMax(5, MotorType.kBrushed);
    CANSparkMax colMotorReverse = new CANSparkMax(6, MotorType.kBrushed);

    DifferentialDrive drive = new DifferentialDrive(colMotorForward, colMotorReverse);

// declarar velocidade do coletor
    double colSpeed;

//Pega os valores obtidos no joystick e calcula o movimento do robô
    public void playWithJoystick(XboxController m_secundPilotController, double colSpeed){
        drive.arcadeDrive((m_secundPilotController.getRawAxis(1)*colSpeed), -(m_secundPilotController.getRawAxis(1)*colSpeed));
        this.colSpeed = colSpeed;
}

//Organiza o sentido dos motores no movimentos (Frente)
     public void driveFoward(double speed){
        drive.tankDrive(speed, -speed);
    }

//Organiza o sentido dos motores no movimentos (Trás)
    public void driveBackwards(double speed){
        drive.tankDrive(speed, -speed);
    }


}
