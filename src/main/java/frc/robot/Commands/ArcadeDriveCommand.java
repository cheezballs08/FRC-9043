package frc.robot.Commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.DrivetrainSubsystem;

public class ArcadeDriveCommand extends CommandBase {

  private final DrivetrainSubsystem drivetrainSubsystem;

  //Supplier kullanılmasının sebebi bize daha çok esneklik sağlaması.
  private final Supplier<Double> speedFunction, turnFunction;

  public ArcadeDriveCommand(DrivetrainSubsystem drivetrainSubsystem, Supplier<Double> speedFunction, Supplier<Double> turnFunction) {
    this.drivetrainSubsystem = drivetrainSubsystem; this.speedFunction = speedFunction; this.turnFunction = turnFunction;
    addRequirements(drivetrainSubsystem);
  }

  //Başlangıçta ufak bir feedback.
  @Override
  public void initialize() {
    System.out.println("ARCADE DRIVE ACTIVE");
  }

  //Basit bir komut, sıkıntı varsa haber verin.
  @Override
  public void execute() {
    drivetrainSubsystem.arcadeDrive(speedFunction.get(), turnFunction.get());
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
