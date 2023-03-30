// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class RampSub extends SubsystemBase {

  private static DoubleSolenoid rampSolenoid;
  /** Creates a new RampSub. */
  public RampSub() {
    rampSolenoid = new DoubleSolenoid(Constants.PCMCan, PneumaticsModuleType.CTREPCM, Constants.rampSol1, Constants.rampSol2);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

public void my_set(Value direction) {
  rampSolenoid.set(direction);
}
}
