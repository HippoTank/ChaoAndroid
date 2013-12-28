package com.android.ChaoIsland;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OnStart extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onClickGalleryButton(View view)
    {
        startActivity(new Intent(this, Gallery.class));
    }
}
