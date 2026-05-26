package template;

import strategy.RenderingStrategy;

public class CsvExporter extends AbstractExporter {

    public CsvExporter(RenderingStrategy renderingStrategy) {
        super(renderingStrategy);
    }

    // Returns the export format name
    @Override
    public String getFormatLabel() { return "CSV"; }
}
