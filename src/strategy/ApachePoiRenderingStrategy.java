package strategy;

public class ApachePoiRenderingStrategy implements RenderingStrategy {

    @Override
    public String render(String documentContent) {
        System.out.println("[Template]   Step 2: Rendering content (Apache POI engine)... OK");
        return "=== WORD DOCUMENT (rendered by Apache POI) ===\n\n"
             + documentContent + "\n\n"
             + "[Rendered as .docx: styles, headings, and paragraph spacing applied]\n"
             + "[Apache POI engine: XWPFDocument structure generated]\n";
    }

    @Override
    public double getSizeMb() { return 3.1; }

    @Override
    public String getEngineName() { return "ApachePoiRenderingStrategy"; }
}
