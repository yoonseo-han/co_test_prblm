## Quick orientation for AI coding agents

This repository is a personal collection of single-file solutions for competitive programming / coding-test problems (Baekjoon, Programmers, LeetCode, HackerEarth). Your goal: make minimal, correct changes to individual problem files while preserving the author's conventions and the single-file execution style.

### Big picture
- Top-level folders group problems by topic (e.g. `Greedy`, `DP`, `Array`, `Graph`, `Heap`, `map`, `Queue:Stack`).
- Each file is typically a self-contained solution that reads from STDIN and writes to STDOUT. There is no central build system, test harness, or packages.

### Languages present
- Java (.java) — dominant. Files are usually package-less, with a single public class whose name matches the filename (e.g. `Greedy/PG_Collect_Parcel_Array.java`).
- C++ (.cpp) — single-file solutions using `cin`/`cout`. A VS Code build task exists for C++ (label: "C/C++: g++-11 build active file") that invokes `/opt/homebrew/bin/g++-11`.
- JavaScript (.js) — Node-style solutions (often using `fs.readFileSync(0, 'utf8')`).

### Naming conventions / prefixes
- Filenames commonly start with a source tag:
  - `BJ_` — Baekjoon
  - `PG_` — Programmers
  - `LC_` — LeetCode
- Keep those prefixes and the filename/classname mapping. Many online judges expect class names or file names to remain unchanged.

### I/O patterns and local testing
- Most solutions read from STDIN; many directories contain `input.txt` for local testing (e.g. `Array/input.txt`, `BFS_DFS/input.txt`).
- To run locally with a sample input:
  - Java: `javac Greedy/PG_Collect_Parcel_Array.java && java -cp Greedy PG_Collect_Parcel_Array < Greedy/input.txt`
  - C++: use the provided VS Code task or run: `/opt/homebrew/bin/g++-11 -g Greedy/example.cpp -o example && ./example < Greedy/input.txt`
  - Node: `node Greedy/script.js < Greedy/input.txt`

### Editing rules for AI edits (must follow)
1. Preserve the single-file structure — do not introduce packages, build files, or multi-file modules.
2. Do not rename top-level public classes in Java or filenames; if you must, ask before changing file/class names.
3. Prefer minimal diffs: change only the file needed for the problem (e.g. `Greedy/PG_Collect_Parcel_Array.java`).
4. Follow existing input parsing style in the file (BufferedReader vs Scanner in Java). If mixing styles, prefer the one already used.
5. If a file reads from STDIN, use redirection for local tests and avoid adding hard-coded paths.

### Patterns & examples to reference
- Java single-file solution example: `Greedy/PG_Collect_Parcel_Array.java` and `Greedy/PG_Collect_Parcel_PQ.java` — no package, class name equals file name, read from STDIN.
- C++ VS Code build task: task label "C/C++: g++-11 build active file" calls `/opt/homebrew/bin/g++-11` (use same flags if creating new tasks).
- Local test inputs: many directories include `input.txt` (run solutions with `< input.txt`).

### Common pitfalls for automated edits
- Do not add external dependencies (no Maven/Gradle, no npm installs). The repository is intended to be runnable as single files.
- Avoid changing read/write style across the file. Small refactors are ok, but preserve behavior and input parsing.
- Many solutions assume trimmed input or specific whitespace — preserve `.trim()`/split behavior when present.

### When to add tests or helpers
- Add a tiny `*.in` sample alongside a changed file only if it mirrors the repository's existing `input.txt` pattern. Prefer adding comments at top of the file showing how to run with the sample.

### Where to look for more context
- Root `README.md` — high-level organization.
- Representative files by topic: `Greedy/PG_Collect_Parcel_Array.java`, `Array/input.txt`, `Heap/PG_disk_controller.java`, `Queue:Stack/Programmers_1.cpp`.

If anything in these instructions is unclear or you need policy for a non-trivial change (refactoring multiple files, adding dependencies, or renaming classes), ask for clarification before proceeding.
