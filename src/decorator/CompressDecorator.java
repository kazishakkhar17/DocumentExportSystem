package decorator;

import template.AbstractExporter;

/**
 * Concrete Decorator — CompressDecorator
 *
 * Applies gzip compression to the export output stream.
 * In a real system this would wrap the OutputStream with GZIPOutputStream.
 * Reduces file size before any subsequent decorators run.
 */
public class CompressDecorator extends ExporterDecorator {

    private static final double COMPRESSION_RATIO = 0.37;

    public CompressDecorator(AbstractExporter wrapped) {
        super(wrapped);
    }

    @Override
    protected double postProcess(double sizeMb) {
        double compressed = Math.round(sizeMb * COMPRESSION_RATIO * 10.0) / 10.0;
        System.out.printf("[Decorator]  → CompressDecorator:   %.1fMB → %.1fMB (gzip)%n",
                sizeMb, compressed);
        return compressed;
    }
}
