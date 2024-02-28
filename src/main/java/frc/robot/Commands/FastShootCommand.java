/*ShootCommand, Aktif olduğu boyunca ShooterSubsystemdeki motorları
önceden sabitlenmiş bir hızda çalıştırır. Çok da karmaşık değil.*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ShooterConstants;
//Basit importlar.
import frc.robot.Subsystems.ShooterSubsystem;

public class FastShootCommand extends CommandBase {

  //Subsystemi ekliyelim
  private ShooterSubsystem ss_shooterSubsystem;
  

  public FastShootCommand(ShooterSubsystem shooterSubsystem) {
    this.ss_shooterSubsystem = shooterSubsystem;
  }


  @Override
  public void initialize() {
    //Başlangıçta motorların hızını resetliyelim.
    ss_shooterSubsystem.setShooterMotorControllerGroupSpeed(0);
    System.out.println("FAST SHOOT COMMAND ACTIVATED");
  }

  //Hızı ayarlıyoruz.
  @Override
  public void execute() {
    ss_shooterSubsystem.setShooterMotorControllerGroupSpeed(ShooterConstants.c_shooterFastMotorControllerGroupSpeed);
  }


  @Override
  public void end(boolean interrupted) {
    //Ve sonda da motorların hızını resetliyelim ki bitince sonsuza kadar gitmesin.
    ss_shooterSubsystem.setShooterMotorControllerGroupSpeed(0);
    System.out.println("FAST SHOOT COMMAND ENDED");
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
