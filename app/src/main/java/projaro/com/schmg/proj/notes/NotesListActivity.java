package projaro.com.schmg.proj.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;

import projaro.com.schmg.proj.notes.adapters.NotesRecyclerAdapter;
import projaro.com.schmg.proj.notes.models.Note;
import projaro.com.schmg.proj.notes.utils.VerticalSpacingItemDecorator;

public class NotesListActivity extends AppCompatActivity implements NotesRecyclerAdapter.OnNoteListener {

    private static final String TAG = "NotesListActivity";

    //UI Components

    private RecyclerView mRecyclerView;

    //Variables
    private ArrayList<Note> mNotes = new ArrayList<>();
    private NotesRecyclerAdapter mNotesRecyclerAdapeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
        mRecyclerView = findViewById(R.id.recyclerView);

        initRecyclerView();
        insertFakeData();

        setSupportActionBar((Toolbar)findViewById(R.id.notes_toolbar));
        setTitle("Notes");
    }
// Adds a fake set of Notes to the Recycler View adpter mNotes
    private void insertFakeData(){
        for(int i = 0; i <1000; i++){
            Note note = new Note();
            note.setTitle("Title #" +i);
            note.setContent("Content #" +i);
            note.setTimestamp("Jan 2018");
            mNotes.add(note);
        }

        // Calling the notfyDataSetChange method tells the recylerView that that the data has been updated
        mNotesRecyclerAdapeter.notifyDataSetChanged();
    }

    private void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mNotesRecyclerAdapeter = new NotesRecyclerAdapter(mNotes, this);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerView.addItemDecoration(itemDecorator);
        mRecyclerView.setAdapter(mNotesRecyclerAdapeter);
    }

    @Override
    public void onNoteClick(int position) {
        Log.d(TAG, "onNoteClick: clicked.");

        Intent intent = new Intent(this, NoteActivity.class);
        intent.putExtra("selected_notes" , mNotes.get(position));
        startActivity(intent);
    }
}

/**TODO: Implement the NotesRecyclerView OnNotesLister and pass it as a parmeter to the Adapterclass
 * so that it can detect the onclick event done by the user
 */
// TODO: Create a Bundle to get the current list itemm clicked and pass that to the intent
