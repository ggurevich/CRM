package com.users.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.users.beans.User;
import com.users.repositories.ContactRepository;
import com.users.repositories.UserRepository;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

import java.util.List;

import static com.users.security.Role.ROLE_USER;
import static com.users.security.Role.ROLE_ADMIN;

//@Service specifies intent of a class and its function
@Service
public class PermissionService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ContactRepository contactRepo;

	// displays the current user
	public long findCurrentUserId() {
		List<User> users = userRepo.findByEmail(getToken().getName());
		return users != null && !users.isEmpty() ? users.get(0).getId() : -1;
	}

	// retrieves an authentication token for username and password. displays
	// context of the user and if they have authentication.
	private AbstractAuthenticationToken getToken() {
		return (AbstractAuthenticationToken) getContext().getAuthentication();
	}

	// Checks the role of a user and puts out what authority they have if any
	public boolean hasRole(Role role) {
		for (GrantedAuthority ga : getToken().getAuthorities()) {
			if (role.toString().equals(ga.getAuthority())) {
				return true;
			}
		}
		return false;
	}

	// Allows a profile to be edited only if the profile is that current user or
	// an admin
	public boolean canAccessUser(long userID) {

		return hasRole(ROLE_ADMIN) || (hasRole(ROLE_USER) && findCurrentUserId() == userID);
	}

	// allows a user to edit contacts
	public boolean canEditContact(long contactId) {
		return hasRole(ROLE_USER) && contactRepo.findByUserIdAndId(findCurrentUserId(), contactId) != null;
	}

}
