// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseTalon;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.fasterxml.jackson.databind.JsonSerializable.Base;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import pabeles.concurrency.ConcurrencyOps.Reset;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */

  BaseTalon leftFront, rightFront, leftBack, rightBack;

  AHRS gyro;

  public Drivetrain() {

    gyro = new AHRS();

    leftFront = new TalonFX(0);
    leftBack = new TalonFX(0);
    rightFront = new TalonFX(0);
    rightBack = new TalonFX(0);

    leftFront.configFactoryDefault();
    leftBack.configFactoryDefault();
    rightFront.configFactoryDefault();
    rightBack.configFactoryDefault();

    leftBack.follow(leftFront);
    rightBack.follow(rightFront); 

    resetGyro();
    resetDrivetrainEncoders();
  }

  /**
   * Create a manual PID loop for turning the drivetrain
   * @param degrees degrees that the robot needs to turn through in place
   */
  public void turn(double degrees) {}

  /**
   * Retrieves gyro angle in degrees
   * @return degrees rotation of gyroscope
   */
  public double getGyroAngle() {
    return 0;
  }

  /**
   * Resets gyroscope angle readings to 0
   */
  public void resetGyro() {}

  /**
   * Use the ControlMode PID loop to move the robot to the specified position
   * @param meters defines goal position in meters
   */
  public void toPosition(double meters) {}

  /**
   * Convert the distance in meters that the robot traveled to ticks of the drivetrain motors
   * @param meters distance in meters
   * @return distance in ticks
   */
  public double metersToTicks(double meters) {
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

  public void resetDrivetrainEncoders() {
    resetEncoder(leftFront);
    resetEncoder(leftBack);
    resetEncoder(rightFront);
    resetEncoder(rightBack);
  }

  public double leftDistance() {
    return getEncoderDistance(leftFront);
  }

  public double rightDistance() {
    return getEncoderDistance(rightFront);
  }

  public void straight(double speed) {
    runMotor(leftFront, speed);
    runMotor(rightFront, speed);
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
