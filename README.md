ShakePhoneLib
=============

This library runs background service that is listening for shake movements in device.

<img src='./Sample.png' width='270' height='480' />

Usage
-----

Declare ShakePhone service in your AndroidManifest:

```xml

<service
		android:name=".ShakePhoneService"
		android:exported="false"
		android:label="@string/app_name"/>

```

To use ShakePhone library you can initialize ``ShakePhone`` using a Context instance and one ``ShakePhoneListener``:

```java

		ShakePhone.initializeShakeService(this, new ShakeListener() {

			@Override
			public void onShake(float force) {
					shakeButtons();

			}

			@Override
			public void onAccelerationChanged(float x, float y, float z) {

			}
		});

```

Or customizing threshold and interval data for shakes:

```java

		ShakePhone.initializeShakeService(this, 20, 600, new ShakeListener() {

			@Override
			public void onShake(float force) {
					shakeButtons();

			}

			@Override
			public void onAccelerationChanged(float x, float y, float z) {

			}
		});
```

You can stop the ShakePhone service like in this sample:

```java

ShakePhone.stopShakeService(context);

```

and Just Shake your phone!!

Credits & Contact
-----------------

ShakePhone was created by jcmore2@gmail.com


License
-------

ShakePhone is available under the Apache License, Version 2.0.
