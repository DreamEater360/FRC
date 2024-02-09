package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.DriveDefaut;
import frc.robot.commands.collectorCommand;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.collector;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {

  public static final DriveTrainSubsystem driveTrain = new DriveTrainSubsystem();
  public static final DriveDefaut DRIVE_DEFAUT = new DriveDefaut(driveTrain);
  public static final collector coletor = new collector();
  public static final collectorCommand COLLECTOR = new collectorCommand(coletor);

  public static final XboxController m_firstPilotController =
    new XboxController(OperatorConstants.firstPilot);
  public static final XboxController m_secundPilotController =
    new XboxController(OperatorConstants.secundPilot);
  
  public RobotContainer() {
    DRIVE_DEFAUT.addRequirements(driveTrain);
    COLLECTOR.addRequirements(coletor);
    driveTrain.setDefaultCommand(DRIVE_DEFAUT);

  }

  public static DriveTrainSubsystem getDrivetrain() {
    return driveTrain;
  }


  public static DriveDefaut getDriveDefaut() {
    return DRIVE_DEFAUT;
  }

  public static collector getColetor() {
    return coletor;
  }

  public static XboxController getmFirstpilotcontroller() {
    return m_firstPilotController;
  }

  public static XboxController getmSecundpilotcontroller() {
    return m_secundPilotController;
  }

  // public Command getAutonomousCommand() {

  //   return AutoCommand.logicAuto(driveTrain);
    
  // } 
}
