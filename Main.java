import net.sharkfw.knowledgeBase.SharkKBException;
import net.sharkfw.knowledgeBase.filesystem.FSSharkKB;


public class Main {
    public static void main(String[] args) throws SharkKBException {
        FSSharkKB kb = new FSSharkKB("Dateipfad goes here");
        Importer importer = new Importer(kb);
        importer.getInformation();
    }
}