# JPA Relationship

> N + 1 Query problem

My colleagues usually avoid using `@OneToMany`, `@ManyToOne` because of  `n+1 query problem`

I solve that problem by changed code style:

```java
public class TeacherEntity extends BaseEntity {

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private List<SubjectEntity> subjectList = new ArrayList<>();

    @Transient
    public List<SubjectEntity> subjects = new ArrayList<>();

    public void transferSubjects() {
        subjects = subjectList
                .stream()
                .peek(subjectEntity -> subjectEntity.teacher = null)
                .toList();
    }
}
```

I separate to two properties to avoid `@OneToMany` auto execute query get associations (**n+1 query**).
If you need to get entity with associations, use `@EntityGraph` to attach `join` statement automatically.
And I use [spring-data-jpa-entity-graph](#spring-data-jpa-entity-graph) to create dynamic EntityGraph.

Remember, use `transferSubjects()` else `subjects` always empty.

```java
public class SubjectEntity extends BaseEntity {

    @Column(name = "teacher_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Long teacherId;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false, insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(allOf = TeacherEntity.class)
    public TeacherEntity teacher;
}
```

But you don't have to always separate association properties.
Like the above example, I want `teacher` association always be attached when fetching `SubjectEntity` (**FetchType.EAGER
**).

But when use `@ManyToOne`, you have to separate like the above code.
It saves you the work of set A into B every time you insert or update.

If you want to fetch not **EAGER** but **LAZY**, then separate properties to 3.

About `@JsonProperty` see [Anti DTO section](#anti-dto).
About `@Schema` see [API Tester section](#api-tester).

## Join and Limit

> Just because you can, doesn't mean you should

I **_strongly recommend_** not using findAll(Pageable, EntityGraph)

Because it will select all from table and limiting by java code

Example:

<pre>
1 teacher - n student
teacherRepo.findAll(int limit, int page);

Select * from teacher: 10 records
Select * from teacher join student: 37 records

Select * from teacher join student limit 5

Expected: 5 records of teachers
But was: 2 teacher, teacher1 with 3 student + teacher2 with 2 student
</pre>

But if you really want to join @OneToMany fields with pagination.
You have to write a @Query, use Select sub-query

## Common Projection