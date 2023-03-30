// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RampSub;

public class Ramp extends CommandBase {

  private final RampSub m_rampSub;

  /** Creates a new Ramp. */
  public Ramp(RampSub subsystem) {

    m_rampSub = subsystem;
    addRequirements(m_rampSub);
  
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    RampSub.rampSolenoid.set(DoubleSolenoid.Value.kForward);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) { 
    
    RampSub.rampSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
