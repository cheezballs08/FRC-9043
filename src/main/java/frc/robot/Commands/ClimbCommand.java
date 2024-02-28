//Intake ile hemen hemen aynı şey shootera bakın commentler için.
package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ClimberConstants;
import frc.robot.Subsystems.ClimberSubsystem;

public class ClimbCommand extends CommandBase {

  ClimberSubsystem cs_climberSubsystem;

  public ClimbCommand(ClimberSubsystem climberSubsystem) {
    this.cs_climberSubsystem = climberSubsystem;
  }

  @Override
  public void initialize() {
    cs_climberSubsystem.setClimberMotorControllerGroupSpeed(0);
    System.out.println("CLIMB COMMAND ACTIVE");
  }

  @Override
  public void execute() {
    cs_climberSubsystem.setClimberMotorControllerGroupSpeed(ClimberConstants.c_climberMotorSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    cs_climberSubsystem.setClimberMotorControllerGroupSpeed(0);
    System.out.println("CLIMB COMMAND DEACTIVE");
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}