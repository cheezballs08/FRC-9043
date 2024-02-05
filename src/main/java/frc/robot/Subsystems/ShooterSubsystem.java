package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {

  //Constructorta kullanılacak boolean ifadeleri
  private boolean b_shooterMotor1Inverted, b_shooterMotor2Inverted;

  /*Motor Controllerları tanımlayalım bunlar neo unutmayın fırçasızlar! Ve IDleri Constants dosyasındaki
  shooter constants kısmından değiştirmeyi unutmayın!*/
  private CANSparkMax m_shooterMotor1 = new CANSparkMax(ShooterConstants.c_shooterMotor1ID, MotorType.kBrushless);
  private CANSparkMax m_shooterMotor2 = new CANSparkMax(ShooterConstants.c_shooterMotor2ID, MotorType.kBrushless);

  //Ve MotorControllerGroupları da tanımlayalım.
  private MotorControllerGroup mcg_shooterMotorControllerGroup = new MotorControllerGroup(m_shooterMotor1, m_shooterMotor2);

  //Constructoru yazalım
  public ShooterSubsystem(boolean motor1Inverted, boolean motor2Inverted ) {
    this.b_shooterMotor1Inverted = motor1Inverted; this.b_shooterMotor2Inverted = motor2Inverted;
    m_shooterMotor1.setInverted(b_shooterMotor1Inverted); m_shooterMotor2.setInverted(b_shooterMotor2Inverted);
  }

  //Buraya koymamız gereken herhangi bir şey yok.
  @Override
  public void periodic() {}

  //Hızını ayarlamak için bir metod
  public void setShooterMotorControllerGroupSpeed(double speed){
    if(speed < -1){
      mcg_shooterMotorControllerGroup.set(-1);
    }
    else if(speed > 1){
      mcg_shooterMotorControllerGroup.set(1);
    }
    else{
      mcg_shooterMotorControllerGroup.set(speed);
    }
  }
}
