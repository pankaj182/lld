package org.neatcode.services;

import lombok.NonNull;
import org.neatcode.models.user.User;

public interface UserService {

    void addUser(@NonNull final User user);

    void deleteUser(@NonNull final String userId);

    void updateUser(@NonNull final User user);

    User getUser(@NonNull final String userId);
}