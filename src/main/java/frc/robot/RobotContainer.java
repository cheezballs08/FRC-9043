/*Burası önemli bir yer, lütfen burası ile sadece yeni komut ekliyor veya eski komutlardaki
bugları değiştiriyorsanız oynayın!*/

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Commands.ArcadeDriveCommand;
import frc.robot.Commands.ClimbCommand;
import frc.robot.Commands.FastShootCommand;
import frc.robot.Commands.IntakeCommand;
import frc.robot.Commands.SlowShootCommand;
import frc.robot.Constants.ControllerConstants;
import frc.robot.Subsystems.DrivetrainSubsystem;
import frc.robot.Subsystems.IntakeSubsystem;
import frc.robot.Subsystems.ShooterSubsystem;
import frc.robot.Subsystems.ClimberSubsystem;


public class RobotContainer {

  //COMMAND (Önemli) Xbox Controller tanımlaması. Command olmasında dikkat ediniz.
  CommandXboxController cxc_commandXboxController = new CommandXboxController(ControllerConstants.c_commandXboxControllerID);

  //Triggerları tanımlayalım, şuan ney neye gidiyo bilmiyorum deneme yanılma ile hallederiz :D
  Trigger t_rightTopTrigger =  cxc_commandXboxController.rightTrigger(0.2);
  Trigger t_rightBottomTrigger = cxc_commandXboxController.button(0);
  Trigger t_leftBottomTrigger = cxc_commandXboxController.button(0);

  //Alt sistemlerin tanımlamaları.
  DrivetrainSubsystem ds_drivetrainSubsystem = new DrivetrainSubsystem(false, false, false, false);
  IntakeSubsystem is_intakeSubsystem = new IntakeSubsystem(false);
  ShooterSubsystem ss_shooterSubsystem = new ShooterSubsystem(false, false);
  ClimberSubsystem cs_climberSubsystem = new ClimberSubsystem(false,false);

  //Komut tanımlamaları
  /*Bu gördüğünüz () -> ifadesi lambda ifadeleri olarak geçiyor, zamanında supplier kullandığımız için Java bizden argüman olarak
  fonksiyon istiyor, biz de argümanımızı fonksiyona çevirmek için lambda ifadeleri kullandık, sonuçta lambda ifadeleri birer fonksiyondur.*/
  ArcadeDriveCommand adc_arcadeDriveCommand = new ArcadeDriveCommand(ds_drivetrainSubsystem, () -> cxc_commandXboxController.getLeftX(), () -> cxc_commandXboxController.getLeftY());
  ClimbCommand cc_climbCommand = new ClimbCommand(cs_climberSubsystem);
  FastShootCommand fsc_fastShootCommand = new FastShootCommand(ss_shooterSubsystem);
  IntakeCommand ic_intakeCommand = new IntakeCommand(is_intakeSubsystem);
  SlowShootCommand ssc_slowShootCommand = new SlowShootCommand(ss_shooterSubsystem);

  public RobotContainer() {
    ds_drivetrainSubsystem.setDefaultCommand(adc_arcadeDriveCommand);
    configureBindings();
  }

  private void configureBindings() {
    t_leftBottomTrigger.whileTrue(ic_intakeCommand);
    t_rightBottomTrigger.whileTrue(fsc_fastShootCommand);
    t_rightTopTrigger.whileTrue(ssc_slowShootCommand);
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
