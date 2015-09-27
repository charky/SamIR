package com.enterprise.charky.samir;

import android.app.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.enterprise.charky.samir.irtransmitter.GenericIRCodes;
import com.enterprise.charky.samir.irtransmitter.IRTransmitter;

public class MainActivity extends Activity {

    public IRTransmitter irTransmitter;
    private static final String TAG = "SamIR_MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Be sure to call the super class.
        super.onCreate(savedInstanceState);

        //Create IRTransmitter
        //irTransmitter = new IRTransmitter(this, new SamsungIRCodes());

        setContentView(R.layout.activity_main);
    }

    public void RemoteButtonClick(View v) {
        GenericIRCodes genericIRCodes = irTransmitter.getGenericIRCodes();
        try {
            switch (v.getId()) {
                case R.id.bt_1:
                    irTransmitter.sendIR(genericIRCodes.getIRC_1());
                    break;
                case R.id.bt_2:
                    irTransmitter.sendIR(genericIRCodes.getIRC_2());
                    break;
                case R.id.bt_3:
                    irTransmitter.sendIR(genericIRCodes.getIRC_3());
                    break;
                case R.id.bt_4:
                    irTransmitter.sendIR(genericIRCodes.getIRC_4());
                    break;
                case R.id.bt_5:
                    irTransmitter.sendIR(genericIRCodes.getIRC_5());
                    break;
                case R.id.bt_6:
                    irTransmitter.sendIR(genericIRCodes.getIRC_6());
                    break;
                case R.id.bt_7:
                    irTransmitter.sendIR(genericIRCodes.getIRC_7());
                    break;
                case R.id.bt_8:
                    irTransmitter.sendIR(genericIRCodes.getIRC_8());
                    break;
                case R.id.bt_9:
                    irTransmitter.sendIR(genericIRCodes.getIRC_9());
                    break;
                case R.id.bt_0:
                    irTransmitter.sendIR(genericIRCodes.getIRC_0());
                    break;
                //Volume and Channel Buttons
                case R.id.bt_VolUp:
                    irTransmitter.sendIR(genericIRCodes.getIRC_VOLUME_UP());
                    break;
                case R.id.bt_Mute:
                    irTransmitter.sendIR(genericIRCodes.getIRC_MUTE());
                    break;
                case R.id.bt_VolDown:
                    irTransmitter.sendIR(genericIRCodes.getIRC_VOLUME_DOWN());
                    break;
                case R.id.bt_ChUp:
                    irTransmitter.sendIR(genericIRCodes.getIRC_CHANNEL_UP());
                    break;
                case R.id.bt_Info:
                    irTransmitter.sendIR(genericIRCodes.getIRC_INFORMATION());
                    break;
                case R.id.bt_ChDown:
                    irTransmitter.sendIR(genericIRCodes.getIRC_CHANNEL_DOWN());
                    break;
                //Menu Navigation Buttons
                case R.id.bt_Up:
                    irTransmitter.sendIR(genericIRCodes.getIRC_ARROW_UP());
                    break;
                case R.id.bt_Left:
                    irTransmitter.sendIR(genericIRCodes.getIRC_ARROW_LEFT());
                    break;
                case R.id.bt_Enter:
                    irTransmitter.sendIR(genericIRCodes.getIRC_ENTER());
                    break;
                case R.id.bt_Right:
                    irTransmitter.sendIR(genericIRCodes.getIRC_ARROW_RIGHT());
                    break;
                case R.id.bt_Down:
                    irTransmitter.sendIR(genericIRCodes.getIRC_ARROW_DOWN());
                    break;
                case R.id.bt_Exit:
                    irTransmitter.sendIR(genericIRCodes.getIRC_EXIT());
                    break;
                //Elementary Buttons
                case R.id.bt_Power:
                    irTransmitter.sendIR(genericIRCodes.getIRC_POWER());
                    break;
                case R.id.bt_Menu:
                    irTransmitter.sendIR(genericIRCodes.getIRC_MENU());
                    break;
            }
        } catch (IRTransmitter.NoIREmitterException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
