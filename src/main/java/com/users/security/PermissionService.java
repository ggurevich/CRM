package com.users.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.users.repositories.ContactRepository;
import com.users.repositories.UserRepository;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;
import static com.users.security.Role.USER;
import static com.users.security.Role.ADMIN;

//@Service specifies intent of a class and its function
@Service
public class PermissionService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ContactRepository contactRepo;

	// displays the current user
	public long findCurrentUserId() {
		return userRepo.findByEmail(getToken().getName()).get(0).getId();
	}

	// retrieves an authentication token for username and password. displays
	// context of the user and if they have authentication.
	private UsernamePasswordAuthenticationToken getToken() {
		return (UsernamePasswordAuthenticationToken) getContext().getAuthentication();
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
	public boolean canEditUser(long userID) {

		return hasRole(ADMIN) || (hasRole(USER) && findCurrentUserId() == userID);
	}

	// allows a user to edit contacts
	public boolean canEditContact(long contactId) {
		return hasRole(USER) && contactRepo.findByUserIdAndId(findCurrentUserId(), contactId) != null;
	}

}
