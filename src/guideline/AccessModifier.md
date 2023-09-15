# Access Modifier

## Anti Getter Setter

If you have experience of java, you must have seen this pattern:

```java

@Getter
@Setter
public class SubjectEntity {
    private Integer id;
    private String teacherName;
    // Some other fields
}

public class Test {
    public void test(TeacherEntity teacher) {
        final SubjectEntity subject = new SubjectEntity();
        subject.setTeacherName(teacher.getName());
        System.out.println(subject.getTeacherName());
    }
}
```

I think it's call `java bean`.
I used to follow this pattern too.
But one day, I wonder why not just use `public` ?
Like this:

```java
public class SubjectEntity {
    public Integer id;
    public String teacherName;
    // Some other fields
}

public class Test {
    public void test(TeacherEntity teacher) {
        final SubjectEntity subject = new SubjectEntity();
        subject.teacherName = teacher.name;
        System.out.println(subject.teacherName);
    }
}
```

I start finding why?
And know that few people have the same question with me.
[Stack Overflow](https://stackoverflow.com/questions/1568091/why-use-getters-and-setters-accessors).

After summary of all answers, I found three answers that I think reasonable.

1. Old framework like JSP, Thymeleaf, ... need Getter, Setter to binding data
2. We need to validate values before set it into an object, so we need setter to write validate logic inside
3. Easy to debug

But times have changed

1. This project is a RestFul API Server, so I don't need to binding data to view template
2. Validate logic now using `@Annotation` instead setter. See my [Validate section](#Validate)
3. True, but not worst

Of course, I still follow **OOP encapsulation**.
Properties are always `private` in almost class, `public` properties are only for `data class` like: Entity, DTO, ...

## Protected
