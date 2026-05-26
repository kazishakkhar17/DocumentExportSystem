package strategy;

public interface RenderingStrategy {
    String render(String documentContent);
    double getSizeMb();
    String getEngineName();
}
