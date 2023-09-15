# Anti DTO

> DRY: don't repeat yourself

Let's see below codes

```java
public class SubjectEntity {
    public Integer id;
    public String name;
    public TeacherDto teacher;
    public List<Student> students;
    // Some other fields
}

public class SubjectDto {
    public Integer id;
    public String name;
    public Integer teacherId;
    public String teacherName;
    public Integer totalStudent;
    // Some other fields
}

public class SubjectRequest {
    public String name;
    public Integer teacherId;
    // Some other fields
}
```

To remove duplication, I only use one class. See my below code.

```java
public class SubjectEntity {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Integer id;
    public String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Integer teacherId;
    @JsonIgnore
    public TeacherDto teacher;
    @JsonIgnore
    public List<Student> students;

    @Transient
    public String getTeacherName() {
        return teacher.name;
    }

    @Transient
    public Integer getTotalStudent() {
        return students.size();
    }
}
```

I only use `Entity`. And I control which properties are shown on the outbound and return routes.

- `@JsonProperty(access = JsonProperty.Access.READ_ONLY)`, **READ_ONLY**: only shown inside `@ResponseBody`
- `@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)`, **WRITE_ONLY**: only shown inside `@RequestBody`
- `@JsonIgnore`, **WRITE_ONLY**: hide on both sides
- `@Transient`: not interact with DB[^DB]
