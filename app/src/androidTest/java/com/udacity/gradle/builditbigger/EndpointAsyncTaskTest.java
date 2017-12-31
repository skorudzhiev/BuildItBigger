package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class EndpointAsyncTaskTest {

    final CountDownLatch signal = new CountDownLatch(1);

    @Test
    public void testAsync() throws Throwable {

        final EndpointsAsyncTask task = new EndpointsAsyncTask() {

            @Override
            protected String doInBackground(Void... voids) {
                return super.doInBackground(voids);
            }

            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                assertFalse(result.equals(""));
                signal.countDown();
            }
        };

        Runnable runTest =  new Runnable() {
            @Override
            public void run() {
                task.execute();
            }
        };

        runTest.run();

        signal.await(30, TimeUnit.SECONDS);
    }
}
