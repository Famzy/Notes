package projaro.com.schmg.proj.notes.models;

import android.os.Parcel;
import android.os.Parcelable;

/*
TODO: 26/06/2019
using Parcelables help to bundle data contents to be ues by intents
readmmore about Parclebles here https://developer.android.com/reference/android/os/Parcelable

*/

public class Note implements Parcelable {



    //Variable Decletaration
    private String title;
    private String content;
    private String timestamp;

    //Creating a constructor Note class with of the declared Variables as parameters
    public Note(String title, String content, String timestamp) {
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Note() {

    }

    protected Note(Parcel in) {
        title = in.readString();
        content = in.readString();
        timestamp = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    /**
     * Becaces are variables are all private access them we'd need to ues getters and setters
     * to eneable us have access to them
     *
     * weil alle variables sind privaten, dauf man nie sonderen mit ein bekommer und ein Setzen
     *
     * **/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    // print out each properties of the notes

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(content);
        parcel.writeString(timestamp);
    }
}

