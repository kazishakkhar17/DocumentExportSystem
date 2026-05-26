package template;

import strategy.RenderingStrategy;

public class WordExporter extends AbstractExporter {

    public WordExporter(RenderingStrategy renderingStrategy) {
        super(renderingStrategy);
    }

    @Override
    public String getFormatLabel() { return "WORD"; }
}
