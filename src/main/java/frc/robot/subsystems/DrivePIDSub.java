
/*
package frc.robot.subsystems;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DrivePIDSub extends SubsystemBase {
   
private static WPI_TalonFX leftFront;
private WPI_TalonFX leftBack;
private MotorControllerGroup leftMotors;
private WPI_TalonFX rightFront;
private WPI_TalonFX rightBack;
private MotorControllerGroup rightMotors;
public static DifferentialDrive arcadeDrive;
private static PIDController drivepidController;
private final SimpleMotorFeedforward feedforward;

private static final double kP = Constants.DrivePIDkP;
private static final double kI = Constants.DrivePIDkI;
private static final double kD = Constants.DrivePIDkD;
private static final double kF = Constants.DrivePIDkF;
private static final double kRotationsPerPulse = Constants.DriveRot_Per_Pulse; //check this value

private static final double kMaxOutput = 0.5;
private static final double kMinOutput = -0.5;

    
public DrivePIDSub() { //This is the main program to run the drivetrain
        
    leftFront = new WPI_TalonFX(Constants.leftFrontCan);
        leftFront.setInverted(false);
    leftBack = new WPI_TalonFX(Constants.leftBackCan);
        leftBack.setInverted(false);
    leftMotors = new MotorControllerGroup(leftFront, leftBack  );
        addChild("LeftMotors",leftMotors);
 

    rightFront = new WPI_TalonFX(Constants.rightFrontCan);
        rightFront.setInverted(false);
    rightBack = new WPI_TalonFX(Constants.rightBackCan);
        rightBack.setInverted(false);
    rightMotors = new MotorControllerGroup(rightFront, rightBack  );
        addChild("RightMotors",rightMotors);

    leftFront.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.IntegratedSensor, 0, 0);
 

    arcadeDrive = new DifferentialDrive(leftMotors, rightMotors);
        addChild("ArcadeDrive",arcadeDrive);
    arcadeDrive.setSafetyEnabled(true);
    arcadeDrive.setExpiration(0.1);
    arcadeDrive.setMaxOutput(0.75);
    

        drivepidController = new PIDController(kP, kI, kD);
        feedforward = new SimpleMotorFeedforward(kF, 0.1);
}  
      public static void setPosition(double setpoint) {
          drivepidController.setSetpoint(setpoint);
      }
  
      public void setOutputRange(double minOutput, double maxOutput) {
          //pidController.setOutputRange(minOutput, maxOutput);  Not sure if what is below is the correct substitution
          drivepidController.setIntegratorRange(0.1, 0.5);
      }
      public static void resetEncoder() {
        // Reset the motor's integrated encoder to zero
        leftFront.setSelectedSensorPosition(0);
      
      }
  
      public static void stopmotors(){
        ((MotorController) arcadeDrive).set(0);
      }
  
        
    
  
      @Override
      public void periodic() {
          double position = leftFront.getSelectedSensorPosition() * kRotationsPerPulse;
          double velocity = leftFront.getSelectedSensorVelocity();
  
          double output = drivepidController.calculate(position);
          output += feedforward.calculate(drivepidController.getSetpoint(), velocity);
  
          output = Math.max(output, kMinOutput);
          output = Math.min(output, kMaxOutput);
  
          ((MotorController) arcadeDrive).set(output);
  
          SmartDashboard.putNumber("Drive Position", position);
          SmartDashboard.putNumber("Drive Output", output);
      }




@Override
public void simulationPeriodic() {

}

    

}
*/