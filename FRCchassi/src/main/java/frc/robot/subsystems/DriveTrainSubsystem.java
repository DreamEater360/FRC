package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.OperatorConstants;

//Declara classe que comanda a movimentação do chassi
public class DriveTrainSubsystem extends SubsystemBase{

    //Declara motores
    CANSparkMax frontLeft = new CANSparkMax(OperatorConstants.frontLeft, MotorType.kBrushed);
    CANSparkMax frontRight = new CANSparkMax(OperatorConstants.frontRight, MotorType.kBrushed);
    CANSparkMax backLeft = new CANSparkMax(OperatorConstants.backLeft, MotorType.kBrushed);
    CANSparkMax backRight = new CANSparkMax(OperatorConstants.backRight, MotorType.kBrushed);

    //Declara tanque de direção do robô
    DifferentialDrive drive = new DifferentialDrive(frontLeft, frontRight);
    
    //Declara as variaveis de velocidade
    double speed;
    double freio;
    double acelerador;

    //Calcula a velocidade que o robô tem
    public static double calc(XboxController m_firstPilotController, double speed, double freio, double acelerador){
        double ttspeed = (speed-(freio/5))+(acelerador/5);
        return ttspeed; 
    
    }

    //Manda os motores de trás seguir os movimentos dos da frente
    public DriveTrainSubsystem(){
    
        backRight.follow(frontRight);
        backLeft.follow(frontLeft);

    }
    
    //Pega os valores obtidos no joystick e calcula o movimento do robô
    public void driveWithJoystick(XboxController m_firstPilotController, double speed){
        drive.arcadeDrive(-(m_firstPilotController.getRawAxis(4)*speed), -(m_firstPilotController.getRawAxis(1)*speed));
        this.speed = speed;    
    }

    //Organiza o sentido dos motores no movimentos (Frente)
    public void driveFoward(double speed){
        drive.tankDrive(speed, -speed);
    }

    //Organiza o sentido dos motores no movimentos (Trás)
    public void driveBackwards(double speed){
        drive.tankDrive(speed, -speed);
    }

    //Organiza o sentido dos motores no movimentos (Girar para Esquerda)
    public void driveRight(double speed){
        drive.tankDrive(-speed, -speed);
    }

    //Organiza o sentido dos motores no movimentos (girar para Direita)
    public void driveLeft(double speed){
        drive.tankDrive(speed, speed);
    }

    //Para os motores quando o joystick fica neutro
    public void stop(){
        drive.stopMotor();
    }

    //Ciclo de repetição
    @Override
    public void periodic(){
       
        SmartDashboard.getNumber(getName(), DriveTrainSubsystem.calc(RobotContainer.m_firstPilotController,
         0.7, RobotContainer.m_firstPilotController.getLeftTriggerAxis(), 
        RobotContainer.m_firstPilotController.getRightTriggerAxis()));
    }

    

}
