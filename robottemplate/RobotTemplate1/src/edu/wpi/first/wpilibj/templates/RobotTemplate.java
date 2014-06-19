/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

//import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.*;


//import edu.wpi.first.wpilibj.ADXL345_I2C.AllAxes;
//import java.util.Scanner;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
        
    //DriverStation station = new DriverStation();
    
    SmartDashboard dash = new SmartDashboard();
        
    Victor Angle = new Victor(7);
    Victor shooterWheel = new Victor(5);
    Victor motorFL = new Victor(1);
    Victor motorFR = new Victor(2);
    Victor motorBL = new Victor(9);
    Victor motorBR = new Victor(3);
    Relay indexer = new Relay (1,Relay.Direction.kBoth);
    //Victor climber = new Victor(9);
    
    Timer autoTimer = new Timer(); 
    Timer pyramidTimer = new Timer();
    
   // Gyro gyroscope = new Gyro(1,1); 
    
    //ADXL345_I2C accelerometer;
    ADXL345DigitalAccelerometer accelerometer = new ADXL345DigitalAccelerometer(2);
    
    
    DigitalInput encoderShooter = new DigitalInput(1);
    Counter wheelCounter = new Counter(CounterBase.EncodingType.k1X, encoderShooter, encoderShooter, false);
    PIDCounter pidShotCounter = new PIDCounter(wheelCounter);
    
    Joystick joy = new Joystick(1);
    JoyButton joyA = new JoyButton(joy, 1);
    JoyButton joyB = new JoyButton(joy, 2);
    JoyButton joyX = new JoyButton(joy, 3);
    JoyButton joyY = new JoyButton(joy, 4);
    JoyButton joyLB = new JoyButton(joy, 5);
    JoyButton joyRB = new JoyButton(joy, 6);
    JoyButton joyBack = new JoyButton(joy, 7);
    JoyButton joyStart = new JoyButton(joy, 8);
    JoyButton joyLClick = new JoyButton(joy, 9);
    JoyButton joyRClck = new JoyButton(joy, 10);
    
    Indexer index = new Indexer(indexer);
    boolean indexSpinning = true;
    
    double axisValueX = joy.getRawAxis(1);
    double axisValueY = joy.getRawAxis(2);
    
    double angle;
    
