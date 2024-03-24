# Wodel

A domain-specific language for model mutation

Wodel is a Domain-Specific Language for the specification and generation of model mutants. Wodel is domain-independent, as it can be used to generate mutants of models conforming to arbitrary meta-models. Wodel provides nine mutation primitives for object creation and deletion, reference redirection, attribute modification, cloning, and retyping (change the type of an object to one of its siblings types), among others.

The engine verifies that each generated mutant is a valid model (i.e., it conforms to the domain meta-model and satisfies its integrity constraints).

You can access the following links to learn more about this DSL and the tool support provided: 

- [Wodel Website](https://gomezabajo.github.io/Wodel/)
- [Wodel Tutorial](https://github.com/gomezabajo/Wodel/wiki/1.-Get-Started)

## Wodel plugins

- [wodel.core](https://github.com/gomezabajo/Wodel/tree/master/wodel.core)
    - [wodel.dsls.wodel](https://github.com/gomezabajo/Wodel/tree/master/wodel.dsls.wodel)
    - [wodel.dsls.wodel.ide](https://github.com/gomezabajo/Wodel/tree/master/wodel.dsls.wodel.ide)
    - [wodel.dsls.wodel.ui](https://github.com/gomezabajo/Wodel/tree/master/wodel.dsls.wodel.ui)
    - [wodel.extension](https://github.com/gomezabajo/Wodel/tree/master/wodel.extension)
    - [wodel.models](https://github.com/gomezabajo/Wodel/tree/master/wodel.models)
    - [wodel.postprocessor](https://github.com/gomezabajo/Wodel/tree/master/wodel.postprocessor)
    - [wodel.project](https://github.com/gomezabajo/Wodel/tree/master/wodel.project)
    - [wodel.registry](https://github.com/gomezabajo/Wodel/tree/master/wodel.registry)
    - [wodel.registry.reduce](https://github.com/gomezabajo/Wodel/tree/master/wodel.registry.reduce)
    - [wodel.run](https://github.com/gomezabajo/Wodel/tree/master/wodel.run)
    - [wodel.semantic.comparison](https://github.com/gomezabajo/Wodel/tree/master/wodel.semantic.comparison)
    - [wodel.semantic.validation](https://github.com/gomezabajo/Wodel/tree/master/wodel.semantic.validation)
    - [wodel.syntactic.comparison](https://github.com/gomezabajo/Wodel/tree/master/wodel.syntactic.comparison)
    - [wodel.syntactic.validation](https://github.com/gomezabajo/Wodel/tree/master/wodel.syntactic.validation)
    - [wodel.utils](https://github.com/gomezabajo/Wodel/tree/master/wodel.utils)
- [wodel.footprints](https://github.com/gomezabajo/Wodel/tree/master/wodel.footprints)
    - [wodel.metrics.command](https://github.com/gomezabajo/Wodel/tree/master/wodel.metrics.command)
    - [wodel.metrics.data](https://github.com/gomezabajo/Wodel/tree/master/wodel.metrics.data)
    - [wodel.metrics.debug](https://github.com/gomezabajo/Wodel/tree/master/wodel.metrics.debug)
    - [wodel.metrics.dynamic](https://github.com/gomezabajo/Wodel/tree/master/wodel.metrics.dynamic)
    - [wodel.metrics.fixed](https://github.com/gomezabajo/Wodel/tree/master/wodel.metrics.fixed)
- [wodel.additions](https://github.com/gomezabajo/Wodel/tree/master/wodel.additions)
    - [wodel.semantic.comparison.dfa](https://github.com/gomezabajo/Wodel/tree/master/wodel.semantic.comparison.dfa)
- [wodel.examples](https://github.com/gomezabajo/Wodel/tree/master/wodel.examples)
    - [wodel.project.examples](https://github.com/gomezabajo/Wodel/tree/master/wodel.project.examples)
- [wodel.json](https://github.com/gomezabajo/Wodel/tree/master/wodel.json)
    - [wodel.postprocessor.json](https://github.com/gomezabajo/Wodel/tree/master/wodel.postprocessor.json)
- [wodel.asple](https://github.com/gomezabajo/Wodel/tree/master/wodel.asple)
    - [wodel.dsls.asple](https://github.com/gomezabajo/Wodel/tree/master/wodel.dsls.asple)
- [wodel.seed.synthesis](https://github.com/gomezabajo/Wodel/tree/master/wodel.seed.synthesis)
    - [wodel.synthesizer](https://github.com/gomezabajo/Wodel/tree/master/wodel.synthesizer)
- [wodel.emf.comparison](https://github.com/gomezabajo/Wodel/tree/master/wodel.emf.comparison)
    - [wodel.syntactic.comparison.emf](https://github.com/gomezabajo/Wodel/tree/master/wodel.syntactic.comparison.emf)
- [wodel.emf.validation](https://github.com/gomezabajo/Wodel/tree/master/wodel.emf.validation)
    - [wodel.syntactic.validation.emf](https://github.com/gomezabajo/Wodel/tree/master/wodel.syntactic.validation.emf)

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
    - [wodeledu.extension](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.extension)
    - [wodeledu.model2text](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.model2text)
    - [wodeledu.models](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.models)
    - [wodeledu.run](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.run)
    - [wodeledu.utils](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.utils)
- [wodeledu.additions](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.additions)
    - [wodel.semantic.comparison.lc](https://github.com/gomezabajo/Wodel/tree/master/wodel.semantic.comparison.lc)
    - [wodeledu.extension.examples](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.extension.examples)
    - [wodeledu.model2text.dfa](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.model2text.dfa)
    - [wodeledu.model2text.lc](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.model2text.lc)

    ### eduTest DSL plugins

    - [wodeledu.dsls.edutest](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.edutest)
    - [wodeledu.dsls.edutest.ide](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.edutest.ide)
    - [wodeledu.dsls.edutest.ui](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.edutest.ui)

    ### modelDraw DSL plugins

    - [wodeledu.dsls.modeldraw](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.modeldraw)
    - [wodeledu.dsls.modeldraw.ide](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.modeldraw.ide)
    - [wodeledu.dsls.modeldraw.ui](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.modeldraw.ui)

    ### modelText DSL plugins

    - [wodeledu.dsls.modeltext](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.modeltext)
    - [wodeledu.dsls.modeltext.ide](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.modeltext.ide)
    - [wodeledu.dsls.modeltext.ui](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.modeltext.ui)

    ### mutaText DSL plugins

    - [wodeledu.dsls.mutatext](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.mutatext)
    - [wodeledu.dsls.mutatext.ide](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.mutatext.ide)
    - [wodeledu.dsls.mutatext.ui](https://github.com/gomezabajo/Wodel/tree/master/wodeledu.dsls.mutatext.ui)

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
    - [wodeltest.optimiser](https://github.com/gomezabajo/Wodel/tree/master/wodeltest.optimiser)
    - [wodeltest.run](https://github.com/gomezabajo/Wodel/tree/master/wodeltest.run)
- [wodeltest.additions](https://github.com/gomezabajo/Wodel/tree/master/wodeltest.additions)
    - [wodeltest.extension.examples](https://github.com/gomezabajo/Wodel/tree/master/wodeltest.extension.examples)
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
