# Wodel

A domain-specific language for model mutation

Wodel is a Domain-Specific Language for the specification and generation of model mutants. Wodel is domain-independent, as it can be used to generate mutants of models conforming to arbitrary meta-models. Wodel provides nine mutation primitives for object creation and deletion, reference redirection, attribute modification, cloning, and retyping (change the type of an object to one of its siblings types), among others.

The engine verifies that each generated mutant is a valid model (i.e., it conforms to the domain meta-model and satisfies its integrity constraints).

You can access the following links to learn more about this DSL and the tool support provided: 

- [Wodel Website](https://gomezabajo.github.io/Wodel/)
- [Wodel Tutorial](https://github.com/gomezabajo/Wodel/wiki/1.-Get-Started)

## Wodel plugins

- [wodel.core](https://github.com/gomezabajo/Wodel/tree/master/wodel.core)
- [wodel.footprints](https://github.com/gomezabajo/Wodel/tree/master/wodel.footprints)
- [wodel.additions](https://github.com/gomezabajo/Wodel/tree/master/wodel.additions)
- [wodel.examples](https://github.com/gomezabajo/Wodel/tree/master/wodel.examples)
- [wodel.json](https://github.com/gomezabajo/Wodel/tree/master/wodel.json)
- [wodel.asple](https://github.com/gomezabajo/Wodel/tree/master/wodel.asple)
- [wodel.seed.synthesis](https://github.com/gomezabajo/Wodel/tree/master/wodel.seed.synthesis)
- [wodel.emf.comparison](https://github.com/gomezabajo/Wodel/tree/master/wodel.emf.comparison)
- [wodel.emf.validation](https://github.com/gomezabajo/Wodel/tree/master/wodel.emf.validation)

# Wodel-Edu

Wodel-Edu is an extension to Wodel for the automated generation of exercises. It generates seven kinds of exercises:

- Alternative response: the student has to tell if the diagram or the textual representation is correct or not.
- Multiple diagram choice: the student has to tell which of the shown diagrams is correct.
- Multiple text choice: the student has to tell which of the shown textual representations is correct.
- Multiple emendation choice: the student has to tell which text options fix the shown diagram.
- Match pairs choice: the student has to match the statement on the left with the correct option of the drop-down list.
- Missing words choice: the student has to complete the gaps of the text shown with the correct options in the drop-down lists to match the statement.
- Text drag and drop: the student has to complete the gaps of the text shown with the correct options of the set of texts presented as labels in categories to match the statement.

You can access the following links to learn more about this solution and the tool support provided: 

- [Wodel-Edu Website](https://gomezabajo.github.io/Wodel/wodel-edu.html)
- [Wodel-Edu Tutorial](https://github.com/gomezabajo/Wodel/wiki/2.-Get-Started-with-Wodel-Edu)

## Wodel-Edu plugins

- [wodel.wodeledu](https://github.com/gomezabajo/Wodel/tree/master/wodel.wodeledu)
- [wodeledu.models](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.models)
- [wodeledu.extension](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.extension)
- [wodeledu.extension.examples](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.extension.examples)
- [wodeledu.run](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.run)
- [wodeledu.utils](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.utils)
- [wodeledu.additions](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.additions)
- [wodeledu.model2text](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.model2text)
- [wodeledu.model2text.dfa](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.model2text.dfa)
- [wodeledu.model2text.lc](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.model2text.lc)

### modelDraw DSL plugins

- [wodeledu.dsls.modeldraw.ide](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.modeldraw.ide)
- [wodeledu.dsls.modeldraw.ui](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.modeldraw.ui)
- [wodeledu.dsls.modeldraw](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.modeldraw)

### modelText DSL plugins

- [wodeledu.dsls.modeltext.ide](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.modeltext.ide)
- [wodeledu.dsls.modeltext.ui](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.modeltext.ui)
- [wodeledu.dsls.modeltext](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.modeltext)

### mutaText DSL plugins

- [wodeledu.dsls.mutatext.ide](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.mutatext.ide)
- [wodeledu.dsls.mutatext.ui](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.mutatext.ui)
- [wodeledu.dsls.mutatext](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.mutatext)

### eduTest DSL plugins

- [wodeledu.dsls.edutest.ide](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.edutest.ide)
- [wodeledu.dsls.edutest.ui](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.edutest.ui)
- [wodeledu.dsls.edutest](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.edutest)

# Wodel-Test

Wodel-Test is built on top of Wodel, a domain-specific language to define and execute model mutations.

Wodel is language independent, enabling the creation of mutation operators for any language defined by a meta-model.

Once the mutation operators are defined, Wodel-Test generates a complete Mutation Testing (MT) environment for the language as an Eclipse plugin.

This MT tool parses the program representing it as a model conformant to the language meta-model, applies the mutation operators, and evaluates the test suite on the generated mutants, offering a rich collection of metrics about the MT process.

You can access the following link to learn more about this solution and the tool support provided: 

- [Wodel-Test Website](https://gomezabajo.github.io/Wodel/Wodel-Test/)

## Wodel-Test plugins

- [wodel.wodeltest](https://github.com/gomezabajo/Wodel/tree/master/wodel.wodeltest)
- [wodeltest.extension](https://github.com/gomezabajo/Wodel/tree/master/wodeltest.extension)
- [wodeltest.extension.examples](https://github.com/gomezabajo/Wodel/tree/master/wodeltest.extension.examples)
- [wodeltest.run](https://github.com/gomezabajo/Wodel/tree/master/wodeltest.run)
- [wodeltest.additions](https://github.com/gomezabajo/Wodel/tree/master/wodeltest.additions)
- [wodeltest.optimiser](https://github.com/gomezabajo/Wodel/tree/master/wodeltest.optimiser)
- [wodeltest.optimiser.subsumption](https://github.com/gomezabajo/Wodel/tree/master/wodeltest.optimiser.subsumption)

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stars][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![EPL License][license-shield]][license-url]

This work has been funded by the Spanish Ministry of Science (RTI2018-095255-B-I00, project "MASSIVE") and the R&D programme of Madrid (P2018/TCS-4314, project "[FORTE](https://antares.sip.ucm.es/forte-cm/)"). 

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


[![Codacy Badge](https://app.codacy.com/project/badge/Grade/9aaa4b031c1d4143bdd39c4eedf49562)](https://www.codacy.com/gh/gomezabajo/Wodel/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=gomezabajo/Wodel&amp;utm_campaign=Badge_Grade)
[![Codacy Code Coverage](https://app.codacy.com/project/badge/Coverage/9aaa4b031c1d4143bdd39c4eedf49562)](https://www.codacy.com/gh/gomezabajo/Wodel/dashboard?utm_source=github.com&utm_medium=referral&utm_content=gomezabajo/Wodel&utm_campaign=Badge_Coverage)
[![GPL licensed](https://img.shields.io/badge/license-EPL2.0-orange.svg)](https://www.eclipse.org/legal/epl-2.0/)
[![GitHub Repo stars](https://img.shields.io/github/stars/gomezabajo/Wodel?label=Repo%20Stars)](https://github.com/gomezabajo/Wodel/stargazers)
