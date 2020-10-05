package loc.stalex.weblibrary.command;

import loc.stalex.weblibrary.service.BookService;
import loc.stalex.weblibrary.service.UserService;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {

    private final static Map<String, Command> COMMANDS = new HashMap<>();

    static {
        COMMANDS.put("index", new CommandIndex());
        COMMANDS.put("registration", new CommandRegistration(new UserService()));
        COMMANDS.put("login", new CommandLogin(new UserService()));
        COMMANDS.put("logout", new CommandLogout());
        COMMANDS.put("profile", new CommandProfile());
        COMMANDS.put("books-list", new CommandBooks(new BookService()));
        COMMANDS.put("404", new Command404());
    }

    public static Command get(String commandName) {
        return COMMANDS.getOrDefault(commandName, COMMANDS.get("404"));
    }
}
