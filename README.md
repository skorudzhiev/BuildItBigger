# Joke Telling App
**Version 1.0 2017/12/22**

General purpose of this project was to customize the behavior of the Gradle build tool to allow 
automation of repetitive tasks. Particularly, factoring functionality into libraries and creating 
product flavors. App is created in four different modules: 

![alt text](https://github.com/skorudzhiev/BuildItBigger/blob/master/screen-shot-2017-10-31-at-3.54.32-pm.png)

1. A Java library that provides jokes
2. A Google Cloud Endpoints ([GCE](https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/77e9910911d5412e5efede5fa681ec105a0f02ad/HelloEndpoints#2-connecting-your-android-app-to-the-backend) ) project that serves those jokes
3. An Android Library containing an activity for displaying jokes
4. An Android app that fetches jokes from the GCE module and passes them to the Android Library for display

```Gradle
include ':app', ':backend', ':jokes', ':displaylibrary'
```

## General Usage Notes

```Gradle
defaultConfig {
  minSdkVersion 16
  targetSdkVersion 26
}
```
App retrieves jokes from Google Cloud Endpoints module and displays them via an Activity from the Android Library
* Upon installation user will get **Free** and **Paid** version of the app
* Free version includes: 
  * single activity with a button. On pressing the button joke is wrapped inside a dialog window
  * [AdMob](https://developers.google.com/admob/android/quick-start) for Android - Banner and an Interstitial Ad
* Paid version includes: 
  * single activity with a button. On pressing the button joke is wrapped inside a dialog window
  * contains no ads, and no unecessary dependencies


## Features

* The free app variant displays interstitial ads between the main activity and the joke-displaying activity
* The app displays a loading indicator while the joke is being fetched from the server
* Project contains connected tests to verify that the async task is indeed loading jokes
* Gradle task starts the GCE dev server, runs all the Android tests, and shuts down the dev server
