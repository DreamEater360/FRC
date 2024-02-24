// importa as bibliotecas necessarias
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.HookSubsystem;

//Declara a classe principal que executa todos os metodos do gancho
public class HookCommand extends Command{
  public final HookSubsystem m_hook;

  //Requisitando os dados do HookSubsystem
  public HookCommand(HookSubsystem m_hook) {
  this.m_hook = m_hook;
  addRequirements(m_hook);
  }

  //Manda os motores do gancho parararem quando liga
  @Override
  public void initialize() {
    RobotContainer.coletor.stop();
  }

  //Onde é executado o subsistema do gancho
  @Override
  public void execute() {
    m_hook.hookWithJoystick(RobotContainer.m_secundPilotController, 0.3);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }

}


