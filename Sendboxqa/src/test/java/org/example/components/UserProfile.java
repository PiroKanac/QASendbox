package org.example.components;

public class UserProfile
{
	private final String email;
	private final String password;
	private final String displayName;


	public UserProfile(final String email, final String password, final String displayName)
	{
		this.email = email;
		this.password = password;
		this.displayName = displayName;
	}

	public String getAccount()
	{
		return email;
	}

	public String getPassword()
	{
		return password;
	}

	public String getDisplayName()
	{
		return displayName;
	}
}
