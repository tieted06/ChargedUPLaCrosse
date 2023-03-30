package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSub;
import frc.robot.subsystems.ClawSub;
import frc.robot.subsystems.DriveSub;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Auto_NO_Dock extends CommandBase {
  Timer autotime = new Timer();
  
  public Auto_NO_Dock() {
    
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    autotime.reset();
    autotime.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (autotime.get() <= 0.5){
      ClawSub.grabSolenoid.set(DoubleSolenoid.Value.kReverse);
   }else if (autotime.get() <= 2.1){
      DriveSub.arcadeDrive.arcadeDrive(0.0, -0.39);
  }else if (autotime.get() <= 2.2){
      DriveSub.arcadeDrive.arcadeDrive(0.0, 0.0);
  }else if(autotime.get() <= 6.4) {
      ArmSub.armMotor.set(0.17);
  }else if(autotime.get() <= 6.5){
      ArmSub.armMotor.set(0);
  }else if(autotime.get() <=7.5){

  }else if(autotime.get() <=7.9){
      ClawSub.grabSolenoid.set(DoubleSolenoid.Value.kForward);
  }else if(autotime.get() <=11.0){
      ArmSub.armMotor.set(-0.169);
      DriveSub.arcadeDrive.arcadeDrive(0.0,0.53);
  }else if(autotime.get() <=11.1){
      ArmSub.armMotor.set(0);
  }else if(autotime.get() <=14.9){
      DriveSub.arcadeDrive.arcadeDrive(0.0,0.53);
  }else if(autotime.get() <=15.0){
      DriveSub.arcadeDrive.arcadeDrive(0.0,0.0);
  }
    
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}