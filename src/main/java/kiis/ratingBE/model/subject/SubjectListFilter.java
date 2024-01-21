package kiis.ratingBE.model.subject;

import kiis.ratingBE.enums.Department;
import kiis.ratingBE.enums.subjectClassification.Small;
import kiis.ratingBE.model.common.FromTo;

public class SubjectListFilter {
    public FromTo<Integer> credit;
    public FromTo<Integer> registrableYear;
    public String name;
    public Department department;
    public Small classification;
    public Boolean require;
}
