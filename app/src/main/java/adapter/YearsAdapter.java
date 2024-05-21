//package adapter;
//
//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.we_learn.R;
//
//import java.util.ArrayList;
//
//import itemDetail.TestPDF;
//import model.YearsModel;
//
//
//public class YearsAdapter extends RecyclerView.Adapter<YearsAdapter.ViewHolder> {
//
//    private Context context;
//    private ArrayList<YearsModel> yearsModels;
//
//    public YearsAdapter(Context context, ArrayList<YearsModel> yearsModels) {
//        this.context = context;
//        this.yearsModels = yearsModels;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.years_modal, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.bind(yearsModels.get(position));
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                context.startActivity(new Intent(context , TestPDF.class)
//                        .putExtra("yearID" , yearsModels.get(position).getId())
//                        .putExtra("subjectID" , scienceModels.get(position).getFirst_name())
//                );
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return yearsModels.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        private TextView years;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            years = itemView.findViewById(R.id.years_show);
//        }
//
//        public void bind(YearsModel scienceModel) {
//            years.setText(scienceModel.getName());
//        }
//    }
//}
//
//
