import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class NoteTest {

    public static void menu(){

        System.out.println("1. Add Note");
        System.out.println("2. View All Notes");
        System.out.println("3. Search Note by Title");
        System.out.println("4. Delete Note");
        System.out.println("5. Save Notes to File");
        System.out.println("6. Load Notes from File");
        System.out.println("7. Exit");
    }

    public static void addNote(Scanner input, ArrayList<Note> notes){

        input.nextLine();

        System.out.println("Enter note title");
        String noteTitle = input.nextLine();
        System.out.println();
        System.out.println("Enter note content");
        String noteContent = input.nextLine();

        notes.add(new Note(noteTitle, noteContent));

        System.out.println("Note added succcessfully");
    }

    public static void addNote(String title,String content, ArrayList<Note> notes){

        notes.add(new Note(title, content));

        System.out.println("Note added succcessfully");
    }

    public static void viewNotes(ArrayList<Note> notes){

        if(notes.isEmpty()){
            System.out.println("notes not found");
        }
        else{

            for(Note note: notes){

                note.displayNoteInfo();;
            }
        }
    }

    public static Note searchNoteByTitle(String title, ArrayList<Note> notes){

        for(Note note:notes){

            if(note.getTitle().equalsIgnoreCase(title)){

                return note;
            }
        }

        return null;

    }


    public static void searchNoteByTitle(Scanner input, ArrayList<Note> notes){

        input.nextLine();

        System.out.println("Enter tite to search notes");
        String searchNotesTitle = input.nextLine();

        Note foundNote = searchNoteByTitle(searchNotesTitle, notes);

        if (foundNote != null) {
            foundNote.displayNoteInfo();
        } else {
            System.out.println("Note not found");
        }

    }



    public static void deleteNote(Scanner input, ArrayList<Note> notes){

        input.nextLine();

        if(notes.isEmpty()){

            System.out.println("notes not found");
        }

        else{

            System.out.println("Enter title to delete note");
            String noteToDelete = input.nextLine();

            Note foundNote = searchNoteByTitle(noteToDelete, notes);

            if (foundNote != null) {
                notes.remove(foundNote);
                System.out.println("Note deleted successfully");
            } else {
                System.out.println("Note not found");
            }

        }
    }

    public static void saveNotesToFile(ArrayList<Note> notes){

        try{

            FileWriter fw = new FileWriter("Note.txt");

            for(Note note:notes){

              fw.write(note.getTitle() + "|" + note.getContent() + "\n");

            }

            System.out.println("Note written successfully");
            
            fw.close();
        }
        catch(Exception e){

            System.out.println(e);
        }


    }

    public static void loadNotesFromFile(ArrayList<Note> notes){


        try{

            notes.clear();
            
            FileReader fr = new FileReader("Note.txt");

            BufferedReader br = new BufferedReader(fr);

           
            String line;

            while((line = br.readLine())!=null){
                
                String[] parts = line.split("\\|", 2);

                if (parts.length == 2) {
                    notes.add(new Note(parts[0], parts[1]));
                }
        
            }

          
            br.close();
            fr.close();
        }

        catch(Exception e){

            System.out.println(e);
        }


    }


    public static void main(String[] args){
        ArrayList<Note>  notes = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        while(true){
    
            menu();

            int userInput = input.nextInt();

            if(userInput == 1){

                addNote(input, notes);
            }

            else if(userInput == 2){

                viewNotes(notes);
            }

            else if(userInput == 3){

                searchNoteByTitle(input, notes);
            }

            else if(userInput == 4){

                deleteNote(input, notes);

            }

            else if(userInput == 5){

                saveNotesToFile(notes);
            }
            
            else if(userInput == 6){

                loadNotesFromFile(notes);
            }

            else if(userInput == 7){

                System.out.println("Exiting...");
                break;
            }

            else{

                System.out.println("Invalid choice");
            }
        }

        input.close();
    }
}
