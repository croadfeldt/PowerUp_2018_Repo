package frc.team2220.robot.commands.leftstart;

import frc.team2220.robot.commands.miscellaneous.AntiClockwiseTurn;
import frc.team2220.robot.commands.auto.DriveToDistance;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team2220.robot.utils.Constants;
import frc.team2220.robot.utils.Converter;

public class LStartLScale extends CommandGroup{
	
	public LStartLScale() {
		//Division by 2 as Robot mid should be on target point
		double target1 = Converter.inToEncTicks(324) - Converter.inToEncTicks(Constants.frameLengthIn/2);
		double target2 = Converter.inToEncTicks(12) - Converter.inToEncTicks(Constants.frameLengthIn/2);
		
		addSequential(new DriveToDistance(target1));
		addSequential(new AntiClockwiseTurn(Converter.degreesTurnToEncTicks(90)));
		addSequential(new DriveToDistance(target2));
		
	}

}
