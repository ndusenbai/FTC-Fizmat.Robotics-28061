package org.firstinspires.ftc.robotcontroller;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "tutorial")
public class tutorial extends OpMode {

    DcMotor leftMotor;
    DcMotor rightMotor;

    @Override
    public void init() {
        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");

        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.FORWARD);

        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        telemetry.addData("init", "completed");
        telemetry.update();
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            leftMotor.setPower(0.5);
            telemetry.addData("motor", "forward");
        } else if (gamepad1.b) {
            leftMotor.setPower(-0.5);
            telemetry.addData("motor", "backward");
        } else {
            leftMotor.setPower(0);
            telemetry.addData("motor", "stopped");
        }

        telemetry.update();
    }
}
