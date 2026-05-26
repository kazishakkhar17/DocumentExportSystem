package decorator;

import template.AbstractExporter;

public abstract class ExporterDecorator extends AbstractExporter {

    protected final AbstractExporter wrapped;

    public ExporterDecorator(AbstractExporter wrapped) {
        super(wrapped.renderingStrategy);
        this.wrapped = wrapped;
    }

    @Override
    public double export(String documentContent, String filename) {
        double sizeMb = wrapped.export(documentContent, filename);
        return postProcess(sizeMb);
    }

    protected abstract double postProcess(double sizeMb);

    @Override
    public String getFormatLabel() {
        return wrapped.getFormatLabel();
    }
}
