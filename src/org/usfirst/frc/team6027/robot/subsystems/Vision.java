package org.usfirst.frc.team6027.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.VisionThread;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team6027.robot.GripPipeline;
import org.usfirst.frc.team6027.robot.RobotMap;

/**
 * A subsystem to control cameras and vision processing.
 */
public class Vision extends Subsystem {
    private double centerX = 0.0;
    private VisionThread visionThread;
    private final Object imgLock = new Object();
    private UsbCamera camera;
    boolean isOne = true;
    public Vision() {
        super();
    }

    /**
     * No default command
     */
    @Override
    protected void initDefaultCommand() {

    }

    /**
     * A method to start the camera and create a vision processing thread.
     */
    public void setUpCamera(){
        CameraServer.getInstance().startAutomaticCapture();
        camera = CameraServer.getInstance().startAutomaticCapture();
        //camera.setResolution(RobotMap.IMG_WIDTH, RobotMap.IMG_HEIGHT);
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

    /**
     * A method to start the vision processing thread.
     */
    public void startProcessing(){
        visionThread.start();
    }

    /**
     *
     * @return about the front of the robot is off target in degrees.
     */
    public double getTurn(){
        double centerX;
        synchronized (imgLock) {
            centerX = this.centerX;
        }
        return (centerX - (RobotMap.IMG_WIDTH / 2))*(RobotMap.FOV/RobotMap.IMG_WIDTH);
    }

    /**
     * A method to set the exposure of the camera to a suitable level for vision processing.
     */
    public void setAnalyzeExposure(){
        camera.setExposureManual(RobotMap.exposure);
    }

    /**
     * A method to set the exposure of the camera to a regular level.
     */
    public void setRegularExposure(){
        camera.setExposureManual(RobotMap.regularExposure);
    }

}
