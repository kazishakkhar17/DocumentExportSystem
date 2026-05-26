package decorator;

import template.AbstractExporter;

/**
 * Concrete Decorator — WatermarkDecorator
 *
 * Stamps a text watermark onto each page of the exported document.
 * In a real system this would use iText's PdfStamper or Apache POI's
 * header/footer API to overlay text before the stream is finalised.
 * Only meaningful for page-based formats (PDF, Word) — the pipeline
 * applies it regardless; format-specific guards would live inside
 * the real implementation.
 */
public class WatermarkDecorator extends ExporterDecorator {

    private final String watermarkText;

    public WatermarkDecorator(AbstractExporter wrapped, String watermarkText) {
        super(wrapped);
        this.watermarkText = watermarkText;
    }

    @Override
    protected double postProcess(double sizeMb) {
        System.out.printf("[Decorator]  → WatermarkDecorator:  \"%s\" stamped on all pages%n",
                watermarkText);
        return sizeMb;
    }
}
