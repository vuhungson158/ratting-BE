# Project Structure

## Controller

Use Mapping Annotation to create end point: `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`

Use `@AllowMethod` and `@AllowFeature` to authorize

Never write logic code here, create a method on the service layer to do that,
which have the same name, same return type, same parameters

## Service

Use to write business logic code, method name, return type, parameters must same with Controller's method

## Repository

Use to create `@Query` to get data from DB[^DB]. Best Practice: **1 query per endpoint**