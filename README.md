# Вычислитель отличий

### Hexlet tests and linter status:
[![Actions Status](https://github.com/Malcom1986/java-project-lvl2/workflows/hexlet-check/badge.svg)](https://github.com/Malcom1986/java-project-lvl2/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/9f94037f2f0fd09dea34/maintainability)](https://codeclimate.com/github/Malcom1986/java-project-lvl2/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/9f94037f2f0fd09dea34/test_coverage)](https://codeclimate.com/github/Malcom1986/java-project-lvl2/test_coverage)

--- qlty

[![Maintainability](https://qlty.sh/badges/0c5dc4dd-2119-48e0-8657-07231a3022b2/maintainability.svg)](https://qlty.sh/gh/Malcom1986/projects/java-project-lvl2)

---

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



