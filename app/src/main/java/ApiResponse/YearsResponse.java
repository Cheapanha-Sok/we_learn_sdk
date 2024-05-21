package ApiResponse;

import java.util.ArrayList;

import model.YearsModel;

public class YearsResponse {


    private String message;
    private ArrayList<YearsModel> data;

    public String getMessage() {
        return message;
    }

    public ArrayList<YearsModel> getData() {
        return data;
    }


}
