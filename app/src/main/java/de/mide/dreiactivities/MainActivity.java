package de.mide.dreiactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


/**
 * MainActivity kann zwei weitere Activities (Activity A & Activity B)
 * aufrufen und unterscheiden, welche davon beendet wurde.
 * <br/><br/>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    /** Button für "Sprung" zu Activity A. */
    protected Button _buttonFuerActivityA = null;

    /** Button für "Sprung" zu Activity B. */
    protected Button _buttonFuerActivityB = null;


    /**
     * Lifecycle-Methode. Lädt Layout-Datei, füllt Member-Variablen mit
     * Referenzen auf die Button-Objekte und registriert die Activity-Instanz
     * selbst als Event-Handler für die beiden Buttons.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _buttonFuerActivityA = findViewById(R.id.button_gehe_zu_activity_a);
        _buttonFuerActivityB = findViewById(R.id.button_gehe_zu_activity_b);

        _buttonFuerActivityA.setOnClickListener(this);
        _buttonFuerActivityB.setOnClickListener(this);
    }


    /**
     * Event-Handler-Methode für die beiden Buttons.
     *
     * @param view Referenz auf UI-Element (hier also Button-Objekt),
     *             welches das Event ausgelöst hat.
     */
    public void onClick(View view) {

        Intent intent = null;

        if (view == _buttonFuerActivityA) {

            intent = new Intent(this, ActivityA.class);
            //startActivity(intent);
            startActivityForResult(intent, 111);

        } else if (view == _buttonFuerActivityB) {

            intent = new Intent(this, ActivityB.class);
            //startActivity(intent);
            startActivityForResult(intent, 222);
        }
    }


    /**
     * Callback-Methode. Diese Methode wird aufgerufen, wenn eine der beiden Activities A oder B
     * beendet wurde, nachdem sie von dieser Klasse mit der Methode {@link #startActivityForResult(Intent, int)}
     * anstelle der Methode {@link #startActivity(Intent)} aufgerufen wurde.
     *
     * @param requestCode Code, der als zweites Argument beim Aufruf von {@link #startActivityForResult(Intent, int)}
     *                    übergeben wurde; sollte entweder <tt>111</tt> oder <tt>222</tt> sein.
     *
     * @param resultCode Wird nicht ausgewertet.
     *
     * @param intent Wird nicht ausgewertet.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {

        String toastText = "";

        switch (requestCode) {

            case 111:
                toastText = "Activity A ist beendet worden.";
            break;

            case 222:
                toastText = "Activity B ist beendet worden.";
            break;

            default:
                toastText = "Unerwartete Activity ist beendet worden.";
        }

        Toast brot = Toast.makeText(this, toastText, Toast.LENGTH_LONG);
        brot.show();
    }

}
