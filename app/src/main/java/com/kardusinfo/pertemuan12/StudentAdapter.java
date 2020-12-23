package com.kardusinfo.pertemuan12;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private ArrayList<Student> students = new ArrayList<>();
    private Activity activity;

    public StudentAdapter(Activity activity){
        this.activity = activity;
    }
    public ArrayList<Student> getStudents(){
        return students;
    }
    public void setStudents(ArrayList<Student> arrayList){
        if(arrayList.size() >0){
            this.students.clear();
        }
        this.students.addAll(arrayList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StudentAdapter.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentViewHolder holder, int position) {
        holder.tvNim.setText(students.get(position).getNim());
        holder.tvNama.setText(students.get(position).getNama());
        holder.itemView.setOnClickListener(v -> {

        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        final TextView tvNama, tvNim;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.text_nama);
            tvNim = itemView.findViewById(R.id.text_nim);
        }
    }
}
