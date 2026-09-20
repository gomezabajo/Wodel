# Wodel AI assistant chat workflows

The assistant now has two complementary layers:

1. **Deterministic Wodel workflows** for execution, inspection, validation, native seed synthesis, wizards and cleanup. These do not need an API key.
2. **Wodel-native AI workflows** for explaining, diagnosing, repairing and authoring `.mutator` code, plus an alternative LLM-based seed-model generator. These use the selected/named Wodel source, its parsed EMF model, the domain metamodel when resolvable, and Wodel/EMF validation before accepting generated artefacts.

The planner still performs deterministic intent recognition first; LLM intent classification is only a fallback for unmatched natural-language requests.

## Wodel-native AI source commands

- `/explain [program=<file>]` — explain the selected or named Wodel source, including header, model/metamodel context, mutation blocks, selections and effects.
- `/diagnose [program=<file>]` — explain parser/linker/validator errors and warnings in source context.
- `/repair [program=<file>]` — generate a minimal complete repair and validate it with Wodel. The source is not changed by default.
- `/repair ... apply=true` — write a repair only when the generated candidate has no Wodel validation errors. Eclipse resource history is retained.
- `/suggest [request]` — propose/add mutation blocks or operators grounded in the domain metamodel and return a validated complete candidate.
- `/author [request]` — author a new complete Wodel program using the selected source as domain/metamodel/path context.

Examples:

```text
/explain program=testFA1.mutator
/diagnose program=testFA1.mutator
/repair program=testFA1.mutator
/repair program=testFA1.mutator apply=true
/suggest Add boundary-value mutations for numeric attributes
/author Create a mutator that removes optional transitions and changes final states
Explain what the active Wodel mutator does
Why does this mutator fail validation?
Suggest mutation blocks for missing and duplicated references
```

### Validation loop

Code-producing AI tasks (`/repair`, `/suggest`, `/author`) request a **complete** `.mutator` source, not a patch. The candidate is parsed and validated through `WodelStandaloneSetup` / `IResourceValidator` in a temporary in-memory resource located in the active Wodel project. This preserves project-relative Wodel metamodel/import resolution semantics. If validation errors remain, the exact diagnostics are fed back to the model and generation is retried up to three times. Remaining errors are reported rather than hidden.

Warnings are surfaced separately. A candidate is called error-free only when the Wodel validator reports no `ERROR` diagnostics.

### Source and metamodel grounding

Source resolution uses, in order:

1. an explicitly named `.mutator` source (`program=...`, `mutator=...`, a `.mutator` path, etc.);
2. the active `.mutator` editor/selection in the active Wodel project;
3. the only `.mutator` source when the project contains exactly one.

If several sources exist and none is identifiable, the assistant asks the user to select/name one rather than guessing.

For AI prompts the assistant supplies:

- the complete/current `.mutator` source (bounded only for very large files),
- a structural summary parsed from the `MutatorEnvironment`,
- current Xtext error/warning diagnostics,
- a textual description of the referenced Ecore domain metamodel when it can be resolved,
- a compact Wodel language reference bundled with the plugin.

The Wodel Xtext parser/validator remains authoritative; the language reference is only prompt context.

## Seed-model generation: native and LLM alternatives

Two explicit seed-generation mechanisms are available for the same selected/named executable Wodel program:

- `/seeds [N]` — use Wodel's existing USE/Kodkod synthesizer. This remains the default for a plain request such as `Generate 5 seed models for the corresponding Wodel program metamodel`.
- `/seeds-ai [N]` — use the configured LLM API to generate EMF/XMI candidates, validating every candidate against the program's Ecore metamodel before saving it. Aliases: `/ai-seeds`, `/llm-seeds`. Optional model characteristics can be supplied with `features=...` (quoted when they contain spaces).

Examples:

```text
/seeds 5
/seeds-ai 5
/seeds-ai 5 program=testFA1.mutator
/seeds-ai 5 program=testFA1.mutator features="at least three states and two transitions"
Generate 5 seed models for the corresponding Wodel program metamodel using the LLM API
Generate 5 seed models using the LLM with features: several objects and non-empty references
Create 3 seed models with AI for program=testFA1.mutator
```

The LLM path adapts the earlier Gotten model-generation prompt pattern to Wodel. The prompt is organised around the authoritative Ecore metamodel, optional user-requested model features, the selected Wodel program as semantic guidance, and a `do not repeat` section containing previously accepted seed XMI. Each response must contain one complete XMI document and no prose. A candidate is loaded with the exact EPackages of the Wodel program's metamodel and checked with `ModelManager.validateModel(Resource)` plus the same `ModelManager.validateModel(metamodel, model)` path used by the native synthesizer. Invalid candidates are rejected and their validation diagnostics are fed back to the LLM for up to three attempts per requested seed. Exact duplicate fingerprints are rejected as an additional diversity guard. Only validated candidates are added to the previous-model prompt history.

