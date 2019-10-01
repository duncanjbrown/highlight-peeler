# highlight-peeler

Turn CSV-formatted Safari Books highlights into org-mode entries.

## Usage

Invoke using `clj` as below, passing the path of the exported
highlights (use "Export all notes and highlights" in the Safari web
app) plus a string matching the title of the book whose highlights you
are interested in. eg:

```
clj -m highlight-peeler.core ~/Downloads/safari-annotations-export.csv "Agile Software Development: The Cooperative Game"
```

The output, which is printed on `STDOUT`, takes the following form:

```org
* Chapter name
[date of highlight]
Highlighted text
[footnote linking to chapter in Safari online]
```

For example:

```
* 2. Individuals
[2019-10-01]
One of my favorite sentences comes from Wenger and Lave (1993) about the power of the concrete:

“The world carries its own structure, so that specificity always implies generality (and in this sense, generality is not to be assimilated to abstractness). That is why stories can be so powerful in conveying ideas, often more so than an articulation of the idea itself.”[fn::Agile Software Development: The Cooperative Game, Second Edition - 2. Individuals (https://learning.oreilly.com/library/view/agile-software-development/0321482751/ch05.html)]
```
