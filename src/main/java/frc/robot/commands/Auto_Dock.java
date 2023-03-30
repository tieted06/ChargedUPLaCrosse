package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSub;
import frc.robot.subsystems.ClawSub;
//import frc.robot.subsystems.DrivePIDSub;
import frc.robot.subsystems.DriveSub;


public class Auto_Dock extends CommandBase {
  Timer autotime = new Timer();
 
  public Auto_Dock() {
    
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
    if (autotime.get() <= 0.5){ //0.5 seconds close claw
      ClawSub.grabSolenoid.set(DoubleSolenoid.Value.kReverse);
   }else if (autotime.get() <= 2.1){ //1.6 seconds drive forward, move arm forward
      DriveSub.arcadeDrive.arcadeDrive(0.0, -0.39);
      ArmSub.armMotor.set(0.21);
  }else if (autotime.get() <= 2.2){  //0.1 seconds stop motion, continue move arm forward
    ArmSub.armMotor.set(0.21);
    DriveSub.arcadeDrive.arcadeDrive(0.0, 0.0);
  }else if (autotime.get() <= 3.6){ //1.4 seconds continue move arm
    ArmSub.armMotor.set(0.21);
  }else if(autotime.get() <= 3.7) { //0.1 seconds stop arm
      ArmSub.armMotor.set(0);
  }else if(autotime.get() <=4.2){ //0.5 seconds open claw
    ClawSub.grabSolenoid.set(DoubleSolenoid.Value.kForward);
  }else if(autotime.get() <=4.3){ //0.1 seconds reverse arm
    ArmSub.armMotor.set(-0.21);
  }else if(autotime.get() <=8.0){ //3.2 seconds drive reverse  
    DriveSub.arcadeDrive.arcadeDrive(0.0,0.70);
  }else if(autotime.get() <=8.1){ //0.1 seconds stop arm
      ArmSub.armMotor.set(0);
  }else if(autotime.get() <=12.15){  //3.7 seconds drive forward
      DriveSub.arcadeDrive.arcadeDrive(0.0,-0.51);
  }else if(autotime.get() <=13.9){ //1.7 seconds drive stop, rotate
      DriveSub.arcadeDrive.arcadeDrive(0.4,0.0);
  }else if(autotime.get() <=14.0){ //0.1 seconds all stop
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