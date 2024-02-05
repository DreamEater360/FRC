package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.OperatorConstants;

public class DriveTrainSubsystem extends SubsystemBase{

    CANSparkMax frontLeft = new CANSparkMax(OperatorConstants.frontLeft, MotorType.kBrushed);
    CANSparkMax frontRight = new CANSparkMax(OperatorConstants.frontRight, MotorType.kBrushed);
    CANSparkMax backLeft = new CANSparkMax(OperatorConstants.backLeft, MotorType.kBrushed);
    CANSparkMax backRight = new CANSparkMax(OperatorConstants.backRight, MotorType.kBrushed);

    DifferentialDrive drive = new DifferentialDrive(frontLeft, frontRight);
    
    double speed;
    double freio;
    double acelerador;

    public static double calc(XboxController m_driverController, double speed, double freio, double acelerador){
        double ttspeed = (speed-(freio/5))+(acelerador/5);
        return ttspeed; 
    
    }

    public DriveTrainSubsystem(){

     backLeft.follow(frontLeft);

    }
    
    public void driveWithJoystick(XboxController m_driverController, double speed){
        drive.arcadeDrive(-(m_driverController.getRawAxis(4)*speed), -(m_driverController.getRawAxis(1)*speed));
        this.speed = speed;    
    }

    public void driveFoward(double speed){
    drive.tankDrive(speed, -speed);
    }

    public void driveBackwards(double speed){
        drive.tankDrive(speed, -speed);
    }

    public void driveRight(double speed){
        drive.tankDrive(-speed, -speed);
    }

    public void driveLeft(double speed){
        drive.tankDrive(speed, speed);
    }

    public void stop(){
        drive.stopMotor();
    }

    @Override
    public void periodic(){
       
        backRight.follow(frontRight);
        SmartDashboard.getNumber(getName(), DriveTrainSubsystem.calc(RobotContainer.m_driverController, 0.7, RobotContainer.m_driverController.getLeftTriggerAxis(), 
        RobotContainer.m_driverController.getRightTriggerAxis()));
    }

}