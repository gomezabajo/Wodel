<p align="center">
  <a href="https://gomezabajo.github.io/Wodel/">
    <img src="https://gomezabajo.github.io/Wodel/images/wodel.png" width="120" height="100" alt="Wodel logo" />
  </a>
</p>

<h1 align="center">Wodel</h1>

<p align="center"><i>A domain-specific language for model mutation</i></p>

<p align="center">
  <img src="https://img.shields.io/badge/version-2.3-blue" alt="Version 2.3">
  <a href="https://github.com/gomezabajo/Wodel/graphs/contributors"><img src="https://img.shields.io/github/contributors/gomezabajo/Wodel" alt="Contributors"></a>
  <a href="https://github.com/gomezabajo/Wodel/network/members"><img src="https://img.shields.io/github/forks/gomezabajo/Wodel" alt="Forks"></a>
  <a href="https://github.com/gomezabajo/Wodel/stargazers"><img src="https://img.shields.io/github/stars/gomezabajo/Wodel" alt="Stars"></a>
  <a href="https://raw.githubusercontent.com/gomezabajo/Wodel/master/LICENSE"><img src="https://img.shields.io/github/license/gomezabajo/Wodel" alt="License"></a>
</p>

<p align="center">
  <a href="https://gomezabajo.github.io/Wodel/">Website</a> &middot;
  <a href="https://github.com/gomezabajo/Wodel/wiki/1.-Get-Started">Tutorial</a> &middot;
  <a href="https://github.com/gomezabajo/Wodel/issues">Report a bug</a>
</p>

---

## Table of contents

