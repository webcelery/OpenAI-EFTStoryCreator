import org.example.view.ControlPanel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControlPanelLabelsTest
{
    final ControlPanel controlPanel = new ControlPanel();

    @Test
    void testStatusLabel()
    {
        assertEquals("", controlPanel.statusLabel.getText());
    }

    @Test
    void
    testCreateButtonText()
    {
        assertEquals("Create Story", controlPanel.createButton.getText());
    }

    @Test
    void
    testSaveButtonText()
    {
        assertEquals("Save", controlPanel.saveButton.getText());
    }
}