package com.jcmore2.shakephone.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.jcmore2.shakephone.ShakeListener;
import com.jcmore2.shakephone.ShakePhone;

/**
 * Sample activity created to show how to use ShakePhone library.
 * 
 * @author jcmore2@gmail.com
 */
public class MainActivity extends Activity {

	private Button startService;
	private Button stopService;

	private boolean finish = true;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initUI();
		initButtonListeners();
	}

	private void initUI() {
		startService = (Button) findViewById(R.id.bt_start_service);
		stopService = (Button) findViewById(R.id.bt_stop_service);
	}

	private void initButtonListeners() {
		startService.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(MainActivity.this, "Start Shake Service",
						Toast.LENGTH_SHORT).show();
				initializeShakeService();
			}
		});

		stopService.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(MainActivity.this, "Stop Shake Service",
						Toast.LENGTH_SHORT).show();
				stopShakeService();
			}
		});
	}

	private void initializeShakeService() {
		ShakePhone.initializeShakeService(this, new ShakeListener() {

			@Override
			public void onShake(float force) {
				showToast(force);
				if (finish)
					shakeButtons();

			}

			@Override
			public void onAccelerationChanged(float x, float y, float z) {

			}
		});
	}

	private void stopShakeService() {
		ShakePhone.stopShakeService(this);
	}

	private void showToast(float force) {
		Toast.makeText(this, "SHAKE Force = " + force, Toast.LENGTH_SHORT)
				.show();

	}

	private void shakeButtons() {

		Animation shake = AnimationUtils.loadAnimation(MainActivity.this,
				R.anim.shake);
		startService.startAnimation(shake);
		stopService.startAnimation(shake);

		shake.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				finish = false;
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				finish = true;
			}
		});

	}

	@Override
	protected void onPause() {
		stopShakeService();
		super.onPause();
	}

}
