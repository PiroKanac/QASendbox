package org.example.components;

public enum NavigationTab
{
	SANDBOX("Sandbox"),
	EXAM("Exam"),
	INTRO("Intro"),
	USE_CASES("Use Cases"),
	PLAYGROUND("Playground"),
	REPORTING_ISSUES("Reporting issues");

	private final String name;

	NavigationTab(final String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}
}
