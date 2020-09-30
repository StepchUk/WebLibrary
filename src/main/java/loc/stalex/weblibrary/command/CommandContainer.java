package loc.stalex.weblibrary.command;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {

    private final static Map<String, Command> COMMANDS = new HashMap<>();

    static {
        COMMANDS.put("index", new CommandIndex());
        COMMANDS.put("registration", new CommandRegistration());
        COMMANDS.put("login", new CommandLogin());
        COMMANDS.put("404", new Command404());
    }

    public static Command get(String commandName) {
        return COMMANDS.getOrDefault(commandName, COMMANDS.get("404"));
    }
}
