/*Tersine shoot yapan bir metod. */

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ShooterConstants;
import frc.robot.Subsystems.ShooterSubsystem;
//Basit importlar.

public class ReversedShoot extends CommandBase {

  //Subsystemi ekliyelim
  private ShooterSubsystem ss_shooterSubsystem;
  

  public ReversedShoot(ShooterSubsystem shooterSubsystem) {
    this.ss_shooterSubsystem = shooterSubsystem;
    addRequirements(ss_shooterSubsystem);
  }


  @Override
  public void initialize() {
    //Başlangıçta motorların hızını resetliyelim.
    ss_shooterSubsystem.setShooterMotorControllerGroupSpeed(0);
    System.out.println("REVERSE COMMAND ACTIVATED");
  }

  //Hızı ayarlıyoruz.
  @Override
  public void execute() {
    ss_shooterSubsystem.setShooterMotorControllerGroupSpeed(ShooterConstants.c_shooterFastMotorControllerGroupSpeed*-0.3);
  }


  @Override
  public void end(boolean interrupted) {
    //Ve sonda da motorların hızını resetliyelim ki bitince sonsuza kadar gitmesin.
    ss_shooterSubsystem.setShooterMotorControllerGroupSpeed(0);
    System.out.println("REVERSE SHOOT COMMAND ENDED");
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
