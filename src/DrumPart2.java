import javax.sound.midi.MidiUnavailableException;
import java.io.File;

public class DrumPart2 implements Runnable{

    public void run() {
        Note note = new Note(-2,4,6);
        String testnoteScrap = "76 32";
        NoteSheet noteSheet = new NoteSheet(new File("src/Songs/TonyLgy_Astronomia/drumsheet2"));
        for (int i = 0; i < noteSheet.getNoteSheet().size() ; i++) {
            System.out.println(noteSheet.getNoteSheet().get(i).toString());
        }
        try {
            Player.playNoteSheet(noteSheet,1);
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }


    }

}
