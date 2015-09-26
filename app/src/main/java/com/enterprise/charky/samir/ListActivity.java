package com.enterprise.charky.samir;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.enterprise.charky.samir.IRTransmitter.IRTransmitter;
import com.enterprise.charky.samir.TVIRCodes.SamNewIRCodesCompiled;




public class ListActivity extends Activity {

    private static final String TAG = "SamIR_ListActivity";

    private static final String[] values = new String[] {
            "bt_0","bt_1","bt_2","bt_3","bt_4","bt_5","bt_6","bt_7","bt_8","bt_9","bt_Arrow_Down","bt_Arrow_Left","bt_Arrow_Right","bt_Arrow_Up","bt_Blue","bt_Channel_Down","bt_Channel_List","bt_Channel_Up","bt_Closed_Caption","bt_Enter","bt_Exit","bt_Fav_Channel","bt_Foreward","bt_Green","bt_Information","bt_Media_Play","bt_Menu","bt_Guide","bt_MTS","bt_Mute","bt_Pause","bt_Picture_Mode","bt_Picture_Size","bt_Play","bt_Power","bt_Prev_Channel","bt_Record","bt_Red","bt_Return","bt_Reverse","bt_Sleep","bt_Source","bt_SRS","bt_Stop","bt_Tools","bt_TV","bt_Volume_Down","bt_Volume_Up","bt_Yellow","bt__Cable","bt__DVD","bt__STB","bt__TV","bt__VCR","bt_Aspect_169","bt_Aspect_43","bt_Aspect_Panorama","bt_Aspect_Zoom1","bt_Aspect_Zoom2","bt_AV1","bt_AV2","bt_Component1","bt_Component2","bt_HDMI1","bt_HDMI2","bt_HDMI3","bt_HDMI4","bt_P_Mode_Dynamic","bt_P_Mode_Movie1","bt_P_Mode_Movie2","bt_P_Mode_Standard","bt_PC","bt_Power_Off","bt_Power_On","bt_Sound_Mode","bt_Toggle_Active_Input"
};

