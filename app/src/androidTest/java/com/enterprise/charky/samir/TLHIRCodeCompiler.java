package com.enterprise.charky.samir;

import com.enterprise.charky.samir.IRTransmitter.IRCode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by charky on 05.09.15.
 */
public class TLHIRCodeCompiler {
    public static void main(String[] args) {
        boolean classMode = true;

        try {
            String class_path = System.getProperty("user.dir");

            class_path += "/app/src/main/java/com/enterprise/charky/samir/IRTransmitter";

            File file = new File(class_path + File.separator + "SamsungCompiledIRCodes.java");

            System.out.format("Output-File-Path: %s%n",file.getAbsolutePath());
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            //Create Class Header
            bw.write("package com.enterprise.charky.samir.IRTransmitter;\n\n");
            bw.write("import com.enterprise.charky.samir.IRTransmitter.GenericTVManFactCodes;\n");
            bw.write("import com.enterprise.charky.samir.IRTransmitter.IRCommand;\n\n");
            bw.write("public class SamsungCompiledIRCodes"
                    + ((classMode)?" extends GenericTVManFactCodes":"") + "{\n\n");

            //Write Body
            Class<?> c = Class.forName("com.enterprise.charky.samir.IRTransmitter.SamsungIRCodes");
            int searchMods = Modifier.FINAL;
            Field[] flds = c.getDeclaredFields();
            System.out.format("Fields in Class '%s' containing modifiers:  %s%n",
                    c.getName(),
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
                String fName = f.getName();
                String subName = f.getName().substring(3);
                bw.write("\tpublic static final int "
                        + fName + "_frequency = "
                        + irCode.getFrequency() +";\n");
                bw.write("\tpublic static final int[] "
                        + fName + "_codes = new int[] "
                        + irCode.getCodesAsString() +";\n");
                if(classMode){
                    bw.write("\tpublic IRCommand getIRC" + subName + "() {\n"
                            + "\t\treturn IRCommand.createIRCommand(\n"
                            + "\t\t\tSamsungCompiledIRCodes." + fName + "_frequency,\n"
                            + "\t\t\tSamsungCompiledIRCodes." + fName + "_codes);}\n");
                }

            }

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
