package frc.team2220.robot.commands.leftstart;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2220.robot.commands.auto.WorstAutoGroup;
import frc.team2220.robot.commands.leftstart.LStartLScale;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team2220.robot.commands.leftstart.LStartLSwitch;
import openrio.powerup.MatchData;

public class LeftAutoHelper extends InstantCommand{

	private Command switchAuto = new LStartLSwitch();
	private Command scaleAuto = new LStartLScale();
	private Command WorstAuto = new WorstAutoGroup();
	
	@Override
	protected void initialize() {
        //Robot.side = "LEFT";
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
        switchAuto.start();

        MatchData.OwnedSide switchSide = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH_NEAR);
		MatchData.OwnedSide scaleSide = MatchData.getOwnedSide(MatchData.GameFeature.SCALE);
        System.out.println("Ran once");

		if (switchSide == MatchData.OwnedSide.LEFT) {//Lxx

            switchAuto.start();
            System.out.println("Lxx");

		} else if (switchSide == MatchData.OwnedSide.RIGHT) {//Rxx
				
				if (scaleSide == MatchData.OwnedSide.LEFT) {//RLx
					
					scaleAuto.start();
					
				} else if (scaleSide == MatchData.OwnedSide.RIGHT) {

					WorstAuto.start(); //TODO DO BASIC STUFF DONT LEAVE THIS HERE

				}


        }
			
		}


}