Only validated models are saved. This provides a formal metamodel/EMF validity gate, but it is not equivalent to USE/Kodkod's solver guarantees: the LLM path does not formally prove that every requested mutation operator is applicable to every generated seed. LLM-generated seeds use names such as `<program>_ai0.model`, `<program>_ai1.model`, ... so they can coexist with native USE/Kodkod seeds such as `<program>0.model`, `<program>1.model`, .... The LLM workflow requires the Wodel `gen-AI API Key` preference or `OPENAI_API_KEY`; the native `/seeds` workflow does not.

## Deterministic execution and project commands

- `/run` — execute the selected `.mutator` file through Wodel's normal Eclipse command.
- `/all` — generate mutants for all executable programs using current Wodel preferences.
- `/generate ...` — invoke the generated project `IMutatorExecutor` with conversational overrides. **This is mutation execution, not source generation.**
- `/seeds [N]` — native Wodel USE/Kodkod seed synthesis.
- `/seeds-ai [N]` — alternative LLM-generated seed models with EMF/Wodel validation.
- `/project` — list executable Wodel programs.
- `/blocks` — show each executable program's domain metamodel and block names/command counts.
- `/validate` — validate every `.mutator` source under `src` (programs and libraries).
- `/mutants` — open the custom mutant-generation wizard.
- `/operators` — open the mutation-operator wizard.
- `/clean-output` and `/clean-registry` — invoke the existing Wodel cleanup commands.

## Parameterised mutation execution

Examples:

```text
/generate program=testFA1 mutants=20 attempts=5 blocks=BlockA,BlockB seed=1234 registry=true
Generate 10 mutants for blocks Foo and Bar with seed 42 without registry
Run mutations with maxAttempts=8 seed=123 metrics=true serialize=false
Clean Wodel output and then generate 5 mutants with seed 7
```

Supported overrides are:

- target executable program (`program=<name-or-project-relative-path>`)
- number of mutants
- maximum attempts
- block names
- execution seed
- registry generation
- net metrics
- debug metrics
- serialization

Any omitted setting falls back to the current Wodel preferences (serialization defaults to `true`). The execution seed defaults to a fresh value when omitted. A Wodel program that declares its own mutant count, or uses exhaustive generation, may override the requested mutant count in the generated code.

Parameterized generation resolves its scope in this order:

1. an explicit `program=<name-or-project-relative-path>`;
2. the active executable `.mutator` file, if one is open/selected;
3. otherwise the generated project `DynamicLauncher`.

For an individual program the assistant invokes its generated `<program>Dynamic` class directly with the same mutation-engine arguments used by Wodel. For project-wide execution, block names apply across executable programs in the project. `/run` remains the normal Wodel command-based execution path using the standard preferences.

## API key behaviour

The OpenAI client is lazy. `/run`, `/all`, `/generate`, `/seeds`, `/project`, `/blocks`, `/validate`, the wizards and cleanup commands work without an API key. `/seeds-ai` and the AI source workflows require either the Wodel `gen-AI API Key` preference or `OPENAI_API_KEY` in the environment. `/explain` and `/diagnose` degrade to parsed/validator information when the key is absent; code-producing workflows report the configuration requirement without modifying project files.

## Legacy compatibility

The historical Gotten-oriented `AITask`, `MetamodelInferingTask` and mock/experiment classes remain in the bundle for source compatibility, but they are not registered by `WodelTaskProvider` and are not part of the normal Wodel chat planning path. New functionality lives under `wodel.ai.assistant.wodel.ai` and uses Wodel-native parsing/validation/context exclusively.

## Post-generation analysis workflows

The assistant can also analyse artefacts produced by Wodel:

- `/explain-mutant <file.model>` reads the applied-mutation registry for a generated mutant.
- `/adequacy` reports which Wodel mutation commands have actually been applied by the current seed set.
- `/why-no-mutants ...` combines registry evidence with Wodel source/metamodel context to diagnose uncovered operators.
- `/metrics [all|static|dynamic|debug]` exposes registry metrics and installed Wodel footprint metrics.
- `/compare-mutants A.model B.model [semantic]` invokes installed Wodel comparison extensions.
- `/equivalents [semantic=true]` scans registered mutants for duplicate/equivalent pairs.
- `/test`, `/test-results`, `/survivors` and `/optimise-mutants` integrate Wodel-Test and its optimiser extension point.
- `/doctor` summarizes effective Wodel preferences and optional bundle availability.
- `/reproduce ... [save=true]` creates a JSON reproducibility manifest for the selected Wodel program.
- `/compare-seeds` compares native and `_ai` seeds through observed mutation-command coverage.
- `/improve-seeds [count=N]` generates validated LLM seeds targeted at currently uncovered Wodel commands. After generation, rerun mutants with `registry=true` and invoke `/adequacy` to close the feedback loop.

`/adequacy`, `/explain-mutant`, `/compare-seeds` and `/improve-seeds` depend on Wodel applied-mutation registry data. Generate mutants with `registry=true` before interpreting absent registry evidence as operator inapplicability.
