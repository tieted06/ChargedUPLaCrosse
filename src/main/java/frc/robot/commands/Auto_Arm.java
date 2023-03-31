package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSub;

public class Auto_Arm extends CommandBase {
  private final ArmSub m_Arm;
  private double m_speed;
 
  public Auto_Arm(double speed, ArmSub sub) {
    m_Arm = sub;
    m_speed = speed;
    addRequirements(m_Arm);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_Arm.my_set(m_speed);
  }

  @Override
  public void end(boolean interrupted) {
    m_Arm.my_set(0.0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
