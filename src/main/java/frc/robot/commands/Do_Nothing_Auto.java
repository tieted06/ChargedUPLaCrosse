package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.ArmSub;
import frc.robot.subsystems.ClawSub;
import frc.robot.subsystems.DriveSub;

public class Do_Nothing_Auto extends SequentialCommandGroup {
 
  public Do_Nothing_Auto(DriveSub m_drive, ClawSub m_claw, ArmSub m_arm) {
   
    addCommands(new Claw_Close(m_claw),
                new WaitCommand(.5),
                new Auto_Drive(.15, 0, m_drive).withTimeout(1.5),
                  new WaitCommand(0),
                  new Auto_Arm(.17, m_arm).withTimeout(4.2),
                  new Claw_Open(m_claw),
                  new WaitCommand(1.5),
                  new Auto_Arm(-0.175, m_arm).withTimeout(3)

    );
  }
}
