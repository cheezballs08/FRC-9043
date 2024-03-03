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

  //Ve gearlar için bir ortak double değeri
  double d_arcadeDriveSpeedMultiplier = 1;

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
      d_arcadeDriveSpeedMultiplier = DrivetrainConstants.c_arcadeDriveGear1Multiplier;
    }
    else if(ds_drivetrainSubsystem.getGearStatus(2)){
      d_arcadeDriveSpeedMultiplier = DrivetrainConstants.c_arcadeDriveGear2Multiplier;
    }
    ds_drivetrainSubsystem.arcadeDrive(f_speedFunction.get()*d_arcadeDriveSpeedMultiplier, f_turnFunction.get()*DrivetrainConstants.c_arcadeDriveTurnMultipiler);
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