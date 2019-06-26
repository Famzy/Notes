package projaro.com.schmg.proj.notes;

import android.print.PrinterId;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import projaro.com.schmg.proj.notes.models.Note;

public class NoteActivity extends AppCompatActivity {
    private static final String TAG = "NoteActivity";

    //UI Components

    private LinedEditText mLinedEditText;
    private EditText mEditTitle;
    private TextView mViewTitle;


    // VARIABLES SECTON
    private boolean mIsNewNote;
    private Note initialNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        mLinedEditText = findViewById(R.id.note_text);
        mEditTitle = findViewById(R.id.note_edit_title);
        mViewTitle = findViewById(R.id.note_text_title);

        if(getIncomingIntents()){
            // This means there is a new note go to edit mode
        }
        else {
            // go into view mode
        }

    }

    // Check to see if there is a new note sent or not.
    private boolean  getIncomingIntents(){
     if(getIntent().hasExtra("selected_notes")){

         Note isIncomingNote = getIntent().getParcelableExtra("selected_notes");
         Log.d(TAG, "getIncomingIntents: " +isIncomingNote.toString());
         mIsNewNote = false;
         return false;
     }
     mIsNewNote = true;
     return true;
    }

    private void setNewNotesProperties(){
        mViewTitle.setText("Note Title");
        mEditTitle.setText("Note Title");
    }
}
/* TODO: 26/06/2019
* make THE ACTIVITY have both a view and an Edit state in the Application.
* */