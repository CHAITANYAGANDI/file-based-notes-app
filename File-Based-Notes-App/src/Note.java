public class Note {

    private String title;
    private String content;

    public Note(String title, String content){

        setContent(content);
        setTitle(title);
    }

    public void setTitle(String title){

        if(title!=null && !(title.trim().isEmpty())){

            this.title = title.trim();
        }

        else{

            System.out.println("title is null or empty");
        }
    }

    public void setContent(String content){

        if(content!=null && !(content.trim().isEmpty())){

            this.content = content.trim();
        }

        else{

            System.out.println("content is null or empty");
        }
    }

    public String getTitle(){

        return title;
    }

    public String getContent(){

        return content;
    }

    public void displayNoteInfo(){

        System.out.println("Note title: "+title);
        System.out.println("Note content: "+content);
    }
}
