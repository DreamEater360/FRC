// importa as bibliotecas necessarias
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.CollectorSubsystem;

//Declara a classe principal que executa todos os metodos do coletor
public class collectorCommand extends Command{

  public final CollectorSubsystem m_collector;

  //Requisitando os dados do CollectorSubsystem
  public collectorCommand(CollectorSubsystem m_collector) {
  this.m_collector = m_collector;
  addRequirements(m_collector);
  }

  //Manda os motores do coletor parararem quando liga
  @Override
  public void initialize() {
    RobotContainer.coletor.stop();
  }

  //Onde é executado o subsistema do coletor
  @Override
  public void execute() {
    m_collector.playWithJoystick(RobotContainer.m_secundPilotController, 0.7);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }

}
