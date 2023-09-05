<!-- PROJECT NAME -->

# School Rating App (BackEnd)

<!-- DESCRIPTION -->
> This is description
>
> in multiline

<!-- RELATED LINK  -->

#### Related link: [Front End Project][front-end-url] - [Backend Swagger UI (API tester)][swagger-url] - [Version 2.7.6][old-version-url]

<!-- Index, TABLE OF CONTENTS -->

## Index

1. [Example](#Built-With)

## Getting Started

### By Docker compose

## Highlight

### AOP

### Commonize

> I extremely hate duplicate code

After code for 3 months, I realize that almost every table has 6 same end points

1. `findAll(Pageable)`: get a list of record with pagination
2. `findAll(Pageable, Example)`: get a list of record with pagination and filter
3. `findById(Long)`: get a specific record by record ID
4. `save(Long)`: insert a new record
5. `update(Long)`: update a record
6. `delete(Long)`: soft delete a record (set field `id_delete` = true)

So I group these end point processes flow into a [package][common-package-url]

- **_an abstract Controller_**: `SimpleCurdController<T>`. T must be a `Entity`
- **_an abstract Service_**: `SimpleCurdService<T>`.
- **_an abstract Repository_**: `SimpleCurdRepository<T>`.

Why **_abstract_** ???
Because you cannot use (create instance) an abstract class directly.
You must create a class, example: `TeacherController` extend `SimpleCurdController<TeacherEntity>`
to get these common endpoints.

And of course, you always can write new method (C-S-R flow), with full control.

| Layer      | Description                                                                                                                                                                                                                                                                                              |
|------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Controller | Use Mapping Annotation to create end point: `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`<br/>Use `@AllowMethod` and `@AllowFeature` to authorize<br/>Never write logic code here, create a method on service layer to do that, which have same name, same return type, same parameters |
| Service    | Use to write business logic code, method name, return type, parameters must same with Controller's method                                                                                                                                                                                                |
| Repository | Use to create `@Query` to get data from database. Best Practice: **1 query per endpoint**                                                                                                                                                                                                                |

### JPA Relationship

### Other

#### Exception Handler

## Built With

### Roadmap

## Contact

- Gmail: [vuhungson158@gmail.com](mailto:vuhungson158@gmail.com)

<!-- MARKDOWN LINKS -->

[swagger-url]: http://localhost:8080/api/v1/swagger-ui/index.html

[front-end-url]: http://localhost:8080/api/v1/swagger-ui/index.html

[old-version-url]: https://github.com/vuhungson158/school-subject-rating-BE

[common-package-url]: https://github.com/vuhungson158/ratting-BE/tree/master/src/main/java/kiis/ratingBE/common

<!-- IMAGES -->
