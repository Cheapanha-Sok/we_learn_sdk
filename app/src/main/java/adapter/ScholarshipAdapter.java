package adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.we_learn.R;

import java.util.ArrayList;

import itemDetail.SubjectDetailPDF;
import model.ScholarshipModel;

public class ScholarshipAdapter extends RecyclerView.Adapter<ScholarshipAdapter.ViewHolder> {
    Context context;
    ArrayList<ScholarshipModel> scholarshipModels;

    public ScholarshipAdapter(Context context, ArrayList<ScholarshipModel> arrayList) {
        this.context = context;
        this.scholarshipModels = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.scholarship_modal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bind(scholarshipModels.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context , SubjectDetailPDF.class)
                        .putExtra("img" , scholarshipModels.get(position).getAvatar())
                        .putExtra("title" , scholarshipModels.get(position).getLast_name())
                );
            }
        });
    }

    @Override
    public int getItemCount() {
        return scholarshipModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView scholarship_url;
        private TextView scholarship_title, scholarship_description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            scholarship_title = itemView.findViewById(R.id.scholarship_title);
            scholarship_description = itemView.findViewById(R.id.scholarship_description);
            scholarship_url = itemView.findViewById(R.id.scholarship_img);
        }

        public void bind(ScholarshipModel scholarshipModel) {
            scholarship_title.setText(scholarshipModel.getEmail());
            scholarship_description.setText(scholarshipModel.getLast_name());
            Glide.with(context).load(scholarshipModel.getAvatar()).into(scholarship_url);
        }
    }
}
