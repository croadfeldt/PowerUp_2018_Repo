package frc.team2220.robot.commands.leftstart;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2220.robot.commands.auto.PathReader;
import frc.team2220.robot.commands.miscellaneous.WorstAutoGroup;

import edu.wpi.first.wpilibj.command.InstantCommand;
import openrio.powerup.MatchData;

public class LeftAutoHelper extends InstantCommand{

    //SS stand for SAME SIDE
//	private Command switchAutoSS = new LStartLSwitch();
//	private Command scaleAutoSS = new LStartLScale();

    private Command switchAutoSS = new PathReader("/home/lvuser/paths/LStart/LStartLSwitch_left_detailed.csv", "/home/lvuser/paths/LStart/LStartLSwitch_right_detailed.csv", 0.0015);


	//OS stand for OPPOSITE SIDE

	private Command WorstAuto = new WorstAutoGroup();
	
	@Override
	protected void initialize() {
        //Robot.side = "LEFT";
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
        switchAutoSS.start();

        MatchData.OwnedSide switchSide = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH_NEAR);
		MatchData.OwnedSide scaleSide = MatchData.getOwnedSide(MatchData.GameFeature.SCALE);
        System.out.println("Ran once");

		if (switchSide == MatchData.OwnedSide.LEFT) {//Lxx

            switchAutoSS.start();

		} else if (switchSide == MatchData.OwnedSide.RIGHT) {//Rxx
				
				if (scaleSide == MatchData.OwnedSide.LEFT) {//RLx
					
					//scaleAutoSS.start();
					
				} else if (scaleSide == MatchData.OwnedSide.RIGHT) {

					WorstAuto.start(); //TODO DO BASIC STUFF DONT LEAVE THIS HERE

				}


        }
			
		}


}
