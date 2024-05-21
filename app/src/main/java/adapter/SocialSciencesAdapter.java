package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.we_learn.R;

import java.util.ArrayList;

import fragment.YearSelectionDialogFragment;
import model.ScienceModel;
import model.YearsModel;

public class SocialSciencesAdapter extends RecyclerView.Adapter<SocialSciencesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ScienceModel> scienceModels;
    private ArrayList<YearsModel> yearsModels;

    public SocialSciencesAdapter(Context context, ArrayList<ScienceModel> scienceModels, ArrayList<YearsModel> yearsModels) {
        this.context = context;
        this.scienceModels = scienceModels;
        this.yearsModels = yearsModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for the science item
        View view = LayoutInflater.from(context).inflate(R.layout.science_modal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Bind the science model to the view holder
        holder.bind(scienceModels.get(position));
        // Set an onClickListener to show the year selection dialog
        holder.itemView.setOnClickListener(view -> showYearSelectionDialog(scienceModels.get(position).getId()));
    }

    @Override
    public int getItemCount() {
        // Return the number of science models
        return scienceModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView science_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Find the TextView for the science subject title
            science_title = itemView.findViewById(R.id.science_subject_title);
        }

        public void bind(ScienceModel scienceModel) {
            // Set the text of the TextView to the name of the science model
            science_title.setText(scienceModel.getName());
        }
    }

    private void showYearSelectionDialog(int subjectId) {
        // Create and show the YearSelectionDialogFragment
        YearSelectionDialogFragment dialogFragment = new YearSelectionDialogFragment(yearsModels, subjectId, context);
        dialogFragment.show(((FragmentActivity) context).getSupportFragmentManager(), "YearSelectionDialog");
    }
}
