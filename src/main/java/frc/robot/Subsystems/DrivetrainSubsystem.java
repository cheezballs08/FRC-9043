/*Aşağıda drivetrain subsystemi için yazdığım kodu bulacaksınız, herhangi bir sıkıntı olursa kendiniz değiştirebilirsiniz.
Ancak bana haber vermeyi unutmayın!*/
package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;
//Basit importlar.

public class DrivetrainSubsystem extends SubsystemBase {

  /*Gerekli objelerin hepsi burada tanımlıdır, herhangi bir değişim gerekirse burayı veya
  Constants dosyasındaki gerekli yeri değiştireceksiniz.*/
  
  //Invert durumları, DrivetrainSubsystem constructorunda kullanılacaklar.
  private boolean b_leftMotor1Inverted, b_leftMotor2Inverted, b_rightMotor1Inverted, b_rightMotor2Inverted;

  //MotorController tanımlamaları, ID değiştirmek için Constants dosyasındaki DrivetrainConstants Classına Bakın.
  private CANSparkMax m_leftMotor1 = new CANSparkMax(DrivetrainConstants.c_drivetrainLeftMotor1ID, MotorType.kBrushed);
  private CANSparkMax m_leftMotor2 = new CANSparkMax(DrivetrainConstants.c_drivetrainLeftMotor2ID, MotorType.kBrushed);
  private CANSparkMax m_rightMotor1 = new CANSparkMax(DrivetrainConstants.c_drivetrainRightMotor1ID, MotorType.kBrushed);
  private CANSparkMax m_rightMotor2 = new CANSparkMax(DrivetrainConstants.c_drivetrainRightMotor2ID, MotorType.kBrushed);

  //MotorControllerGroup tanımlamaları, her taraf için bir tane.
  private MotorControllerGroup mcg_leftMotorControllerGroup = new MotorControllerGroup(m_leftMotor1, m_leftMotor2);
  private MotorControllerGroup mcg_rightMotorControllerGroup = new MotorControllerGroup(m_rightMotor1, m_rightMotor2);

  //DifferentialDrive tanımlamaları, robotun hareketi için.
  private DifferentialDrive dd_differentialDrive = new DifferentialDrive(mcg_leftMotorControllerGroup, mcg_rightMotorControllerGroup);

  public DrivetrainSubsystem(boolean leftMotor1Inverted, boolean leftMotor2Inverted, boolean rightMotor1Inverted, boolean rightMotor2Inverted) {
    //Constructordan alıyoruz bunları.
    this.b_leftMotor1Inverted = leftMotor1Inverted; this.b_leftMotor2Inverted = leftMotor2Inverted;
    this.b_rightMotor1Inverted = rightMotor1Inverted; this.b_rightMotor2Inverted = rightMotor2Inverted;
    
    //Sonra motorları buna göre invertliyoruz.
    m_leftMotor1.setInverted(b_leftMotor1Inverted); m_leftMotor2.setInverted(b_leftMotor2Inverted);
    m_rightMotor1.setInverted(b_rightMotor1Inverted); m_rightMotor2.setInverted(b_rightMotor2Inverted);
  }


  @Override
  public void periodic() {}

  /*Aşağıda MotorControllerGroupların hızını ayarlamak istersek diye iki metod yazdım. Biri sol için biri sağ için.
  Gerekli yerlerde kullanın veya yenilerini ekleyin.*/

  /*Sakatlıkları önlemek amacıyla her iki metodun da speed -1 den küçük veya +1 den büyük ise -1 veya 1'e atması gerekiyor.
  robotu yanlışlıkla patlatmayalım!*/
  public void setLeftMotorControllerSpeed(double speed){
    if(speed < -1){
      mcg_leftMotorControllerGroup.set(-1);
    }
    else if(speed > 1){
      mcg_leftMotorControllerGroup.set(1);
    }
    else{
      mcg_leftMotorControllerGroup.set(speed);
    }
  }

  //Burası Dahil.
  public void setRightMotorControllerSpeed(double speed){
    if(speed < -1){
      mcg_rightMotorControllerGroup.set(-1);
    }
    else if(speed > 1){
      mcg_rightMotorControllerGroup.set(1);
    }
    else{
      mcg_rightMotorControllerGroup.set(speed);
    }
  }

  /*Bu aşağıdaki fonksiyon normal arcade drive fonksiyonu için bir shell (Kabuk), herhangi bir özelliği yoktur.
  Komutlarda kullanım için yazılmıştır.
  Bu fonksiyonda herhangi bir limitlemeye gerek duymadım sonuçta DifferentialDrive classı gerekli düzenlemeleri yapıyor
  örn: deadband DifferentialDriveClassı tarafından hallediliyor ve controllerın 1 den büyük veya -1 den küçük değer vericeğini
  sanmıyorum.*/
  public void arcadeDrive(double speed, double turn){
    dd_differentialDrive.arcadeDrive(speed, turn);
  }

}
