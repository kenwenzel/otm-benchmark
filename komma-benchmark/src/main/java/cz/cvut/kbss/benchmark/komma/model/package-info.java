package cz.cvut.kbss.benchmark.komma.model;

// Had to define the setters in interfaces (overriding the inherited ones), otherwise ASM did not generate implementation
// for them in the proxies.

// Also couldn't inherit OccurrenceReport from the core one, because class generation by ASM was failing with duplicate field/attribute
// in class.
// This also means that the KommaGenerator could not reuse code from core, but had to copy it with correct types
// Curiously, this issue did not apply to Person and Occurrence.