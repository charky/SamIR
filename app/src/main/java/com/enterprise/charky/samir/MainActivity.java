package com.enterprise.charky.samir;

import android.app.Activity;
import android.content.Context;
import android.hardware.ConsumerIrManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.enterprise.charky.samir.IRTransmitter.GenericTVManFactCodes;
import com.enterprise.charky.samir.IRTransmitter.IRTransmitter;
import com.enterprise.charky.samir.IRTransmitter.SamsungCompiledIRCodes;

public class MainActivity extends Activity {

    public IRTransmitter irTransmitter;
    private static final String TAG = "SamIR_MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Be sure to call the super class.
        super.onCreate(savedInstanceState);

        //Create IRTransmitter
        irTransmitter = new IRTransmitter(this, new SamsungCompiledIRCodes());

        setContentView(R.layout.activity_main);
    }

    public void RemoteButtonClick(View v) {
        GenericTVManFactCodes tvManFactCodes = irTransmitter.getTvManFactCodes();
        try {
            switch (v.getId()) {
                case R.id.bt_1:
                    irTransmitter.sendIR(tvManFactCodes.getIRC1());
                    break;
                case R.id.bt_2:
                    irTransmitter.sendIR(tvManFactCodes.getIRC2());
                    break;
                case R.id.bt_3:
                    irTransmitter.sendIR(tvManFactCodes.getIRC3());
                    break;
                case R.id.bt_4:
                    irTransmitter.sendIR(tvManFactCodes.getIRC4());
                    break;
                case R.id.bt_5:
                    irTransmitter.sendIR(tvManFactCodes.getIRC5());
                    break;
                case R.id.bt_6:
                    irTransmitter.sendIR(tvManFactCodes.getIRC6());
                    break;
                case R.id.bt_7:
                    irTransmitter.sendIR(tvManFactCodes.getIRC7());
                    break;
                case R.id.bt_8:
                    irTransmitter.sendIR(tvManFactCodes.getIRC8());
                    break;
                case R.id.bt_9:
                    irTransmitter.sendIR(tvManFactCodes.getIRC9());
                    break;
                case R.id.bt_0:
                    irTransmitter.sendIR(tvManFactCodes.getIRC0());
                    break;
                //Volume and Channel Buttons
                case R.id.bt_VolUp:
                    irTransmitter.sendIR(tvManFactCodes.getIRCVolUp());
                    break;
                case R.id.bt_Mute:
                    irTransmitter.sendIR(tvManFactCodes.getIRCMute());
                    break;
                case R.id.bt_VolDown:
                    irTransmitter.sendIR(tvManFactCodes.getIRCDown());
                    break;
                case R.id.bt_ChUp:
                    irTransmitter.sendIR(tvManFactCodes.getIRCChUp());
                    break;
                case R.id.bt_Info:
                    irTransmitter.sendIR(tvManFactCodes.getIRCInfo());
                    break;
                case R.id.bt_ChDown:
                    irTransmitter.sendIR(tvManFactCodes.getIRCChDown());
                    break;
                //Menu Navigation Buttons
                case R.id.bt_Up:
                    irTransmitter.sendIR(tvManFactCodes.getIRCUp());
                    break;
                case R.id.bt_Left:
                    irTransmitter.sendIR(tvManFactCodes.getIRCLeft());
                    break;
                case R.id.bt_Enter:
                    irTransmitter.sendIR(tvManFactCodes.getIRCEnter());
                    break;
                case R.id.bt_Right:
                    irTransmitter.sendIR(tvManFactCodes.getIRCRight());
                    break;
                case R.id.bt_Down:
                    irTransmitter.sendIR(tvManFactCodes.getIRCDown());
                    break;
                case R.id.bt_Exit:
                    irTransmitter.sendIR(tvManFactCodes.getIRCExit());
                    break;
                //Elementary Buttons
                case R.id.bt_Power:
                    irTransmitter.sendIR(tvManFactCodes.getIRCPower());
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
