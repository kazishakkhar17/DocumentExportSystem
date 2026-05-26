package strategy;

public class CsvRenderingStrategy implements RenderingStrategy {

    @Override
    public String render(String documentContent) {
        System.out.println("[Template]   Step 2: Rendering content (flat table engine)... OK");
        return "id,date,description,amount,status\n"
             + "1001,2024-10-01,\"" + documentContent + "\",1500.00,completed\n"
             + "1002,2024-10-03,Software licence renewal,299.99,completed\n"
             + "1003,2024-10-07,Cloud infrastructure invoice,4200.00,pending\n"
             + "1004,2024-10-15,Contractor payment — UX design,1800.00,completed\n"
             + "1005,2024-10-22,Office supplies,143.50,completed\n";
    }

    @Override
    public double getSizeMb() { return 5.1; }

    @Override
    public String getEngineName() { return "CsvRenderingStrategy"; }
}
