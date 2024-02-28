//Shooter ile hemen hemen aynı şey shootera bakın commentler için.
package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase {

  IntakeSubsystem is_intakeSubsystem;

  public IntakeCommand(IntakeSubsystem intakeSubsystem) {
    this.is_intakeSubsystem = intakeSubsystem;
    addRequirements(is_intakeSubsystem);
  }

  @Override
  public void initialize() {
    is_intakeSubsystem.setIntakeMotorSpeed(0);
    System.out.println("INTAKE COMMAND ACTIVE");
  }

  @Override
  public void execute() {
    is_intakeSubsystem.setIntakeMotorSpeed(IntakeConstants.c_intakeMotorSpeed);
  }


  @Override
  public void end(boolean interrupted) {
    is_intakeSubsystem.setIntakeMotorSpeed(0);
    System.out.println("INTAKE COMMAND DEACTIVE");
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
