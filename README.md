# Вычислитель отличий

### Hexlet tests and linter status:

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Malcom1986_java-project-lvl2&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=Malcom1986_java-project-lvl2)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=Malcom1986_java-project-lvl2&metric=bugs)](https://sonarcloud.io/summary/new_code?id=Malcom1986_java-project-lvl2)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Malcom1986_java-project-lvl2&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=Malcom1986_java-project-lvl2)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Malcom1986_java-project-lvl2&metric=coverage)](https://sonarcloud.io/summary/new_code?id=Malcom1986_java-project-lvl2)

Вычислитель отличий – программа, определяющая разницу между двумя структурами данных

Возможности утилиты:

* Поддержка разных входных форматов: yaml и json
* Генерация отчета в виде plain text, stylish и json

Пример использования:

```text
# формат plain
./app --format plain path/to/file.yml another/path/file.json

Property 'follow' was added with value: false
Property 'baz' was updated. From 'bas' to 'bars'
Property 'group2' was removed

# формат stylish
./app filepath1.json filepath2.json

{
+ follow: false
+ numbers: [1, 2, 3]
  setting1: Value 1
- setting2: 200
- setting3: true
+ setting3: {key=value}
+ setting4: blah blah
  }
```
