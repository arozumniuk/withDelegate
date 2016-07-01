package Data;

/**
 * Created by orozumniuk on 6/27/2016.
 */
public class ExperienceData {

    private String name;
    private String code;
    private boolean profileSelection = false;
    private Boolean evalSummary = false;
    private String passingGrade = "";
    private String duration;
    private boolean count_down = false;
    private boolean loop = false;
    private Boolean timer = false;
    private ExperienceType experienceType;

    public ExperienceData(String name, String code, ExperienceType experienceType  ){
        this.name = name;
        this.code = code;
        this.experienceType = experienceType;
    }

    public boolean getProfileSelection() {
        return profileSelection;
    }

    public Boolean getEvalSummary() {
        return evalSummary;
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

    public Boolean getTimer() {
        return timer;
    }
    public String getDuration() {
        return duration;
    }

    public ExperienceData withTimerDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public boolean getCount_down() {
        return count_down;
    }

    public ExperienceData withCount_down(boolean count_down) {
        this.count_down = count_down;
        return this;
    }

    public boolean getLoop() {
        return loop;
    }

    public ExperienceType getExperienceType() {
        return experienceType;
    }

    public ExperienceData withLoop(boolean loop) {
        this.loop = loop;
        return this;
    }


    public ExperienceData withTimer(Boolean timer) {
        this.timer = timer;
        return this;
    }
    public ExperienceData withProfileSelection(boolean getProfileSelection) {
        this.profileSelection = getProfileSelection;
        return this;
    }

    public ExperienceData withEvalSummary(Boolean evalSummary) {
        this.evalSummary = evalSummary;
        return this;
    }

    public ExperienceData withPassingGrade(String passingGrade) {
        this.passingGrade = passingGrade;
        return this;
    }

    public ExperienceData withName(String name) {
        this.name = name;
        return this;
    }

    public ExperienceData withCode(String code) {
        this.code = code;
        return this;
    }
}

