package com.jcmore2.shakeit;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/**
 * Service use for start accelerometer in background
 * 
 * @author jcmore2@gmail.com
 * 
 */
public class ShakeService extends Service {

	private Context context = this;

	@Override
	public void onCreate() {
		super.onCreate();

	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		if (ShakeManager.isSupported(context)) {
			// Start Accelerometer Listening
			ShakeManager.startListening(ShakePhone.shakeListener,
					ShakePhone.threshold, ShakePhone.interval);
		}

		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onDestroy() {
		// Check device supported Accelerometer sensor or not
		if (ShakeManager.isListening()) {

			// Start Accelerometer Listening
			ShakeManager.stopListening();

		}
		super.onDestroy();
	}

}
