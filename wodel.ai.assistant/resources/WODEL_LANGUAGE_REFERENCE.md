# Wodel language reference for the AI assistant

This compact reference is derived from the Wodel Xtext grammar and repository examples. It is prompt context only; the Wodel Xtext validator is the authority.

## Program and library headers

Executable program:

```wodel
generate 10 mutants
in "data/out/"
from "data/model/"
metamodel "/Project/data/model/domain.ecore"
description "Optional description"

with blocks {
    blockName "Optional block description" {
        // mutation commands
    }
}
```

`generate exhaustive mutants` is also valid. A library starts with:

```wodel
library for metamodel "/Project/data/model/domain.ecore"
with commands {
    // reusable commands
}
```

Programs can declare auxiliary resources with `with resources from {name="path" metamodel="..."}` clauses. Sources can import other Wodel files with `import "..."`.

## Mutation blocks

A block has an identifier, optional string description, optional dependencies (`from blockA, blockB`), optional repeat clause, a body, and optional cardinality.

```wodel
with blocks {
    aor "Arithmetic replacement" {
        modify one Expression where {operator = '+'} with {operator = '-'}
    }
}
```

## Core mutation commands

Selection:

```wodel
x = select one EClass
x = select one EClass where {name = 'Customer'}
y = select one EAttribute in x->eStructuralFeatures
allClasses = select sample from all EClass
```

Object creation/removal/cloning/retyping:

```wodel
create EClass with {name = random-string(4, 8)}
remove one EClass
copy = deep clone one EClass with {name = 'Copy'}
retype one SomeClass as OtherClass
```

Modification:

```wodel
modify one EClass where {name <> null} with {name = random-string(4, 8)}
modify x with {name = 'Changed'}
```

References:

```wodel
create reference children to one Child in one Parent
remove reference children in one Parent
remove all reference children in Parent
modify source children from one Parent to other Parent
modify target children from one Parent to other Child
```

Selections include `one`, `all`, `other`, `typed`, `null`, selected variables, and optional `where { ... }`. Navigation uses `->`. Auxiliary resources can be addressed with `from <name> resources`.

## Attribute/reference updates

Inside `with { ... }`, Wodel supports direct attribute/reference assignment plus operations such as `copy(...)`, `swap(...)`, `reverse(...)`, `unset(...)`, `swapref(...)`, `unsetref(...)`, `+=`, and `-=` where allowed by the grammar/metamodel.

Random value helpers include `random-string(min,max)`, `random-int`, `random-double`, `random-boolean`, `random`, `upper`, `lower`, `catstart(...)`, `catend(...)`, and `replace(...)` depending on the feature type.

## Conditions

`where` expressions can test attributes/references with operators such as `=`, `<>`, `in`, `is`, `not`, `>=`, `<=`, `>`, and `<`, combined with `and` / `or`. Examples from Wodel programs include:

```wodel
where {operator in ['+', '-', '*'] and leftOperand <> null}
where {expression is typed NumberLiteral}
where {required = true}
```

## Authoring rules for the assistant

- Never invent an EClass, EAttribute or EReference when a metamodel description is available.
- Preserve project paths and auxiliary resource names from the selected program unless the user explicitly asks to change them.
- Preserve existing valid source unless the requested change requires modifying it.
- Return a complete `.mutator` source when asked to repair, improve, or generate code.
- Generated code must pass the Wodel Xtext validator before being presented as validated.
- If validation still fails after retries, report the remaining issues rather than claiming the code is valid.
