package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.ClimberConstants;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class ClimberSubsystem extends SubsystemBase {

     /*Motorların inverted olup olmadıkları ile ilgili bilgiyi taşıyan boolean değerleri*/
    private boolean b_climberMotor1Inverted, b_climberMotor2Inverted;
    
    /*Gerekli Motorları Tanımlıyoruz bunlar neo o yüzden fırçasız olacaklar*/
    private CANSparkMax m_climberMotor1 = new CANSparkMax(ClimberConstants.c_climberMotor1ID, MotorType.kBrushless);
    private CANSparkMax m_climberMotor2 = new CANSparkMax(ClimberConstants.c_climberMotor2ID, MotorType.kBrushless);

    /*Gerekli MotorControllerGroupları Tanımlıyoruz.*/
    private MotorControllerGroup mcg_climberMotorControllerGroup = new MotorControllerGroup(m_climberMotor1, m_climberMotor2);

    public ClimberSubsystem(boolean climberMotor1Inverted, boolean climberMotor2Inverted) {
        //Constructordan Bunları Alıyoruz
        this.b_climberMotor1Inverted = climberMotor1Inverted; this.b_climberMotor2Inverted = climberMotor2Inverted;

        //Sonra motorları buna göre Invertliyoruz
        m_climberMotor1.setInverted(b_climberMotor1Inverted); m_climberMotor2.setInverted(b_climberMotor2Inverted);
    }

    public void setClimberMotorControllerGroupSpeed(double speed){
        if(speed < -1){
          mcg_climberMotorControllerGroup.set(-1);
        }
        else if(speed > 1){
          mcg_climberMotorControllerGroup.set(1);
        }
        else{
          mcg_climberMotorControllerGroup.set(speed);
        }
  }
    
}
