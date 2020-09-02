package org.example.components;

public enum AttributesComponent
{
	ANCHOR("a"),
	BUTTON("button"),
	DIV("div"),
	INPUT("input"),
	ICON("i"),
	LABEL("label"),
	SPAN("span"),
	ITALIC("i");


	private final String component;

	AttributesComponent(final String component)
	{
		this.component = component;
	}

	public String getComponent()
	{
		return component;
	}
}
