<p align="center">
  <a href="https://gomezabajo.github.io/Wodel-Test/dropdown/Wodel-Test%20plugins_Wodel-Test%20designer/">
    <img src="https://gomezabajo.github.io/Wodel-Test/assets/img/wodeltest.png" width="173" height="120" alt="Wodel-Test logo" />
  </a>
</p>

<h1 align="center">Wodel-Test designer</h1>

<p align="center"><i>A model-based framework for engineering language-specific mutation testing (MT) tools</i></p>

<p align="center">
  <img src="https://img.shields.io/badge/version-2.3-blue" alt="Version 2.3">
  <a href="https://github.com/gomezabajo/Wodel/graphs/contributors"><img src="https://img.shields.io/github/contributors/gomezabajo/Wodel" alt="Contributors"></a>
  <a href="https://github.com/gomezabajo/Wodel/network/members"><img src="https://img.shields.io/github/forks/gomezabajo/Wodel" alt="Forks"></a>
  <a href="https://github.com/gomezabajo/Wodel/stargazers"><img src="https://img.shields.io/github/stars/gomezabajo/Wodel" alt="Stars"></a>
  <a href="https://raw.githubusercontent.com/gomezabajo/Wodel/master/LICENSE"><img src="https://img.shields.io/github/license/gomezabajo/Wodel" alt="License"></a>
</p>

<p align="center">
  <a href="https://gomezabajo.github.io/Wodel-Test/dropdown/Wodel-Test%20plugins_Wodel-Test%20designer/">Website</a> &middot;
  <a href="https://github.com/gomezabajo/Wodel-Test/wiki/Get-Started-with-Wodel%E2%80%90Test-Designer">Tutorial</a> &middot;
  <a href="https://github.com/gomezabajo/Wodel/issues">Report a bug</a>
</p>

