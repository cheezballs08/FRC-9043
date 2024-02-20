//Intake ile hemen hemen aynı şey shootera bakın commentler için.
package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ClimberConstants;
import frc.robot.Subsystems.ClimberSubsystem;

public class ClimberCommand extends CommandBase {

  ClimberSubsystem cs_climberSubsystem;

  public ClimberCommand(ClimberSubsystem climberSubsystem) {
    this.cs_climberSubsystem = climberSubsystem;
  }

  @Override
  public void initialize() {
    cs_climberSubsystem.setClimberMotorControllerGroupSpeed(0);
  }

  @Override
  public void execute() {
    is_climberSubsystem.setClimberMotorControllerGroupSpeed(climberConstants.c_climberMotorSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    is_climberSubsystem.setClimberMotorControllerGroupSpeed(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