- [Overview](#overview)
- [What's new in 2.3](#whats-new-in-23)
- [Requirements](#requirements)
- [Installation](#installation)
- [Getting started](#getting-started)
- [A quick example](#a-quick-example)
- [Wodel](#wodel)
- [Wodel-Edu](#wodel-edu)
- [Wodel-Test](#wodel-test)
- [Roadmap](#roadmap)
- [Acknowledgements and third-party components](#acknowledgements-and-third-party-components)
- [Citing Wodel](#citing-wodel)
- [Funding](#funding)
- [License](#license)
- [Credits](#credits)

---

## Overview

Wodel is a **domain-specific language (DSL) for the specification and generation of model
mutants**. It is *domain-independent*: it can mutate models conforming to arbitrary meta-models,
so the same tool serves automata, class diagrams, electronic circuits, business processes,
or any other language defined by an [EMF](https://eclipse.dev/modeling/emf/) meta-model.

Wodel provides nine mutation primitives — covering object creation and deletion, reference
redirection, attribute modification, cloning, and retyping (changing an object's type to one of
its sibling types), among others. The engine verifies that each generated mutant is a valid
model: it conforms to the domain meta-model and satisfies its integrity constraints. Its
development environment is extensible, allowing post-processors to be plugged in for different
applications.

The repository hosts three related tools built around this core:

| Tool | Purpose |
|------|---------|
| **[Wodel](#wodel)** | The model-mutation DSL and engine. |
| **[Wodel-Edu](#wodel-edu)** | Automated generation of educational exercises from mutated models. |
| **[Wodel-Test](#wodel-test)** | Synthesis of full mutation-testing environments for arbitrary languages. |

See also **[Wodel4diac](https://github.com/gomezabajo/Wodel4diac)**, a Wodel variant compatible
with [Eclipse 4diac](https://eclipse.dev/4diac/) / IEC 61499, maintained in its own repository.

## What's new in 2.3

- **Migration to Eclipse 4.40** (and Xtext 2.43), keeping the toolset current with the latest
  Eclipse Modeling platform.
- The **Wodel-Edu & Wodel-Test** suites were advanced to **2.2**, and the **Wodel** core to **2.3**.
- A new **console view** for following mutation runs from within the IDE.
- **Ubuntu/Linux compatibility fix** (thanks to [@jameseb7](https://github.com/jameseb7)).
- Groundwork laid for a forthcoming **GenAI-based assistant** — see [Roadmap](#roadmap).

## Requirements

- **Java 21** (required to run Eclipse 4.40 / 2026-06)
- **Eclipse Modeling Tools 4.40** (2026-06) — or the *Eclipse IDE for Java and DSL Developers*
- **Xtext 2.43** and **EMF** — installed automatically as plugin dependencies via the update site
- Optional, depending on the features used: **Sirius**, **Epsilon**, and a model-finder /
  constraint backend for semantic validation

## Installation

Wodel is provided as a set of Eclipse plug-ins.

### Option 1: Install from the update site (recommended)

1. In Eclipse, open **Help → Install New Software…**
2. Click **Add…** and enter the Wodel update site:

   ```
   https://gomezabajo.github.io/Wodel/update-site/
   ```

3. Select **Wodel** from the list, click **Next**, and follow the wizard to complete the installation.
4. Restart Eclipse when prompted.

> **Requirements:** Eclipse Modeling Tools 4.40 2026-06 with EMF, running on Java 21.

### Option 2: Pre-packaged distributions

If you prefer a ready-to-run environment, you can download:

- [Standalone Eclipse with Wodel pre-installed](https://www.dropbox.com/scl/fi/ygwr91ir761bexl9uj2es/eclipse.zip?rlkey=x5negwalmf30fzjmfyxr10sj7&dl=0)
- [Windows 7 x64 VirtualBox VM with Wodel](https://www.dropbox.com/scl/fi/wlpr7e0ab0981kvfthi5n/Windows.7.x64.Wodel.2.0.zip?rlkey=hxlk3y0mh3flqp6763dfsgm20&st=pkor7ex6&dl=0)

### Option 3: From source

Clone this repository and import the plug-in projects into an Eclipse workspace with the Plug-in Development Environment (PDE) installed. 

## Getting Started

Once installed, create your first Wodel project via **File → New → Other… → Wodel → New Wodel Project**, and follow the [Get Started tutorial](https://github.com/gomezabajo/Wodel/wiki/1.-Get-Started). A complete example project (finite automata) is available [here](https://gomezabajo.github.io/Wodel/zip/automata/DFAWodel.zip).

## A quick example

The following Wodel program generates two mutants of Finite Automaton models by redirecting the target of a transition to a different state:

```
generate 2 mutants
in "data/out/"
from "data/model/"
metamodel "http://dfaAutomaton/1.0"

with commands {
     modify target tar from one Transition to other State
}
```

Mutations can also be organized into *blocks* — optionally chained, so that one block mutates the mutants produced by a previous one — and constrained with OCL to ensure that every generated mutant remains a valid model:

```
generate mutants
in "data/out/"
from "data/model/exercise1.model"
metamodel "http://dfaAutomaton/1.0"

with blocks {
    first {
         modify target tar from one Transition to other State [3]
    } [2]
    second from first repeat=no {
         modify one State with { name = random-string(4,6)}
    } [3]
}
constraints {
    context State connected:: "isInitial or Set{self}->
            closure(s | Transition.allInstances()->
            select(t | t.tar=s)->collect(src))->exists(s | s.isInitial)"
}
```

The Wodel engine checks that each mutant conforms to the domain meta-model and satisfies its integrity constraints, and avoids generating duplicated mutants.

![The Wodel IDE](http://gomezabajo.github.io/Wodel/images/wodelIDE.png)


> [`wodel.examples`](https://github.com/gomezabajo/Wodel/tree/master/wodel.examples) /
> [`wodel.project.examples`](https://github.com/gomezabajo/Wodel/tree/master/wodel.project.examples),
> and follow the [tutorial](https://github.com/gomezabajo/Wodel/wiki/1.-Get-Started) for the
> authoritative syntax.

A Wodel program names a seed model and its meta-model, then declares the mutation operators to
apply and how many mutants to generate. This program creates two mutants of a finite automaton
by redirecting the target of a transition:

```
generate 2 mutants
in "data/out/"
from "data/model/"
metamodel "http://dfaAutomaton/1.0"

with commands {
     modify target tar from one Transition to other State
}
```

Mutations can also be organized in **blocks** — with cardinalities, dependencies between blocks,
and OCL **constraints** that every generated mutant must satisfy:

```
generate mutants
in "data/out/"
from "data/model/exercise1.model"
metamodel "http://dfaAutomaton/1.0"

with blocks {
    first {
         modify target tar from one Transition to other State [3]
    } [2]
    second from first repeat=no {
         modify one State with { name = random-string(4,6)}
    } [3]
}
constraints {
    context State connected:: "isInitial or Set{self}->
            closure(s | Transition.allInstances()->
            select(t | t.tar=s)->collect(src))->exists(s | s.isInitial)"
}
```

Running the program produces a folder of valid mutants, ready to be consumed by Wodel-Edu, Wodel-Test, or a custom post-processor. More examples are available on the
[samples page](https://gomezabajo.github.io/Wodel/samples.html).

---

## Wodel

Wodel is the core DSL described in [Overview](#overview). Learn more:

- [Wodel website](https://gomezabajo.github.io/Wodel/)
- [Wodel tutorial](https://github.com/gomezabajo/Wodel/wiki/1.-Get-Started)

<details>
<summary><b>Wodel plugins</b></summary>

- [wodel.core](https://github.com/gomezabajo/Wodel/tree/master/wodel.core)
  - [wodel.dsls.wodel](https://github.com/gomezabajo/Wodel/tree/master/wodel.dsls.wodel) &middot; [wodel.dsls.wodel.ide](https://github.com/gomezabajo/Wodel/tree/master/wodel.dsls.wodel.ide) &middot; [wodel.dsls.wodel.ui](https://github.com/gomezabajo/Wodel/tree/master/wodel.dsls.wodel.ui)
  - [wodel.extension](https://github.com/gomezabajo/Wodel/tree/master/wodel.extension) &middot; [wodel.models](https://github.com/gomezabajo/Wodel/tree/master/wodel.models) &middot; [wodel.postprocessor](https://github.com/gomezabajo/Wodel/tree/master/wodel.postprocessor)
  - [wodel.project](https://github.com/gomezabajo/Wodel/tree/master/wodel.project) &middot; [wodel.registry](https://github.com/gomezabajo/Wodel/tree/master/wodel.registry) &middot; [wodel.registry.reduce](https://github.com/gomezabajo/Wodel/tree/master/wodel.registry.reduce) &middot; [wodel.run](https://github.com/gomezabajo/Wodel/tree/master/wodel.run)
  - [wodel.semantic.comparison](https://github.com/gomezabajo/Wodel/tree/master/wodel.semantic.comparison) &middot; [wodel.semantic.validation](https://github.com/gomezabajo/Wodel/tree/master/wodel.semantic.validation)
  - [wodel.syntactic.comparison](https://github.com/gomezabajo/Wodel/tree/master/wodel.syntactic.comparison) &middot; [wodel.syntactic.validation](https://github.com/gomezabajo/Wodel/tree/master/wodel.syntactic.validation) &middot; [wodel.utils](https://github.com/gomezabajo/Wodel/tree/master/wodel.utils)
- [wodel.footprints](https://github.com/gomezabajo/Wodel/tree/master/wodel.footprints)
  - [wodel.metrics.command](https://github.com/gomezabajo/Wodel/tree/master/wodel.metrics.command) &middot; [wodel.metrics.data](https://github.com/gomezabajo/Wodel/tree/master/wodel.metrics.data) &middot; [wodel.metrics.debug](https://github.com/gomezabajo/Wodel/tree/master/wodel.metrics.debug) &middot; [wodel.metrics.dynamic](https://github.com/gomezabajo/Wodel/tree/master/wodel.metrics.dynamic) &middot; [wodel.metrics.fixed](https://github.com/gomezabajo/Wodel/tree/master/wodel.metrics.fixed)
- [wodel.additions](https://github.com/gomezabajo/Wodel/tree/master/wodel.additions)
  - [wodel.semantic.comparison.atl](https://github.com/gomezabajo/Wodel/tree/master/wodel.semantic.comparison.atl) &middot; [wodel.semantic.comparison.dfa](https://github.com/gomezabajo/Wodel/tree/master/wodel.semantic.comparison.dfa) &middot; [wodel.semantic.comparison.java](https://github.com/gomezabajo/Wodel/tree/master/wodel.semantic.comparison.java) &middot; [wodel.semantic.validation.atl](https://github.com/gomezabajo/Wodel/tree/master/wodel.semantic.validation.atl) &middot; [wodel.semantic.validation.java](https://github.com/gomezabajo/Wodel/tree/master/wodel.semantic.validation.java)
- [wodel.examples](https://github.com/gomezabajo/Wodel/tree/master/wodel.examples)
  - [wodel.project.examples](https://github.com/gomezabajo/Wodel/tree/master/wodel.project.examples)
- [wodel.json](https://github.com/gomezabajo/Wodel/tree/master/wodel.json)
  - [wodel.postprocessor.json](https://github.com/gomezabajo/Wodel/tree/master/wodel.postprocessor.json)
- [wodel.asple](https://github.com/gomezabajo/Wodel/tree/master/wodel.asple)
  - [wodel.dsls.asple](https://github.com/gomezabajo/Wodel/tree/master/wodel.dsls.asple) &middot; [wodel.dsls.asple.ide](https://github.com/gomezabajo/Wodel/tree/master/wodel.dsls.asple.ide) &middot; [wodel.dsls.asple.ui](https://github.com/gomezabajo/Wodel/tree/master/wodel.dsls.asple.ui)
- [wodel.seed.synthesis](https://github.com/gomezabajo/Wodel/tree/master/wodel.seed.synthesis)
  - [wodel.synthesizer](https://github.com/gomezabajo/Wodel/tree/master/wodel.synthesizer)
- [wodel.emf.comparison](https://github.com/gomezabajo/Wodel/tree/master/wodel.emf.comparison)
  - [wodel.syntactic.comparison.emf](https://github.com/gomezabajo/Wodel/tree/master/wodel.syntactic.comparison.emf)
- [wodel.emf.validation](https://github.com/gomezabajo/Wodel/tree/master/wodel.emf.validation)
  - [wodel.syntactic.validation.emf](https://github.com/gomezabajo/Wodel/tree/master/wodel.syntactic.validation.emf)

</details>

## Wodel-Edu

Wodel-Edu is an extension to Wodel for the **automated generation of exercises**. It produces
seven kinds of exercises:

- **Alternative response** — the student decides whether a diagram or its textual representation is correct.
- **Multiple diagram choice** — the student selects which of the shown diagrams is correct.
- **Multiple text choice** — the student selects which of the shown textual representations is correct.
- **Multiple emendation choice** — the student selects which text options fix the shown diagram.
- **Match pairs choice** — the student matches each statement on the left with the correct drop-down option.
- **Missing words choice** — the student fills the gaps in a text using the correct drop-down options to match the statement.
- **Text drag and drop** — the student fills the gaps in a text using labelled options grouped in categories to match the statement.

Learn more:

- [Wodel-Edu website](https://gomezabajo.github.io/Wodel/wodel-edu.html)
- [Wodel-Edu tutorial](https://github.com/gomezabajo/Wodel/wiki/2.-Get-Started-with-Wodel-Edu)

<details>
<summary><b>Wodel-Edu plugins</b></summary>

- [wodel.wodeledu](https://github.com/gomezabajo/Wodel/tree/master/wodel.wodeledu)
  - [wodeledu.extension](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.extension) &middot; [wodeledu.model2text](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.model2text) &middot; [wodeledu.models](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.models) &middot; [wodeledu.run](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.run) &middot; [wodeledu.utils](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.utils)
- [wodeledu.additions](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.additions)
  - [wodel.semantic.comparison.lc](https://github.com/gomezabajo/Wodel/tree/master/wodel.semantic.comparison.lc) &middot; [wodeledu.extension.examples](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.extension.examples) &middot; [wodeledu.model2text.dfa](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.model2text.dfa) &middot; [wodeledu.model2text.lc](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.model2text.lc)

**eduTest DSL** — [wodeledu.dsls.edutest](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.edutest) &middot; [.ide](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.edutest.ide) &middot; [.ui](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.edutest.ui)

**modelDraw DSL** — [wodeledu.dsls.modeldraw](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.modeldraw) &middot; [.ide](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.modeldraw.ide) &middot; [.ui](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.modeldraw.ui)

**modelText DSL** — [wodeledu.dsls.modeltext](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.modeltext) &middot; [.ide](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.modeltext.ide) &middot; [.ui](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.modeltext.ui)

**mutaText DSL** — [wodeledu.dsls.mutatext](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.mutatext) &middot; [.ide](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.mutatext.ide) &middot; [.ui](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.mutatext.ui)

</details>

## Wodel-Test

Wodel-Test is built on top of Wodel. Because Wodel is language-independent, mutation operators
can be defined for any language given by a meta-model. Once the operators are defined,
**Wodel-Test generates a complete Mutation Testing (MT) environment for that language as an
Eclipse plugin**. The generated MT tool parses a program into a model conforming to the language
meta-model, applies the mutation operators, evaluates the test suite against the resulting
mutants, and reports a rich collection of metrics about the MT process.

Learn more:

- [Wodel-Test website](https://gomezabajo.github.io/Wodel/Wodel-Test/)
- [Wodel-Test companion repository](https://github.com/gomezabajo/Wodel-Test)
- [Wodel-Test designer tutorial](https://github.com/gomezabajo/Wodel-Test/wiki/Get-Started-with-Wodel%E2%80%90Test-Designer)

<details>
<summary><b>Wodel-Test plugins</b></summary>

- [wodel.wodeltest](https://github.com/gomezabajo/Wodel/tree/master/wodel.wodeltest)
  - [wodeltest.designer](https://github.com/gomezabajo/Wodel/tree/master/wodeltest.designer) &middot; [wodeltest.extension](https://github.com/gomezabajo/Wodel/tree/master/wodeltest.extension) &middot; [wodeltest.optimiser](https://github.com/gomezabajo/Wodel/tree/master/wodeltest.optimiser) &middot; [wodeltest.run](https://github.com/gomezabajo/Wodel/tree/master/wodeltest.run)
- [wodeltest.additions](https://github.com/gomezabajo/Wodel/tree/master/wodeltest.additions)
  - [wodeltest.conga.parsers](https://github.com/gomezabajo/Wodel/tree/master/wodeltest.conga.parsers) &middot; [wodeltest.extension.examples](https://github.com/gomezabajo/Wodel/tree/master/wodeltest.extension.examples) &middot; [wodeltest.optimiser.subsumption](https://github.com/gomezabajo/Wodel/tree/master/wodeltest.optimiser.subsumption)

</details>

---

## Roadmap

- **GenAI-based assistant (in progress).** Work is underway to integrate a generative-AI
  assistant into the Wodel toolset, to help users author and refine mutation programs.
  This feature is experimental and not yet generally available.

## Acknowledgements and third-party components

Wodel builds upon and redistributes components from several projects, including:

- **[anATLyzer](https://github.com/anatlyzer/anatlyzer)** — static analysis of ATL transformations (`anatlyzer.*`).
- **[eFinder](https://github.com/jesusc/efinder)** — model finding / constraint solving (`efinder.*`).
- **[tinytools](https://github.com/jesusc/tiny-tools)** — supporting EMF utilities (`tinytools.*`).

Developed in the context of work at the Universidad Autónoma de Madrid and the Universidad de Murcia.

## Citing Wodel

If you use Wodel, Wodel-Edu, or Wodel-Test in academic work, please cite the relevant
publication(s):

```bibtex
@inproceedings{GomezAbajo2016Wodel,
  author    = {G\'omez-Abajo, Pablo and Guerra, Esther and de Lara, Juan},
  title     = {Wodel: A Domain-Specific Language for Model Mutation},
  booktitle = {Proceedings of the 31st Annual ACM Symposium on Applied Computing (SAC)},
  pages     = {1968--1973},
  year      = {2016},
  doi       = {10.1145/2851613.2851751}
}

@article{GomezAbajo2017Exercises,
  author  = {G\'omez-Abajo, Pablo and Guerra, Esther and de Lara, Juan},
  title   = {A Domain-Specific Language for Model Mutation and Its Application
             to the Automated Generation of Exercises},
  journal = {Computer Languages, Systems \& Structures},
  volume  = {49},
  pages   = {152--173},
  year    = {2017}
}

@article{GomezAbajo2018Tool,
  author  = {G\'omez-Abajo, Pablo and Guerra, Esther and de Lara, Juan and Merayo, Mercedes G.},
  title   = {A Tool for Domain-Independent Model Mutation},
  journal = {Science of Computer Programming},
  volume  = {163},
  pages   = {85--92},
  year    = {2018}
}

@article{GomezAbajo2021WodelTest,
  author  = {G\'omez-Abajo, Pablo and Guerra, Esther and de Lara, Juan and Merayo, Mercedes G.},
  title   = {Wodel-Test: A Model-Based Framework for Language-Independent Mutation Testing},
  journal = {Software and Systems Modeling},
  volume  = {20},
  pages   = {767--793},
  year    = {2021},
  doi     = {10.1007/s10270-020-00827-0}
}

@article{GomezAbajo2025WodelTestSoftwareX,
  author  = {G\'omez-Abajo, Pablo and Guerra, Esther and de Lara, Juan},
  title   = {Wodel-Test: A Model-Based Framework for Engineering
             Language-Specific Mutation Testing Tools},
  journal = {SoftwareX},
  volume  = {31},
  year    = {2025},
  issn    = {2352-7110},
  publisher = {Elsevier}
}
```

## Funding

This work has been funded by the Spanish Ministry of Science (RTI2018-095255-B-I00, project "MASSIVE") and the R&D programme of Madrid (P2018/TCS-4314, project
"[FORTE](https://antares.sip.ucm.es/forte-cm/)").

## License

The Wodel plug-ins developed by this project are distributed under the
[**Eclipse Public License 2.0 (EPL-2.0)**](https://github.com/gomezabajo/Wodel/blob/master/LICENSE). This repository also includes the
`anatlyzer.*` projects from [anATLyzer](https://anatlyzer.github.io/),
a static analyser for ATL used by the ATL case study, which retain their
original license. Please consult the license headers of each plug-in for details.

> **Note:** the `anatlyzer.*` projects are a bundled copy of
> [anATLyzer](https://anatlyzer.github.io/), a static analyser for ATL
> developed by third parties, which Wodel uses for the ATL model
> transformation use case. They are not part of Wodel itself.


## Credits

**Wodel, Wodel-Edu & Wodel-Test** — by Juan de Lara, Esther Guerra, Pablo Gómez-Abajo *et al.*, of the [miso research group](http://www.miso.es/), Universidad Autónoma de Madrid.

The Wodel project was started by the miso group in September 2013; its initial IDE was
implemented by Víctor López Rivero. Since March 2015 it has been developed by Pablo Gómez-Abajo under the supervision of Esther Guerra and Juan de Lara (and, during his PhD studies, Mercedes G. Merayo). Wodel builds on [Xtext](https://eclipse.dev/Xtext/),
[Sirius](https://eclipse.dev/sirius/), and [Epsilon](https://eclipse.dev/epsilon/), among other frameworks.

Thanks to [@jameseb7](https://github.com/jameseb7) for his priceless help regarding the Ubuntu/Linux compatibility fix.
