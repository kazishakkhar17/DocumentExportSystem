package strategy;

public class ITextRenderingStrategy implements RenderingStrategy {

    @Override
    public String render(String documentContent) {
        System.out.println("[Template]   Step 2: Rendering content (iText engine)... OK");
        return "=== PDF DOCUMENT (rendered by iText) ===\n\n"
             + documentContent + "\n\n"
             + "--- Page 1 of 1 ---\n"
             + "[Rendered as PDF: margins, fonts, and layout applied]\n"
             + "[iText engine: paragraphs, headings, page numbers embedded]\n";
    }

    @Override
    public double getSizeMb() { return 2.4; }

    @Override
    public String getEngineName() { return "ITextRenderingStrategy"; }
}
