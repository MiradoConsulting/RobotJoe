import robocode.*;
import java.awt.Color;


public class RobotJoe extends AdvancedRobot {
    
    public void run() {
        setColors(Color.pink, Color.orange, Color.green); // body,gun,radar
        while (true) {
            turnRadarRight(360);
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        double absBearing = e.getBearingRadians() + getHeadingRadians();
        double latVel = e.getVelocity() * Math.sin(e.getHeadingRadians() - absBearing);
        double gunTurn;
        setTurnRadarLeftRadians(getRadarTurnRemainingRadians());

        if (e.getDistance() > 150) {
            gunTurn = robocode.util.Utils.normalRelativeAngle(absBearing - getGunHeadingRadians() + latVel / 22);
            setTurnGunRightRadians(gunTurn);
            setTurnRightRadians(
                    robocode.util.Utils.normalRelativeAngle(absBearing - getHeadingRadians() + latVel / getVelocity()));
            setAhead((e.getDistance() - 140) * getHeadingRadians());
            setFire(3);
        } else {// if we are close enough...
            gunTurn = robocode.util.Utils.normalRelativeAngle(absBearing - getGunHeadingRadians() + latVel / 15);
            setTurnGunRightRadians(gunTurn);// turn our gun
            setTurnLeft(-90 - e.getBearing()); // turn perpendicular to the enemy
            setAhead((e.getDistance() - 140) * getHeadingRadians());// move forward
            setFire(3);
        }
    }

    public void onHitWall(HitWallEvent e) {
        setAhead(getHeadingRadians());
    }
}
