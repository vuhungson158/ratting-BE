<!-- PROJECT NAME -->

# School Rating App (BackEnd)

<!-- DESCRIPTION -->
> My project is a web application that allows users (almost students) to easily evaluate subjects and teachers
>
> The Main feature is rating, show all ratings as graph, write comment for each subject and teacher

<!-- RELATED LINK  -->

#### Related link: [Front End Project][front-end-url] - [Backend Swagger UI (API tester)][swagger-url] - [Version 2.7.6][old-version-url]

<!-- Index, TABLE OF CONTENTS -->

## Index

1. [Getting Started](#Getting-Started)
    - [By Docker compose](#By-Docker-compose)
    - [Manually](#Manually)
2. **Highlight (My creation)**
    1. [Access Modifier](#Access-Modifier)
    2. [Anti DTO](#Anti-DTO)
    3. [Commonize](#Commonize)
        - [Usage](#Usage)
    4. [JPA Relationship](#JPA-Relationship)
    5. [Project Structure](#Project-Structure)
    6. [Other](#Other)
        - [Final](#Final)
        - [Validate](#Validate)
        - [AOP](#AOP)
        - [Exception Handler](#Exception-Handler)
        - [Common Projection](#Common-Projection)
3. [Built With](#Built-With)
4. [Roadmap](#Roadmap)
5. [Contact](#Contact)

## Getting Started

### By Docker compose

### Manually

---

---
> From here, I will write about the difference thing of my project

## Access Modifier

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

## Anti DTO

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

## Commonize

> DRY: don't repeat yourself

After code for 3 months, I realize that almost every table has 6 same end points

1. `findAll(Pageable)`: get a list of record with pagination
2. `findAll(Pageable, Example)`: get a list of record with pagination and filter
3. `findById(Long)`: get a specific record by record ID
4. `save(Long)`: insert a new record
5. `update(Long)`: update a record
6. `delete(Long)`: soft delete a record (set field `id_delete` = true)

So I create three abstract classes to group these end point processes flow.
You can find these classes in [this package][common-package-url].

- T must be a `Entity`
- `SimpleCurdController<T>`
- `SimpleCurdService<T>`
- `SimpleCurdRepository<T>`

Why **_abstract_** ???
Because you cannot use (create instance) an abstract class directly.
You must create a class, example: `TeacherController` extend `SimpleCurdController<TeacherEntity>`
to get these common endpoints.

#### Usage

And of course, you always can write new method (C-S-R flow), with full control. [Reference][teacher-base-package-url].

Create three extend classes to generate 6 end points as default:

- `TeacherController` extends `SimpleCurdController<TeacherEntity>`
- `TeacherService` extends `SimpleCurdService<TeacherEntity>`
- `TeacherRepository` extends `SimpleCurdRepository<TeacherEntity>`

And `@Override` method if you need to add more logic, or create new end point.
But remember to follow the [Project Structure](#Project-Structure)

## JPA Relationship

> N + 1 Query problem

My colleagues usually avoid using `@OneToMany`, `@ManyToOne` because of  

## Project Structure

| Layer      | Description                                                                                                                                                                                                                                                                                              |
|------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Controller | Use Mapping Annotation to create end point: `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`<br/>Use `@AllowMethod` and `@AllowFeature` to authorize<br/>Never write logic code here, create a method on service layer to do that, which have same name, same return type, same parameters |
| Service    | Use to write business logic code, method name, return type, parameters must same with Controller's method                                                                                                                                                                                                |
| Repository | Use to create `@Query` to get data from DB[^DB]. Best Practice: **1 query per endpoint**                                                                                                                                                                                                                 |

## Other

### Final

### Validate

### AOP

### Exception Handler

### Common Projection

## Built With

## Roadmap

## Contact

- Gmail: [vuhungson158@gmail.com](mailto:vuhungson158@gmail.com)
- Facebook: [Vũ Hùng Sơn](https://www.facebook.com/hungson.vu.14)

<!-- MARKDOWN LINKS -->

[swagger-url]: http://localhost:8080/api/v1/swagger-ui/index.html

[front-end-url]: http://localhost:8080/api/v1/swagger-ui/index.html

[old-version-url]: https://github.com/vuhungson158/school-subject-rating-BE

[common-package-url]: src/main/java/kiis/ratingBE/common

[teacher-base-package-url]: src/main/java/kiis/ratingBE/features/teacher/base

<!-- IMAGES -->

<!-- Footnotes -->

[^DB]: Database
