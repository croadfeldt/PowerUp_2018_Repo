package frc.team2220.robot.commands.miscellaneous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team2220.robot.Robot;
import frc.team2220.robot.subsystems.VelocityTestSubsystem;

public class VelocityMotorCommand extends Command{

    double vel;

    public VelocityMotorCommand(double vel) {
        requires(Robot.velocityTestSubsystem);
        this.vel = vel;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        //VelocityTestSubsystem.getInstance().changeToPercentVBus();
        VelocityTestSubsystem.getInstance().changeToVelocity();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        //double xVal = Robot.oi.getDriverStick().getRawAxis(1);
        SmartDashboard.putNumber("EXPECTED VELOCITY", vel);
        VelocityTestSubsystem.getInstance().motorSet(vel);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
