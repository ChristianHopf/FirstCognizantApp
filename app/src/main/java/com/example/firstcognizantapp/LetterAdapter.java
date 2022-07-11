package com.example.firstcognizantapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LetterAdapter extends RecyclerView.Adapter<LetterAdapter.LetterViewHolder>{

    public static String TAG = LetterAdapter.class.getSimpleName();
    String[] alphabet;

    public LetterAdapter(String[] mAlphabet) {
        alphabet = mAlphabet;
    }

    @NonNull
    @Override
    public LetterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "creating viewholder");
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View item = layoutInflater.inflate(R.layout.row_item, parent, false);
        return new LetterViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull LetterViewHolder holder, int position) {
        Log.i(TAG, "binding viewholder - setting text");
        holder.letterTextView.setText(alphabet[position]);
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "counting number of items");
        return alphabet.length;
    }

    public class LetterViewHolder extends RecyclerView.ViewHolder {
        TextView letterTextView;
        public LetterViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.i(TAG, "viewholder received item");
            letterTextView = itemView.findViewById(R.id.tvLetter);
        }
    }
}
