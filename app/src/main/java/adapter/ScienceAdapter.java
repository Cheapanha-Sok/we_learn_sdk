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
import model.ScienceModel;

public class ScienceAdapter extends RecyclerView.Adapter<ScienceAdapter.ViewHolder> {

    Context context;
    ArrayList<ScienceModel> scienceModels;


    public ScienceAdapter(Context context, ArrayList<ScienceModel> arrayList ) {
        this.context = context;
        this.scienceModels = arrayList;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.science_modal,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bind(scienceModels.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                context.startActivity(new Intent(context , SubjectDetailPDF.class)
                        .putExtra("img" , scienceModels.get(position).getAvatar())
                        .putExtra("title" , scienceModels.get(position).getFirst_name())
                );
            }
        });
    }
    @Override
    public int getItemCount() {

        return scienceModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_url;
        private TextView science_title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            science_title = itemView.findViewById(R.id.science_subject_title);
            img_url = itemView.findViewById(R.id.science_subject_img);
        }
        public void bind(ScienceModel scienceModel) {
            science_title.setText(scienceModel.getFirst_name());
            Glide.with(context).load(scienceModel.getAvatar()).into(img_url);
        }
    }
}