    public IRTransmitter irTransmitter;
    public SamNewIRCodesCompiled samIRC;
    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //Create IRTransmitter
        samIRC =  new SamNewIRCodesCompiled();
        irTransmitter = new IRTransmitter(this, samIRC);
        listView = (ListView)findViewById(R.id.listView);




        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout
                .simple_list_item_single_choice, android.R.id.text1, values);

        // Assign adapter to ListView
        listView.setAdapter(adapter);
        listView.setItemChecked(0, true);

    }

    public void SendButtonClick(View v) {
 
        int tmp = listView.getCheckedItemPosition();
        
        if( 0 > tmp || tmp >= values.length){
            return;
        }

        String value = values[tmp];

        Log.d(TAG,"Sending IR for " + value);

        try {
            switch (value) {
                case "bt_0":
                    irTransmitter.sendIR(samIRC.getIRC0());
                    break;
                case "bt_1":
                    irTransmitter.sendIR(samIRC.getIRC1());
                    break;
                case "bt_2":
                    irTransmitter.sendIR(samIRC.getIRC2());
                    break;
                case "bt_3":
                    irTransmitter.sendIR(samIRC.getIRC3());
                    break;
                case "bt_4":
                    irTransmitter.sendIR(samIRC.getIRC4());
                    break;
                case "bt_5":
                    irTransmitter.sendIR(samIRC.getIRC5());
                    break;
                case "bt_6":
                    irTransmitter.sendIR(samIRC.getIRC6());
                    break;
                case "bt_7":
                    irTransmitter.sendIR(samIRC.getIRC7());
                    break;
                case "bt_8":
                    irTransmitter.sendIR(samIRC.getIRC8());
                    break;
                case "bt_9":
                    irTransmitter.sendIR(samIRC.getIRC9());
                    break;
                case "bt_Arrow_Down":
                    irTransmitter.sendIR(samIRC.getIRCArrow_Down());
                    break;
                case "bt_Arrow_Left":
                    irTransmitter.sendIR(samIRC.getIRCArrow_Left());
                    break;
                case "bt_Arrow_Right":
                    irTransmitter.sendIR(samIRC.getIRCArrow_Right());
                    break;
                case "bt_Arrow_Up":
                    irTransmitter.sendIR(samIRC.getIRCArrow_Up());
                    break;
                case "bt_Blue":
                    irTransmitter.sendIR(samIRC.getIRCBlue());
                    break;
                case "bt_Channel_Down":
                    irTransmitter.sendIR(samIRC.getIRCChannel_Down());
                    break;
                case "bt_Channel_List":
                    irTransmitter.sendIR(samIRC.getIRCChannel_List());
                    break;
                case "bt_Channel_Up":
                    irTransmitter.sendIR(samIRC.getIRCChannel_Up());
                    break;
                case "bt_Closed_Caption":
                    irTransmitter.sendIR(samIRC.getIRCClosed_Caption());
                    break;
                case "bt_Enter":
                    irTransmitter.sendIR(samIRC.getIRCEnter());
                    break;
                case "bt_Exit":
                    irTransmitter.sendIR(samIRC.getIRCExit());
                    break;
                case "bt_Fav_Channel":
                    irTransmitter.sendIR(samIRC.getIRCFav_Channel());
                    break;
                case "bt_Foreward":
                    irTransmitter.sendIR(samIRC.getIRCForeward());
                    break;
                case "bt_Green":
                    irTransmitter.sendIR(samIRC.getIRCGreen());
                    break;
                case "bt_Information":
                    irTransmitter.sendIR(samIRC.getIRCInformation());
                    break;
                case "bt_Media_Play":
                    irTransmitter.sendIR(samIRC.getIRCMedia_Play());
                    break;
                case "bt_Menu":
                    irTransmitter.sendIR(samIRC.getIRCMenu());
                    break;
                case "bt_Guide":
                    irTransmitter.sendIR(samIRC.getIRCGuide());
                    break;
                case "bt_MTS":
                    irTransmitter.sendIR(samIRC.getIRCMTS());
                    break;
                case "bt_Mute":
                    irTransmitter.sendIR(samIRC.getIRCMute());
                    break;
                case "bt_Pause":
                    irTransmitter.sendIR(samIRC.getIRCPause());
                    break;
                case "bt_Picture_Mode":
                    irTransmitter.sendIR(samIRC.getIRCPicture_Mode());
                    break;
                case "bt_Picture_Size":
                    irTransmitter.sendIR(samIRC.getIRCPicture_Size());
                    break;
                case "bt_Play":
                    irTransmitter.sendIR(samIRC.getIRCPlay());
                    break;
                case "bt_Power":
                    irTransmitter.sendIR(samIRC.getIRCPower());
                    break;
                case "bt_Prev_Channel":
                    irTransmitter.sendIR(samIRC.getIRCPrev_Channel());
                    break;
                case "bt_Record":
                    irTransmitter.sendIR(samIRC.getIRCRecord());
                    break;
                case "bt_Red":
                    irTransmitter.sendIR(samIRC.getIRCRed());
                    break;
                case "bt_Return":
                    irTransmitter.sendIR(samIRC.getIRCReturn());
                    break;
                case "bt_Reverse":
                    irTransmitter.sendIR(samIRC.getIRCReverse());
                    break;
                case "bt_Sleep":
                    irTransmitter.sendIR(samIRC.getIRCSleep());
                    break;
                case "bt_Source":
                    irTransmitter.sendIR(samIRC.getIRCSource());
                    break;
                case "bt_SRS":
                    irTransmitter.sendIR(samIRC.getIRCSRS());
                    break;
                case "bt_Stop":
                    irTransmitter.sendIR(samIRC.getIRCStop());
                    break;
                case "bt_Tools":
                    irTransmitter.sendIR(samIRC.getIRCTools());
                    break;
                case "bt_TV":
                    irTransmitter.sendIR(samIRC.getIRCTV());
                    break;
                case "bt_Volume_Down":
                    irTransmitter.sendIR(samIRC.getIRCVolume_Down());
                    break;
                case "bt_Volume_Up":
                    irTransmitter.sendIR(samIRC.getIRCVolume_Up());
                    break;
                case "bt_Yellow":
                    irTransmitter.sendIR(samIRC.getIRCYellow());
                    break;
                case "bt__Cable":
                    irTransmitter.sendIR(samIRC.getIRC_Cable());
                    break;
                case "bt__DVD":
                    irTransmitter.sendIR(samIRC.getIRC_DVD());
                    break;
                case "bt__STB":
                    irTransmitter.sendIR(samIRC.getIRC_STB());
                    break;
                case "bt__TV":
                    irTransmitter.sendIR(samIRC.getIRC_TV());
                    break;
                case "bt__VCR":
                    irTransmitter.sendIR(samIRC.getIRC_VCR());
                    break;
                case "bt_Aspect_169":
                    irTransmitter.sendIR(samIRC.getIRCAspect_169());
                    break;
                case "bt_Aspect_43":
                    irTransmitter.sendIR(samIRC.getIRCAspect_43());
                    break;
                case "bt_Aspect_Panorama":
                    irTransmitter.sendIR(samIRC.getIRCAspect_Panorama());
                    break;
                case "bt_Aspect_Zoom1":
                    irTransmitter.sendIR(samIRC.getIRCAspect_Zoom1());
                    break;
                case "bt_Aspect_Zoom2":
                    irTransmitter.sendIR(samIRC.getIRCAspect_Zoom2());
                    break;
                case "bt_AV1":
                    irTransmitter.sendIR(samIRC.getIRCAV1());
                    break;
                case "bt_AV2":
                    irTransmitter.sendIR(samIRC.getIRCAV2());
                    break;
                case "bt_Component1":
                    irTransmitter.sendIR(samIRC.getIRCComponent1());
                    break;
                case "bt_Component2":
                    irTransmitter.sendIR(samIRC.getIRCComponent2());
                    break;
                case "bt_HDMI1":
                    irTransmitter.sendIR(samIRC.getIRCHDMI1());
                    break;
                case "bt_HDMI2":
                    irTransmitter.sendIR(samIRC.getIRCHDMI2());
                    break;
                case "bt_HDMI3":
                    irTransmitter.sendIR(samIRC.getIRCHDMI3());
                    break;
                case "bt_HDMI4":
                    irTransmitter.sendIR(samIRC.getIRCHDMI4());
                    break;
                case "bt_P_Mode_Dynamic":
                    irTransmitter.sendIR(samIRC.getIRCP_Mode_Dynamic());
                    break;
                case "bt_P_Mode_Movie1":
                    irTransmitter.sendIR(samIRC.getIRCP_Mode_Movie1());
                    break;
                case "bt_P_Mode_Movie2":
                    irTransmitter.sendIR(samIRC.getIRCP_Mode_Movie2());
                    break;
                case "bt_P_Mode_Standard":
                    irTransmitter.sendIR(samIRC.getIRCP_Mode_Standard());
                    break;
                case "bt_PC":
                    irTransmitter.sendIR(samIRC.getIRCPC());
                    break;
                case "bt_Power_Off":
                    irTransmitter.sendIR(samIRC.getIRCPower_Off());
                    break;
                case "bt_Power_On":
                    irTransmitter.sendIR(samIRC.getIRCPower_On());
                    break;
                case "bt_Sound_Mode":
                    irTransmitter.sendIR(samIRC.getIRCSound_Mode());
                    break;
                case "bt_Toggle_Active_Input":
                    irTransmitter.sendIR(samIRC.getIRCToggle_Active_Input());
                    break;
            }
        } catch (IRTransmitter.NoIREmitterException e) {
            e.printStackTrace();
        }
    }

}
