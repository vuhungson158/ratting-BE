# Commonize

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

## Usage

And of course, you always can write new method (C-S-R flow), with full control. [Reference][teacher-base-package-url].

Create three extend classes to generate 6 end points as default:

- `TeacherController` extends `SimpleCurdController<TeacherEntity>`
- `TeacherService` extends `SimpleCurdService<TeacherEntity>`
- `TeacherRepository` extends `SimpleCurdRepository<TeacherEntity>`

And `@Override` method if you need to add more logic, or create new end point.
But remember to follow the [Project Structure](#Project-Structure)
