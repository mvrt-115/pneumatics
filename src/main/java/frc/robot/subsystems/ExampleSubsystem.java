// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {

  private Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
//  private Solenoid exampleSolenoidPCM = new Solenoid(PneumaticsModuleType.CTREPCM, 2);

  DoubleSolenoid exampleDoublePCM = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 0);
  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {
    pcmCompressor.enableDigital();
   
    pcmCompressor.disable();
    exampleDoublePCM.set(Value.kOff);
   // pcmCompressor.close();
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
          pcmCompressor.enableDigital();
          
          exampleDoublePCM.set(Value.kForward);
       //   pcmCompressor.disable();
       //   exampleDoublePCM.set(Value.kOff);
       //   pcmCompressor.close();
        });
  }

  public CommandBase reverse() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
          pcmCompressor.enableDigital();
          
          exampleDoublePCM.set(Value.kReverse);
       //   pcmCompressor.disable();
       //   exampleDoublePCM.set(Value.kOff);
       //   pcmCompressor.close();
        });
  }

  /**
   * An example
   *  method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
