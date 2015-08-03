package com.jcmore2.shakeit;

import android.content.Context;
import android.content.Intent;

/**
 * Main library class. This class has to be used to initialize or stop the
 * accelerometer service.
 * 
 * @author jcmore2@gmail.com
 */
public class ShakePhone {

	static ShakeListener shakeListener;
	static int threshold = 25;
	static int interval = 600;

	/**
	 * Starts the service and store the listener to be notified when a new shake
	 * is generated in phone
	 * 
	 * @param context
	 *            used to start the service
	 * @param shakeListener
	 *            to notify when phone is shaked
	 */
	public static void initializeShakeService(Context context,
			ShakeListener shakeListener) {
		initializeShakeService(context, threshold, interval, shakeListener);
	}

	/**
	 * 
	 * @param context
	 *            used to start the service
	 * @param threshold
	 *            use to configure threshold
	 * @param interval
	 *            use to configure interval
	 * @param shakeListener
	 *            to notify when phone is shaked
	 */
	public static void initializeShakeService(Context context, int threshold,
			int interval, ShakeListener shakeListener) {
		ShakePhone.threshold = threshold;
		ShakePhone.interval = interval;
		ShakePhone.shakeListener = shakeListener;
		Intent intent = new Intent(context, ShakeService.class);
		context.startService(intent);
	}

	/**
	 * Stops the service and remove the AccelerometerListener added when the
	 * ShakePhone was initialized
	 * 
	 * @param context
	 *            used to stop the service
	 */
	public static void stopShakeService(Context context) {
		ShakePhone.shakeListener = null;
		Intent intent = new Intent(context, ShakeService.class);
		context.stopService(intent);
	}

}
