package org.usfirst.frc.team6027.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team6027.robot.GripPipeline;

public class Vision extends Subsystem {

    private static final int IMG_WIDTH = 320;
    private static final int IMG_HEIGHT = 240;
    private static final double FOV = 66;
    private double centerX = 0.0;
    private VisionThread visionThread;
    private final Object imgLock = new Object();
    UsbCamera camera;
    public Vision() {
        super();
    }
    @Override
    protected void initDefaultCommand() {

    }
    public void setUpCamera(){
        CameraServer.getInstance().startAutomaticCapture();
        camera = CameraServer.getInstance().startAutomaticCapture();
        camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
        camera.setExposureManual(5);
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
        return (centerX - (IMG_WIDTH / 2))*(FOV/IMG_WIDTH);
    }

}
