package projaro.com.schmg.proj.notes.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import projaro.com.schmg.proj.notes.R;
import projaro.com.schmg.proj.notes.models.Note;

/**
 *
 * TODO: extend The RecylcerView Class using our custom adapter
 *
**/
public class NotesRecyclerAdapter  extends RecyclerView.Adapter<NotesRecyclerAdapter.ViewHolder>{

    /**
     *
     * TODO: Implement all override methods needed for the recyclerView Adapter to function well
     *
     **/

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_note_list_item, viewGroup, false);
        return new ViewHolder(view, mOnNoteLister);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.timestamp.setText(mNotes.get(i).getTimestamp());
        viewHolder.title.setText(mNotes.get(i).getTitle());
        //Auto Gerenated Overides

    }

    @Override
    public int getItemCount() {
        return mNotes.size();
        //Auto Gerenated Overides
    }

    private ArrayList<Note> mNotes = new ArrayList<>();
    private OnNoteListener mOnNoteLister;

//TODO: Create an arrayList construtor

    public NotesRecyclerAdapter(ArrayList<Note> notes, OnNoteListener onNoteListener) {
        this.mNotes = notes;
        this.mOnNoteLister = onNoteListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

         TextView title, timestamp;
         OnNoteListener onNoteListener;

         //TODO: Create a blank construstor for the ViewHolder class
        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            title = itemView.findViewById(R.id.note_title);
            timestamp = itemView.findViewById(R.id.note_timestamp);
            this.onNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());

        }
    }

    // Handling click events to our notes application

    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}
