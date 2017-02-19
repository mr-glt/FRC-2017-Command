package org.usfirst.frc.team6027.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team6027.robot.GripPipeline;
import org.usfirst.frc.team6027.robot.RobotMap;

public class Vision extends Subsystem {
    private double centerX = 0.0;
    private VisionThread visionThread;
    private final Object imgLock = new Object();
    UsbCamera camera;
    boolean isOne = true;
    public Vision() {
        super();
    }
    @Override
    protected void initDefaultCommand() {

    }
    public void setUpCamera(){
        CameraServer.getInstance().startAutomaticCapture();
        camera = CameraServer.getInstance().startAutomaticCapture();
        camera.setResolution(RobotMap.IMG_WIDTH, RobotMap.IMG_HEIGHT);
        //camera.setExposureManual(RobotMap.exposure);
        visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
            if (!pipeline.filterContoursOutput().isEmpty()) {
                Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
                synchronized (imgLock) {
                    centerX = r.x + (r.width / 2);
                }
            }
        });
    }
    public void startProcessing(){
        visionThread.start();
    }
    public double getTurn(){
        double centerX;
        synchronized (imgLock) {
            centerX = this.centerX;
        }
        return (centerX - (RobotMap.IMG_WIDTH / 2))*(RobotMap.FOV/RobotMap.IMG_WIDTH);
    }
    public void setAnalyzeExposure(){
        camera.setExposureManual(RobotMap.exposure);
    }
    public void setRegularExposure(){
        camera.setExposureManual(RobotMap.regularExposure);
    }

}
