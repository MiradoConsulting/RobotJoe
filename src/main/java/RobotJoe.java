import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * RobotJoe - a robot by Georgios
 */
public class RobotJoe extends Robot {
    /**
     * run: RobotJoe's default behavior
     */
    public void run() {
        // Initialization of the robot should be put here

        // After trying out your robot, try uncommenting the import at the top,
        // and the next line:

        setColors(Color.pink, Color.grey, Color.green); // body,gun,radar

        // Robot main loop
        while (true) {
            scan();
            ahead(Math.random() * 150);
            turnGunRight(360);
            back(Math.random() * 150);
            turnGunRight(360);
            turnLeft(Math.random() * 150);
            turnGunRight(360);
            turnRight(Math.random() * 150);
        }
    }
    
    /**
     * onScannedRobot: What to do when you see another robot
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        // Replace the next line with any behavior you would like
        fire(3);
    }

    /**
     * onHitByBullet: What to do when you're hit by a bullet
     */
    public void onHitByBullet(HitByBulletEvent e) {
        // Replace the next line with any behavior you would like
        back(10);
    }

    /**
     * onHitWall: What to do when you hit a wall
     */
    public void onHitWall(HitWallEvent e) {
        // Replace the next line with any behavior you would like
        back(20);
    }
}
