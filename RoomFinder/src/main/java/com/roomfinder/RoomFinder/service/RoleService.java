package com.roomfinder.RoomFinder.service;
import com.roomfinder.RoomFinder.model.Role;

import java.util.List;

public interface RoleService {

    Role addRole(Role role);

    List<Role> getAllRoles();

    Role findById(int id);

    Role updateRole(Role role);

    String deleteRole(int id);
}
