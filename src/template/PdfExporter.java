package template;

import strategy.RenderingStrategy;

public class PdfExporter extends AbstractExporter {

    public PdfExporter(RenderingStrategy renderingStrategy) {
        super(renderingStrategy);
    }

    @Override
    public String getFormatLabel() { return "PDF"; }
}
