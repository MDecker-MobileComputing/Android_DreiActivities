package de.mide.dreiactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


/**
 * Eine der beiden Activities, die von der MainActivity
 * aufgerufen werden kann.
 * <br/>
 * Wenn diese Activity über einen Intent mit der Methode
 * {@link Activity#startActivityForResult(Intent, int)} aufgerufen
 * wird, dann ist als <i>requestCode</i> die Zahl <i>222</i> zu
 * verwenden.
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class ActivityB extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    }
    
}
