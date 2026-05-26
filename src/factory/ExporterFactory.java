package factory;

import template.AbstractExporter;
import template.PdfExporter;
import template.WordExporter;
import template.CsvExporter;
import strategy.ITextRenderingStrategy;
import strategy.ApachePoiRenderingStrategy;
import strategy.CsvRenderingStrategy;

/**
 * Factory Pattern — ExporterFactory
 *
 * Centralises the decision of which exporter to construct.
 *
 * Why this matters in production:
 * The format string ("PDF", "CSV") typically arrives from an HTTP request
 * parameter, a database record, or a configuration file — it is a runtime
 * value, not a compile-time constant. Without a factory, every caller would
 * need its own if/else chain to map that string to a concrete class, and
 * each chain would also need to know which rendering strategy to pair with it.
 *
 * The factory encapsulates both decisions in one place.
 * Adding a new format (e.g. "HTML") requires changing only this class.
 */
public class ExporterFactory {

    /**
     * Creates and returns the appropriate AbstractExporter for the given format.
     * Also selects and injects the correct RenderingStrategy.
     *
     * @param format one of: "PDF", "WORD", "CSV"
     * @return configured exporter ready to run the export pipeline
     * @throws IllegalArgumentException for unsupported formats
     */
    public static AbstractExporter create(String format) {
        System.out.println("[Factory]    Export request received: " + format);
        switch (format.toUpperCase()) {
            case "PDF":
                System.out.println("[Factory]    Creating PdfExporter with ITextRenderingStrategy...");
                return new PdfExporter(new ITextRenderingStrategy());
            case "WORD":
                System.out.println("[Factory]    Creating WordExporter with ApachePoiRenderingStrategy...");
                return new WordExporter(new ApachePoiRenderingStrategy());
            case "CSV":
                System.out.println("[Factory]    Creating CsvExporter with CsvRenderingStrategy...");
                return new CsvExporter(new CsvRenderingStrategy());
            default:
                throw new IllegalArgumentException("[Factory]    Unsupported format: " + format);
        }
    }
}