The **Wodel-Test designer** is a model-based framework for engineering language-specific mutation testing (MT) tools. Given the meta-model of a language and a set of mutation operators defined with [Wodel](https://gomezabajo.github.io/Wodel/), the designer automatically synthesises a complete MT environment for that language as an Eclipse plug-in.

<p align="center">
  <a href="https://youtu.be/sB1oh2NFPso">
    <img src="https://raw.githubusercontent.com/gomezabajo/Wodel/gh-pages/images/wodel-test-designer.png" alt="Demonstration of the Wodel-Test designer" width="640"/>
  </a>
  <br/>
  <em>The Wodel-Test designer in operation (click to watch the video).</em>
</p>

## Table of contents

- [Overview](#overview)
- [How it works](#how-it-works)
- [Repository structure](#repository-structure)
- [Installation](#installation)
- [MuT tools generated with the designer](#mut-tools-generated-with-the-designer)
- [Resources](#resources)
- [Publications](#publications)
- [Funding](#funding)
- [License](#license)

## Overview

[Wodel-Test](https://gomezabajo.github.io/Wodel-Test/) is built on top of [Wodel](https://gomezabajo.github.io/Wodel/), a domain-specific language to define and execute model mutations. Wodel is language-independent, enabling the creation of mutation operators for any language defined by a meta-model.

Once the mutation operators are defined, the Wodel-Test designer generates a complete MT environment for the language as an Eclipse plug-in. The generated MuT tool:

- Parses the programs, representing them as models conformant to the language meta-model.
- Applies the mutation operators to generate mutants.
- Evaluates the test suite on the generated mutants.
- Offers a rich collection of metrics about the MT process, including the mutation score and the mutants detected by each test.

This way, Wodel-Test makes mutation testing readily available for any language — from general-purpose programming languages to domain-specific ones — without having to build an ad hoc MT tool from scratch.

## How it works

1. **Meta-model** — the abstract syntax of the target language is described by an Ecore meta-model.
2. **Mutation operators** — the mutation operators for the language are defined at the model level with the Wodel DSL.
3. **Generation** — from these two artefacts, the Wodel-Test designer synthesises the complete MT environment for the language as an Eclipse plug-in, packaged with its own update site, ready for installation and distribution.
4. **Mutation testing** — the generated tool parses the programs as models, applies the mutation operators, and executes the test suites against the resulting mutants.
5. **Analysis** — the tool reports detailed metrics that help users assess and improve the quality of their test suites.

A step-by-step guide is available in the [Get started with the Wodel-Test designer](https://github.com/gomezabajo/Wodel-Test/wiki/Get-Started-with-Wodel%E2%80%90Test-Designer) tutorial.

## Repository structure

| Folder | Description |
| --- | --- |
| `designer` | The Wodel-Test designer Eclipse plug-in. |
| `designer.plugins` | The Eclipse feature that groups the plug-ins of the Wodel-Test designer. |
| `designer.updatesite` | The Eclipse update site to install the Wodel-Test designer. |
| `wodel.core` | The core plug-in of the Wodel DSL. |
| `wodel.additions` | Additional utilities for the Wodel DSL. |
| `wodel.emf.comparison` | Model-comparison support for EMF models. |
| `wodel.emf.validation` | Validation support for EMF models. |
| `wodel.examples` | Example Wodel projects. |
| `wodel.footprints` | Footprint analysis for Wodel mutation programs. |
| `wodel.seed.synthesis` | Synthesis of seed models for mutation. |
| `wodel.wodeltest` | The Wodel-Test extension of the Wodel DSL. |

## Installation

### Option 1: Eclipse update site

1. In Eclipse, open *Help → Install New Software...*
2. Add the update site: <https://gomezabajo.github.io/Wodel/Wodel-Test/designer/update-site>
3. Select the **Wodel-Test designer** features, and complete the installation wizard.
4. Restart Eclipse when prompted.

### Option 2: Standalone Eclipse distribution

Download a ready-to-use Eclipse distribution with the Wodel-Test designer already installed:

- [Standalone Eclipse distribution with the Wodel-Test designer](https://www.dropbox.com/scl/fi/d698rghjmord6r2ig4dya/eclipse.zip?rlkey=57qufltl84a396inezs9l65si&dl=0)

## MuT tools generated with the designer

The following MT tools have been generated with the Wodel-Test designer, each available in its own branch of this repository:

| MuT tool | Branch |
| --- | --- |
| [Wodel-Test for ATL](https://gomezabajo.github.io/Wodel-Test/dropdown/Wodel-Test%20plugins_Wodel-Test%20for%20ATL/) | [Wodel-Test-for-ATL](https://github.com/gomezabajo/Wodel/tree/Wodel-Test-for-ATL) |
| [Wodel-Test for Chatbots](https://gomezabajo.github.io/Wodel-Test/dropdown/Wodel-Test%20plugins_Wodel-Test%20for%20Chatbots/) | [Wodel-Test-for-Conga](https://github.com/gomezabajo/Wodel/tree/Wodel-Test-for-Conga) |
| [Wodel-Test for Finite Automata](https://gomezabajo.github.io/Wodel-Test/dropdown/Wodel-Test%20plugins_Wodel-Test%20for%20Finite%20Automata/) | [Wodel-Test-for-FA](https://github.com/gomezabajo/Wodel/tree/Wodel-Test-for-FA) |
| [Wodel-Test for Java](https://gomezabajo.github.io/Wodel-Test/dropdown/Wodel-Test%20plugins_Wodel-Test%20for%20Java/) | [Wodel-Test-for-Java](https://github.com/gomezabajo/Wodel/tree/Wodel-Test-for-Java) |
| [Wodel-Test for Logic Circuits](https://gomezabajo.github.io/Wodel-Test/dropdown/Wodel-Test%20plugins_Wodel-Test%20for%20Logic%20Circuits/) | [Wodel-Test-for-LC](https://github.com/gomezabajo/Wodel/tree/Wodel-Test-for-LC) |

## Resources

- 🌐 [Wodel-Test website](https://gomezabajo.github.io/Wodel-Test/)
- 🌐 [Wodel-Test designer page](https://gomezabajo.github.io/Wodel-Test/dropdown/Wodel-Test%20plugins_Wodel-Test%20designer/)
- 📦 [Eclipse update site](https://gomezabajo.github.io/Wodel/Wodel-Test/designer/update-site)
- 🎬 [Video demo: the Wodel-Test designer in operation](https://youtu.be/sB1oh2NFPso)
- 📖 [Get started with the Wodel-Test designer (tutorial)](https://github.com/gomezabajo/Wodel-Test/wiki/Get-Started-with-Wodel%E2%80%90Test-Designer)
- 🌐 [Wodel website](https://gomezabajo.github.io/Wodel/)

## Publications

- P. Gómez-Abajo, E. Guerra, J. de Lara. *Wodel-Test: A model-based framework for engineering language-specific mutation testing tools*. **SoftwareX** (Elsevier), 2025.
- P. Gómez-Abajo, E. Guerra, J. de Lara, M. G. Merayo. *Wodel-Test: a model-based framework for language-independent mutation testing*. **Software and Systems Modeling** (Springer), 2021.

The complete publication list is available on the [Publications & Funding](https://gomezabajo.github.io/Wodel-Test/items/publications/) page.

## Funding

This work has been funded by the Spanish Ministry of Science (RTI2018-095255-B-I00, project "MASSIVE") and the R&D programme of Madrid (P2018/TCS-4314, project "[FORTE](https://antares.sip.ucm.es/forte-cm/)").

## License

This project is distributed under the [Eclipse Public License 1.0](https://raw.githubusercontent.com/gomezabajo/Wodel/master/LICENSE.txt).

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/ec027f6d9774493592ceeb885c6f23d5)](https://app.codacy.com/gh/gomezabajo/Wodel/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_grade)
[![Codacy Code Coverage](https://app.codacy.com/project/badge/Coverage/9aaa4b031c1d4143bdd39c4eedf49562)](https://www.codacy.com/gh/gomezabajo/Wodel/dashboard?utm_source=github.com&utm_medium=referral&utm_content=gomezabajo/Wodel&utm_campaign=Badge_Coverage)
[![EPL licensed](https://img.shields.io/badge/license-EPL1.0-orange.svg)](https://www.eclipse.org/org/documents/epl-v10.php)
[![GitHub Repo stars](https://img.shields.io/github/stars/gomezabajo/Wodel?label=Repo%20Stars)](https://github.com/gomezabajo/Wodel/stargazers)

[contributors-shield]: https://img.shields.io/github/contributors/gomezabajo/Wodel?style=for-the-badge
[contributors-url]: https://github.com/gomezabajo/Wodel/graphs/contributors

[stars-shield]: https://img.shields.io/github/stars/gomezabajo/Wodel?style=for-the-badge
[stars-url]: https://github.com/gomezabajo/Wodel/stargazers

[forks-shield]: https://img.shields.io/github/forks/gomezabajo/Wodel?style=for-the-badge
[forks-url]: https://github.com/gomezabajo/Wodel/network/members

[issues-shield]: https://img.shields.io/github/issues/gomezabajo/Wodel?style=for-the-badge
[issues-url]: https://github.com/gomezabajo/Wodel/issues

[license-shield]: https://img.shields.io/github/license/gomezabajo/Wodel?style=for-the-badge
[license-url]: https://raw.githubusercontent.com/gomezabajo/Wodel/master/LICENSE.txt
