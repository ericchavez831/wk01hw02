package com.cst438.wk01hw02;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class IntentFactory {
    public static Intent getIntent(String className, Context context, Bundle bundle) {

        switch (className){
            case "LandingPageActivity":
                return LandingPageActivity.getIntent(context, bundle);
            default:
                return new Intent(context, MainActivity.class);
        }
    }
}
