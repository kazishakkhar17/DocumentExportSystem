# Document Export System

A Java demonstration of four Gang-of-Four design patterns working together
in a realistic document export pipeline.

## Patterns used

| Pattern | Class | Why |
|---|---|---|
| Factory | `ExporterFactory` | Maps a runtime format string to the right exporter |
| Template | `AbstractExporter` | Enforces the pipeline sequence across all formats |
| Strategy | `RenderingStrategy` | Swaps the rendering engine without changing the pipeline |
| Decorator | `ExporterDecorator` | Stacks post-processors (compress, encrypt, watermark) in any combination |

## Run

```bash
cd src
mkdir out

# macOS / Linux
javac -d out $(find . -name "*.java")

# Windows
for /r %f in (*.java) do javac -d out %f

java -cp out Main
```

No external libraries or build tools required — plain Java 11+. It can be run without any additional dependency.

## Project structure

```
src/
├── Main.java
├── factory/ExporterFactory.java
├── template/AbstractExporter.java
├── template/PdfExporter.java
├── template/WordExporter.java
├── template/CsvExporter.java
├── strategy/RenderingStrategy.java
├── strategy/ITextRenderingStrategy.java
├── strategy/ApachePoiRenderingStrategy.java
├── strategy/CsvRenderingStrategy.java
├── decorator/ExporterDecorator.java
├── decorator/CompressDecorator.java
├── decorator/EncryptDecorator.java
└── decorator/WatermarkDecorator.java
```
