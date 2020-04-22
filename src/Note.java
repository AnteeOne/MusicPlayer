import java.util.HashMap;

public class Note {

    private HashMap<Integer,String> notesDictionary;
    public int note;
    public int noteVolume;
    public int noteDuration;

    public Note(int note, int noteVolume, int noteDuration) {
        this.note = note;
        this.noteVolume = noteVolume;
        this.noteDuration = noteDuration;
    }

    @Override
    public String toString(){
        notesDictionary = new HashMap<Integer, String>();
        notesDictionary.put(0,"C");
        notesDictionary.put(1,"C#");
        notesDictionary.put(2,"D");
        notesDictionary.put(3,"D#");
        notesDictionary.put(4,"E");
        notesDictionary.put(5,"F");
        notesDictionary.put(6,"F#");
        notesDictionary.put(7,"G");
        notesDictionary.put(8,"G#");
        notesDictionary.put(9,"A");
        notesDictionary.put(10,"A#");
        notesDictionary.put(11,"B");

        if(this.note == -1){
            return "[pause:" + noteDuration + "ms]";
        }
        else{
            return "[" + notesDictionary.get(this.note % 12) + ";noteTon=" + this.note + ";volume=" + noteVolume +
                                                        ";duration="+ noteDuration + "]";
        }
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getNoteVolume() {
        return noteVolume;
    }

    public void setNoteVolume(int noteVolume) {
        this.noteVolume = noteVolume;
    }
}
