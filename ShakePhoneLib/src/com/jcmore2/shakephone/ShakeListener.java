package com.jcmore2.shakephone;

/**
 * 
 * Listener class use for accelerometer events
 * 
 * @author jcmore2@gmail.com
 * 
 */
public interface ShakeListener {

	public void onAccelerationChanged(float x, float y, float z);

	public void onShake(float force);

}
