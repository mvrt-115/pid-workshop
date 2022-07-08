// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.BaseTalon;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */

  public BaseTalon intakeMotor, pivotMotor;

  public Intake() {
    intakeMotor = new TalonSRX(21);
    pivotMotor = new TalonSRX(10);

    intakeMotor.configFactoryDefault();
    pivotMotor.configFactoryDefault();

    intakeMotor.setInverted(false);
    pivotMotor.setInverted(false); //check

    pivotMotor.setNeutralMode(NeutralMode.Brake);

    resetIntake();
  }

  /**
   * Create a manual PID loop for lifting up the pivot to the desired angle
   * @param degrees degrees that the intake arm needs to turn through
   */
  public void pivotUp(double degrees) {}

  /**
   * Create a conversion method for going from degrees of the intake arm to ticks of the intake motor
   * @param degrees turn amount in degrees
   * @return turn amount ticks
   */
  public double degreesToTicks(double degrees) {
    return 0;
  }

  /**
   * Create a method to retrieve the value for a motor's encoder
   * @param motor specified motor's encoder that needs to be checked
   * @return distance in ticks that the motor rotated through
   */
  public double getEncoderDistance(BaseTalon motor) {
    return 0;
  }

  /**
   * Create a method to reset a motor's encoder
   * @param motor motor whose encoder needs to be reset
   */
  public void resetEncoder(BaseTalon motor) {}

  public void resetIntake() {
    resetEncoder(intakeMotor);
  }

  public double intakeTurn() {
    return getEncoderDistance(intakeMotor);
  }

  public void runIntake() {
    pivotMotor.setNeutralMode(NeutralMode.Coast);
    runMotor(intakeMotor, 0.5);
  }

  public void stopIntake() {
    stop(intakeMotor);
    pivotMotor.setNeutralMode(NeutralMode.Brake);
  }

  public void runPivot(double speed) {
    runMotor(pivotMotor, speed);
  }

  public void stopPivot() {
    stop(intakeMotor);
  }

  public void runMotor(BaseTalon motor, double speed) {
    motor.set(ControlMode.PercentOutput, speed);
  }

  public void stop(BaseTalon motor) {
    runMotor(motor, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
