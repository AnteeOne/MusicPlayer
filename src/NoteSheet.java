import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class NoteSheet {
    public ArrayList<Note> noteSheet;

    public NoteSheet(ArrayList<Note> noteSheet) {
        this.noteSheet = noteSheet;
    }

    public NoteSheet(Note[] arr) {
        this.noteSheet = (ArrayList<Note>) Arrays.asList(arr);
    }

    public NoteSheet(){
    }

    public NoteSheet(File file){
        this.noteSheet = new ArrayList<Note>();
        try(BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = in.readLine()) != null){
                String[] notes = line.split(" ");
                for (int i = 0; i < notes.length ; i++) {
                    String[] notestr = notes[i].split(";");
                    int[] note = getIntArr(notestr);
                    noteSheet.add(new Note(note[0],note[1],note[2]));
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return noteSheet.toString();
    }

    public ArrayList<Note> getNoteSheet() {
        return noteSheet;
    }

    public void setNoteSheet(ArrayList<Note> noteSheet) {
        this.noteSheet = noteSheet;
    }

    public static int[] getIntArr(String[] arr){
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length ; i++) {
            res[i] = Integer.parseInt(arr[i]);
        }
        return res;
    }

    public static NoteSheet makeNoteSheetFromIntArray(int[] arr,int volume,int duration){
        NoteSheet res = new NoteSheet();
        res.setNoteSheet(new ArrayList<Note>());
        for (int i = 0; i < arr.length; i++) {
            res.getNoteSheet().add(new Note(arr[i],volume,duration));
        }
        return res;
    }
}
