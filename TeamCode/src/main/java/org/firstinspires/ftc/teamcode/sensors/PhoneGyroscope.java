package org.firstinspires.ftc.teamcode.sensors;


import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.util.Log;

import com.qualcomm.robotcore.hardware.HardwareMap;


import static android.content.Context.SENSOR_SERVICE;

public class PhoneGyroscope implements SensorEventListener {
    public enum PhoneOrientation {
        VERTICAL,
        VERTICAL_REVERSE,
        FACE_UP,
        FACE_DOWN,
        HORIZONTAL_LEFT,
        HORIZONTAL_RIGHT
    }

    private SensorManager sensorManager;
    private float position;
    private float epsilon;

    private PhoneOrientation orientation;

    private static final float NS2S = 1.0f / 1000000000.0f;
    private final float[] deltaRotationVector = new float[4];
    private float timestamp;

    public PhoneGyroscope(PhoneOrientation starting_orientation) {
        super();
        orientation = starting_orientation;
    }

    public void start(HardwareMap map) {
        this.sensorManager = (SensorManager) map.appContext.getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);
        epsilon = sensor.getResolution();
        position = 0;
        timestamp = 0;
    }

    public void stop() {
        sensorManager.unregisterListener(this);
        sensorManager = null;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // This time step's delta rotation to be multiplied by the current rotation
        // after computing it from the gyro sample data.
        if (timestamp != 0) {
            final float dT = (event.timestamp - timestamp) * NS2S;
            // Axis of the rotation sample, not normalized yet.
            float axisX = event.values[0];
            float axisY = event.values[1];
            float axisZ = event.values[2];

            // Calculate the angular speed of the sample
            float omegaMagnitude = (float) Math.sqrt(axisX * axisX + axisY * axisY + axisZ * axisZ);

            // Normalize the rotation vector if it's big enough to get the axis
            if (omegaMagnitude > epsilon) {
                position += axisZ * dT;
            }
        }
        timestamp = event.timestamp;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public double getPosition() { return position; }
}