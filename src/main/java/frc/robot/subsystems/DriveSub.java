package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class DriveSub extends SubsystemBase {
   
private WPI_TalonFX leftFront;
private WPI_TalonFX leftBack;
private MotorControllerGroup leftMotors;
private WPI_TalonFX rightFront;
private WPI_TalonFX rightBack;
private MotorControllerGroup rightMotors;
private static DifferentialDrive arcadeDrive;

    
public DriveSub() { //This is the main program to run the drivetrain
        
    leftFront = new WPI_TalonFX(Constants.leftFrontCan);
        leftFront.setInverted(false);
    leftBack = new WPI_TalonFX(Constants.leftBackCan);
        leftBack.setInverted(false);
    leftMotors = new MotorControllerGroup(leftFront, leftBack  );
        addChild("LeftMotors",leftMotors);
 

    rightFront = new WPI_TalonFX(Constants.rightFrontCan);
        rightFront.setInverted(true);
    rightBack = new WPI_TalonFX(Constants.rightBackCan);
        rightBack.setInverted(true);
    rightMotors = new MotorControllerGroup(rightFront, rightBack  );
        addChild("RightMotors",rightMotors);
 

    arcadeDrive = new DifferentialDrive(leftMotors, rightMotors);
        addChild("ArcadeDrive",arcadeDrive);
    arcadeDrive.setSafetyEnabled(false);
    arcadeDrive.setExpiration(0.1);
    arcadeDrive.setMaxOutput(0.75);

}

@Override
public void periodic() {
      

}

@Override
public void simulationPeriodic() {

}

public void my_Arcade(double speed, double turn, boolean square_input){
    arcadeDrive.arcadeDrive(speed, turn, square_input);
}

    

}

