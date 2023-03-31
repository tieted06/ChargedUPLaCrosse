package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.ArmSub;
import frc.robot.subsystems.ClawSub;
import frc.robot.subsystems.DriveSub;

public class Auto_Dock extends SequentialCommandGroup {
  
  public Auto_Dock(DriveSub m_drive, ClawSub m_claw, ArmSub m_arm) {
    
    addCommands(new Claw_Close(m_claw),
                new WaitCommand(0.5),
                new Auto_Drive(0.17, 0, m_drive).withTimeout(1.5),
                  //new WaitCommand(0),
                  new Auto_Arm(0.17, m_arm).withTimeout(4.2),
                  new Claw_Open(m_claw),
                  new WaitCommand(1.5),
                  Commands.parallel(new Auto_Arm(-0.175, m_arm).withTimeout(3),
                                    new Auto_Drive(-0.5, 0, m_drive).withTimeout(3.2)),
                  new Auto_Drive(0.31,0, m_drive).withTimeout(3.5),
                  new Auto_Drive(0,0.2,m_drive).withTimeout(1.7)
    );
  }
}
