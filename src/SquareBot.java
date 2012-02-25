import lejos.nxt.*;
// The  library for this project must include  classes.jar from  NXJ_HOME

/**
 * This class an trace a square of any size and in any direction.
 * @author 
 */
// use this  class to build and run your robot
public class SquareBot {

    /**
   * Constructs the robot and drives it to meet the project specifications
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
      LCD.drawString("GO",0,0);
      Button.waitForAnyPress();
      SquareBot robot = new SquareBot();
      Motor.A.setSpeed(300);
      Motor.A.setAcceleration(3000);
      Motor.C.setSpeed(300);
      Motor.C.setAcceleration(3000);
      int direction = 1;
      Button.waitForAnyPress();
      for(int i = 0 ;i< 4; i++)
      {
        robot.square(60,direction);
        if(i ==1)
        {
          robot.rotate(90*direction);
          direction = -1*direction;
          Button.waitForAnyPress();
        }
      }
    }
    /**
     * Top level task:  trace a square of specified size, and direction
     * @param length
     * @param direction 
     */
    public void square(float length,int direction)
    {
      for (int i = 0; i<4; i++)
      {
        move(length);
        rotate(direction*90);
      }
    }
    /**
     * straight line move in specified distance
     * @param distance 
     */
    public void move(float distance)
    {
      int angle = (int)(distance* 360/(3.14159f*wheelDiameter));
      Motor.A.rotate(angle,true);
      Motor.C.rotate(angle,false);    
    }
    /**
     * rotate through specified angle.   Positive = anti-clockwise
     * @param rotationAngle 
     */
    public void rotate(int rotationAngle)
    {
      int angle = (int)(rotationAngle*trackWidth/wheelDiameter);
      Motor.C.rotate(angle,true);
      Motor.A.rotate(-angle,false);
    }
    //  instance variables
      float wheelDiameter =  5.35f;
      float trackWidth = 11.7f;
}
