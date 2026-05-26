import factory.ExporterFactory;
import template.AbstractExporter;
import decorator.CompressDecorator;
import decorator.EncryptDecorator;
import decorator.WatermarkDecorator;

public class Main {

    public static void main(String[] args) {

        System.out.println("=====================================================");
        System.out.println("         Document Export System -- Demo              ");
        System.out.println("=====================================================");

        // Scenario 1: Confidential quarterly report --> PDF
        System.out.println("\n-- Scenario 1: Quarterly report (PDF, confidential) --\n");

        AbstractExporter pdfExporter = ExporterFactory.create("PDF");
        AbstractExporter pipeline1 = new WatermarkDecorator(
                new EncryptDecorator(
                        new CompressDecorator(pdfExporter)
                ), "CONFIDENTIAL");

        double size1 = pipeline1.export("Q3 Financial Report -- Board Edition", "Q3_Financial_Report.txt");

        System.out.println();
        System.out.println("[Strategy]   Renderer used : " + pdfExporter.getRendererName());
        System.out.printf("[Result]     Export complete. Final size: %.1fMB%n", size1);

        // Scenario 2: Data extract --> CSV
        System.out.println("\n-- Scenario 2: Data extract (CSV, internal use) --\n");

        AbstractExporter csvExporter = ExporterFactory.create("CSV");
        AbstractExporter pipeline2 = new CompressDecorator(csvExporter);

        double size2 = pipeline2.export("Customer transactions -- October 2024", "Customer_Transactions.csv");

        System.out.println();
        System.out.println("[Strategy]   Renderer used : " + csvExporter.getRendererName());
        System.out.printf("[Result]     Export complete. Final size: %.1fMB%n", size2);

        // Scenario 3: Word draft -- no post-processing
        System.out.println("\n-- Scenario 3: Internal draft (Word, no post-processing) --\n");

        AbstractExporter wordExporter = ExporterFactory.create("WORD");

        double size3 = wordExporter.export("Project Proposal -- Draft v2", "Project_Proposal_Draft.txt");

        System.out.println();
        System.out.println("[Strategy]   Renderer used : " + wordExporter.getRendererName());
        System.out.printf("[Result]     Export complete. Final size: %.1fMB%n", size3);

        System.out.println("\n=====================================================");
        System.out.println("  All exports finished. Check the exports/ folder.  ");
        System.out.println("=====================================================");
    }
}
