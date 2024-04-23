package ApiResponse;

import java.util.ArrayList;

import model.ScholarshipModel;


public class ScholarshipResponse {
    private boolean status;
    private String message;
    private ArrayList<ScholarshipModel> data;

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<ScholarshipModel> getData() {
        return data;
    }
}