//    PIDKinect pidx3 = new PIDKinect(x3Val);
 //   PIDController pidHor = new PIDController(.105,4,.1,pidx3);
        
    double motorP = 15;
    double pyramidP = 5;
    double motorI = 1;
    double motorD = 0;
    
    PandaStuff x3 = new PandaStuff("x3");
    PandaStuff y3 = new PandaStuff("y3");
    PandaStuff xpyr = new PandaStuff("xpyr");
    PandaStuff ypyr = new PandaStuff("ypyr");
    
    SmartDashboardAcc SDA = new SmartDashboardAcc();
    
    
    PIDController pid = new PIDController(.1,4,.105,0,pidShotCounter,shooterWheel);
    PIDController mAN = new PIDController(1,1,0,y3, Angle);
    PIDController sAN = new PIDController(1,1,0,SDA,Angle);
    PIDController mFR = new PIDController(motorP,motorI,motorD,x3, motorFR);
    PIDController mFL = new PIDController(motorP,motorI,motorD,x3, motorFL);
    PIDController mBR = new PIDController(motorP,motorI,motorD,x3, motorBR);
    PIDController mBL = new PIDController(motorP,motorI,motorD,x3, motorBL); 
    PIDController pAN = new PIDController(1,1,0,ypyr,Angle);
    PIDController pFR = new PIDController(pyramidP,motorI,motorD,xpyr, motorFR);
    PIDController pFL = new PIDController(pyramidP,motorI,motorD,xpyr, motorFL);
    PIDController pBR = new PIDController(pyramidP,motorI,motorD,xpyr, motorBR);
    PIDController pBL = new PIDController(pyramidP,motorI,motorD,xpyr, motorBL);    

    
    // Drive drive = new Drive(joy, motorFL, motorFR, motorBL, motorBR);

    
    //Scanner scan = new Scanner(System.in);
    
    double autoShotPower = 0;
            
    double ourSetPoint = 3600;
        
    NetworkTable table;
    
    int angleOffset = 0;

    
    public void robotInit() {
        
        accelerometer.initialize();
        accelerometer.setRange(ADXL345DigitalAccelerometer.DATA_FORMAT_16G);
        wheelCounter.start();
        wheelCounter.setMaxPeriod(5);
        pid.setPID(.1, 4, .105);
        pid.setOutputRange(-1,1);
        pid.setInputRange(0, 5500);
        pid.setContinuous(false);
        mAN.setOutputRange(-1, 1);
        mAN.setInputRange(-90, 90);
        mAN.setContinuous(false);
        mAN.setAbsoluteTolerance(5);
        sAN.setOutputRange(0, 90);
        sAN.setContinuous(false);
        sAN.setAbsoluteTolerance(1);
        mFR.setOutputRange(-1, 1);
        mFR.setInputRange(-360, 360);
        mFR.setContinuous(false);
        mFR.setAbsoluteTolerance(20);
        mFL.setOutputRange(-1, 1);
        mFL.setInputRange(-360, 360);
        mFL.setContinuous(false);
        mFL.setAbsoluteTolerance(20);
        mBR.setOutputRange(-1, 1);
        mBR.setInputRange(-360, 360);
        mBR.setContinuous(false);
        mBR.setAbsoluteTolerance(20);
        mBL.setOutputRange(-1, 1);
        mBL.setInputRange(-360, 360);
        mBL.setContinuous(false);
        mBR.setAbsoluteTolerance(20);
        pFR.setOutputRange(-1, 1);
        pFR.setInputRange(-240, 240);
        pFR.setContinuous(false);
        pFR.setAbsoluteTolerance(20);
        pFL.setOutputRange(-1, 1);
        pFL.setInputRange(-240, 240);
        pFL.setContinuous(false);
        pFL.setAbsoluteTolerance(20);
        pBR.setOutputRange(-1, 1);
        pBR.setInputRange(-240, 240);
        pBR.setContinuous(false);
        pBR.setAbsoluteTolerance(20);     
        pBL.setOutputRange(-1, 1);
        pBL.setInputRange(-240, 240);
        pBL.setContinuous(false);
        pBL.setAbsoluteTolerance(20);   

        //gyroscope.reset();
        //ourSetPoint = 2000;//1800 is half and 3600 is full
        
        table = NetworkTable.getTable("SmartDashboard");
        
        table.putNumber("capture", 0);
        
        table.putNumber("angleOffset", 0);
        
        dash.putNumber("SmartDashboardAcc", 0);
        
        System.out.println("cRio connected ");
    
}
    public void autonomousInit() {  
        autoTimer.start();
    }
    
    public void autonomousPeriodic() {
        System.out.println("Auto Run");
   
        
        //System.out.println("RPM: " + pidShotCounter.pidGet());
        //System.out.println("SP: " + pid.getSetpoint());
        //System.out.println( pid.getSetpoint() - pidShotCounter.pidGet());
        //shooterWheel.set(autoShotPower);
       SmartDashboard.putNumber("RPM", pidShotCounter.pidGet());        
        //mAN.enable();
        // FIRING
            //mAN.enable();
       /*
        * //LETS JUST DO FULL BLAST
            pid.setSetpoint(ourSetPoint);
            pid.enable();
        */
       shooterWheel.set(1);
       double time = autoTimer.get();
       double onLength = 0.9;//in sec
       double offLength = 2.5; //in sec
       
       if (time%(onLength+offLength)<offLength){     
           indexer.set(Relay.Value.kOff);
       }
       else
       {
           indexer.set(Relay.Value.kOn);
       }
       /*if (autoTimer.get() > 3) {
                //mAN.disable();
                index.fire();
            
            }
            */
        
            
            /*shooterWheel.set(1);
            autoTimer.start();
            while (autoTimer.get() < 3) {
                index.stop();    
            }
            autoTimer.stop();
            autoTimer.reset();
            autoTimer.start();
            while (autoTimer.get() < 14) {
                index.fire();    
            }
            pid.disable();
            index.stop();
            autoTimer.stop();
            autoTimer.reset();*/
        
        // MOVEMENT
        
//        autoTimer.start();
//        // MOVE LEFT
//        while (autoTimer.get() < 1.5) {
//            motorFL.set(1);
//            motorBL.set(-1);
//            motorFR.set(-1);
//            motorBR.set(1);
//        }
//        autoTimer.stop();
//        autoTimer.reset();
//        autoTimer.start();
//        // MOVE BACK
//        while (autoTimer.get() < 2) {
//            motorFL.set(-1);
//            motorBL.set(-1);
//            motorFR.set(-1);
//            motorBR.set(-1);
//        }
//        autoTimer.stop();
//        autoTimer.reset();
//        motorFL.set(0);
//        motorBL.set(0);
//        motorFR.set(0);
//        motorBR.set(0);
        
   }
    
    public void disabledInit(){
        autoTimer.stop();
        autoTimer.reset();
        //motorFL.set(0);
        //mFL.disable();
        //motorFR.set(0);
        //mFR.disable();
        //motorBL.set(0);
        //mBL.disable();
        //motorBR.set(0);
        //mBR.disable();
    }
    
    public void teleopInit() {
        //mAN.disable();
        autoTimer.stop();
        pid.disable();
        shooterWheel.set(0);
    }
    
    public void teleopPeriodic() {
        //mAN.disable();
        double currentAngle = accelerometer.pidGet();
        
        if (joy.getRawButton(3)) { //REMAP TO LEFT TRIGGER //Good
        table.putNumber("PYRAMIDSHOT", 0);       
        if (mFR.onTarget()) {
            mFR.disable();
            mFL.disable();
            mBR.disable();
            mBL.disable();
            mAN.disable();
            System.out.println("3POINT ADJUST TRUE");
        } else {
            mFR.enable();         
            mFL.enable();
            mBR.enable();
            mBL.enable();
            mAN.enable();
            System.out.println("3POINT ADJUST FALSE");
      }
   } else if (joy.getRawButton(4)) {       //REMAP TO LEFT BUMPER //good
        table.putNumber("PYRAMIDSHOT", 1);      
        if (pFR.onTarget()) {
            pFR.disable();
            pFL.disable();
            pBR.disable();
            pBL.disable();  
            pAN.disable();
            System.out.println("PYRSHOt ADJUST TRUE");
        } else {
            pFR.enable();
            pFL.enable();
            pBR.enable();
            pBL.enable();
            pAN.enable();
            System.out.println("PYRSHOt ADJUST FALSE");
       }
    } else {
        table.putNumber("PYRAMIDSHOT", 0);
        mFR.disable();
        mFL.disable();
        mBR.disable();
        mBL.disable();
        mAN.disable();
        pFR.disable();
        pFL.disable();
        pBR.disable();
        pBL.disable();
        pAN.disable();
        System.out.println("EVERYTHING ADJUST FALSE");
   }
//        double x3 = 0.0;
//        x3 = table.getNumber("x3");
//        System.out.println(x3);
//--------------------------------------------------------------------------        
//-----------------Turning on/off wheel to shooter--------------------------
//--------------------------------------------------------------------------
        //System.out.println(pidShotCounter.pidGet());
        //System.out.println(Math.abs(joy.getRawAxis(5)));

        //double ourSetPoint = SmartDashboard.getNumber("Wheel Speed");
        //System.out.println(ourSetPoint);
        // Shooter Speed Adjustment by LB/RB -> Unnecessary with Camera automaton
   /*     if (joy.getRawButton(5)) {
            ourSetPoint = ourSetPoint - 100;
        }
        else if (joy.getRawButton(6)) {
            ourSetPoint = ourSetPoint + 100;
        }
   */
        if(joy.getRawButton(1)) { //while the A is pressed
            /*pid.setSetpoint(ourSetPoint);
            pid.enable();*/
            //shooterWheel.set(joshAxis); //position R joystick
            shooterWheel.set(1);
        }
        else {
            //pid.disable();
            shooterWheel.set(0);
        }      
     
       /*
        double joshAxis = Math.abs(joy.getRawAxis(5)); //y axis right joy stick
        if(joshAxis > 0.2 ) { //while the B is pressed
            shooterWheel.set(Math.abs(joshAxis));
            System.out.println(joshAxis);
        } */
        
        
 //--------------------------------------------------------------------------
 //--------------------------Encoder Wheel Speed--------------------------------------------
 //--------------------------------------------------------------------------
        
        //System.out.println("----------------------" + encoderShooter.get());
       // System.out.println(wheelCounter.getPeriod());
        
        //System.out.println(pid.get());
        /* DECLARED AT TOP
        double Circumference = (22/7) * 70 ; //70mm diameter
        double timeOfSplit = wheelCounter.getPeriod();
        double speedOfWheel = (Circumference / timeOfSplit);        
        */
 
 //--------------------------------------------------------------------------
 //--------------------------Pyramid Shot------------------------------
 //--------------------------------------------------------------------------
        /*
        
        double pyramidSetPoint = 2600;
        double pyramidRaiseTime = 1.5; //find the accurate time needed to raise
        double pyramidLowerTime = 1.5; //find the accurate time needed to lower

        if (joyBack.checkState()==true) { //if the 'back' button is pressed
            //System.out.println("PyramidShot");   
            
        pyramidTimer.start();
        // raises the angle of the shooter for a pyramid shot
        while (pyramidTimer.get() < pyramidRaiseTime) {
            Angle.set(1);
       }
        pyramidTimer.stop();
        pyramidTimer.reset();
        
        pid.setSetpoint(pyramidSetPoint);
        pid.enable();
        }
        
        else{ //turn the shooter back to a normal shot
        pyramidTimer.start();
        // lowers the angle of the shooter for a pyramid shot
        while (pyramidTimer.get() < pyramidLowerTime) {
            Angle.set(-1);
       }
        pyramidTimer.stop();
        pyramidTimer.reset();
        
        pid.disable(); //turns off auto wheel for regular shot
        
        }
        */
        
       
 //--------------------------------------------------------------------------
 //---------------------------Indexer----------------------------------------
 //--------------------------------------------------------------------------
      /*
        //&& pidShotCounter.pidGet() < ourSetPoint-150
        if (joy.getRawAxis(3) == -1 || indexSpinning){ //Right Trigger, speed is up, not pressed
           if (!indexSpinning || !tripWire.get()){ //true meaning its pressed
               indexer.set(Relay.Value.kOn);
           }
           else{
               indexer.set(Relay.Value.kOff);
           }
        } */
        System.out.println(joy.getRawAxis(3));
        indexer.setDirection(Relay.Direction.kBoth);
         if (joy.getRawAxis(3) == -1)
         {
             indexer.set(Relay.Value.kForward);
         }
         else if (joy.getRawAxis(3) == 1)
         {
             //indexer.setDirection(Relay.Direction.kReverse);
             indexer.set(Relay.Value.kReverse);
         }
         else{
             indexer.set(Relay.Value.kOff);
         }
         
         //System.out.println(tripWire.getVoltage());

        
         if (joy.getRawButton(7) || joy.getRawButton(8)) System.out.println("tryingtoadjustangler");
  if (joy.getRawButton(7) && currentAngle > 20 && currentAngle <60) {
      Angle.set(-1);
  } else if (joy.getRawButton(8) && currentAngle > 20 && currentAngle <60) {
      Angle.set(1);
  } else
      Angle.set(0);
 //--------------------------------------------------------------------------
 //--------------------------Drive Train-------------------------------------
 //--------------------------------------------------------------------------

   double leftX = joy.getRawAxis(2);
   double leftY = joy.getRawAxis(1);
   double rightX = joy.getRawAxis(4);
   
   

   //System.out.println("driving " + leftX + " " + rightX);
    
      if (Math.abs(leftX) < 0.1)
      {
          leftX =0 ;
      }
      if (Math.abs(leftY) < 0.1)
      {
          leftY =0 ;
      }
      if (Math.abs(rightX) < 0.1)
      {
          rightX =0 ;
      }
      
              double spd = 1.0;
        motorFL.set((leftY*(spd)) - (leftX*(spd)) + (rightX) );
        motorFR.set((leftY*(spd))+(leftX*(spd)) + (rightX) );
        motorBL.set((-leftY*(spd))-(leftX*(spd)) + (rightX) );
        motorBR.set((-leftY*(spd))+(leftX*(spd)) + (rightX) ); 

//   
//   if (joy.getRawButton(7))            //REMAP TO "back" ON CONTROLLER //good
//       table.putNumber("capture", 1);
//   else 
//       table.putNumber("capture", 0);
//   
//   if (joy.getRawButton(2)) {  //REMAP TO "B" ON CoNTROLLER //good
//       sAN.enable();
//       if (sAN.onTarget()) 
//           sAN.disable();
//   } else
//       sAN.disable();
//   if (joy.getRawButton(4))         //REMAP TO Y ON FOUR WAY PAD \
//       angleOffset++;               //                            \
//   else if (joy.getRawButton(3))    //REMAP TO X ON FOUR WAY PAD   }GOOD
//       angleOffset = 0;             //                            /
//   else if (joy.getRawButton(1))    //REMAP TO A ON FOUR WAY PAD /
//       angleOffset--;
   table.putNumber("angleOffset", angleOffset);
    
   SmartDashboard.putNumber("Angle", accelerometer.pidGet());
   System.out.println("ACCELEROMETER angle: " + accelerometer.pidGet());
   
    }
    
}