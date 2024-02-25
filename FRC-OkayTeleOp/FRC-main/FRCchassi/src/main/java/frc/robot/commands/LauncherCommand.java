// importa as bibliotecas necessarias
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.LauncherSubsystem;

//Declara a classe principal que executa todos os metodos do lançador
public class LauncherCommand extends Command{
    public final LauncherSubsystem m_launcher;

  //Requisitando os dados LauncherSubsystem
  public LauncherCommand(LauncherSubsystem m_launcher) {
  this.m_launcher = m_launcher;
  addRequirements(m_launcher);
  }

  //Manda os motores do lançador parararem quando liga
  @Override
  public void initialize() {
    RobotContainer.lancador.stop();
  }

  //Onde é executado o subsistema do lançador
  @Override
  public void execute() {
    m_launcher.launcherWithJoystick(RobotContainer.m_secundPilotController, 
    LauncherSubsystem.calcLauncher(RobotContainer.m_secundPilotController, 1));
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }

}

