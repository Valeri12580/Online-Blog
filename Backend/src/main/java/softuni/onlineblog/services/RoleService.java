package softuni.onlineblog.services;

import softuni.onlineblog.domain.entities.Role;

public interface RoleService {

    Role findRoleByName(String name);
}
