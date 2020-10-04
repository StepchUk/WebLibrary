package loc.stalex.weblibrary.utility;

import loc.stalex.weblibrary.model.Role;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class SecurityUtility {

    private final Map<Role, String> permissions = new EnumMap<>(Role.class);

    public SecurityUtility() {
        permissions.put(Role.ADMIN, "index, logout, books-list, profile, error");
        permissions.put(Role.LIBRARIAN, "index, logout, books-list, profile, error");
        permissions.put(Role.USER, "index, logout, books-list, profile, error");
        permissions.put(Role.GUEST, "index, books-list, login, registration, error");
    }

    public boolean isForbiddenRequest(String path, Role role) {
        return Optional.ofNullable(permissions.get(role))
                .map(s -> Arrays.stream(s.split(", ")).noneMatch(path::contains))
                .orElse(true);
    }
}
