package com.cst438.wk01hw02;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import static org.junit.Assert.*;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

/**
 *
 * <h1><b>IntentInstrumentedTest</b></h1>
 * Creates an intent with the method created in LandingPageActivity
 * (getIntent) which uses the factory pattern method.
 *
 * @author Eric Chavez Velez
 */

@RunWith(AndroidJUnit4.class)
public class IntentInstrumentedTest {

    @Test
    public void testFactoryIntent(){
        Context appContext = getInstrumentation().getTargetContext();
        Bundle extra = new Bundle();
        extra.putString("username", "bret");
        extra.putString("userId", "1");
        Intent i = LandingPageActivity.getIntent(appContext, extra);
        assertEquals("1", i.getBundleExtra("SECOND_ACTIVITY_COM_ECHAVEZ").getString("userId"));
    }

}
