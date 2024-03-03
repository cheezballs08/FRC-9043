package frc.robot.Commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DrivetrainConstants;
import frc.robot.Subsystems.DrivetrainSubsystem;

public class ArcadeDriveCommand extends CommandBase {

  //Subsystemi ekliyelim
  private final DrivetrainSubsystem ds_drivetrainSubsystem;

  //Supplier kullanılmasının sebebi bize daha çok esneklik sağlaması.
  private final Supplier<Double> f_speedFunction, f_turnFunction;

  public ArcadeDriveCommand(DrivetrainSubsystem drivetrainSubsystem, Supplier<Double> speedFunction, Supplier<Double> turnFunction) {
    this.ds_drivetrainSubsystem = drivetrainSubsystem; this.f_speedFunction = speedFunction; this.f_turnFunction = turnFunction;
    addRequirements(ds_drivetrainSubsystem);
  }

  //Başlangıçta ufak bir feedback.
  @Override
  public void initialize() {
    System.out.println("ARCADE DRIVE ACTIVE");
  }

  //Basit bir komut, sıkıntı varsa haber verin.
  @Override
  public void execute() {
    if(ds_drivetrainSubsystem.getGearStatus(1)){
      ds_drivetrainSubsystem.arcadeDrive(f_speedFunction.get()*DrivetrainConstants.c_arcadeDriveGear1Multiplier, f_turnFunction.get()*DrivetrainConstants.c_arcadeDriveTurnMultipiler);
    }
    else if(ds_drivetrainSubsystem.getGearStatus(2)){
      ds_drivetrainSubsystem.arcadeDrive(f_speedFunction.get()*DrivetrainConstants.c_arcadeDriveGear2Multiplier, f_turnFunction.get()*DrivetrainConstants.c_arcadeDriveTurnMultipiler);
    }
  }

  //Aynısını komutun sonu için de yapalım (Ki fonksiyonun şuanlık sonu olmamalı, sonra değişebilir.)
  @Override
  public void end(boolean interrupted) {
    System.out.println("ARCADE DRIVE DEACTIVATED");
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}