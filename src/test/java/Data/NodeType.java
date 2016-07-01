package Data;

/**
 * Created by orozumniuk on 6/29/2016.
 */
public enum NodeType {

    TEXT_ONLY ("Text Only"),
    QUESTION_WITH_ONE_CORRECT_ANSWER ("Question with one correct answer"),
    QUESTION_WITH_MULTIPLE_CORRECT_ANSWERS ("Question with multiple correct answers / Check-List"),
    RATING_QUESTION ("Rating Question"),
    FREE_FORM_TEXT_ENTRY_FIELD ("Free Form Text Entry Field"),
    USER_SELECTION ("User Selection"),
    FORCED_RANKED_QUESTION ("Forced Ranked Question"),
    LIST ("List");

    private String value;

    NodeType(String value) {
        this.value = value;
    }

    public String value(){
        return value;
    }


}
