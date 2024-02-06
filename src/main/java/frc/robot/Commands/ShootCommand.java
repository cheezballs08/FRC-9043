/*ShootCommand, Aktif olduğu boyunca ShooterSubsystemdeki motorları
önceden sabitlenmiş bir hızda çalıştırır. Çok da karmaşık değil.*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ShooterConstants;
//Basit importlar.
import frc.robot.Subsystems.ShooterSubsystem;

public class ShootCommand extends CommandBase {

  //Subsystemi ekliyelim
  private ShooterSubsystem ss_shooterSubsystem;
  

  public ShootCommand(ShooterSubsystem shooterSubsystem) {
    this.ss_shooterSubsystem = shooterSubsystem;
  }


  @Override
  public void initialize() {
    System.out.println("SHOOT COMMAND ACTIVATED");
  }

  //Hızı ayarlıyoruz.
  @Override
  public void execute() {
    ss_shooterSubsystem.setShooterMotorControllerGroupSpeed(ShooterConstants.c_shooterMotorControllerGroupSpeed);
  }


  @Override
  public void end(boolean interrupted) {
    System.out.println("SHOOT COMMAND ENDED");
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
