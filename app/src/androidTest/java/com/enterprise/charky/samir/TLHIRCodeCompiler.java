package com.enterprise.charky.samir;

import com.enterprise.charky.samir.irtransmitter.IRCode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by charky on 05.09.15.
 */
public class TLHIRCodeCompiler {

    public static Set<String> basicIRCodesSet = new HashSet<String>();

    private static final String[] BASIC_IRCODES = new String[] { "BT_POWER","BT_0","BT_1","BT_2",
            "BT_3","BT_4","BT_5","BT_6","BT_7","BT_8","BT_9","BT_CHANNEL_UP","BT_CHANNEL_DOWN","BT_VOLUME_UP","BT_VOLUME_DOWN","BT_MUTE","BT_ENTER","BT_MENU","BT_EXIT","BT_ARROW_UP","BT_ARROW_DOWN","BT_ARROW_LEFT",
            "BT_ARROW_RIGHT","BT_GUIDE","BT_INFORMATION"};

    public static void main(String[] args) {
        basicIRCodesSet.addAll(Arrays.asList(BASIC_IRCODES));
        convertRawCode("SamsungIRCodes");
        //convertRawCode("PanasonicIRCodes");
        //convertRawCode("SkyIRCodes");
    }

    public static void convertRawCode(String className){
        try {
            String class_path = System.getProperty("user.dir");

            //Settings
            String rawLabel = "RAW";
            String compiledLabel = "";

            class_path += "/app/src/main/java/com/enterprise/charky/samir/irclibrary";

            File file = new File(class_path + File.separator + className + compiledLabel + ".java");

            System.out.format("Output-File-Path: %s%n",file.getAbsolutePath());
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            //Create Class Header
            bw.write("package com.enterprise.charky.samir.irclibrary;\n\n");
            bw.write("import com.enterprise.charky.samir.irtransmitter.GenericIRCodes;\n");
            bw.write("import com.enterprise.charky.samir.irtransmitter.IRCommand;\n\n");
            bw.write("public class " + className + compiledLabel
                    + " extends GenericIRCodes" + "{\n\n");

            //Collect all IRCodes
            ArrayList<String> nonBasicIRCodes = new ArrayList<String>();
            //Write Body
            Class<?> c = Class.forName("com.enterprise.charky.samir.irclibraryraw." + className + rawLabel);
            int searchMods = Modifier.FINAL;
            Field[] flds = c.getDeclaredFields();
            System.out.format("Fields in Class '%s' containing %d modifiers of %s%n",
                    c.getName(),
                    flds.length,
                    Modifier.toString(searchMods));
            for (Field f : flds) {
                int foundMods = f.getModifiers();

                // Skip wrong Modifiers
                if ((foundMods & searchMods) != searchMods) {
                    continue;
                }

                // Require all of the requested modifiers to be present
                String strValue = (String) f.get(new Object());
                IRCode irCode = new IRCode(strValue);
                String fName = f.getName().toUpperCase();
                String subName = fName.substring(3);

                //Write function
                bw.write("\tpublic static final int "
                        + fName + "_frequency = "
                        + irCode.getFrequency() +";\n");
                bw.write("\tpublic static final int[] "
                        + fName + "_codes = new int[] "
                        + irCode.getCodesAsString() +";\n");

                bw.write("\tpublic IRCommand getIRC_" + subName + "() {"
                        + " return IRCommand.createIRCommand("
                        + fName + "_frequency," + fName + "_codes); }\n");

                //Collect no basic IRCodes
                if(!basicIRCodesSet.contains(fName)) {
                    nonBasicIRCodes.add(fName);
                }


            }

            //Create CustomIRCodes-Method
            bw.write("\tpublic IRCommand getCustomCommand(String irCommandName){\n");
            String CustomCommandNames = "";
            boolean firstRun = true;
            if(!nonBasicIRCodes.isEmpty()) {
                bw.write("\t\tswitch(irCommandName) {\n");
                //Create irCodeName-Array
                for (String irCodeFunc : nonBasicIRCodes) {
                    if(firstRun){
                       firstRun = false;
                    }else{
                        CustomCommandNames += ", ";
                    }
                    String subName = irCodeFunc.substring(3);
                    bw.write("\t\t\tcase \"" + irCodeFunc +"\":\n"
                            + "\t\t\t\treturn getIRC_" + subName + "();\n");
                    CustomCommandNames += "\"" + irCodeFunc + "\"";
                }
                bw.write("\t\t}\n");
            }
            bw.write("\t\treturn null;\n\t}\n");
            //Create CustomIRCodesArray
            bw.write("\tpublic static final String[] CUSTOMCOMMANDSNAMES = new String[]{"
                    + CustomCommandNames + "};\n");
            bw.write("\tpublic String[] getCustomCommandNames(){\n");
            bw.write("\t\treturn CUSTOMCOMMANDSNAMES;\n\t}\n");

            //Create Class Footer
            bw.write("\n");
            bw.write("}\n");

            //Close and Exit
            bw.close();
            System.out.println("Finish!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
