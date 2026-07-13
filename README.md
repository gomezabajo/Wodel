<p align="center">
  <a href="https://gomezabajo.github.io/Wodel-Test/dropdown/Wodel-Test%20plugins_Wodel-Test%20for%20ATL/">
    <img src="https://gomezabajo.github.io/Wodel/images/wodel-test.png" width="224" height="120" alt="Wodel-Test logo" />
  </a>
</p>

<h1 align="center">Wodel-Test for ATL</h1>

<p align="center"><i>A mutation testing (MT) tool for the ATL model-transformation language</i></p>

<p align="center">
  <img src="https://img.shields.io/badge/version-2.3-blue" alt="Version 2.3">
  <a href="https://github.com/gomezabajo/Wodel/graphs/contributors"><img src="https://img.shields.io/github/contributors/gomezabajo/Wodel" alt="Contributors"></a>
  <a href="https://github.com/gomezabajo/Wodel/network/members"><img src="https://img.shields.io/github/forks/gomezabajo/Wodel" alt="Forks"></a>
  <a href="https://github.com/gomezabajo/Wodel/stargazers"><img src="https://img.shields.io/github/stars/gomezabajo/Wodel" alt="Stars"></a>
  <a href="https://raw.githubusercontent.com/gomezabajo/Wodel/master/LICENSE"><img src="https://img.shields.io/github/license/gomezabajo/Wodel" alt="License"></a>
</p>

<p align="center">
  <a href="https://gomezabajo.github.io/Wodel-Test/dropdown/Wodel-Test%20plugins_Wodel-Test%20for%20ATL/">Website</a> &middot;
  <a href="https://github.com/gomezabajo/Wodel-Test/wiki/Get-Started-with-Wodel%E2%80%90Test-Designer">Tutorial</a> &middot;
  <a href="https://github.com/gomezabajo/Wodel/issues">Report a bug</a>
</p>

**Wodel-Test for ATL** is a mutation testing (MT) tool for the [ATL](https://eclipse.dev/atl/) model-transformation language, automatically generated with [Wodel-Test](https://gomezabajo.github.io/Wodel-Test/), a model-based framework for engineering language-specific mutation-testing tools.

<p align="center">
  <a href="https://youtu.be/TeV2BClqmiw">
    <img src="https://raw.githubusercontent.com/gomezabajo/Wodel/gh-pages/images/wodeltest-for-atl.png" alt="Demonstration of the Wodel-Test MuT tool for ATL" width="640"/>
  </a>
  <br/>
  <em>The generated MuT tool for ATL in operation (click to watch the video).</em>
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

Once the mutation operators are defined, Wodel-Test generates a complete MT environment for the language as an Eclipse plug-in. This branch contains the MT tool generated for **ATL**, which:

- Parses ATL transformations, representing them as models conformant to the ATL meta-model.
- Applies the mutation operators defined with Wodel to generate ATL mutants.
- Evaluates the test suite on the generated mutants.
- Offers a rich collection of metrics about the MT process, including the mutation score and the mutants detected by each test.

The tool integrates [anATLyzer](https://anatlyzer.github.io/) for the static analysis of the ATL transformations, which helps discard invalid mutants.

## How it works

1. **Meta-model** — the abstract syntax of ATL is described by an Ecore meta-model ([ATL.ecore](https://gomezabajo.github.io/Wodel/Wodel-Test/ecore/ATL.ecore)).
2. **Mutation operators** — the ATL mutation operators are defined at the model level with the Wodel DSL ([testATL.zip](https://gomezabajo.github.io/Wodel/Wodel-Test/plugins/testATL.zip)).
3. **Generation** — the Wodel-Test designer synthesises the complete MT environment for ATL as an Eclipse plug-in, distributed through its own update site.
4. **Mutation testing** — the generated tool parses the ATL transformations as models, applies the mutation operators, and executes the test suites against the resulting mutants.
5. **Analysis** — the tool reports detailed metrics that help users assess and improve the quality of their test suites.

## Repository structure

| Folder | Description |
| --- | --- |
| `WodelTest4ATL` | The generated MT Eclipse plug-in for ATL. |
| `WodelTest4ATL.plugins` | The Eclipse feature that groups the plug-ins of the MT tool for ATL. |
| `WodelTest4ATL.updatesite` | The Eclipse update site to install the MT tool for ATL, including the required Wodel and anATLyzer plug-ins. |

## Installation

### Option 1: Eclipse update site

1. In Eclipse, open *Help → Install New Software...*
2. Add the update site: <https://gomezabajo.github.io/Wodel/Wodel-Test/atl/update-site>
3. Select the **Wodel-Test for ATL** features, and complete the installation wizard.
4. Restart Eclipse when prompted.

### Option 2: Standalone Eclipse distribution

Download a ready-to-use Eclipse distribution with Wodel-Test for ATL already installed:

- [Standalone Eclipse distribution with Wodel-Test for ATL](https://www.dropbox.com/scl/fi/06ptvz1j3vzey5wpwd41u/eclipse.zip?rlkey=99x8xvo7023w91wi81dgtf7c9&dl=0)

## Resources

- 🌐 [Wodel-Test website](https://gomezabajo.github.io/Wodel-Test/)
- 🌐 [Wodel-Test for ATL page](https://gomezabajo.github.io/Wodel-Test/dropdown/Wodel-Test%20plugins_Wodel-Test%20for%20ATL/)
- 📦 [Eclipse update site](https://gomezabajo.github.io/Wodel/Wodel-Test/atl/update-site)
- 🧬 [ATL Ecore meta-model](https://gomezabajo.github.io/Wodel/Wodel-Test/ecore/ATL.ecore)
- 🧪 [Wodel project with the ATL mutation operators (ZIP)](https://gomezabajo.github.io/Wodel/Wodel-Test/plugins/testATL.zip)
- 🎬 [Video demo: the generated MuT tool for ATL in operation](https://youtu.be/TeV2BClqmiw)
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

