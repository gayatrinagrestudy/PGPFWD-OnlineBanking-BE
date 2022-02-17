package com.simplilearn.capstone.project.login.model;

import java.util.Collection;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;



@Service
public class CustomeUserDetails implements UserDetails{

	//private static final long serialVersionUID = 6490825574230063546L;
	private User user;
	
	@Autowired
    private ModelMapper modelMapper;

	public CustomeUserDetails(User user) {
		UserDto userDto = convertToDto (user);
		
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		/*
		 * SimpleGrantedAuthority grantedAuthority = new
		 * SimpleGrantedAuthority(user.getRole()); return List.of(grantedAuthority);
		 */
		return null;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return  user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	

	private UserDto convertToDto(User post) {
		ModelMapper modelMapper = new ModelMapper(); 
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		UserDto postDto = modelMapper.map(post, UserDto.class);
	    return postDto;
	}
	
	private User convertToEntity(UserDto userDto) {
		return new ModelMapper().map(userDto, User.class);
	}

}
