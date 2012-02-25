import java.util.Iterator;
import lejos.nxt.*;
import lejos.robotics.navigation.*;
import lejos.util.Delay;


/**
 * Here is another implementation of the Lab1 specifications illustrating the use 
 * of the Differentialilot class.<br>
 * The problem can be analysed into a top-level task (trace 4 squares) which contains
 * a single sub-task <br>
 * (trace a square) repeated 4 times.  This in turn is composed of 2 steps: 
 * trace a straight line and rotate 90 deg;
 * The two top abstraction levels are each implemented in a method. 
 * the bottom level steps are single commands. 
 * @author Roger Glassey
 */
public class SquareBot1
{
   DifferentialPilot pilot;  // see the javadoc for this object
   
 /**
  * The constructor arguments are requirid to configure the instance of Pilot w
  * @param wheelDiameter
  * @param trackWidth
  * @param leftMotor
  * @param rightMotor
  */    
   public SquareBot1(DifferentialPilot aPilot)
   {
      // direct pass through of the pilot specifications
      pilot = aPilot;
      Motor.A.setAcceleration(3000);
      Motor.C.setAcceleration(3000);
      pilot.setTravelSpeed(25);
      pilot.setRotateSpeed(180);
   }
   
 /**  
  * Definition of the top level task
  * @param  the length of a side
  */
   public void fourSquares (int length)
   {  System.out.println("L "+length);
      byte direction = 1; // direction of traversing the square; initially turning left
      for (int i = 0; i<4; i++)// 4 squares total need
      {
         LCD.drawInt(i, 0, 0);
         if(i==2)// after 2 have been completed, turn back and change the direction of traverse
         {
            pilot.rotate(90);
            direction = -1;
         }
         square(length, direction);
      }
   }
   /**
    * The sub-task
    * @param length
    * @param direction
    */
   private void square(int length, byte direction)
   {
      for (int i = 0; i <4; i++)
      {
         pilot.travel(length);
         pilot.rotate(direction * 90);
      }
      Sound.beepSequenceUp();
      Delay.msDelay(500);
   }
   public static void main(String[] args)
   {
      //specifications for building the robot object
      DifferentialPilot pilot = new DifferentialPilot(5.35f, 11.7f, Motor.A, Motor.C);
      SquareBot1 squareBot = new SquareBot1(pilot);
      System.out.println("SquareBot1");
      Button.waitForAnyPress();
      squareBot.fourSquares(90);
   }
   
}
