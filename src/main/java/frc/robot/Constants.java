package frc.robot;
public class Constants {

    //Motor speed POT adjustment assignments
    
    public static final double potvalueMOD = 2; //divide total input value by this so that the values range from 0 to 1
    public static final double turnSpeedMod = 4; //2=fast, 3=medium, 4=slow
    
    //Arm Rotation Positions
    public static final double ConeHighRotation = 0.44; //How much of a rotation arm should move for High placment
    public static final double ConeLowRotation = 0.48;  //How much of a rotation arm should move for Low Placement
    public static final double ConeIntakeRotation = 0.10; //How much of a rotation arm should move for Floor Placement
    
    //pid Controller Values
        //pid Arm
        public static final double ArmPIDkP = 0.90; // Increase this value to increase the rate of motion of arm
        public static final double ArmPIDkI = 0.15; // Increase this value so motor mainains it's position over time
        public static final double ArmPIDkD = 0.86; //  Increase this value so motor settles on value more quickly
        public static final double ArmPIDkF = 0.00;  // Increase to adjust the responsivness of the pidcontroller
        public static final double ArmRot_Per_Pulse = 0.00000488281; //(1/2048/100) one rotation per 2048 clicks per 100:1 gear box
        //pid Drive
        public static final double DrivePIDkP = 0;
        public static final double DrivePIDkI = 0;
        public static final double DrivePIDkD = 0;
        public static final double DrivePIDkF = 0;
        public static final double DriveRot_Per_Pulse = 0.00048281;//need to adjust for drive gear box
    
    
    
    //Can ID assignments
    public static final int leftFrontCan = 1;
    public static final int leftBackCan = 2;
    public static final int rightFrontCan = 3;
    public static final int rightBackCan = 4;
    public static final int ArmCan = 11;
    public static final int PCMCan = 5;
    public static final int grabSol1 = 0;
    public static final int grabSOl2 = 1;
    public static final int rampSol1 = 2;
    public static final int rampSol2 = 3;
    

    //DriveStick assignments
    public static final int driveStick = 0; //Driver Joystick USB assignment
    public static final int DrivestickXaxis = 0;
    public static final int DrivestickYaxis = 4;
    public static final int teleopdrive = 3;

    //ArmClawStick assignments
    public static final int armClawStick = 1;  //Buttons Joystick USB assignment
    public static final int armClawstickYaxis = 1;
    public static final int ClawJoystickbutton = 8;
    public static final int armEngageButton = 4;
    public static final int ConeCubeRequestButton = 7;
    public static final int ArmIntakeButton = 6;
    public static final int ArmLowButton = 1;
    public static final int ArmHighButton = 2;
    public static final int RampButton = 3;
    public static final int EncoderResetButton = 5;
    public static final int driveSpeed = 3; //drive motor speed joystick assignment POT
    public static final int armSpeed = 4; // shoot motor speed joystick assignment POT


    
    
    
    
    
 
    
    
    
    
    
    
   
    
    
    

}


