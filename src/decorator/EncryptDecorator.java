package decorator;

import template.AbstractExporter;

/**
 * Concrete Decorator — EncryptDecorator
 *
 * Applies AES-256 encryption to the output stream.
 * In a real system this would wrap the OutputStream with a CipherOutputStream
 * configured with a symmetric key from a secrets manager (e.g. AWS KMS).
 * Size remains roughly the same after encryption (negligible IV overhead).
 */
public class EncryptDecorator extends ExporterDecorator {

    public EncryptDecorator(AbstractExporter wrapped) {
        super(wrapped);
    }

    @Override
    protected double postProcess(double sizeMb) {
        System.out.printf("[Decorator]  → EncryptDecorator:    AES-256 applied (%.1fMB)%n", sizeMb);
        return sizeMb;
    }
}
