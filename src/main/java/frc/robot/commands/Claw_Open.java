package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.ClawSub;

public class Claw_Open extends InstantCommand {
  private final ClawSub m_claw;
  public Claw_Open(ClawSub claw) {
    m_claw = claw;
    addRequirements(m_claw);
    
  }

  @Override
  public void initialize() {
    m_claw.my_Claw_Open();
  }
}
