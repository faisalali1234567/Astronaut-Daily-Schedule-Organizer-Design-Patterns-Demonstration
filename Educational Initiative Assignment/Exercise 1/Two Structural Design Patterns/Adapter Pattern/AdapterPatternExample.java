import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

// Common interface for task creation
interface TaskCreator {
    Task createTask();
}

// Base class for tasks
abstract class Task {
    String name;
    String priority;

    public Task(String name, String priority) {
        this.name = name;
        this.priority = priority;
    }

    public abstract void describeTask();
}

// High Priority Task class
class HighPriorityTask extends Task {
    public HighPriorityTask(String name) {
        super(name, "High");
    }

    @Override
    public void describeTask() {
        System.out.println("Task: " + name + " [Priority: " + priority + "]");
    }
}

// Low Priority Task class
class LowPriorityTask extends Task {
    public LowPriorityTask(String name) {
        super(name, "Low");
    }

    @Override
    public void describeTask() {
        System.out.println("Task: " + name + " [Priority: " + priority + "]");
    }
}

// JSON Adapter
class JSONTaskAdapter implements TaskCreator {
    private String jsonInput;

    public JSONTaskAdapter(String jsonInput) {
        this.jsonInput = jsonInput;
    }

    @Override
    public Task createTask() {
        JSONObject jsonObject = new JSONObject(jsonInput);
        String name = jsonObject.getString("name");
        String priority = jsonObject.getString("priority");

        if (priority.equalsIgnoreCase("High")) {
            return new HighPriorityTask(name);
        } else {
            return new LowPriorityTask(name);
        }
    }
}

// XML Adapter
class XMLTaskAdapter implements TaskCreator {
    private String xmlInput;

    public XMLTaskAdapter(String xmlInput) {
        this.xmlInput = xmlInput;
    }

    @Override
    public Task createTask() {
        try {
            InputStream inputStream = new ByteArrayInputStream(xmlInput.getBytes());
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
            Element rootElement = document.getDocumentElement();
            String name = rootElement.getElementsByTagName("name").item(0).getTextContent();
            String priority = rootElement.getElementsByTagName("priority").item(0).getTextContent();

            if (priority.equalsIgnoreCase("High")) {
                return new HighPriorityTask(name);
            } else {
                return new LowPriorityTask(name);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error parsing XML", e);
        }
    }
}

// Main class to demonstrate the Adapter Pattern
public class AdapterPatternExample {
    public static void main(String[] args) {
        // JSON input
        String jsonInput = "{\"name\": \"Complete Assignment\", \"priority\": \"High\"}";
        TaskCreator jsonTaskAdapter = new JSONTaskAdapter(jsonInput);
        Task jsonTask = jsonTaskAdapter.createTask();
        jsonTask.describeTask();

        // XML input
        String xmlInput = "<task><name>Watch Movie</name><priority>Low</priority></task>";
        TaskCreator xmlTaskAdapter = new XMLTaskAdapter(xmlInput);
        Task xmlTask = xmlTaskAdapter.createTask();
        xmlTask.describeTask();
    }
}
