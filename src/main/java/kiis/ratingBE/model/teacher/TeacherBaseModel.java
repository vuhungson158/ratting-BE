package kiis.ratingBE.model.teacher;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kiis.ratingBE.common.BaseEntity;
import kiis.ratingBE.enums.Gender;
import kiis.ratingBE.enums.Nationality;
import kiis.ratingBE.helper.Util;
import kiis.ratingBE.validate.Furigana;

import java.util.Date;

@MappedSuperclass
public class TeacherBaseModel extends BaseEntity {
    @NotBlank
    public String name;

    @NotBlank
    @Furigana
    public String furigana;

    @Enumerated(EnumType.STRING)
    @NotBlank
    public Nationality nationality;

    @Enumerated(EnumType.STRING)
    @NotNull
    public Gender gender;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    public Date dob;

    @Transient
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Integer getAge() {
        return Util.calculateAge(dob);
    }
}
