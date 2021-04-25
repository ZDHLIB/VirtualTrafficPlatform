package utils;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;

public class XMLUtils {
    public static String WriteXML(String filePath, Document doc) {
        OutputFormat format = OutputFormat.createPrettyPrint();
        try(FileWriter fileWriter = new FileWriter(filePath)){
            XMLWriter writer = new XMLWriter(fileWriter, format);
            writer.write(doc);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }
}
