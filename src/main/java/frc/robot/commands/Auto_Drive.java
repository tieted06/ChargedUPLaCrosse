package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSub;

public class Auto_Drive extends CommandBase {
  private final DriveSub m_drive;
  private double m_speed;
  private double m_turn;

  
  public Auto_Drive(double speed, double turn, DriveSub sub) {
    m_drive = sub;
    m_speed = speed;
    m_turn = turn;
    addRequirements(m_drive);
    
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_drive.my_Arcade(m_speed, m_turn,false);
  }

  @Override
  public void end(boolean interrupted) {
    m_drive.my_Arcade(0,0,false);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
