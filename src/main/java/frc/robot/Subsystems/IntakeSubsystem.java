//IntakeSubsystem, çok da tırt değil
package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;
//Importlar

public class IntakeSubsystem extends SubsystemBase {

  //Constructor için tanımlama.
  private boolean b_intakeMotorInverted;

  /*Motor fırçasız ve motorun IDsi değişmesi gerekirse constants daki gerekli yere bakın*/
  private CANSparkMax m_intakeMotor = new CANSparkMax(IntakeConstants.c_intakeMotorID, MotorType.kBrushless);

  public IntakeSubsystem(boolean motorInverted) {
    this.b_intakeMotorInverted = motorInverted;
    m_intakeMotor.setInverted(b_intakeMotorInverted);
  }

  @Override
  public void periodic() {}

  //Motorları kontrol etmek için bir metod.
  public void setIntakeMotorSpeed(double speed){
    if(speed < -1){
      m_intakeMotor.set(-1);
    }
    else if(speed > 1){
      m_intakeMotor.set(1);
    }
    else{
      m_intakeMotor.set(speed);
    }
  }
}
