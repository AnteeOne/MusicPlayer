import javax.sound.midi.MidiUnavailableException;
import java.io.File;

public class MainPart implements Runnable{

    public void run() {
        NoteSheet noteSheet = new NoteSheet(new File("src/Songs/TonyLgy_Astronomia/notesheet"));
        for (int i = 0; i < noteSheet.getNoteSheet().size() ; i++) {
            System.out.println(noteSheet.getNoteSheet().get(i).toString());
        }
        try {
            Player.playNoteSheet(noteSheet,106);
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }


    }

}
