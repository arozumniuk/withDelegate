package Data;

/**
 * Created by orozumniuk on 6/27/2016.
 */
public enum ExperienceType {

        EVALUATION("Evaluation"),
        STANDART("Standart"),
        QUESTIONPORTAL("QuestionPortal");

        private String value;
        ExperienceType(String value){
                this.value = value;
        }

        public String value(){
                return value;
        }

}
