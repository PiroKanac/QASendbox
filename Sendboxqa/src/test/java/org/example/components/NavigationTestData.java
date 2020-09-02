package org.example.components;

public enum NavigationTestData
{
	SUBMIT_BUTTON("submit_btn"),
	DELETE_BUTTON("remove_usecase_btn"),
	CREATE_CASE("create_use_case_btn"),
	NAVIGATION_ITEM_USE_CASES("use_cases_card_id"),
	NAVIGATION_ITEM_PLAYGROUND("playground_card_id"),
	NAVIGATION_ITEM_REPORTING_ISSUES("reports_card_id");

	private final String component;

	NavigationTestData(final String component)
	{
		this.component = component;
	}

	public String getComponent()
	{
		return component;
	}
}
