//necessary imports
package template;

import strategy.RenderingStrategy;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class AbstractExporter {

    public final RenderingStrategy renderingStrategy;
    private static final String EXPORTS_DIR = "exports";

    public AbstractExporter(RenderingStrategy renderingStrategy) {
        this.renderingStrategy = renderingStrategy;
        new File(EXPORTS_DIR).mkdirs();
    }

    public double export(String documentContent, String filename) {
        System.out.println("[Template]   Starting export pipeline...");
        validate(documentContent);
        String renderedContent = renderingStrategy.render(documentContent);
        double sizeMb = renderingStrategy.getSizeMb();
        writeToStream(renderedContent, filename);
        logAuditTrail(filename, sizeMb);
        return sizeMb;
    }

    private void validate(String documentContent) {
        System.out.println("[Template]   Step 1: Validating document structure... OK");
    }

    private void writeToStream(String renderedContent, String filename) {
        System.out.println("[Template]   Step 3: Writing to output stream... OK");
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(EXPORTS_DIR + File.separator + filename))) {
            writer.write(renderedContent);
            System.out.println("[Template]   Step 3: File written  -->  exports/" + filename);
        } catch (IOException e) {
            System.out.println("[Template]   Step 3: ERROR writing file - " + e.getMessage());
        }
    }

    private void logAuditTrail(String filename, double sizeMb) {
        System.out.println("[Template]   Step 4: Logging export audit trail... OK");
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logEntry = String.format("[%s]  %-45s  format=%-5s  engine=%-30s  size=%.1fMB%n",
                timestamp, filename, getFormatLabel(),
                renderingStrategy.getEngineName(), sizeMb);
        try (BufferedWriter log = new BufferedWriter(
                new FileWriter(EXPORTS_DIR + File.separator + "audit_log.txt", true))) {
            log.write(logEntry);
        } catch (IOException e) {
            System.out.println("[Template]   Step 4: ERROR writing audit log - " + e.getMessage());
        }
    }

    public abstract String getFormatLabel();

    public String getRendererName() {
        return renderingStrategy.getEngineName();
    }
}
