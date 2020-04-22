import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class Player {

    public static void playNoteSheet(NoteSheet noteSheet,int musicalInstrument) throws MidiUnavailableException {
        try {
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            MidiChannel[] channels = synth.getChannels();
            channels[0].programChange(musicalInstrument);
            Thread.sleep(6);
            for (int i = 0; i < noteSheet.getNoteSheet().size() ; i++) {
                Note currentNote = noteSheet.getNoteSheet().get(i);
                if(currentNote.note == -1){
                    Thread.sleep(currentNote.noteVolume);
                }
                else{
                    channels[0].noteOn(currentNote.note, currentNote.noteVolume);
                    Thread.sleep(currentNote.noteDuration);
                    channels[0].noteOff(currentNote.note);
                }
            }
        }
        catch (MidiUnavailableException | InterruptedException e){
            throw new MidiUnavailableException("Problems with your sound card!");
        }

    }
}
