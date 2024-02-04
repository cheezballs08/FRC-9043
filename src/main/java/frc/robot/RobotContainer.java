/*Burası önemli bir yer, lütfen burası ile sadece yeni komut ekliyor veya eski komutlardaki
bugları değiştiriyorsanız oynayın!*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Commands.ArcadeDriveCommand;
import frc.robot.Constants.ControllerConstants;
import frc.robot.Subsystems.ClimberSubsystem;
import frc.robot.Subsystems.DrivetrainSubsystem;
import frc.robot.Subsystems.IntakeSubsystem;
import frc.robot.Subsystems.ShooterSubsystem;

public class RobotContainer {

  //Xbox Controller tanımlaması.
  XboxController xboxController = new XboxController(ControllerConstants.xboxControllerID);
  
  //Alt sistemlerin tanımlamaları.
  ClimberSubsystem climberSubsystem = new ClimberSubsystem();
  DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem(false, false, false, false);
  IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  ShooterSubsystem shooterSubsystem = new ShooterSubsystem();

  //Komut tanımlamaları
  /*Bu gördüğünüz () -> ifadesi lambda ifadeleri olarak geçiyor, zamanında supplier kullandığımız için Java bizden argüman olarak
  fonksiyon istiyor, biz de argümanımızı fonksiyona çevirmek için lambda ifadeleri kullandık, sonuçta lambda ifadeleri birer fonksiyondur.*/
  ArcadeDriveCommand arcadeDriveCommand = new ArcadeDriveCommand(drivetrainSubsystem, () -> xboxController.getLeftX(), () -> xboxController.getLeftY());

  public RobotContainer() {
    drivetrainSubsystem.setDefaultCommand(arcadeDriveCommand);
    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
