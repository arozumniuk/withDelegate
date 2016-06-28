package Data;

/**
 * Created by orozumniuk on 6/27/2016.
 */
public class ExperienceData {

    private String name;
    private String code;
    private boolean profileSelection;
    private Boolean evalSummary;
    private String passingGrade;


    public ExperienceData(String name, String code, String passingGrade, Boolean evalSummary, Boolean profileSelection  ){
        this.name = name;
        this.code = code;
        this.passingGrade = passingGrade;
        this.evalSummary = evalSummary;
        this.profileSelection = profileSelection;
    }

    public boolean getProfileSelection() {
        return profileSelection;
    }

    public void setGetProfileSelection(boolean getProfileSelection) {
        this.profileSelection = getProfileSelection;
    }



    public Boolean getEvalSummary() {
        return evalSummary;
    }

    public void setEvalSummary(Boolean evalSummary) {
        this.evalSummary = evalSummary;
    }



    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getPassingGrade() {
        return passingGrade;
    }

    public void setPassingGrade(String passingGrade) {
        this.passingGrade = passingGrade;
    }

}

