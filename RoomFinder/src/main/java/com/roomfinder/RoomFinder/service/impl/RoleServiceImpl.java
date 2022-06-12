package com.roomfinder.RoomFinder.service.impl;

import com.roomfinder.RoomFinder.exception.NotFoundException;
import com.roomfinder.RoomFinder.model.Role;
import com.roomfinder.RoomFinder.repository.RoleRepository;
import com.roomfinder.RoomFinder.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(int id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        "Role not found for id: " + id
                ));
    }

    @Override
    public Role updateRole(Role role) {
        findById(role.getId());
        return roleRepository.save(role);
    }

    @Override
    public String deleteRole(int id) {
        findById(id);
        roleRepository.deleteById(id);
        return "Role Deleted Successfully.";
    }
}
