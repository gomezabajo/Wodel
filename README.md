# Wodel-Test for Finite Automata

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stars][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![EPL License][license-shield]][license-url]

**Wodel-Test for Finite Automata** is a mutation testing (MT) tool for finite automata, automatically generated with [Wodel-Test](https://gomezabajo.github.io/Wodel-Test/), a model-based framework for engineering language-specific mutation-testing tools.

<p align="center">
  <a href="https://youtu.be/9NhFv36BgS8">
    <img src="https://raw.githubusercontent.com/gomezabajo/Wodel/gh-pages/images/wodeltest-for-fa.png" alt="Demonstration of the Wodel-Test MuT tool for finite automata" width="640"/>
  </a>
  <br/>
  <em>The generated MuT tool for finite automata in operation (click to watch the video).</em>
</p>

## Table of contents

- [Overview](#overview)
- [How it works](#how-it-works)
- [Repository structure](#repository-structure)
- [Installation](#installation)
- [Resources](#resources)
- [Publications](#publications)
- [Funding](#funding)
- [License](#license)

## Overview

[Wodel-Test](https://gomezabajo.github.io/Wodel-Test/) is built on top of [Wodel](https://gomezabajo.github.io/Wodel/), a domain-specific language to define and execute model mutations. Wodel is language-independent, enabling the creation of mutation operators for any language defined by a meta-model.

Once the mutation operators are defined, Wodel-Test generates a complete MT environment for the language as an Eclipse plug-in. This branch contains the MT tool generated for **finite automata**, which:

- Parses the finite automata, representing them as models conformant to the finite-automata meta-model.
- Applies the mutation operators defined with Wodel — such as redirecting transitions, or changing the initial or final states — to generate automaton mutants.
- Evaluates the test suite, made of input words that the automata should accept or reject, on the generated mutants.
- Offers a rich collection of metrics about the MT process, including the mutation score and the mutants detected by each test.

Finite automata are a paradigmatic example of a domain-specific language: this MT tool illustrates how Wodel-Test makes mutation testing readily available for languages that lack ad hoc MT tooling.

## How it works

1. **Meta-model** — the abstract syntax of the finite automata is described by an Ecore meta-model ([DFAAutomaton.ecore](https://gomezabajo.github.io/Wodel/Wodel-Test/ecore/DFAAutomaton.ecore)).
2. **Mutation operators** — the finite-automata mutation operators are defined at the model level with the Wodel DSL ([testFA.zip](https://gomezabajo.github.io/Wodel/Wodel-Test/plugins/testFA.zip)).
3. **Generation** — the Wodel-Test designer synthesises the complete MT environment for finite automata as an Eclipse plug-in, distributed through its own update site.
4. **Mutation testing** — the generated tool parses the finite automata as models, applies the mutation operators, and executes the test suites against the resulting mutants.
5. **Analysis** — the tool reports detailed metrics that help users assess and improve the quality of their test suites.

## Repository structure

| Folder | Description |
| --- | --- |
| `WodelTest4FA` | The generated MT Eclipse plug-in for finite automata. |
| `WodelTest4FA.plugins` | The Eclipse feature that groups the plug-ins of the MT tool for finite automata. |
| `WodelTest4FA.updatesite` | The Eclipse update site to install the MT tool for finite automata, including the required Wodel plug-ins. |

## Installation

### Option 1: Eclipse update site

1. In Eclipse, open *Help → Install New Software...*
2. Add the update site: <https://gomezabajo.github.io/Wodel/Wodel-Test/fa/update-site>
3. Select the **Wodel-Test for Finite Automata** features, and complete the installation wizard.
4. Restart Eclipse when prompted.

### Option 2: Standalone Eclipse distribution

Download a ready-to-use Eclipse distribution with Wodel-Test for Finite Automata already installed:

- [Standalone Eclipse distribution with Wodel-Test for Finite Automata](https://www.dropbox.com/scl/fi/lt3izw39nau9ewx2xk3os/eclipse.zip?rlkey=7ni6t1dtwz3rg80r2dtyeqx0r&dl=0)

## Resources

- 🌐 [Wodel-Test website](https://gomezabajo.github.io/Wodel-Test/)
- 🌐 [Wodel-Test for Finite Automata page](https://gomezabajo.github.io/Wodel-Test/dropdown/Wodel-Test%20plugins_Wodel-Test%20for%20Finite%20Automata/)
- 📦 [Eclipse update site](https://gomezabajo.github.io/Wodel/Wodel-Test/fa/update-site)
- 🧬 [Finite-automata Ecore meta-model](https://gomezabajo.github.io/Wodel/Wodel-Test/ecore/DFAAutomaton.ecore)
- 🧪 [Wodel project with the finite-automata mutation operators (ZIP)](https://gomezabajo.github.io/Wodel/Wodel-Test/plugins/testFA.zip)
- 🎬 [Video demo: the generated MuT tool for finite automata in operation](https://youtu.be/9NhFv36BgS8)
- 📖 [Get started with the Wodel-Test designer (tutorial)](https://github.com/gomezabajo/Wodel-Test/wiki/Get-Started-with-Wodel%E2%80%90Test-Designer)

## Publications

- P. Gómez-Abajo, E. Guerra, J. de Lara, M. G. Merayo. *Wodel-Test: A model-based framework for engineering language-specific mutation testing tools*. **SoftwareX** (Elsevier), 2025.
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
