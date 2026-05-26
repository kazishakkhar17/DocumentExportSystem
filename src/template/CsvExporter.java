package template;

import strategy.RenderingStrategy;

public class CsvExporter extends AbstractExporter {

    public CsvExporter(RenderingStrategy renderingStrategy) {
        super(renderingStrategy);
    }

    @Override
    public String getFormatLabel() { return "CSV"; }
}
