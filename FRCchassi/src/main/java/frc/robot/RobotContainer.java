package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.DriveDefaut;
import frc.robot.commands.HookCommand;
import frc.robot.commands.LauncherCommand;
import frc.robot.commands.collectorCommand;
import frc.robot.subsystems.CollectorSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.HookSubsystem;
import frc.robot.subsystems.LauncherSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;


public class RobotContainer {

  public static final DriveTrainSubsystem driveTrain = new DriveTrainSubsystem();
  public static final DriveDefaut DRIVE_DEFAUT = new DriveDefaut(driveTrain);
  public static final CollectorSubsystem coletor = new CollectorSubsystem();
  public static final collectorCommand COLLETOR = new collectorCommand(coletor);
  public static final LauncherSubsystem lancador = new LauncherSubsystem();
  public static final LauncherCommand LANCADOR = new LauncherCommand(lancador);
  public static final HookSubsystem gancho = new HookSubsystem();
  public static final HookCommand GANCHO = new HookCommand(gancho);

  
  public static final XboxController m_firstPilotController =
    new XboxController(OperatorConstants.firstPilot);
  public static final XboxController m_secundPilotController =
    new XboxController(OperatorConstants.secundPilot);
  
  public RobotContainer() {
    DRIVE_DEFAUT.addRequirements(driveTrain);
    COLLETOR.addRequirements(coletor);
    LANCADOR.addRequirements(lancador);
    GANCHO.addRequirements(gancho);
    driveTrain.setDefaultCommand(DRIVE_DEFAUT);
    coletor.setDefaultCommand(COLLETOR);
    lancador.setDefaultCommand(LANCADOR);
    gancho.setDefaultCommand(GANCHO);

  }

  public static DriveTrainSubsystem getDrivetrain() {
    return driveTrain;
  }
  public static DriveDefaut getDriveDefaut() {
    return DRIVE_DEFAUT;
  }
  public static CollectorSubsystem getColetor(){
    return coletor;
  }
  public static collectorCommand getCOLLETOR(){
    return COLLETOR;
  }
  public static LauncherSubsystem getLauncher(){
    return lancador;
  }
  public static LauncherCommand getLANCADOR(){
    return LANCADOR;
  }
  public static HookSubsystem getHook(){
    return gancho;
  }
  public static HookCommand getHOOK(){
    return GANCHO;
  }
  public static XboxController getmFirstpilotcontroller() {
    return m_firstPilotController;
  }
  public static XboxController getmSecundpilotcontroller() {
    return m_secundPilotController;
  }

  public Command getAutonomousCommand() {

    return null;
    
  } 
}
