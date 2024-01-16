package kiis.ratingBE.model.subject;

import kiis.ratingBE.enums.Department;
import kiis.ratingBE.enums.subjectClassification.Small;

public class SubjectListFilter {
    public Integer creditFrom;
    public Integer creditTo;
    public Integer registrableYearFrom;
    public Integer registrableYearTo;
    public String name;
    public Department department;
    public Small classification;
    public Boolean require;
    public String semester;
    public String schedule;
}
