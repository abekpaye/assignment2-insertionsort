# Assignment 2 — Insertion Sort Analysis

## Overview
This project implements the **Insertion Sort** algorithm with an optimization for **nearly-sorted data**, as part of the *Algorithmic Analysis and Peer Code Review* assignment.

The project follows all **implementation, testing, and benchmarking requirements** outlined in the specification.

---

## Features
- Clean, documented Java implementation (`algorithms/InsertionSort.java`)
- Metrics tracking via `PerformanceTracker` (comparisons, swaps, array accesses, memory allocations)
- Unit tests covering all edge cases
- CLI interface for manual testing and automated benchmarking
- CSV export and Excel plots for empirical performance analysis
- Follows Maven structure and Git workflow conventions

---

## Project Structure
```
assignment2-insertionsort/
├── src/
│ ├── main/java/
│ │ ├── algorithms/
│ │ │ └── InsertionSort.java
│ │ ├── metrics/
│ │ │ ├── PerformanceTracker.java
│ │ │ └── BenchmarkCSVExporter.java
│ │ └── cli/
│ │   ├── BenchmarkRunner.java
│ │   └── InteractiveBenchmarkRunner.java
│ └── test/java/
│   └── algorithms/
│   └── InsertionSortTest.java
├── docs/
│ ├── performance-plots/
│ │ ├── insertion_benchmark.csv
│ │ └── insertion_benchmark_visualized.xlsx
│ └── analysis-report.pdf
├── pom.xml
├── .gitignore
└── README.md
```

---

## Implementation Details

### Core Algorithm
`InsertionSort.java` implements the **Insertion Sort** algorithm  
with step-by-step metric tracking for:
- Comparisons
- Swaps
- Array accesses
- Execution time (in milliseconds)

Optimizations:
- Minimal data movement when the array is already partially sorted
- Early termination for already sorted arrays

---

### Metrics Collection
`PerformanceTracker.java` records:
- `comparisons`
- `swaps`
- `array accesses`
- `memory allocations`

These are passed to the **benchmark exporter** for CSV logging.

---

### Benchmark Automation
`BenchmarkRunner.java` automatically benchmarks sorting for:
- Input types: `random`, `sorted`, `reverse`, `nearlySorted`
- Array sizes: 100, 1,000, 5,000, 10,000, 50,000

Results are exported to:
`docs/performance-plots/insertion_benchmark.csv`

Then analyzed visually in Excel (`insertion_benchmark.xlsx`).

---

### Interactive CLI
`InteractiveBenchmarkRunner.java` allows testing custom array sizes  
and input types directly from the terminal.


---

### Testing
`InsertionSortTest.java` contains **unit tests** for:
- Empty arrays
- Single-element arrays
- Duplicates
- Sorted and reverse inputs

All tests pass successfully.

---

## Empirical Analysis
- Benchmark data → stored in `insertion_benchmark.csv`
- Visualization → `insertion_benchmark.xlsx` (Excel graphs)
- Report summary → `docs/analysis-report.pdf`

Metrics include:
- Number of comparisons
- Swaps
- Array accesses
- Execution time




