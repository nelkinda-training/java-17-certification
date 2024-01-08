# Modules


## Visibility Matrix

+------------------------+------------+--------------+-------------------------+-------------+--------------------------+---------------+
| Visibility             | Same Class | same package | Subclass in same module | Same Module | Subclass in other module | Other Modules |
| `private`              |   Yes      |    No        |            No           |         No  |            No            |      No       |
| (package default)      |   Yes      |    Yes       |            No           |         No  |            No            |      No       |
| unexported `protected` |   Yes      |    Yes       |            Yes          |         No  |            No            |      No       |
| unexported `public`    |   Yes      |    Yes       |            Yes          |        Yes  |            No            |      No       |
| exported `protected`   |   Yes      |    Yes       |            Yes          |         No  |            Yes           |      No       |
| exported `public`      |   Yes      |    Yes       |            Yes          |        Yes  |            Yes           |      Yes      |
